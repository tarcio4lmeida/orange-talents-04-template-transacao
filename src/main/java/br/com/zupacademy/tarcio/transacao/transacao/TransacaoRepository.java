package br.com.zupacademy.tarcio.transacao.transacao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
	
	@Query(value = "select *"
			+ "  from"
			+ "  transacao.tb_transacao tt"
			+ "  inner join transacao.tb_cartao tc on"
			+ "	 tt.cartao_id = tc.id"
			+ "  where tc.uuid = :nr_processo"
			+ "  order by tt.id desc"
			+ "  limit 10;",  nativeQuery = true)
	List<Transacao> findLast10rderByIdDesc(String nr_processo);

}
