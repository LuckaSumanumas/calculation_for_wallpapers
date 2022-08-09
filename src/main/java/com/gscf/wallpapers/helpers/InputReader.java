package com.gscf.wallpapers.helpers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputReader {

	Logger logger = Logger.getLogger(InputReader.class.getName());

	public List<String> readFromInput() {
		String fileName = "input1.txt";

		ClassLoader classLoader = getClass().getClassLoader();

		File file = new File(classLoader.getResource(fileName).getFile());

		List<String> dimentions = new ArrayList<>();

		try (Stream<String> stream = Files.lines(Paths.get(file.getPath()))) {
			dimentions = stream.collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return dimentions;
	}

}
