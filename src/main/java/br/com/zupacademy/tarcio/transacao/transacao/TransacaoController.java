package br.com.zupacademy.tarcio.transacao.transacao;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.tarcio.transacao.cartao.Cartao;
import br.com.zupacademy.tarcio.transacao.cartao.CartaoRepository;

@RestController
@RequestMapping(value = "/transacoes")
public class TransacaoController {

	private CartaoRepository cartaoRepository;
	private TransacaoRepository transacaoRepository;
	

	public TransacaoController(CartaoRepository cartaoRepository, TransacaoRepository transacaoRepository) {
		this.cartaoRepository = cartaoRepository;
		this.transacaoRepository = transacaoRepository;
	}

	@GetMapping("/{id}")
	@Transactional
	public ResponseEntity<?> listaDezUltimasTransacoes(@PathVariable("id") String id) {
		Cartao cartao = cartaoRepository.findByUuid(id);
		if (cartao == null) {
			return ResponseEntity.notFound().build();
		}
		List<Transacao> listTransacoes = transacaoRepository.findLast10rderByIdDesc(id);
		List<TransacaoResponse> listTransacoesResponse = listTransacoes.stream().map(x -> new TransacaoResponse(x))
				.collect(Collectors.toList());

		return ResponseEntity.ok().body(listTransacoesResponse);

	}
}
