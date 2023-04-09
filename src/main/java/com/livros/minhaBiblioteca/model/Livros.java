package com.livros.minhaBiblioteca.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor

@Entity
public class Livros {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="Título")
	private String titulo;
	
	@Column(name="Autor")
	private String autor;
	

	@Column(name="Editora")
	private String editora;
	
	@Column(name="Páginas")
	private int páginas;
	
	@Column(name="Descrição")
	private String descrição;
	
	@Column(name="Categoria")
	private String categoria;
	
	@Column(name="Disponibilidade")
	private boolean disponivel;
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livros other = (Livros) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	

}