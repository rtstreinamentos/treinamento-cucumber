package rts.treinamento.tdd;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LoginTest {

	@Test
	public void testeLogarComSucesso() {
		String emailValido = "teste@teste.com";
		String senha = "123";

		assertTrue(verificarLogin(emailValido, senha));
	}
	
	@Test
	public void testeLogarSemInformarEmail() {
		String emailValido = null;
		String senha = "123";

		assertFalse(verificarLogin(emailValido, senha));
	}
	
	@Test
	public void testeLogarComEmailEmBranco() {
		String emailValido = "";
		String senha = "123";

		assertFalse(verificarLogin(emailValido, senha));
	}
	
	@Test
	public void testeLogarSemInformarSenha() {
		String emailValido = "teste@teste.com";
		String senha = null;

		assertFalse(verificarLogin(emailValido, senha));
	}
	
	@Test
	public void testeLogarComSenhaEmBranco() {
		String emailValido = "teste@teste.com";
		String senha = "";

		assertFalse(verificarLogin(emailValido, senha));
	}
	
	@Test 
	public void testeTentarLogarComSenhaErrada() {
		String emailValido = "teste@teste.com";
		String senha = "123456";

		assertFalse(verificarLogin(emailValido, senha));
	}
	
	@Test 
	public void testeTentarLogarComUsuarioNaoCadastrado() {
		String emailValido = "usuarionaocadastrado@teste.com";
		String senha = "123";

		assertFalse(verificarLogin(emailValido, senha));
	}

	private boolean verificarLogin(String email, String senha) {
		String senhaValida = "123";
		String usuarioCadastrado = "teste@teste.com";
		
		if (email == null || email == "") {
			return false;
		}
		if (senha == null || senha == "") {
			return false;
		}
		if (senha != senhaValida) {
			return false;
		}
		if (email != usuarioCadastrado) {
			return false;
		}
		return true;
	}
}
