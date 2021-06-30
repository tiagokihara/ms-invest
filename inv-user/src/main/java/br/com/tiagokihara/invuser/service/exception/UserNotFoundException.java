package br.com.tiagokihara.invuser.service.exception;

public class UserNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public UserNotFoundException(Long lm) {
		super(String.format("Nenhum usuário foi encontrado para o id: %d", lm));
	}

}
