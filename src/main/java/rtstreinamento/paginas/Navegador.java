package rtstreinamento.paginas;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

public abstract class Navegador {
	protected static WebDriver navegador;

	protected void abrirNavegador() {
		if (navegador == null) {
			System.setProperty("phantomjs.binary.path", "C:\\web-drivers\\phantomjs.exe");
			navegador = new PhantomJSDriver();
			Runtime.getRuntime().addShutdownHook(new Thread() {
				public void run() {
					fechar();
				}
			});
		}
	}

	public void fechar() {
		navegador.quit();
	}

	public void printTela(String nomeArquivo) throws IOException {
		File file = ((TakesScreenshot) navegador)
				.getScreenshotAs(OutputType.FILE);
		String nomeCompletoArquivo = "target\\" + nomeArquivo;
		FileUtils.copyFile(file, new File(nomeCompletoArquivo));
	}
	
	public void excluirCookieSessao() {
		navegador.manage().deleteCookieNamed("sessionid");
	}	
	
	public void recarregar() {
		navegador.navigate().refresh();
	}

	public void preencherCampo(WebElement campo, String valor) {
		campo.clear();
		campo.sendKeys(valor);
	}
}
