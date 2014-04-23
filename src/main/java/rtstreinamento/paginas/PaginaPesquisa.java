package rtstreinamento.paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PaginaPesquisa extends Navegador {

	public void abrir() {
		abrirNavegador();
	    navegador.get("http://tghcastro.lojaintegrada.com.br/");	
	}

	public boolean existeProdutoDisponivel() {
		return navegador.findElements(By.className("listagem-linha")) != null;
	}
	
	public boolean existeProdutoIndisponivel() {
		return navegador.findElementByClassName("bandeira-indisponivel") != null;
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
}
