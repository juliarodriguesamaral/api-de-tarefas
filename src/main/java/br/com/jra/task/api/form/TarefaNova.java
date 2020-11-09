package br.com.jra.task.api.form;

import javax.validation.constraints.NotBlank;

public class TarefaNova {
	@NotBlank(message = "O nome da tarefa não pode ser vazio e ou nulo")
	private String nome;

	public String getNome() {
		return nome;
	}
	
}
