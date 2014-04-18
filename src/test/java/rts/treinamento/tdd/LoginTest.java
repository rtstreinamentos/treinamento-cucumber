package rts.treinamento.tdd;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import rts.treinamento.app.ServiceLogin;

public class LoginTest {

	/**
	 * Dado que tenho credencias válidas
	 * Quando tento logar
	 * Então minha autenticação é feita com sucesso
	 */
	@Test
	public void testeLogarComSucesso() {
		String emailValido = "teste@teste.com";
		String senha = "123";

		assertTrue(ServiceLogin.fazerLogin(emailValido, senha));
	}
	
	
	/**
	 * Dado que não tenho um e-mail
	 * Quando tento logar
	 * Então minha autenticação não é finalizada
	 */
	@Test
	public void testeLogarSemInformarEmail() {
		String emailValido = null;
		String senha = "123";

		assertFalse(ServiceLogin.fazerLogin(emailValido, senha));
	}

	/**
	 * Dado que não tenho um e-mail
	 * Quando tento logar
	 * Então minha autenticação não é finalizada
	 */
	@Test
	public void testeLogarComEmailEmBranco() {
		String emailValido = "";
		String senha = "123";

		assertFalse(ServiceLogin.fazerLogin(emailValido, senha));
	}
	
	/**
	 * Dado que não lembro minha senha
	 * Quando tento logar sem preencher a senha
	 * Então minha autenticação não é finalizada
	 */
	@Test
	public void testeLogarSemInformarSenha() {
		String emailValido = "teste@teste.com";
		String senha = null;

		assertFalse(ServiceLogin.fazerLogin(emailValido, senha));
	}
	
	/**
	 * Dado que não lembro minha senha
	 * Quando tento logar sem preencher a senha
	 * Então minha autenticação não é finalizada
	 */
	@Test
	public void testeLogarComSenhaEmBranco() {
		String emailValido = "teste@teste.com";
		String senha = "";

		assertFalse(ServiceLogin.fazerLogin(emailValido, senha));
	}
	
	/**
	 * Dado que não lembro minha senha
	 * Quando tento logar com uma senha errada
	 * Então minha autenticação não é finalizada
	 */
	@Test 
	public void testeTentarLogarComSenhaErrada() {
		String emailValido = "teste@teste.com";
		String senha = "123456";

		assertFalse(ServiceLogin.fazerLogin(emailValido, senha));
	}
	
	/**
	 * Dado que não lembro meu e-mail de cadastro
	 * Quando tento logar com um e-mail não cadastrado
	 * Então minha autenticação não é finalizada
	 */	
	@Test 
	public void testeTentarLogarComUsuarioNaoCadastrado() {
		String emailValido = "usuarionaocadastrado@teste.com";
		String senha = "123";

		assertFalse(ServiceLogin.fazerLogin(emailValido, senha));
	}
}
