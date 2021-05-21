package br.com.zupacademy.tarcio.transacao.transacao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.zupacademy.tarcio.transacao.cartao.Cartao;
import br.com.zupacademy.tarcio.transacao.estabelecimento.Estabelecimento;

@Entity
@Table(name = "tb_transacao")
public class Transacao implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String uuid;
	
	@Column(nullable = false)
	private BigDecimal valor;
	
	@OneToOne(cascade = {CascadeType.ALL})
	private Estabelecimento estabelecimento;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	private Cartao cartao;
	
	@Column(nullable = false)
	private LocalDateTime efetivadaEm;
	
	@Deprecated
	public Transacao() {
	}

	public Transacao(String uuid, BigDecimal valor, Estabelecimento estabelecimento, Cartao cartao, LocalDateTime efetivadaEm) {
		this.uuid = uuid;
		this.valor = valor;
		this.estabelecimento = estabelecimento;
		this.cartao = cartao;
		this.efetivadaEm = efetivadaEm;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getUuid() {
		return uuid;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public Cartao getCartao() {
		return cartao;
	}

	public LocalDateTime getEfetivadaEm() {
		return efetivadaEm;
	}
	
}
