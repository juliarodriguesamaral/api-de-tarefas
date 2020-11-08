package br.com.jra.task.api.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	public void criarTarefa(@RequestBody TarefaNova novaTarefa) {
		
		Tarefa tarefa = new Tarefa(novaTarefa.getNome());
		
		repository.save(tarefa);
	}
	
	@GetMapping
	public List<Tarefa> listarTarefas(){
		return repository.findAll();
	}

}
