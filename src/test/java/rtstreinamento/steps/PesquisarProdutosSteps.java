package rtstreinamento.steps;

import static org.junit.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
	    WebElement caixaPesquisa = navegador.findElement(By.id("auto-complete"));
	    WebElement butaoPesquisar = navegador.findElement(By.xpath("//*[@id=\"form-buscar\"]/button"));
	    
	    caixaPesquisa.sendKeys("Bluray - Senhor dos Anéis - A Sociedade do Anel");
	    butaoPesquisar.click();
	}

	@Então("^visualizo o produto pesquisado$")
	public void visualizo_o_produto_pesquisado() throws Throwable {
		// Verifico se estou na página de pesquisa
		WebElement tituloPagina = navegador.findElement(By.xpath("//*[@id=\"corpo\"]/div/div[1]/ul/li[3]/strong"));
	    assertEquals("Resultado de busca", tituloPagina.getText());
	    
	    // Verifico se exibiu o produto pesquisado
	    WebElement tituloPrimeiroProduto = navegador.findElement(By.xpath("//*[@id=\"corpo\"]/div/div[2]/div[2]/div[2]/h1"));
	    assertEquals("Bluray - Senhor dos Anéis - A Sociedade do Anel", tituloPrimeiroProduto.getText());
	}

	@Dado("^que existam produtos com nomes semelhantes$")
	public void que_existam_produtos_com_nomes_semelhantes() throws Throwable {
		// Não faz nada ou verifica se existem os 2 filmes Senhor dos Anéis da página principal
	}

	@Quando("^realizo uma pesquisa por parte do nome$")
	public void realizo_uma_pesquisa_por_parte_do_nome() throws Throwable {
	    WebElement caixaPesquisa = navegador.findElement(By.id("auto-complete"));
	    WebElement butaoPesquisar = navegador.findElement(By.xpath("//*[@id=\"form-buscar\"]/button"));
	    
	    caixaPesquisa.sendKeys("Senhor dos Anéis");
	    butaoPesquisar.click();
	}

	@Então("^visualizo os produtos com nomes semelhantes$")
	public void visualizo_os_produtos_com_nomes_semelhantes() throws Throwable {
		// Verifico se estou na página de pesquisa
		WebElement tituloPagina = navegador.findElement(By.xpath("//*[@id=\"corpo\"]/div/div[1]/ul/li[3]/strong"));
	    assertEquals("Resultado de busca", tituloPagina.getText());	
	    
	    // Verifico se exibiu o primeiro e o segundo produto pesquisado
	    WebElement tituloPrimeiroProduto = navegador.findElement(By.xpath("//*[@id=\"listagemProdutos\"]/ul/li/ul/li[1]/div/a"));
	    assertEquals("Bluray - Senhor dos Anéis -  As Duas Torres", tituloPrimeiroProduto.getAttribute("title"));
	    
	    WebElement tituloSegundoProduto = navegador.findElement(By.xpath("//*[@id=\"listagemProdutos\"]/ul/li/ul/li[2]/div/a"));
	    assertEquals("Bluray - Senhor dos Anéis - A Sociedade do Anel", tituloSegundoProduto.getAttribute("title"));

	}

	@Dado("^que exista um produto indisponível$")
	public void que_exista_um_produto_indisponível() throws Throwable {
	    assertNotNull(navegador.findElementByClassName("bandeira-indisponivel"));
	}

	@Quando("^realizo a pesquisa por um produto indisponível$")
	public void realizo_a_pesquisa_por_um_produto_indisponível() throws Throwable {
	    WebElement caixaPesquisa = navegador.findElement(By.id("auto-complete"));
	    WebElement butaoPesquisar = navegador.findElement(By.xpath("//*[@id=\"form-buscar\"]/button"));
	    
	    caixaPesquisa.sendKeys("Thor");
	    butaoPesquisar.click();
	}

	@Então("^visualo o produto marcado como indisponível$")
	public void visualo_o_produto_marcado_como_indisponível() throws Throwable {
		// Verifico se estou na página de pesquisa
		WebElement tituloPagina = navegador.findElement(By.xpath("//*[@id=\"corpo\"]/div/div[1]/ul/li[3]/strong"));
	    assertEquals("Resultado de busca", tituloPagina.getText());	
	    
	    // Verifico se exibiu o primeiro com a tag indisponível
	    WebElement tituloIndiponivelPrimeiroProduto = navegador.findElement(By.cssSelector("#listagemProdutos > ul > li > ul > li > div > div.bandeiras-produto > span"));
	    assertEquals("INDISPONÍVEL", tituloIndiponivelPrimeiroProduto.getText());
	}

	@Dado("^que existam produtos não cadastrados$")
	public void que_existam_produtos_não_cadastrados() throws Throwable {
	    //Não faz nada
	}

	@Quando("^realizo a pesquisa por seu nome$")
	public void realizo_a_pesquisa_por_seu_nome() throws Throwable {
	    WebElement caixaPesquisa = navegador.findElement(By.id("auto-complete"));
	    WebElement butaoPesquisar = navegador.findElement(By.xpath("//*[@id=\"form-buscar\"]/button"));
	    
	    caixaPesquisa.sendKeys("Capitão América");
	    butaoPesquisar.click();
	}

	@Então("^visualizo uma mensagem dizendo que o produto não foi encontrado$")
	public void visualizo_uma_mensagem_dizendo_que_o_produto_não_foi_encontrado() throws Throwable {
	    String mensagemProdutoInexistente = "Sua busca por: \"Capitão América\" não encontrou nenhum resultado";
	    WebElement produtoInexistente = navegador.findElement(By.tagName("h1"));
	    assertEquals(mensagemProdutoInexistente, produtoInexistente.getText());
	}
}
