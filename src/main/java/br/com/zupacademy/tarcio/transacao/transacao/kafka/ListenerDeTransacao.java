package br.com.zupacademy.tarcio.transacao.transacao.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import br.com.zupacademy.tarcio.transacao.transacao.Transacao;
import br.com.zupacademy.tarcio.transacao.transacao.TransacaoRepository;

@Component
public class ListenerDeTransacao {
	
	private TransacaoRepository transacaoRepository;
	
    public ListenerDeTransacao(TransacaoRepository transacaoRepository) {
		this.transacaoRepository = transacaoRepository;
	}

	@KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void ouvir(EventoDeTransacao eventoDeTransacao) {
        System.out.println(eventoDeTransacao);
        Transacao transacao = eventoDeTransacao.toModel();
        
        transacaoRepository.save(transacao);
    }

}