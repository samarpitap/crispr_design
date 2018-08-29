package org.bioe134.crispr;

import javafx.util.Pair;

/**
 *
 * @author J. Christopher Anderson
 */
public class Design_CRISPR_Oligos {
    
    public void initiate() throws Exception {
        
        //TODO:  write this initiate (if needed)
        
    }
    
    public Pair<String,String> run(String cds) throws Exception {
        
        //TODO:  write this algorithm, put the oligo sequences in line below
        String pam = "GG";
        int oligo1_index = cds.indexOf(pam);
        String oligo1 = cds.substring(oligo1_index+2, oligo1_index+22);
        int oligo2_index = cds.indexOf(pam, oligo1_index+2);
        String oligo2 = cds.substring(oligo2_index+2, oligo2_index+22);
        
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