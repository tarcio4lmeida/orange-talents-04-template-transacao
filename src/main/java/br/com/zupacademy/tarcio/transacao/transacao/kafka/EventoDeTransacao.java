package br.com.zupacademy.tarcio.transacao.transacao.kafka;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.zupacademy.tarcio.transacao.cartao.CartaoResponse;
import br.com.zupacademy.tarcio.transacao.estabelecimento.EstabelecimentoResponse;
import br.com.zupacademy.tarcio.transacao.transacao.Transacao;

public class EventoDeTransacao {

    private String id;

    private BigDecimal valor;
    
    private EstabelecimentoResponse estabelecimento;
    
    private CartaoResponse cartao;
    
    private LocalDateTime efetivadaEm;

    @Deprecated
    public EventoDeTransacao() {
	}

	public EventoDeTransacao(String id, BigDecimal valor, EstabelecimentoResponse estabelecimento,
			CartaoResponse cartao, LocalDateTime efetivadaEm) {
		this.id = id;
		this.valor = valor;
		this.estabelecimento = estabelecimento;
		this.cartao = cartao;
		this.efetivadaEm = efetivadaEm;
	}

	public String getId() {
		return id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public EstabelecimentoResponse getEstabelecimento() {
		return estabelecimento;
	}

	public CartaoResponse getCartao() {
		return cartao;
	}

	public LocalDateTime getEfetivadaEm() {
		return efetivadaEm;
	}

	public Transacao toModel() {
		return new Transacao(this.id, this.valor, this.estabelecimento.toModel(), this.cartao.toModel(), this.efetivadaEm);
	}

	@Override
	public String toString() {
		return "EventoDeTransacao [id=" + id + ", valor=" + valor + ", estabelecimento=" + estabelecimento + ", cartao="
				+ cartao + ", efetivadaEm=" + efetivadaEm + "]";
	}
    
}