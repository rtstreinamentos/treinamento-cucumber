package rtstreinamento.steps;

import static org.junit.Assert.*;

import rtstreinamento.paginas.PaginaCadastro;
import rtstreinamento.paginas.PaginaIdentificacao;
import rtstreinamento.paginas.PaginaPesquisa;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class CadastrarClienteSteps {

	private PaginaPesquisa paginaPesquisa;
	private PaginaIdentificacao paginaIdentificacao;
	private PaginaCadastro paginaCadastro;
	
	
	@Dado("^que quero me cadastrar$")
	public void que_quero_me_cadastrar() throws Throwable {
	    paginaPesquisa = new PaginaPesquisa();
	    paginaPesquisa.abrir();
	    paginaIdentificacao = paginaPesquisa.clicarIdentificacao();
	}

	@Dado("^que meu e-mail é \"([^\"]*)\"$")
	public void que_meu_e_mail_é(String email) throws Throwable {
		paginaIdentificacao.preencherEmailCadastrar(email);
		paginaCadastro = paginaIdentificacao.cadastrar();
	}

	@Quando("^informo todos os meus dados válidos$")
	public void informo_todos_os_meus_dados_válidos() throws Throwable {
	}

	@Quando("^tentar me cadastrar informando a confirmação de e-mail \"([^\"]*)\"$")
	public void tentar_me_cadastrar_informando_a_confirmação_de_e_mail(String confirmacaoEmail) throws Throwable {
	    
		String pessoaFisica = "id_tipo_0";
		String feminino = "f";
		
		paginaCadastro.confirmacaoEmail(confirmacaoEmail);
		paginaCadastro.senha("12345");
		paginaCadastro.confirmacaoSenha("12345");
		paginaCadastro.tipoCadastro(pessoaFisica);
		paginaCadastro.nomeCompleto("Teste Automatizado da Silva");
		paginaCadastro.sexo(feminino);
		paginaCadastro.dataNascimento("10/10/2000");
		paginaCadastro.cpf("55450372760");
		paginaCadastro.rg("22222222");
		paginaCadastro.telefoneCelular("999998888");
		paginaCadastro.telefoneResidencial("33338888");
		paginaCadastro.cep("55555555");
		paginaCadastro.endereco("Rua A");
		paginaCadastro.numero("123");
		paginaCadastro.complemento("Casa 1");
		paginaCadastro.bairro("Copacabana");
		paginaCadastro.cidade("Rio de Janeiro");
		paginaCadastro.estado("Rio de Janeiro");
		
		paginaCadastro.criarConta();
	}
	
	@Então("^visualizo que consegui me cadastrar$")
	public void visualizo_que_consegui_me_cadastrar() throws Throwable {

	}

	@Então("^visualizo uma mensagem dizendo que não é possível fazer o cadastro$")
	public void visualizo_uma_mensagem_dizendo_que_não_é_possível_fazer_o_cadastro() throws Throwable {
	    assertTrue(paginaCadastro.exibiuMensagemErroCadastro());
	}
}
