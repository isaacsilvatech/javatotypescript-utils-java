package br.com.isaac.javatotypescript.converter;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class TypeScriptModel extends TypeScriptGenerator {

	private Class<?> clazz;
	private List<Class<?>> imports = new ArrayList<>();

	public TypeScriptModel(Class<?> clazz) {
		this.clazz = clazz;
	}

	@Override
	public String toString() {

		System.out.println("converting " + clazz.getName());

		StringBuilder model = new StringBuilder();

		model.append("export interface " + clazz.getSimpleName() + " {\n");

		for (Field field : clazz.getDeclaredFields()) {

			if (isSerialVersionUID(field)) {
				continue;
			}

			model.append("\t" + field.getName() + ": " + getType(field) + ";\n");
		}

		model.append("}");

		resolveImports(model);

		return model.toString();
	}

	@Override
	protected String getType(Field field) {

		String type = super.getType(field);

		if (type == null) {
			imports.add(field.getType());
			return field.getType().getSimpleName();
		}

		return type;
	}

	private void resolveImports(StringBuilder model) {

		if (imports.size() == 0) {
			return;
		}

		int indexInsert = model.indexOf("export");

		for (Class<?> impClass : imports) {

			String fileName = TypeScriptLoader.getFileName(impClass, "model").replace(".ts", "");
			String importStr = "import { " + impClass.getSimpleName() + " } from './" + fileName + "';\n";

			model.insert(indexInsert, importStr);
		}

		indexInsert = model.indexOf("export");
		model.insert(indexInsert, "\n");
	}

}
