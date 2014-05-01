package rtstreinamento.paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import rtstreinamento.box.BoxCarrinho;

public class PaginaPesquisa extends Navegador {

	private BoxCarrinho boxCarrinho;

	public void abrir() {
		abrirNavegador();
	    navegador.get("http://tghcastro.lojaintegrada.com.br/");	
	    boxCarrinho = new BoxCarrinho();
	}

	public boolean existeProdutoDisponivel() {
		return navegador.findElements(By.className("listagem-linha")) != null;
	}
	
	public boolean existeProdutoIndisponivel() {
		return navegador.findElement(By.className("bandeira-indisponivel")) != null;
	}

	public void preencherCampoPesquisa(String textoPesquisado) {
	    WebElement caixaPesquisa = navegador.findElement(By.id("auto-complete"));
	    caixaPesquisa.sendKeys(textoPesquisado);
	}

	public PaginaResultadoPesquisa pesquisar() {
	    WebElement butaoPesquisar = navegador.findElement(By.xpath("//*[@id=\"form-buscar\"]/button"));
	    butaoPesquisar.click();
	    return new PaginaResultadoPesquisa();
	}

	public String tituloIndiponivelPrimeiroProduto() {
		WebElement tituloIndiponivelPrimeiroProduto = navegador.findElement(By.cssSelector("#listagemProdutos > ul > li > ul > li > div > div.bandeiras-produto > span"));
	    return tituloIndiponivelPrimeiroProduto.getText();
	}

	public BoxCarrinho boxCarrinho() {
		return boxCarrinho;
	}

	public PaginaDetalheProduto clicarNoProduto(int indice) {
		String xpath = "//*[@id=\"listagemProdutos\"]/ul/li/ul/li[" + indice + "]/div/a";
		navegador.findElement(By.xpath(xpath)).click();
		return new PaginaDetalheProduto();
	}

	public PaginaIdentificacao clicarIdentificacao() {
		navegador.findElement(By.className("bem-vindo")).click();
		return new PaginaIdentificacao();
	}


}
