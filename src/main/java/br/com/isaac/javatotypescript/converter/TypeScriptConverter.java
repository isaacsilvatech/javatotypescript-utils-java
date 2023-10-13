package br.com.isaac.javatotypescript.converter;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.List;

public class TypeScriptConverter {

	private String modelPackage;
	private String formPackage;
	private String outputPath;

	public TypeScriptConverter(String modelPackage, String formPackage, String outputPath) {
		this.modelPackage = modelPackage;
		this.formPackage = formPackage;
		this.outputPath = outputPath;
	}

	public void toConvert() throws Exception {

		System.out.println("converting...");

		clearOutputPath();

		convertTo(TypeScriptModel.class, modelPackage, "model");
		convertTo(TypeScriptForm.class, formPackage, "form");

		System.out.println("conversation completed!");
	}

	private void clearOutputPath() {
		File typescriptFolder = new File(outputPath);

		if (!typescriptFolder.exists())
			typescriptFolder.mkdir();

		for (File file : typescriptFolder.listFiles()) {
			file.delete();
		}
	}

	private void convertTo(Class<? extends TypeScriptGenerator> generator, String packagee, String prefix)
			throws Exception {

		TypeScriptLoader loader = createLoader(packagee);

		List<Class<?>> listClass = loader.getAllClasses();

		for (Class<?> clazz : listClass) {

			String fileName = TypeScriptLoader.getFileName(clazz, prefix);
			String pathFull = outputPath + "/" + fileName;

			TypeScriptGenerator generatorInstance = (TypeScriptGenerator) generator.getDeclaredConstructors()[0]
					.newInstance(clazz);
			TypeScriptWriter typeScriptWriter = new TypeScriptWriter(new FileOutputStream(pathFull));
			typeScriptWriter.write(generatorInstance);
		}
	}

	private TypeScriptLoader createLoader(String packagee) {
		URL systemResource = ClassLoader.getSystemResource(packagee.replace(".", "//"));
		return new TypeScriptLoader(packagee, systemResource);
	}

}
