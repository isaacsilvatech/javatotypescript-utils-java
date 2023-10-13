package br.com.isaac.javatotypescript.converter;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class TypeScriptLoader {

	private URL systemResource;
	private String packageFull;

	public TypeScriptLoader(String packageFull, URL systemResource) {
		this.packageFull = packageFull;
		this.systemResource = systemResource;
	}

	public List<Class<?>> getAllClasses() throws URISyntaxException, ClassNotFoundException {

		File directory = new File(systemResource.toURI());
		List<Class<?>> classes = new ArrayList<>();

		for (File file : directory.listFiles()) {
			String fullyQualifiedName = packageFull + "." + file.getName().replace(".class", "");
			Class<?> clazz = Class.forName(fullyQualifiedName);
			classes.add(clazz);
		}

		return classes;
	}

	public static String getFileName(Class<?> clazz, String prefix) {
		String fileName = clazz.getSimpleName().replaceAll("([A-Z])", "-$1").toLowerCase().substring(1);
		return fileName + "." + prefix + ".ts";
	}
}
