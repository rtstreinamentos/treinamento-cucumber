package rts.treinamento;

import static org.junit.Assert.*;

import java.util.UUID;

import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class CadastroDeNewsLetterSteps {
	
	private PaginaPrincipal paginaPesquisa;
	private String emailGravar;

	public CadastroDeNewsLetterSteps() {
		paginaPesquisa = new PaginaPrincipal();
		paginaPesquisa.abrir();
	}
	
	@Dado("^que a Newsletter esteja ativada$")
	public void que_a_Newsletter_esteja_ativada() throws Throwable {
		assertTrue(paginaPesquisa.exibiuNewsletter());
	}

	@Dado("^que meu e-mail ainda não foi cadastrado na newsletter$")
	public void que_meu_e_mail_ainda_não_foi_cadastrado_na_newsletter()	throws Throwable {
		// Não faz nada
	}

	@Quando("^cadastro meu e-mail$")
	public void cadastro_meu_e_mail() throws Throwable {
		String nomeGerado = UUID.randomUUID().toString();
		emailGravar = nomeGerado + "@teste.com";
		paginaPesquisa.newsletter().preencherEmail(emailGravar);
		paginaPesquisa.newsletter().gravar();
	}

	@Então("^visualizo a mensagem de sucesso do cadastro da newsletter$")
	public void visualizo_a_mensagem_de_sucesso_do_cadastro_da_newsletter() throws Throwable {
		assertTrue(paginaPesquisa.newsletter().exibiuMensagemSucesso());
	}
	
	@Dado("^que meu e-mail ainda já foi cadastrado na newsletter$")
	public void que_meu_e_mail_ainda_já_foi_cadastrado_na_newsletter() throws Throwable {
	    cadastro_meu_e_mail();
	}

	@Então("^visualizo a mensagem informando que o e-mail já havia sido cadastrado$")
	public void visualizo_a_mensagem_informando_que_o_e_mail_já_havia_sido_cadastrado() throws Throwable {
	    assertTrue(paginaPesquisa.newsletter().exibiuMensagemJaCadastrado());
	}
	
	@Quando("^tento cadastrar um e-mail inválido$")
	public void tento_cadastrar_um_e_mail_inválido() throws Throwable {
	   
	}
	
	@Quando("^tento cadastrar o e-mail \"([^\"]*)\"$")
	public void tento_cadastrar_o_e_mail(String emailInvalido) throws Throwable {
		paginaPesquisa.newsletter().preencherEmail(emailInvalido);
	}

	@Então("^não consigo cadastrar o email na newsletter$")
	public void não_consigo_cadastrar_o_email_na_newsletter() throws Throwable {
	    assertTrue(paginaPesquisa.newsletter().exibiuAlertaNoCampoEmail());
	}

}
