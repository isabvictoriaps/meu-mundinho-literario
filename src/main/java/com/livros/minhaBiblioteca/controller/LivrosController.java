package com.livros.minhaBiblioteca.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.livros.minhaBiblioteca.model.Livros;
import com.livros.minhaBiblioteca.repository.LivrosRepository;


@RestController
@RequestMapping("/Livros")

public class LivrosController {

	@Autowired
	private LivrosRepository livrosRepository;
	
	@GetMapping
	public List<Livros> listarLivros() {
		return livrosRepository.findAll();
		
	}
	
	@GetMapping("/autores")
	public List<String> listarAutores() {
	    return livrosRepository.findAllAuthors();
	}

	
	@GetMapping("/titulos")
	public List<String> listarTitulos() {
	    return livrosRepository.findAllBooks();
	}
	
	@GetMapping("/categorias")
	public List<String> listarCategorias() {
	    return livrosRepository.findAllCategories();
	}
	
	
	@GetMapping("/autores/{autor}")
	public List<Livros> listarAutor(@PathVariable String autor) {
	    List<Livros> livros = livrosRepository.findAll();
	    List<Livros> livrosDoAutor = new ArrayList<>();
	    for (Livros livro : livros) {
	        if (livro.getAutor().equals(autor)) {
	            livrosDoAutor.add(livro);
	        }
	    }
	    return livrosDoAutor;
	}
	

	@GetMapping("/categorias/{categoria}")
	public List<Livros> listarCategoria(@PathVariable String categoria) {
	    List<Livros> categorias = livrosRepository.findAll();
	    List<Livros> livrosCategorias = new ArrayList<>();
	    for (Livros livro : categorias) {
	        if (livro.getCategoria().equals(categoria)) {
	            livrosCategorias.add(livro);
	        }
	    }
	    return livrosCategorias;
	}
	
	@GetMapping("/titulos/{titulo}")
	public List<Livros> listarLivro(@PathVariable String titulo) {
	    List<Livros> livros = livrosRepository.findAll();
	    List<Livros> titulos = new ArrayList<>();
	    for (Livros livro : livros) {
	        if (livro.getTitulo().equals(titulo)) {
	            titulos.add(livro);
	        }
	    }
	    return titulos;
	}
	
	@GetMapping("/disponivel")
	public List<Livros> listarLivrosDisponiveis() {
	    return livrosRepository.findByDisponivelTrue();
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Livros> buscarPorId(@PathVariable Long id) {
	Optional<Livros> livros = livrosRepository.findById(id);
	return livros.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Livros adicionar(@RequestBody Livros livros) {
		return livrosRepository.save(livros);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Livros> excluir(@PathVariable Long id) {
	Optional<Livros> usuario = livrosRepository.findById(id);
	 if (usuario.isPresent()) {
		 	livrosRepository.delete(usuario.get());
		 	return ResponseEntity.ok().build();
		 } else {
		 	return ResponseEntity.notFound().build();
		 }
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Livros> atualizar(@PathVariable Long id, @RequestBody Livros livrosAtualizado) {
		Optional<Livros> livrosExistente = livrosRepository.findById(id);
		if (livrosExistente.isPresent()) {
			Livros livros = livrosExistente.get();
			livros.setTitulo(livrosAtualizado.getTitulo());
			livros.setAutor(livrosAtualizado.getAutor());
			livros.setCategoria(livrosAtualizado.getCategoria());
			livros.setDescricao(livrosAtualizado.getDescricao());
			livros.setEditora(livrosAtualizado.getEditora());
			if (livrosAtualizado.getPaginas() != null) {
				livros.setPaginas(livrosAtualizado.getPaginas());
			}
			livros.setDisponivel(livrosAtualizado.isDisponivel());
			Livros livroAtualizado = livrosRepository.save(livros);
			return ResponseEntity.ok(livros);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	
}
