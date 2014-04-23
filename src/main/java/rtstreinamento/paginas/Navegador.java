package rtstreinamento.paginas;

import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class Navegador {
	protected static FirefoxDriver navegador;
	
	protected void abrirNavegador() {
		navegador = new FirefoxDriver();
	}
	
	public void fechar() {
		navegador.quit();
	}
}
