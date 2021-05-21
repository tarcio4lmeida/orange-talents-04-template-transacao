package br.com.zupacademy.tarcio.transacao.cartao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_cartao")
public class Cartao implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String uuid;
	
	@Column(nullable = false)
	private String email;
	
	@Deprecated
	public Cartao() {
	}

	public Cartao(String uuid, String email) {
		this.uuid = uuid;
		this.email = email;
	}

	public Long getId() {
		return id;
	}
	
	public String getUuid() {
		return uuid;
	}

	public String getEmail() {
		return email;
	}
	
}

