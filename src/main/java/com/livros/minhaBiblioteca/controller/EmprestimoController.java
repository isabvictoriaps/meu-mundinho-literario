package com.livros.minhaBiblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.livros.minhaBiblioteca.model.Emprestimo;
import com.livros.minhaBiblioteca.repository.EmprestimoRepository;

@RestController
@RequestMapping("/Emprestimo")
public class EmprestimoController {
	
	@Autowired
	private EmprestimoRepository emprestimoRepository;

	@GetMapping
	public List<Emprestimo> listarEmprestimos(){
		return emprestimoRepository.findAll();	
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Emprestimo adicionar(@RequestBody Emprestimo emprestimo) {
		return emprestimoRepository.save(emprestimo);
	}
	

}
