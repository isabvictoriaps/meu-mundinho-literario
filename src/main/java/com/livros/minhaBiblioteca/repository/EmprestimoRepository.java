package com.livros.minhaBiblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.livros.minhaBiblioteca.model.Emprestimo;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long>{

}
