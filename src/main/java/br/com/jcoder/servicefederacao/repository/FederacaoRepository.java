package br.com.jcoder.servicefederacao.repository;

import br.com.jcoder.servicefederacao.model.Federacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FederacaoRepository extends JpaRepository<Federacao, Integer> {
}
