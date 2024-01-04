package com.generation.farmacia.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "produto")
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 100)
	@NotBlank(message = "O atributo nome é obrigatório!")
	@Size(min = 7, max = 100, message = "O atributo nome deve conter no mínimo 7 e no máximo 100 caracteres")
	private String nome;

	@Digits(integer = 6, fraction = 2, message = "O preço deve ter no máximo 8 dígitos, sendo 6 inteiros e 2 decimais.")
	@NotNull(message = "O atributo preço é obrigatório!")
	private double preco;

	@UpdateTimestamp
	private LocalDateTime data;
	
	@ManyToOne
    @JsonIgnoreProperties({"produtos"})
	@JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;

	// Construtores, getters e setters
	public Produto() {
	}

	public Produto(Long id,
			@NotBlank(message = "O atributo nome é obrigatório!") @Size(min = 7, max = 100, message = "O atributo nome deve conter no mínimo 7 e no máximo 100 caracteres") String nome,
			@Digits(integer = 6, fraction = 2, message = "O preço deve ter no máximo 8 dígitos, sendo 6 inteiros e 2 decimais.") @NotNull(message = "O atributo preço é obrigatório!") double preco,
			LocalDateTime data) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.data = data;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
}
