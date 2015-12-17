package co.com.quimera.poemgenerator;

import java.io.IOException;
import java.net.URISyntaxException;

import co.com.quimera.poemgenerator.exception.PoemException;
import co.com.quimera.poemgenerator.logic.PoemBuilder;
import co.com.quimera.poemgenerator.logic.PoemBuilderInterface;

/**
 * @author jlondono
 */
public class RandomPoemApp {

	private PoemBuilderInterface poemBuilder;

	public void createPoem(){
		poemBuilder = new PoemBuilder();
		try {
			poemBuilder.generatePoem();
		} catch (PoemException | IOException | URISyntaxException e) {
			System.out.println(e.getMessage());
		}
	}

	public PoemBuilderInterface getPoemBuilder() {
		return poemBuilder;
	}

	public void setPoemBuilder(PoemBuilderInterface poemBuilder) {
		this.poemBuilder = poemBuilder;
	}

	public static void main(String[] args) {
		new RandomPoemApp().createPoem();
	}
}
