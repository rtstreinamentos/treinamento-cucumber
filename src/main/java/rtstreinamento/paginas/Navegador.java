package rtstreinamento.paginas;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class Navegador {
	protected static WebDriver navegador;

	protected void abrirNavegador() {
		if (navegador == null) {
			navegador = new FirefoxDriver();
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
}
