package br.com.zupacademy.tarcio.transacao.cartao;

import java.io.Serializable;

public class CartaoResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;
	
	private String email;
	
	@Deprecated
	public CartaoResponse() {
	}

	public CartaoResponse(Cartao cartao) {
		this.id = cartao.getId().toString();
		this.email = cartao.getEmail();
	}

	public String getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public Cartao toModel() {
		return new Cartao(this.id, this.email);
	}

	@Override
	public String toString() {
		return "CartaoResponse [id=" + id + ", email=" + email + "]";
	}
	
}

