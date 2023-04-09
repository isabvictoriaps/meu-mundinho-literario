package com.livros.minhaBiblioteca.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long uuid;
	
	@Column(name="nm_completo")
	private String nomeCompleto;
	
	@Email(message = "Email inválido. O email deve conter o caractere '@'")
	@Column(name="email")
	private String email;
	
	@Column(name= "senha")
	private String senha;

	
}
