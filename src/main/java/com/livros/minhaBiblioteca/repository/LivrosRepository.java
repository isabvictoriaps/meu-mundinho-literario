package com.livros.minhaBiblioteca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.livros.minhaBiblioteca.model.Livros;


public interface LivrosRepository  extends JpaRepository<Livros, Long>{

    List<Livros> findByDisponivelTrue();
	
    List<Livros> findByAutor(String autor);
	
    List<Livros> findByTitulo(String titulo);
    
    List<Livros> findByCategoria(String categoria);
    
    @Query("SELECT DISTINCT autor FROM Livros")
    List<String> findAllAuthors();
    
    @Query("SELECT DISTINCT titulo FROM Livros")
    List<String> findAllBooks();
    
    @Query("SELECT DISTINCT categoria FROM Livros")
    List<String> findAllCategories();
    
   
}
