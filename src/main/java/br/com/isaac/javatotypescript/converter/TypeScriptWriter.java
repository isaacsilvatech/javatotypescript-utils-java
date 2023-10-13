package br.com.isaac.javatotypescript.converter;

import java.io.FileOutputStream;
import java.io.PrintWriter;

public class TypeScriptWriter {

	private PrintWriter writer;

	public TypeScriptWriter(FileOutputStream fileOutputStream) {
		writer = new PrintWriter(fileOutputStream);
	}

	public void write(TypeScriptGenerator generator) {
		writer.write(generator.toString());
		writer.close();
	}
}
