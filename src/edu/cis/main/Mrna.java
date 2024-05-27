package edu.cis.main;

import java.util.ArrayList;

public class Mrna {
    private ArrayList<String> messengerDNA;

    public Mrna(){
        messengerDNA = new ArrayList<>();
    }

    public void createCopy(ArrayList<String> dnaList) {
        ArrayList<String> copyList = new ArrayList<>();


        //loop through each string in dnaList
        //for each string, we are going to create a copy of it
        //string ccc, we will create a copy that is now ccc
        //string cac, we will translate to cuc
        //add the copy to copyList

        for (String dna : dnaList) {
            String mrna = "";
            for (int j = 0; j < dna.length(); j++) {
                char messengerNucleotide = getMessengerNucleotide(dna.charAt(j));
                mrna += messengerNucleotide;
            }
            copyList.add(mrna);
        }
        messengerDNA = copyList;
    }
    private char getMessengerNucleotide(char nucleotide) {
        if (nucleotide == 'T') {
            return 'U';
        } else {
            return Character.toLowerCase(nucleotide);
        }
    }
    public ArrayList<String> getMessengerDna() { return messengerDNA; }
}
