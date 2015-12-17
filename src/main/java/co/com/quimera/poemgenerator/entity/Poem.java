package co.com.quimera.poemgenerator.entity;

import java.util.HashMap;
import java.util.Map;

public class Poem {
	
	private Map<String, Rule> rules;
	private StringBuilder body;
	
	public Poem() {
		this.rules = new HashMap<String, Rule>();
		body = new StringBuilder();
	}

	public Map<String, Rule> getRules() {
		return this.rules;
	}

	public void setRules(Map<String, Rule> rules) {
		this.rules = rules;
	}

	public StringBuilder getBody() {
		return body;
	}

	public void setBody(StringBuilder body) {
		this.body = body;
	}
	
	public void addWord(String word){
		body.append(word);
	}
	
	public String getAllLines(){
		return this.body.toString();
	}
}
