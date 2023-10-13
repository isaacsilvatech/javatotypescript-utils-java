package br.com.isaac.javatotypescript.converter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TypeScriptType {

	private static final Map<Class<?>, String> TYPES = new HashMap<>() {
		private static final long serialVersionUID = 1L;
		{
			put(Byte.class, "number");
			put(Short.class, "number");
			put(Integer.class, "number");
			put(Long.class, "number");
			put(Float.class, "number");
			put(BigDecimal.class, "number");
			put(BigInteger.class, "number");
			put(String.class, "string");
			put(Boolean.class, "boolean");
			put(Date.class, "Date");
		}
	};
	
	public static String get(Class<?> type) {
		
		return TypeScriptType.TYPES.get(type);
	}
}
