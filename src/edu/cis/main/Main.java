package edu.cis.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        /*
         * PART 1a and 1b
         */
//     UNCOMMENT THE FOLLOWING CODE WHEN YOU'RE READY TO TEST

//        DNAStrand myDna = new DNAStrand();
//        Mrna myMRNA = new Mrna();
        Ribosome myRib = new Ribosome();
//        myDna.readDNA("dnaSequence");
//
//        myMRNA.createCopy(myDna.getDnaSequence());
//        ArrayList<String> protein = myRib.createProtein(myMRNA.getMessengerDna());
//        for (String section : protein) {
//            System.out.println(section);
//        }


        /*
         * PART 2
         */

        // READ the file and turn it into one long DNA string
        GeneFinder myFinder = new GeneFinder();
        try {
            String X73525 = "";
            String salDNA = "";
            Scanner sc = null;
//            try {
//                sc = new Scanner(new File("X73525.fna"));
//            } catch (FileNotFoundException e) {
//                throw new RuntimeException(e);
//            }
//            while (sc.hasNext()) {
//                X73525 += sc.next();
//            }
//            System.out.println(X73525);
//            String orf = GeneFinder.longestORF(X73525);
//            System.out.println(orf);
//            ArrayList<String> codons = GeneFinder.convertORFToCodons(orf);
//            System.out.println(GeneFinder.convertORFToCodons(orf));
//            System.out.println(myRib.createProtein(codons));

//            try {
//                sc = new Scanner(new File("salDNA.fna"));
//            } catch (FileNotFoundException e) {
//                throw new RuntimeException(e);
//            }
//            while (sc.hasNext()) {
//                salDNA += sc.next();
//            }
//            System.out.println(salDNA);
//            String orf = GeneFinder.longestORF(salDNA);
//            System.out.println(orf);
//            ArrayList<String> codons = GeneFinder.convertORFToCodons(orf);
//            System.out.println(GeneFinder.convertORFToCodons(orf));
//            System.out.println(myRib.createProtein(codons));
//            System.out.println();
//
//        } catch (RuntimeException e) {
//            throw new RuntimeException(e);
//        }
            try {
                sc = new Scanner(new File("X73525.fna"));
                while (sc.hasNext()) {
                    X73525 += sc.next();
                }
                System.out.println(GeneFinder.longestORFNoncoding(X73525, 50));
            } catch (RuntimeException e) {
                throw new RuntimeException(e);

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        } catch (RuntimeException e) { //dont comment
            throw new RuntimeException(e); //dont comment
        }
    }
}