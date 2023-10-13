package br.com.isaac.javatotypescript.converter;

import java.lang.reflect.Field;

public abstract class TypeScriptGenerator {

	public abstract String toString();

	protected String getType(Field field) {

		Class<?> type = field.getType();

		if (type.isPrimitive())
			return "number";

		return TypeScriptType.get(type);
	}
	
	protected boolean isSerialVersionUID(Field field) {
		return field.getType().isPrimitive() && field.getName().equals("serialVersionUID");
	}
}
