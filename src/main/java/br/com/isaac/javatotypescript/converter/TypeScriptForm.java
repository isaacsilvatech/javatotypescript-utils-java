package br.com.isaac.javatotypescript.converter;

import java.lang.reflect.Field;

public class TypeScriptForm extends TypeScriptGenerator {

	private Class<?> clazz;

	public TypeScriptForm(Class<?> clazz) {
		this.clazz = clazz;
	}

	@Override
	public String toString() {

		System.out.println("converting " + clazz.getName());

		StringBuilder form = new StringBuilder();

		form.append("form = ");

		createFormGroup(clazz, form);

		form.deleteCharAt(form.indexOf("\t"));
		form.deleteCharAt(form.lastIndexOf(","));
		form.deleteCharAt(form.lastIndexOf("\t"));
		form.deleteCharAt(form.lastIndexOf("\n"));

		return form.toString();
	}

	private void createFormGroup(Class<?> clazz, StringBuilder form) {

		form.append("\tnew FormGroup({\n");

		for (Field field : clazz.getDeclaredFields()) {

			if (isSerialVersionUID(field)) {
				continue;
			}

			String fieldType = getType(field);

			if (fieldType == null) {
				form.append("\t" + field.getName() + ":");
				createFormGroup(field.getType(), form);
				continue;
			}

			form.append("\t" + field.getName() + ": new FormControl<" + fieldType + ">(null),\n");
		}

		form.append("\t}),\n");
	}
}
