package rtstreinamento.paginas;

import org.openqa.selenium.By;

public class PaginaDetalheProduto extends Navegador {

	public PaginaCarrinho comprar() {
		String xpath = "//*[@id=\"corpo\"]/div/div[2]/div[2]/div[1]/div[2]/div/div[2]/div[2]/a";
		navegador.findElement(By.xpath(xpath)).click();
		return new PaginaCarrinho();
	}

}
