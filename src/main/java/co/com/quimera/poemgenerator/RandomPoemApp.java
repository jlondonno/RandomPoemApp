package co.com.quimera.poemgenerator;

import java.io.IOException;
import java.net.URISyntaxException;

import co.com.quimera.poemgenerator.entity.Poem;
import co.com.quimera.poemgenerator.exception.PoemException;
import co.com.quimera.poemgenerator.logic.PoemBuilder;
import co.com.quimera.poemgenerator.logic.PoemBuilderInterface;

/**
 * @author jlondono
 */
public class RandomPoemApp {

	private PoemBuilderInterface poemBuilder;
	
	public void createPoem() throws PoemException {
		poemBuilder = new PoemBuilder();
		try {
			Poem myPoem = poemBuilder.generatePoem();
			System.out.println(myPoem.getBodyPoem());
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
	}

	public PoemBuilderInterface getPoemBuilder() {
		return poemBuilder;
	}
	
	public void setPoemBuilder(PoemBuilderInterface poemBuilder) {
		this.poemBuilder = poemBuilder;
	}

	public static void main(String[] args) {
		try {
			new RandomPoemApp().createPoem();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
