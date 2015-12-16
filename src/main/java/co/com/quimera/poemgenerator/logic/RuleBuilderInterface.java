package co.com.quimera.poemgenerator.logic;

import co.com.quimera.poemgenerator.entity.Rule;
import co.com.quimera.poemgenerator.exception.PoemException;

public interface RuleBuilderInterface {

	public abstract Rule buildRule(String str) throws PoemException;

}