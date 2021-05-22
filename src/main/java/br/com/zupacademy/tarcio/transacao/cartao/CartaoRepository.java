package br.com.zupacademy.tarcio.transacao.cartao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartaoRepository extends JpaRepository<Cartao, Long> {

	Cartao findByUuid(String id);
}
