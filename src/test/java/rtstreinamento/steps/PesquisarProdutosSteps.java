package rtstreinamento.steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import rtstreinamento.paginas.PaginaPesquisa;
import rtstreinamento.paginas.PaginaResultadoPesquisa;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class PesquisarProdutosSteps {
		
	private PaginaPesquisa paginaPesquisa;
	private PaginaResultadoPesquisa paginaResultado;
	
	@Before
	public void noInicioDoCenario() {
		paginaPesquisa = new PaginaPesquisa();
		paginaPesquisa.abrir();	
	}
	
	@After
	public void noFimDoCenario() throws IOException {
		paginaPesquisa.fechar();
	}
	
	@Dado("^que exista um produto disponível$")
	public void que_exista_um_produto_disponível() throws Throwable {
	    assertTrue(paginaPesquisa.existeProdutoDisponivel());
	}

	@Quando("^realizo uma pesquisa pelo produto$")
	public void realizo_uma_pesquisa_pelo_produto() throws Throwable {
		paginaPesquisa.preencherCampoPesquisa("Bluray - Senhor dos Anéis - A Sociedade do Anel");
		paginaResultado = paginaPesquisa.pesquisar();
	}

	@Então("^visualizo o produto pesquisado$")
	public void visualizo_o_produto_pesquisado() throws Throwable {
		// Verifico se estou na página de pesquisa
	    assertTrue(paginaResultado.tituloPagina());
	    
	    // Verifico se exibiu o produto pesquisado
	    assertEquals("Bluray - Senhor dos Anéis - A Sociedade do Anel", paginaResultado.getTituloPrimeiroProdutoResultadoUnico());
	    paginaResultado.printTela("produto-pesquisado.png");
	}

	@Dado("^que existam produtos com nomes semelhantes$")
	public void que_existam_produtos_com_nomes_semelhantes() throws Throwable {
		// Não faz nada ou verifica se existem os 2 filmes Senhor dos Anéis da página principal
	}

	@Quando("^realizo uma pesquisa por parte do nome$")
	public void realizo_uma_pesquisa_por_parte_do_nome() throws Throwable {
		paginaPesquisa.preencherCampoPesquisa("Senhor dos Anéis");
		paginaResultado = paginaPesquisa.pesquisar();
	}

	@Então("^visualizo os produtos com nomes semelhantes$")
	public void visualizo_os_produtos_com_nomes_semelhantes() throws Throwable {
		// Verifico se estou na página de pesquisa
		assertTrue(paginaResultado.tituloPagina());
		
	    // Verifico se exibiu o primeiro e o segundo produto pesquisado
	    assertEquals("Bluray - Senhor dos Anéis -  As Duas Torres", paginaResultado.tituloPrimeiroProdutoResultadoMultiplo());
	    assertEquals("Bluray - Senhor dos Anéis - A Sociedade do Anel", paginaResultado.tituloSegundoProdutoResultadoMultiplo());
	    
	    paginaResultado.printTela("produtos-nomes-semelhantes.png");
	}

	@Dado("^que exista um produto indisponível$")
	public void que_exista_um_produto_indisponível() throws Throwable {
	    assertTrue(paginaPesquisa.existeProdutoIndisponivel());
	}

	@Quando("^realizo a pesquisa por um produto indisponível$")
	public void realizo_a_pesquisa_por_um_produto_indisponível() throws Throwable {
	    paginaPesquisa.preencherCampoPesquisa("Thor");
	    paginaResultado = paginaPesquisa.pesquisar();
	}

	@Então("^visualo o produto marcado como indisponível$")
	public void visualo_o_produto_marcado_como_indisponível() throws Throwable {
		// Verifico se estou na página de pesquisa
		assertTrue(paginaResultado.tituloPagina());
		
	    // Verifico se exibiu o primeiro com a tag indisponível
	    assertEquals("INDISPONÍVEL", paginaPesquisa.tituloIndiponivelPrimeiroProduto());
	    paginaResultado.printTela("produto-indiponivel.png");
	}

	@Dado("^que existam produtos não cadastrados$")
	public void que_existam_produtos_não_cadastrados() throws Throwable {
	    //Não faz nada
	}

	@Quando("^realizo a pesquisa por seu nome$")
	public void realizo_a_pesquisa_por_seu_nome() throws Throwable {
		paginaPesquisa.preencherCampoPesquisa("Capitão América");
	    paginaResultado = paginaPesquisa.pesquisar();
	}

	@Então("^visualizo uma mensagem dizendo que o produto não foi encontrado$")
	public void visualizo_uma_mensagem_dizendo_que_o_produto_não_foi_encontrado() throws Throwable {
	    String mensagemProdutoInexistente = "Sua busca por: \"Capitão América\" não encontrou nenhum resultado";
	    assertEquals(mensagemProdutoInexistente, paginaResultado.mensagemProdutoInexistente());
	    paginaResultado.printTela("mensagem-produto-inexistente.png");
	}
}
