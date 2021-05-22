package br.com.zupacademy.tarcio.transacao.transacao.kafka;

import javax.transaction.Transactional;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import br.com.zupacademy.tarcio.transacao.cartao.CartaoRepository;
import br.com.zupacademy.tarcio.transacao.transacao.Transacao;
import br.com.zupacademy.tarcio.transacao.transacao.TransacaoRepository;

@Component
public class ListenerDeTransacao {
	
	private TransacaoRepository transacaoRepository;
	
	private CartaoRepository cartaoRepository;
	
    public ListenerDeTransacao(TransacaoRepository transacaoRepository, CartaoRepository cartaoRepository) {
		this.transacaoRepository = transacaoRepository;
		this.cartaoRepository = cartaoRepository;
	}

	@KafkaListener(topics = "${spring.kafka.topic.transactions}")
	@Transactional
    public void ouvir(EventoDeTransacao eventoDeTransacao) {
        System.out.println(eventoDeTransacao);
  
        Transacao transacao = eventoDeTransacao.toModel(cartaoRepository);
        transacaoRepository.save(transacao);
    }

}