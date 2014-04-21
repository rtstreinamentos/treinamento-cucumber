package rtstreinamento.steps;

import static org.junit.Assert.assertNotNull;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class PesquisarProdutosSteps {
	
	private FirefoxDriver navegador;

	@Before
	public void noInicioDoCenario() {
	    navegador = new FirefoxDriver();
	    navegador.get("http://tghcastro.lojaintegrada.com.br/");		
	}
	
	@After
	public void noFimDoCenario() {
		navegador.quit();
	}
	
	@Dado("^que exista um produto disponível$")
	public void que_exista_um_produto_disponível() throws Throwable {
	    assertNotNull(navegador.findElements(By.className("listagem-linha")));
	}

	@Quando("^realizo uma pesquisa pelo produto$")
	public void realizo_uma_pesquisa_pelo_produto() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}

	@Então("^visualizo o produto pesquisado$")
	public void visualizo_o_produto_pesquisado() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}

	@Dado("^que existam produtos com nomes semelhantes$")
	public void que_existam_produtos_com_nomes_semelhantes() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}

	@Quando("^realizo uma pesquisa por parte do nome$")
	public void realizo_uma_pesquisa_por_parte_do_nome() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}

	@Então("^visualizo os produtos com nomes semelhantes$")
	public void visualizo_os_produtos_com_nomes_semelhantes() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}

	@Dado("^que exista um produto indisponível$")
	public void que_exista_um_produto_indisponível() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}

	@Quando("^realizo a pesquisa por um produto indisponível$")
	public void realizo_a_pesquisa_por_um_produto_indisponível() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}

	@Então("^visualo o produto marcado como indisponível$")
	public void visualo_o_produto_marcado_como_indisponível() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}

	@Dado("^que existam produtos não cadastrados$")
	public void que_existam_produtos_não_cadastrados() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}

	@Quando("^realizo a pesquisa por seu nome$")
	public void realizo_a_pesquisa_por_seu_nome() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}

	@Então("^visualizo uma mensagem dizendo que o produto não foi encontrado$")
	public void visualizo_uma_mensagem_dizendo_que_o_produto_não_foi_encontrado() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}
}
