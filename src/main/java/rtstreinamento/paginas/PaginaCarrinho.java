package rtstreinamento.paginas;

import org.openqa.selenium.By;

public class PaginaCarrinho extends Navegador {

	public int quantidadeProdutos() {
		String xpath = "//*[@id=\"corpo\"]/div/div[1]/div/div[2]/table/tbody/tr";
		return navegador.findElements(By.xpath(xpath)).size() - 4;
	}

	public PaginaPesquisa clicarLogo() {
		String localizador = "//*[@id=\"cabecalho\"]/div[2]/div[1]/div[1]/h1/a";
		navegador.findElement(By.linkText("tghcastro")).click();
		return new PaginaPesquisa();
	}

}
