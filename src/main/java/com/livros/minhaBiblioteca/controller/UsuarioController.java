package com.livros.minhaBiblioteca.controller;

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

import com.livros.minhaBiblioteca.model.Usuario;
import com.livros.minhaBiblioteca.repository.UsuarioRepository;

@RestController
@RequestMapping("/Usuario")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping
	public List<Usuario> listarUsuarios() {
		return usuarioRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Usuario> buscarPorId(@PathVariable Long id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		return usuario.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario adicionar(@RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Usuario> deletarPorId(@PathVariable Long id){
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		usuarioRepository.delete(usuario.get());
		 if (usuario.isPresent()){
			 return ResponseEntity.ok().build();
		 } else {
		 	return ResponseEntity.notFound().build();
		 }
	}
	

	@PutMapping("/{id}")
	public ResponseEntity<Usuario> atualizar(@PathVariable Long id, @RequestBody Usuario usuarioAtualizado) {
	Optional<Usuario> usuariosExistente = usuarioRepository.findById(id);
	 if (usuariosExistente.isPresent()) {
		 	Usuario usuario = usuariosExistente.get();
		 	usuario.setNomeCompleto(usuarioAtualizado.getNomeCompleto());
		 	usuario.setEmail(usuarioAtualizado.getEmail());
		 	usuario.setSenha(usuarioAtualizado.getSenha());
	        Usuario usuariosAtualizado = usuarioRepository.save(usuario);
		 	return ResponseEntity.ok(usuario);
		 } else {
		 	return ResponseEntity.notFound().build();
		 }
	}
	

}