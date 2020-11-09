package br.com.jra.task.api.controller;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jra.task.api.domain.Tarefa;
import br.com.jra.task.api.form.TarefaNova;

@RestController
@RequestMapping("/api/tarefa")
public class TarefaController {
	
	
	
	@Autowired
	private TarefaRepository repository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<Tarefa> criarTarefa(@RequestBody @Valid TarefaNova novaTarefa) {
		
		Tarefa tarefa = new Tarefa(novaTarefa.getNome());
		
		repository.save(tarefa);
		
		return ResponseEntity.status(201).body(tarefa);
	}
	
	@GetMapping
	public List<Tarefa> listarTarefas(){
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity <Optional<Tarefa>> listarUmaTarefa(@PathVariable Long id){
		Optional<Tarefa> tarefa = repository.findById(id);
		
		if(tarefa.isPresent()) {
			return ResponseEntity.ok().body(tarefa);
		}
		
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletarTarefa(@PathVariable Long id){
		repository.deleteById(id);
		return ResponseEntity.ok().build();
	}

}
