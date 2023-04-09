package com.livros.minhaBiblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.livros.minhaBiblioteca.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
