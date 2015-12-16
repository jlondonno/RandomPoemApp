package co.com.quimera.poemgenerator.util;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileReader {

	public static List<String> readFile(String fileName) throws IOException, URISyntaxException {
		Path path = Paths.get(ClassLoader.getSystemResource(fileName)
				.toURI());
		List<String> lines = null;
		Charset charset = Charset.forName("ISO-8859-1");
		lines = Files.readAllLines(path, charset);
		return lines;
	}
}
