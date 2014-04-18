package rtstreinamento.app;

public class ServiceLogin {

	public static boolean fazerLogin(String email, String senha) {
		String senhaValida = "123";
		String usuarioCadastrado = "teste@teste.com";
		
		return email == usuarioCadastrado && senha == senhaValida;
	}

}
