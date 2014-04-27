package rtstreinamento.paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PaginaResultadoPesquisa extends Navegador {

	public boolean tituloPagina() {
		String urlPaginaResultado = "http://tghcastro.lojaintegrada.com.br/buscar";
		return navegador.getCurrentUrl().contains(urlPaginaResultado);
	}

	public String getTituloPrimeiroProdutoResultadoUnico() {
	    WebElement tituloPrimeiroProduto = navegador.findElement(By.xpath("//*[@id=\"corpo\"]/div/div[2]/div[2]/div[1]/h1"));
	    return tituloPrimeiroProduto.getText();
	}

	public String tituloPrimeiroProdutoResultadoMultiplo() {
	    WebElement tituloPrimeiroProduto = navegador.findElement(By.xpath("//*[@id=\"listagemProdutos\"]/ul/li/ul/li[1]/div/a"));
	    return tituloPrimeiroProduto.getAttribute("title");
	}

	public String tituloSegundoProdutoResultadoMultiplo() {
		WebElement tituloSegundoProduto = navegador.findElement(By.xpath("//*[@id=\"listagemProdutos\"]/ul/li/ul/li[2]/div/a"));
	   	return tituloSegundoProduto.getAttribute("title");
	}

	public String mensagemProdutoInexistente() {
		WebElement produtoInexistente = navegador.findElement(By.tagName("h1"));
	    return produtoInexistente.getText();
	}
	
	

}

