/*@author Chindhu Babu*/
package com.combinations.framework.FindAllEnglishWords.classpackage;

import java.util.ArrayList;
import java.util.HashSet;

import org.paukov.combinatorics3.Generator;

public class WordCombination {
	/*
	 * method used to generate all combinations of word 
	 * ---used combinatoricslib3  dependency----
	 */
	public static HashSet<String> passtheWord(String word) {
		ArrayList<Character> chararr = new ArrayList<Character>();
		HashSet<String> stringcombarr = new HashSet<String>();
		for (int i = 0; i < word.length(); i++) {
			chararr.add(word.charAt(i));
		}
		Object[] arr = Generator.subset(chararr).simple().stream().toArray();
		for (Object j : arr) {
			ArrayList<Character> subchararr = new ArrayList<Character>();
			String strJ = j.toString().replace("[", "").replace("]", "").replace(",", "").replace(" ", "").trim();
			if (strJ != null && strJ.length() > 1) {
				char subarr[] = strJ.toCharArray();

				for (char sub : subarr) {
					subchararr.add(sub);
				}

				Object[] arr1 = Generator.permutation(subchararr).simple().stream().distinct().toArray();
				for (Object i : arr1) {
					String combword=i.toString().replace("[", "").replace("]", "").replace(",", "").replace(" ", "").trim();
					stringcombarr.add(combword);
				}
						
			}
		}
		return stringcombarr;

	}
}
