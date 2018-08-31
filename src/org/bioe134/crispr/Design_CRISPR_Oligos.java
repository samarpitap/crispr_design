package org.bioe134.crispr;

import javafx.util.Pair;

/**
 *
 * @author J. Christopher Anderson, Samarpita Patra
 */
public class Design_CRISPR_Oligos {
    
    public void initiate() throws Exception {
        
        //TODO:  write this initiate (if needed)
        
    }
    
    public Pair<String,String> run(String cds) throws Exception {
        
        //TODO:  write this algorithm, put the oligo sequences in line below
        String pam = "GG";
        String SpeI = "ACTAGT";
        String guideScaff = "gttttagagctagaaatagcaag".toUpperCase();
        String oligo1, oligo2;

        cds = cds.toUpperCase();

        int oligo1_index = cds.indexOf(pam, 21);
        if (oligo1_index != -1) {
            oligo1 = "ccata".toUpperCase()+ SpeI + cds.substring(oligo1_index-21, oligo1_index-1) + guideScaff;
            oligo2 = "ctcag".toUpperCase() + SpeI + "attatacctaggactgagctag".toUpperCase();
        } else {
            throw new Exception("Coding sequence has no NGG sequence or is too small for Cas9");
        }


        Pair<String,String> out = new Pair<>(oligo1, oligo2);
        return out;
    }
    
    public static void main(String[] args) throws Exception {
        //Create some example arguments, here the amilGFP coding sequence
        String cds = "ATGTCTTATTCAAAGCATGGCATCGTACAAGAAATGAAGACGAAATACCATATGGAAGGCAGTGTCAATGGCCATGAATTTACGATCGAAGGTGTAGGAACTGGGTACCCTTACGAAGGGAAACAGATGTCCGAATTAGTGATCATCAAGCCTGCGGGAAAACCCCTTCCATTCTCCTTTGACATACTGTCATCAGTCTTTCAATATGGAAACCGTTGCTTCACAAAGTACCCGGCAGACATGCCTGACTATTTCAAGCAAGCATTCCCAGATGGAATGTCATATGAAAGGTCATTTCTATTTGAGGATGGAGCAGTTGCTACAGCCAGCTGGAACATTCGACTCGAAGGAAATTGCTTCATCCACAAATCCATCTTTCATGGCGTAAACTTTCCCGCTGATGGACCCGTAATGAAAAAGAAGACCATTGACTGGGATAAGTCCTTCGAAAAAATGACTGTGTCTAAAGAGGTGCTAAGAGGTGACGTGACTATGTTTCTTATGCTCGAAGGAGGTGGTTCTCACAGATGCCAATTTCACTCCACTTACAAAACAGAGAAGCCGGTCACACTGCCCCCGAATCATGTCGTAGAACATCAAATTGTGAGGACCGACCTTGGCCAAAGTGCAAAAGGCTTTACAGTCAAGCTGGAAGCACATGCCGCGGCTCATGTTAACCCTTTGAAGGTTAAATAA";

        //Instantiate and initiate the Function
        Design_CRISPR_Oligos func = new Design_CRISPR_Oligos();
        func.initiate();
        
        //Run the function on the example
        Pair<String,String> oligos = func.run(cds);
        
        //Print out the result
        System.out.println("oligo1: " + oligos.getKey());
        System.out.println("oligo2: " + oligos.getValue());
    }
}