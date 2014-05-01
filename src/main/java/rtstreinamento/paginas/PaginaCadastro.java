package rtstreinamento.paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PaginaCadastro extends Navegador {

	public void confirmacaoEmail(String email) {
		WebElement campoConfirmacaoEmail = navegador.findElement(By.id("id_confirmacao_email"));
		campoConfirmacaoEmail.clear();
		campoConfirmacaoEmail.sendKeys(email);
	}

	public void senha(String senha) {
		WebElement campoSenha = navegador.findElement(By.id("id_senha"));
		preencherCampo(campoSenha, senha);
	}

	public void confirmacaoSenha(String senha) {
		WebElement campoConfirmacaoSenha = navegador.findElement(By.id("id_confirmacao_senha"));
		preencherCampo(campoConfirmacaoSenha, senha);
	}

	public void tipoCadastro(String idHtmlCampo) {
		navegador.findElement(By.id(idHtmlCampo)).click();;
	}

	public void nomeCompleto(String nomeCompleto) {
		WebElement campoNomeCompleto = navegador.findElement(By.id("id_nome"));
		preencherCampo(campoNomeCompleto, nomeCompleto);		
	}

	public void sexo(String sexo) {
		WebElement campoSexo = navegador.findElement(By.id("id_sexo"));
		Select selectSexo = new Select(campoSexo);
		selectSexo.selectByValue(sexo);
		
	}

	public void dataNascimento(String dataNascimento) {
		WebElement campoDataNascimento = navegador.findElement(By.id("id_data_nascimento"));
		preencherCampo(campoDataNascimento, dataNascimento);
	}

	public void cpf(String cpf) {
		WebElement campoCpf = navegador.findElement(By.id("id_cpf"));
		preencherCampo(campoCpf, cpf);
	}

	public void rg(String rg) {
		WebElement campoRg = navegador.findElement(By.id("id_rg"));
		preencherCampo(campoRg, rg);
	}

	public void telefoneCelular(String celular) {
		WebElement campoCelular = navegador.findElement(By.id("id_telefone_celular"));
		preencherCampo(campoCelular, celular);
	}

	public void telefoneResidencial(String telefoneResidencial) {
		WebElement campoTelefoneResidencial = navegador.findElement(By.id("id_telefone_principal"));
		preencherCampo(campoTelefoneResidencial, telefoneResidencial);
	}

	public void cep(String cep) {
		WebElement campoCep = navegador.findElement(By.id("id_cep"));
		preencherCampo(campoCep, cep);
	}

	public void endereco(String endereco) {
		WebElement campoEndereco = navegador.findElement(By.id("id_endereco"));
		preencherCampo(campoEndereco, endereco);
	}

	public void numero(String numero) {
		WebElement campoNumero = navegador.findElement(By.id("id_numero"));
		preencherCampo(campoNumero, numero);
	}

	public void complemento(String complemento) {
		WebElement campoComplemento = navegador.findElement(By.id("id_complemento"));
		preencherCampo(campoComplemento, complemento);
	}

	public void bairro(String bairro) {
		WebElement campoBairro = navegador.findElement(By.id("id_bairro"));
		preencherCampo(campoBairro, bairro);
	}

	public void cidade(String cidade) {
		WebElement campoCidade = navegador.findElement(By.id("id_cidade"));
		preencherCampo(campoCidade, cidade);
	}

	public void estado(String estado) {
		WebElement campoEstado = navegador.findElement(By.id("id_estado"));
		Select selectEstado = new Select(campoEstado);
		selectEstado.selectByVisibleText(estado);
	}

	public void criarConta() {
		navegador.findElement(By.xpath("//*[@id=\"formCadastroCompleto\"]/form/div[4]/div/button[2]")).click();;
	}

	public boolean exibiuMensagemErroCadastro() {
		WebElement mensagemErroCadastro = navegador.findElement(By.xpath("//*[@id=\"corpo\"]/div/div[1]"));
		return mensagemErroCadastro != null;
	}

}
