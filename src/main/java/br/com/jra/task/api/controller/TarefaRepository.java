package br.com.jra.task.api.controller;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jra.task.api.domain.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long>{
	

}
