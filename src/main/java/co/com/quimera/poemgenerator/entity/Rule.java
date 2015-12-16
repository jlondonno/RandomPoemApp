package co.com.quimera.poemgenerator.entity;

import java.util.List;
import java.util.Random;

public class Rule {
	
	private String name;
	private List<String> wordsGroup;
	private List<String> keywordsRefRuleGroup;
	
	public Rule() {
	}

	public Rule(String name, List<String> words){
		this.name = name;
		this.wordsGroup = words;
	}
	
	public Rule(String name, List<String> wordsGroup, List<String> keywordsRefRuleGroup){
		this.name = name;
		this.wordsGroup = wordsGroup;
		this.keywordsRefRuleGroup = keywordsRefRuleGroup;
	}
	
	public String getRandomWord(){
		Random rand = new Random();
		int randomNum = 0;
		try {
			randomNum = rand.nextInt(this.wordsGroup.size());
			return this.wordsGroup.get(randomNum);
		} catch (IllegalArgumentException e) {
			return "";
		}
	}
	
	public String getRandomKeywordRefRule(){
		Random rand = new Random();
		int randomNum = 0;
		try {
			randomNum = rand.nextInt(this.keywordsRefRuleGroup.size());
			return this.keywordsRefRuleGroup.get(randomNum);
		} catch (IllegalArgumentException e) {
			return "";
		}
	}
	
	public List<String> getWordsGroup() {
		return wordsGroup;
	}

	public void setWordsGroup(List<String> words) {
		this.wordsGroup = words;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<String> getKeywordsRefRuleGroup() {
		return keywordsRefRuleGroup;
	}

	public void setKeywordsRefRuleGroup(List<String> referencedRules) {
		this.keywordsRefRuleGroup = referencedRules;
	}

	@Override
	public String toString() {
		return "Rule [name=" + name + ", wordsGroup=" + wordsGroup
				+ ", keywordsRefRuleGroup=" + keywordsRefRuleGroup + "]";
	}
}
