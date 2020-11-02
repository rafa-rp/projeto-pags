package br.com.projeto.pag.contasbancarias.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.projeto.pag.contasbancarias.model.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Integer> {

	Optional<Conta> findByContaNumero(String contaNumero);


	@Query("select c from Conta c where c.agencia = :filtro or c.contaNome = :filtro or c.chequeEspecialLiberado = :filtro")
	Page<Conta> findByFiltro(@Param("filtro") String filtro, Pageable paginacao);

}
