package br.com.prototipo.exception;

public class ErroException extends RuntimeException {
	private static final long serialVersionUID = -4237701091333023173L;

	public ErroException(String erro) {
		super(erro);
	}

}