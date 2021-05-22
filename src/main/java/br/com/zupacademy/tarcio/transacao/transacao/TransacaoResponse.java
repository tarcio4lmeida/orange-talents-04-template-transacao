package br.com.zupacademy.tarcio.transacao.transacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.zupacademy.tarcio.transacao.cartao.CartaoResponse;
import br.com.zupacademy.tarcio.transacao.estabelecimento.EstabelecimentoResponse;

public class TransacaoResponse {

    private String id;

    private BigDecimal valor;
    
    private EstabelecimentoResponse estabelecimento;
    
    private CartaoResponse cartao;
    
    private LocalDateTime efetivadaEm;

    @Deprecated
    public TransacaoResponse() {
	}

	public TransacaoResponse(Transacao t) {
		this.id = t.getUuid();
		this.valor = t.getValor();
		this.estabelecimento = new EstabelecimentoResponse(t.getEstabelecimento());
		this.cartao = new CartaoResponse(t.getCartao());
		this.efetivadaEm = t.getEfetivadaEm();
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

}