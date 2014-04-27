package rtstreinamento.box;

import org.openqa.selenium.By;

import rtstreinamento.paginas.Navegador;

public class BoxCarrinho extends Navegador {

	public String quantidadeItens() {
		return navegador.findElement(By.className("qtd-carrinho")).getText();
	}

	public boolean carrinhoVazio() {
		String xpathExpression = "//*[@id=\"cabecalho\"]/div[2]/div[1]/div[2]/div[2]/div[2]/div/a/span";
		return navegador.findElement(By.xpath(xpathExpression)).getText().trim().equalsIgnoreCase("Carrinho vazio");
	}
}
