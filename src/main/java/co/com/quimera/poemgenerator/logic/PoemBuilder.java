package co.com.quimera.poemgenerator.logic;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;
import java.util.Random;

import co.com.quimera.poemgenerator.entity.Poem;
import co.com.quimera.poemgenerator.entity.Rule;
import co.com.quimera.poemgenerator.exception.PoemException;
import co.com.quimera.poemgenerator.util.FileReader;

public class PoemBuilder implements PoemBuilderInterface {
	
	private static final String POEM_RULES_FILE = "poem-rules.txt";
	public static final String LINEBREAK = "$LINEBREAK";
	public static final String END = "$END";
	public static final String[] END_WORDS = { 
			"ADJECTIVE", 
			"NOUN",
			"VERB"
			};
	
	private RuleBuilderInterface rb;
	
	@Override
	public Poem generatePoem() throws IOException, URISyntaxException, PoemException{
		Poem thePoem = new Poem();
		List<String> fileContent = FileReader.readFile(POEM_RULES_FILE);
		rb = new RuleBuilder();

		for (String string : fileContent) {
			Rule rule = rb.buildRule(string);
			thePoem.getRules().put(rule.getName(), rule);
		}

		// Generate the poem
		for (Map.Entry<String, Rule> entry : thePoem.getRules().entrySet()) {
//			System.out.println(entry.getKey() + "/" + entry.getValue());
		}
		
		List<String> refRules = thePoem.getRules().get("POEM").getKeywordsRefRuleGroup();
		
		for (String rule : refRules) {
			createLine(rule.substring(1, rule.length() - 1), thePoem.getRules());
		}
		
		return thePoem;
	}
	
	private void createLine(String ruleName, Map<String, Rule> rulesMap) {
		String randonWord = rulesMap.get(ruleName).getRandomWord();
		String randonKeywordRefRule = rulesMap.get(ruleName).getRandomKeywordRefRule();
		findDefinition(randonWord, rulesMap);
		findDefinition(randonKeywordRefRule, rulesMap);
	}
	
	public void findDefinition(String word, Map<String, Rule> rulesMap){
		
		if (word.startsWith("<") && word.endsWith(">")) {
			findDefinition(word.substring(1, word.length() - 1), rulesMap);
		} else {
			
			if (LINEBREAK.equals(word)) {
				System.out.print("\n");
			} else if (END.equals(word)) {
				// adjective, a noun or a verb
				findDefinition(this.getRandomEndWord(), rulesMap);
			} else{
				Rule mainRule = rulesMap.get(word);
				
				if(mainRule != null){
					String randonWord = mainRule.getRandomWord();
					String randonKeywordRefRule = mainRule.getRandomKeywordRefRule();
					findDefinition(randonWord, rulesMap);
					findDefinition(randonKeywordRefRule, rulesMap);
				} else {
					System.out.print(" " + word);
				}
			} 
		}
		
	}
	
	public String getRandomEndWord(){
		Random rand = new Random();
	    int randomNum = rand.nextInt(END_WORDS.length);
		return END_WORDS[randomNum];
	}

	public RuleBuilderInterface getRb() {
		return rb;
	}

	public void setRb(RuleBuilderInterface rb) {
		this.rb = rb;
	}
}
