package rtstreinamento.paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PaginaCarrinho extends Navegador {

	public int quantidadeProdutos() {
		String xpath = "//*[@id=\"corpo\"]/div/div[1]/div/div[2]/table/tbody/tr";
		return navegador.findElements(By.xpath(xpath)).size() - 4;
	}

	public PaginaPesquisa clicarLogo() {
		navegador.findElement(By.linkText("tghcastro")).click();
		return new PaginaPesquisa();
	}

	public String valorUniatioPrimeiroProduto() {
		String xpath = "//*[@id=\"corpo\"]/div/div[1]/div/div[2]/table/tbody/tr[1]/td[3]/div/div/strong";
		return navegador.findElement(By.xpath(xpath)).getText();
	}

	public void aumentarQuantidadePara(int quantidade) {
		String xpath = "//*[@id=\"corpo\"]/div/div[1]/div/div[2]/table/tbody/tr[1]/td[4]/form/div/a[2]";
		for (int i = 2; i <= quantidade; i++) {
			navegador.findElement(By.xpath(xpath)).click();
		}
	}

	public String valorTotal() {
		String xpath = "//*[@id=\"corpo\"]/div/div[1]/div/div[2]/table/tbody/tr[5]/td/div/strong";
		return navegador.findElement(By.xpath(xpath)).getText();
	}

}
