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

	public EstabelecimentoResponse(Estabelecimento e) {
		this.nome = e.getNome();
		this.cidade = e.getCidade();
		this.endereco = e.getEndereco();
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
