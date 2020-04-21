package org.cap.numerology;

import java.util.Arrays;
import java.util.HashSet;

public class PanagramFinder {

	public static void main(String[] args) {
		
		String word= "sentence";
		String alphabets[]= "abcdefghijklmnopqrstuvwxyz".split("");
		String [] wordArray = word.toLowerCase().replaceAll("[^\\x00-\\x7F]", "").split("");
		findMissingLetters(wordArray); 
		
	}
	public static void findMissingLetters(String[] wordArray ) {
		String alphabets[]= "abcdefghijklmnopqrstuvwxyz".split("");
		HashSet<String> s1 = new HashSet<String>(Arrays.asList(wordArray));
        HashSet<String> s2 = new HashSet<String>(Arrays.asList(alphabets));
        s2.removeAll(s1);
        System.out.println(s2);
	}
}
