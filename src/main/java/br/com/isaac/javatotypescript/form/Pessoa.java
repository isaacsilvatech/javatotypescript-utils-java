package br.com.isaac.javatotypescript.form;

public class Pessoa {

	private long codPessoa;
	private String cpfCnpj;
	private String nomeRazaoSocial;

	public long getCodPessoa() {
		return codPessoa;
	}

	public void setCodPessoa(long codPessoa) {
		this.codPessoa = codPessoa;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public String getNomeRazaoSocial() {
		return nomeRazaoSocial;
	}

	public void setNomeRazaoSocial(String nomeRazaoSocial) {
		this.nomeRazaoSocial = nomeRazaoSocial;
	}

}
