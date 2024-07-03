package br.com.cotiinformatica.dtos;

import lombok.Data;

@Data
public class ContatoResponseDto {

	private Integer id;
	private String nome;
	private String email;
	private String telefone;
}
