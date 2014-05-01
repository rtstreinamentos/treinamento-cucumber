package rtstreinamento.paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PaginaIdentificacao extends Navegador {

	public void preencherEmailCadastrar(String email) {
		WebElement formularioCadastrar = navegador.findElement(By.xpath("//*[@id=\"corpo\"]/div/div[1]/div[2]/div[2]/div/form"));
		WebElement campoEmail = formularioCadastrar.findElement(By.id("id_email"));
		campoEmail.clear();
		campoEmail.sendKeys(email);
	}

	public PaginaCadastro cadastrar() {
		navegador.findElement(By.xpath("//*[@id=\"corpo\"]/div/div[1]/div[2]/div[2]/div/form/fieldset/div/button")).click();
		return new PaginaCadastro();
	}
	
	

}
