package edu.cis.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class GeneFinder{
    public static ArrayList<String> oneFrame(String DNA, int i) {
        return oneFrame(DNA);
    }

        public static ArrayList<String> oneFrame(String DNA) {
            ArrayList<String> orf = new ArrayList<>();
            int index = 0;
            while (index < DNA.length()) {
                String codon = DNA.substring(index, index + 3);
                // look for "ATG"
                // can use charAt 3 times, charAt(i), charAt(i+1), charAt(i+2)
                // or can also use .substring(i, i+3)
                // when "ATG" is found, call restOfORF

                // loop through each letter in partDNA
                if (codon.equals("ATG")) {
                    String ORF = restOfORF(DNA.substring(index));
                    orf.add(ORF);
                    index += 3;
                    //break;
                } else {
                    index += 3;
                }
            }
            //System.out.println(DNA + "->" + orf);
            return orf;
        }
    public static String restOfORF(String partDNA) {
        int startCodonIndex = partDNA.indexOf("ATG");
        if (startCodonIndex == -1) {
            // No start codon found, return empty string
            return "";
        }

        int stopCodonIndex = findStopCodon(partDNA, startCodonIndex + 3);
        if (stopCodonIndex == -1) {
            // No stop codon found, return the entire sequence
            return partDNA.substring(startCodonIndex);
        }

        // Return the ORF from the start codon to the stop codon (excluding the stop codon)
        return partDNA.substring(startCodonIndex, stopCodonIndex);
    }

    private static int findStopCodon(String DNA, int startIndex) {
        for (int i = startIndex; i <= DNA.length() - 3; i += 3) {
            String codon = DNA.substring(i, i + 3);
            if (codon.equals("TAA") || codon.equals("TAG") || codon.equals("TGA")) {
                return i;
            }
            // knowing that the beginning is at ATG, find TAG, TAA, or TGA
            // for each codon in partDNA, if its TAG, return up to that point without including TAG
            // return the string up to stop codon
        }
        return -1; // No stop codon found
    }
    public static String longestORF(String DNA) {
        ArrayList<String> ORFs = oneFrame(DNA);
        String longestORF = "";

        for (String ORF : ORFs) {
            if (ORF.length() > longestORF.length()) {
                longestORF = ORF;
            }
        }

        return longestORF;
    }
    public static String longestORFBothStrands(String DNA) {
        String forwardORF = longestORF(DNA);
        String reverseComplement = reverseComplement(DNA);
        String reverseORF = longestORF(reverseComplement);

        if (forwardORF.length() >= reverseORF.length()) {
            return forwardORF;
        } else {
            return reverseORF;
        }
    }
    public static String reverseComplement(String DNA) {
        StringBuilder reverseComplement = new StringBuilder();

        for (int i = DNA.length() - 1; i >= 0; i--) {
            char nucleotide = DNA.charAt(i);
            char complement = DNAStrand.createComplement(nucleotide);
            reverseComplement.append(complement);
        }

        return reverseComplement.toString();
    }

    public static int longestORFNoncoding(String DNA, int numReps) {
        ArrayList<Character> nucleotides = new ArrayList<>();
        for (char nucleotide : DNA.toCharArray()) {
            nucleotides.add(nucleotide);
        }

        int longestORF = 0;

        for (int i = 0; i < numReps; i++) {
            Collections.shuffle(nucleotides);
            StringBuilder shuffledDNA = new StringBuilder();
            for (char nucleotide : nucleotides) {
                shuffledDNA.append(nucleotide);
            }

            String shuffledDNAString = shuffledDNA.toString();
            int ORFLength = longestORFBothStrands(shuffledDNAString).length();
            longestORF = Math.max(longestORF, ORFLength);
        }

        return longestORF;
    }
    public static List<String> findORFs(String DNA) {
        List<String> allORFs = new ArrayList<>();

        List<String> frame1ORFs = oneFrame(DNA, 0);
        List<String> frame2ORFs = oneFrame(DNA, 1);
        List<String> frame3ORFs = oneFrame(DNA, 2);

        allORFs.addAll(frame1ORFs);
        allORFs.addAll(frame2ORFs);
        allORFs.addAll(frame3ORFs);

        return allORFs;
    }
    public static List<String> findORFsBothStrands(String DNA) {
        List<String> forwardORFs = findORFs(DNA);
        List<String> reverseORFs = findORFs(reverseComplement(DNA));

        List<String> allORFs = new ArrayList<>();
        allORFs.addAll(forwardORFs);
        allORFs.addAll(reverseORFs);

        return allORFs;
    }
    public static Coordinate getCoordinates(String gene, String DNA)
    {
        String geneToUse = gene;
        int start = DNA.indexOf(geneToUse);

        if (start == -1)
        {
            geneToUse = reverseComplement(gene);
            start = DNA.indexOf(geneToUse);
        }

        int end = start + gene.length();
        return new Coordinate(start, end);
    }
    public static Object[][] geneFinder(String DNA, int minLen) {
        List<String> allORFs = findORFsBothStrands(DNA);
        List<Object[]> finalOutputList = new ArrayList<>();

        for (String ORF : allORFs) {
            if (ORF.length() > minLen) {
                int beginningCoord = getCoordinates(ORF, DNA).getStart();
                int endCoord = getCoordinates(ORF, DNA).getEnd();

                ArrayList<String> codons = convertORFToCodons(ORF);
                ArrayList<String> proteinSequence = Ribosome.createProtein(codons); // Assuming createProtein is a valid static method

                Object[] ORFInfo = { beginningCoord, endCoord, proteinSequence };
                finalOutputList.add(ORFInfo);
            }
        }

        Object[][] finalOutputArray = new Object[finalOutputList.size()][];
        for (int i = 0; i < finalOutputList.size(); i++) {
            finalOutputArray[i] = finalOutputList.get(i);
        }

        return finalOutputArray;
    }
    public static ArrayList<String> convertORFToCodons(String ORF) {
        ArrayList<String> codons = new ArrayList<>();
        int length = ORF.length();

        for (int i = 0; i < length; i += 3) {
            if (i + 3 <= length) {
                String codon = ORF.substring(i, i + 3);
                codons.add(codon);
            }
        }

        return codons;
    }
}
