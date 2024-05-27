package edu.cis.main;

import java.io.File;
import java.sql.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class DNAStrand {
    private ArrayList<String> dnaSequenceList;
    private ArrayList<String> complementList;

    public DNAStrand(){
        dnaSequenceList = new ArrayList<>();
        complementList = new ArrayList<>();
    }

    public void readDNA(String filename){
        try {
            File fileToRead = new File(filename);
            Scanner myScanner = new Scanner(fileToRead);

            while (myScanner.hasNextLine()){
                String line = myScanner.nextLine();
//                System.out.println(line);
                dnaSequenceList.add(line);
            }
        }
        catch (Exception error){
            error.printStackTrace();
        }
        complementList = createComplement(dnaSequenceList);
    }

    public static ArrayList<String> createComplement(ArrayList<String> sequences)
    {
        ArrayList<String> complements = new ArrayList<>();
        for (String dna : sequences) {
            complements.add(createComplement(dna));
        }
        return complements;
    }

    public static String createComplement(String sequence){
        // loop through dnaSequenceList
        // for each string in dnaSequenceList
        // create the string that is compliment
            // if string is "atc", the compliment of a is t, the compliment of t is a the compliment of c is g
            // compliment should be "tag"
        // add the new compliment string into the complimentList
        String complement = "";
        for (int i=0; i < sequence.length(); i++) {
            complement += createComplement(sequence.charAt(i));
        }
        return complement;
    }
    public static char createComplement(char nucleotide) {
        switch (nucleotide) {
            case 'A':
                return 'T';
            case 'T':
                return 'A';
            case 'C':
                return 'G';
            case 'G':
                return 'C';
            default:
                return nucleotide; // Return the same character for unknown nucleotides
        }
    }
    public ArrayList<String> getComplement(){
        return dnaSequenceList;
    }
    public ArrayList<String> getDnaSequence(){
        return complementList;
    }
}
