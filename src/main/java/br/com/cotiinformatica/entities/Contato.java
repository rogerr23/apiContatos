package br.com.cotiinformatica.entities;

import lombok.Data;

@Data
public class Contato {

	private Integer id;
	private String nome;
	private String email;
	private String telefone;

}
