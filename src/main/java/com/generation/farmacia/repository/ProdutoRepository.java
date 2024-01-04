package com.generation.farmacia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.generation.farmacia.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	List<Produto> findAllByNomeContainingIgnoreCase(@Param("Produto") String nome);

	List<Produto> findByPrecoLessThan(double preco);

	List<Produto> findByPrecoGreaterThan(double preco);

}
