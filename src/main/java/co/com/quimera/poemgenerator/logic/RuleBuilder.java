package co.com.quimera.poemgenerator.logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import co.com.quimera.poemgenerator.entity.Rule;
import co.com.quimera.poemgenerator.exception.PoemException;

public class RuleBuilder implements RuleBuilderInterface {

	private static final String OR = "\\|";
	private static final String COLON = ":";

	@Override
	public Rule buildRule(String line) throws PoemException {
		List<String> keywordsRefRules = new ArrayList<String>();
		List<String> wordsGroup = new ArrayList<String>();
		
		String[] fileLine = line.split(COLON);
		String ruleName = fileLine[0].toUpperCase();
		String ruleDefinition = fileLine[1];
		
		
		if(!ruleDefinition.contains("|")){
			keywordsRefRules.addAll(new ArrayList<String>(
					Arrays.asList(ruleDefinition.split(" "))));
			
			return new Rule(ruleName, 
					wordsGroup,
					keywordsRefRules);
		}

		String[] ruleItems = ruleDefinition.split(" ");
		
		if (ruleItems.length < 2) {
			throw new PoemException("The " + ruleName
					+ " is not correctly defined");
		}
		
		String words = ruleItems[0];
		String rules = ruleItems[1];

		keywordsRefRules = new ArrayList<String>(
				Arrays.asList(rules.split(OR)));
		
		wordsGroup = new ArrayList<String>(
				Arrays.asList(words.split(OR)));
		
		return new Rule(ruleName, 
				wordsGroup,
				keywordsRefRules);
	}
}
