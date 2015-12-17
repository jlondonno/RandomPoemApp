package co.com.quimera.poemgenerator.entity;

import java.util.HashMap;
import java.util.Map;

public class Poem {
	
	private Map<String, Rule> rules;
	
	public Poem() {
		this.rules = new HashMap<String, Rule>();;
	}

	public Map<String, Rule> getRules() {
		return this.rules;
	}

	public void setRules(Map<String, Rule> rules) {
		this.rules = rules;
	}
}
