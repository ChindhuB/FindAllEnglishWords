package com.combinations.framework.FindAllEnglishWords.Steps;

import java.util.ArrayList;
import java.util.HashSet;

import com.combinations.framework.FindAllEnglishWords.classpackage.WordCombination;
import com.combinations.framework.FindAllEnglishWords.util.Dictionary;
import io.cucumber.java.en.*;

public class ScrambleWordCucumberTest {
	ArrayList<String> existwords = new ArrayList<String>();
	ArrayList<String> nonexistwords = new ArrayList<String>();
	HashSet<String> combword=new HashSet<String>();
	String word;
	@Given("a word to unscramble is given {string}")
	public void a_word_to_unscramble_is_given(String sword) {
		word = sword.toLowerCase();
	}

	@When("find all combinations")
	public void find_all_combinations() {
		combword = WordCombination.passtheWord(word); 
	}

	@When("check word using dictionary")
	public void check_word_using_dictionary() {
		for (String w : combword) {

			if (Dictionary.isEnglishword(w)) {
				existwords.add(w);
				//System.out.println(w);
			} else {
				nonexistwords.add(w);
			}
		}
	}

	@Then("unscramble word combination resultset")
	public void unscramble_word_combination_resultset() {
		System.out.println("==============================ResultSet=======================================");
		System.out.println("Scramble Words Total from Word "+word.toUpperCase()+" : "+existwords.size());
		System.out.println(existwords.toString());
		System.out.println("==============================================================================");
	}

}
