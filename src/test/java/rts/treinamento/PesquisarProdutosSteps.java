package rts.treinamento;

import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import static org.junit.Assert.*
;
public class PesquisarProdutosSteps {
	
	private PaginaPrincipal pagina;
	private PaginaResultadoPesquisa paginaReultadoPesquisa;

	public PesquisarProdutosSteps() {
		pagina = new PaginaPrincipal();
		pagina.abrir();
	}
	
	@Dado("^que exista um produto disponível$")
	public void que_exista_um_produto_disponível() throws Throwable {
		assertTrue(pagina.existeProdutoDisponivel());
	}

	@Quando("^realizo uma pesquisa pelo produto$")
	public void realizo_uma_pesquisa_pelo_produto() throws Throwable {
		paginaReultadoPesquisa = pagina.pesquisarPor("Senhor dos Anéis 1");
	}

	@Então("^visualizo o produto pesquisado$")
	public void visualizo_o_produto_pesquisado() throws Throwable {
		assertTrue(paginaReultadoPesquisa.exibiuProduto("Senhor dos Anéis 1"));
	}

	@Dado("^que existam produtos com nomes semelhantes$")
	public void que_existam_produtos_com_nomes_semelhantes() throws Throwable {
		assertTrue(pagina.existeProduto("Senhor dos Anéis 1"));
		assertTrue(pagina.existeProduto("Senhor dos Anéis 2"));
	}

	@Quando("^realizo uma pesquisa por parte do nome$")
	public void realizo_uma_pesquisa_por_parte_do_nome() throws Throwable {
		paginaReultadoPesquisa = pagina.pesquisarPor("Senhor ");
	}

	@Então("^visualizo os produtos com nomes semelhantes$")
	public void visualizo_os_produtos_com_nomes_semelhantes() throws Throwable {
		assertTrue(paginaReultadoPesquisa.exibiuProduto("Senhor dos Anéis 1"));
		assertTrue(paginaReultadoPesquisa.exibiuProduto("Senhor dos Anéis 2"));
	}

	@Dado("^que exista um produto indisponível$")
	public void que_exista_um_produto_indisponível() throws Throwable {
		assertTrue(pagina.existeProdutoIndisponivel());
	}

	@Quando("^realizo a pesquisa por um produto indisponível$")
	public void realizo_a_pesquisa_por_um_produto_indisponível() throws Throwable {
		paginaReultadoPesquisa = pagina.pesquisarPor("Thor");
	}

	@Então("^visualo o produto marcado como indisponível$")
	public void visualo_o_produto_marcado_como_indisponível() throws Throwable {
		assertTrue(paginaReultadoPesquisa.exibiuProduto("Thor"));
	}

	@Dado("^que existam produtos não cadastrados$")
	public void que_existam_produtos_não_cadastrados() throws Throwable {
		//Não faz nada
	}

	@Quando("^realizo a pesquisa por seu nome$")
	public void realizo_a_pesquisa_por_seu_nome() throws Throwable {
		paginaReultadoPesquisa = pagina.pesquisarPor("Chapolin");
	}

	@Então("^visualizo uma mensagem dizendo que o produto não foi encontrado$")
	public void visualizo_uma_mensagem_dizendo_que_o_produto_não_foi_encontrado() throws Throwable {
		assertTrue(paginaReultadoPesquisa.exibiuMensagemProdutoNaoEncontrado());
	}

}
