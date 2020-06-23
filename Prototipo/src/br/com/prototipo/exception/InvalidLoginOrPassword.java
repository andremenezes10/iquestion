package br.com.prototipo.exception;

public class InvalidLoginOrPassword extends RuntimeException {
	private static final long serialVersionUID = -3437701091333023173L;

	public InvalidLoginOrPassword() {
		super("Login ou Senha inválidos");
	}
}
