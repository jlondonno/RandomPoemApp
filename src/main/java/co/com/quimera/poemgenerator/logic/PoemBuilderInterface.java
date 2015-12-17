package co.com.quimera.poemgenerator.logic;

import java.io.IOException;
import java.net.URISyntaxException;

import co.com.quimera.poemgenerator.entity.Poem;
import co.com.quimera.poemgenerator.exception.PoemException;

public interface PoemBuilderInterface {

	public abstract Poem generatePoem() throws IOException, URISyntaxException,
			PoemException;
}