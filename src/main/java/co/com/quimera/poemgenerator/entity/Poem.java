package co.com.quimera.poemgenerator.entity;

import java.util.HashMap;
import java.util.Map;

public class Poem {
	
	private Map<String, Rule> rules;
	private StringBuilder poem;
	
	public Poem() {
		this.rules = new HashMap<String, Rule>();;
		this.poem = new StringBuilder();
	}

	public StringBuilder getPoem() {
		return poem;
	}

	public void setPoem(StringBuilder poem) {
		this.poem = poem;
	}
	
	public void addWord(String word){
		poem.append(word);
	}
	
	public String getBodyPoem(){
		return poem.toString();
	}

	public Map<String, Rule> getRules() {
		return this.rules;
	}

	public void setRules(Map<String, Rule> rules) {
		this.rules = rules;
	}
}
