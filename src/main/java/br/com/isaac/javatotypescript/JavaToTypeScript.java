package br.com.isaac.javatotypescript;

import br.com.isaac.javatotypescript.converter.TypeScriptConverter;

public class JavaToTypeScript {

	public static void main(String[] args) throws Exception {

		String modelPackage = "br.com.isaac.javatotypescript.model";
		String formPackage = "br.com.isaac.javatotypescript.form";
		String outputPath = "./typescript";

		TypeScriptConverter converter = new TypeScriptConverter(modelPackage, formPackage, outputPath);

		converter.toConvert();
	}
}
