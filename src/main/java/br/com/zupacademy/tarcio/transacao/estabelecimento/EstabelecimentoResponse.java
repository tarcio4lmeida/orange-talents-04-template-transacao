package br.com.zupacademy.tarcio.transacao.estabelecimento;

import java.io.Serializable;

public class EstabelecimentoResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String nome;
	
	private String cidade;
	
	private String endereco;
	
	@Deprecated
	public EstabelecimentoResponse() {
	}

	public EstabelecimentoResponse(String nome, String cidade, String endereco) {
		this.nome = nome;
		this.cidade = cidade;
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEndereco() {
		return endereco;
	}
	
	public Estabelecimento toModel() {
		return new Estabelecimento (this.nome, this.cidade, this.endereco);
	}

	@Override
	public String toString() {
		return "EstabelecimentoResponse [nome=" + nome + ", cidade=" + cidade + ", endereco=" + endereco + "]";
	} 
	
}
