package edu.cis.main;

import java.util.ArrayList;

public class Ribosome {

    public static ArrayList<String> createProtein(ArrayList<String> codons) {
        ArrayList<String> protein = new ArrayList<>();

        for (String codon : codons) {
            String aminoAcid = translateCodon(codon);
            if (aminoAcid != null) {
                protein.add(aminoAcid);
            } else {
                // Handle unrecognized codons, e.g., by marking them with a special symbol
                protein.add("?");
            }
        }

        return protein;
    }

    private static String translateCodon(String codon) {
        String aminoAcid = null; //""
        //System.out.println("input codon = " + codon);
        codon = codon.toUpperCase();

        // Translate the codon to the corresponding amino acid
        if (codon.equals("TTT") || codon.equals("TTC")) {
            aminoAcid = "Phe";
        } else if (codon.equals("TTA") || codon.equals("TTG") || codon.equals("CTT")|| codon.equals("CTC")|| codon.equals("CTA")|| codon.equals("CTG")) {
            aminoAcid = "Leu";
        } else if (codon.equals("ATT") || codon.equals("ATC") || codon.equals("ATA")) {
            aminoAcid = "Ile";
        } else if (codon.equals("ATG")){
            aminoAcid = "Met";
        } else if (codon.equals("GTT") || codon.equals("GTC") || codon.equals("GTA")|| codon.equals("GTG")) {
            aminoAcid = "Val";
        } else if (codon.equals("TCT") || codon.equals("TCC") || codon.equals("TCA")|| codon.equals("TCG")) {
            aminoAcid = "Ser";
        } else if (codon.equals("CCT") || codon.equals("CCC") || codon.equals("CCA")|| codon.equals("CCG")) {
            aminoAcid = "Pro";
        } else if (codon.equals("ACT") || codon.equals("ACC") || codon.equals("ACA")|| codon.equals("ACG")) {
            aminoAcid = "Thr";
        } else if (codon.equals("GCT") || codon.equals("GCC") || codon.equals("GCA")|| codon.equals("GCG")) {
            aminoAcid = "Ala";
        } else if (codon.equals("TAT") || codon.equals("TAC")) {
            aminoAcid = "Tyr";
        } else if(codon.equals("TAA")|| codon.equals("TAG")){
            aminoAcid = "Stop";
        } else if (codon.equals("CAT") || codon.equals("CAC")) {
            aminoAcid = "His";
        } else if (codon.equals("CAA")|| codon.equals("CAG")){
            aminoAcid = "Gln";
        } else if (codon.equals("AAT") || codon.equals("AAC")) {
            aminoAcid = "Asn";
        } else if (codon.equals("AAA")|| codon.equals("AAG")){
            aminoAcid = "Lys";
        } else if (codon.equals("GAT") || codon.equals("GAC")) {
            aminoAcid = "Asp";
        } else if (codon.equals("GAA")|| codon.equals("GAG")){
           aminoAcid = "Glu";
        } else if (codon.equals("TGT") || codon.equals("TGC")) {
            aminoAcid = "Cys";
        } else if (codon.equals("TGA")){
            aminoAcid = "Stop";
        } else if (codon.equals("TGG")){
           aminoAcid = "Trp";
        } else if (codon.equals("CGU") || codon.equals("CGC") || codon.equals("CGA")|| codon.equals("CGG") || codon.equals("AGA")|| codon.equals("AGG")) {
            aminoAcid = "Arg";
        } else if (codon.equals("AGT") || codon.equals("AGC")) {
            aminoAcid = "Ser";
        } else if (codon.equals("GGU")|| codon.equals("GGC") || codon.equals("GGA")|| codon.equals("GGG")){
            aminoAcid = "Gly";
        }
        return aminoAcid ;
    }
}