# Tool-JavaToTypeScript

**Tool-JavaToTypeScript** é uma ferramenta Java que facilita a conversão de classes de domínio Java em modelos TypeScript e formulários reativos do Angular. Esta ferramenta é projetada para simplificar a integração entre o backend Java e o frontend Angular, economizando tempo e evitando erros de digitação.

## Como Funciona

A ferramenta opera da seguinte maneira:

- **Main** execute o main localizado no pacote *br.com.isaac.javatotypescript*
```
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
```

- **Processamento**: A ferramenta analisará os arquivos Java e extrairá informações sobre as classes, atributos e tipos de dados. Ela mapeará as classes de domínio Java para modelos TypeScript correspondentes.

- **Geração de Código**: A ferramenta gerará automaticamente os arquivos TypeScript que representam os modelos correspondentes às suas classes de domínio Java. Além disso, ela criará formulários reativos do Angular com base nas classes de domínio.

- **Saída: Os arquivos** TypeScript gerados e os formulários reativos estarão na pasta ./typescript/.

## Como usar

- Caso queira transformar em um **model** typescript basta adicionar o domain no pacote *br.com.isaac.javatotypescript.model*
- Caso queira transformar em um **formulario reativo angular**  basta adicionar o domain no pacote *br.com.isaac.javatotypescript.form*

## Exemplo

```
public class Pessoa {

	private long codPessoa;
	private String cpfCnpj;
	private String nomeRazaoSocial;
  //...
}
```
### Saída

```
//pessoa.model.ts

export interface Pessoa {
	codPessoa: number;
	cpfCnpj: string;
	nomeRazaoSocial: string;
}
```

```
//pessoa.form.ts

form = new FormGroup({
	codPessoa: new FormControl<number>(null),
	cpfCnpj: new FormControl<string>(null),
	nomeRazaoSocial: new FormControl<string>(null),
})
```
