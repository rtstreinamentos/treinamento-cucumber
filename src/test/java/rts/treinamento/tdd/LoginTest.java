package rts.treinamento.tdd;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import rts.treinamento.app.ServiceLogin;

public class LoginTest {

	@Test
	public void testeLogarComSucesso() {
		String emailValido = "teste@teste.com";
		String senha = "123";

		assertTrue(ServiceLogin.fazerLogin(emailValido, senha));
	}
	
	@Test
	public void testeLogarSemInformarEmail() {
		String emailValido = null;
		String senha = "123";

		assertFalse(ServiceLogin.fazerLogin(emailValido, senha));
	}

	@Test
	public void testeLogarComEmailEmBranco() {
		String emailValido = "";
		String senha = "123";

		assertFalse(ServiceLogin.fazerLogin(emailValido, senha));
	}
	
	@Test
	public void testeLogarSemInformarSenha() {
		String emailValido = "teste@teste.com";
		String senha = null;

		assertFalse(ServiceLogin.fazerLogin(emailValido, senha));
	}
	
	@Test
	public void testeLogarComSenhaEmBranco() {
		String emailValido = "teste@teste.com";
		String senha = "";

		assertFalse(ServiceLogin.fazerLogin(emailValido, senha));
	}
	
	@Test 
	public void testeTentarLogarComSenhaErrada() {
		String emailValido = "teste@teste.com";
		String senha = "123456";

		assertFalse(ServiceLogin.fazerLogin(emailValido, senha));
	}
	
	@Test 
	public void testeTentarLogarComUsuarioNaoCadastrado() {
		String emailValido = "usuarionaocadastrado@teste.com";
		String senha = "123";

		assertFalse(ServiceLogin.fazerLogin(emailValido, senha));
	}
}
