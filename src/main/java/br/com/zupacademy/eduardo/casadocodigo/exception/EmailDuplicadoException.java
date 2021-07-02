package br.com.zupacademy.eduardo.casadocodigo.exception;

public class EmailDuplicadoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EmailDuplicadoException(String mensagemErro)
	{
		super(mensagemErro);
	}
}
