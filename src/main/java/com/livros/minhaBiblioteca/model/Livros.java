package com.livros.minhaBiblioteca.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode

@Entity
public class Livros {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="titulo")
	private String titulo;
	
	@Column(name="autor")
	private String autor;
	

	@Column(name="Editora")
	private String editora;
	
	@Column(name="paginas")
	private Integer paginas;
	
	@Column(name="descricao")
	private String descricao;
	
	@Column(name="Categoria")
	private String categoria;
	
	@Column(name="Disponibilidade")
	private boolean disponivel;
	
	

}
