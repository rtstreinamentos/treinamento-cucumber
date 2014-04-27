package rtstreinamento.steps;

import static org.junit.Assert.*;
import rtstreinamento.paginas.PaginaCarrinho;
import rtstreinamento.paginas.PaginaDetalheProduto;
import rtstreinamento.paginas.PaginaPesquisa;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class ManipularCarrinhoSteps {
	
	private PaginaPesquisa paginaPesquisa;
	private PaginaDetalheProduto paginaDetalheProduto;
	private PaginaCarrinho paginaCarrinho;
	
	public ManipularCarrinhoSteps() {
		paginaPesquisa = new PaginaPesquisa();  
	}
	
	@Dado("^que não existam produtos no meu carrinho$")
	public void que_não_existam_produtos_no_meu_carrinho() throws Throwable {
		paginaPesquisa.abrir();
		paginaPesquisa.excluirCookieSessao();
		paginaPesquisa.recarregar();
		assertTrue(paginaPesquisa.boxCarrinho().carrinhoVazio());
	}
	
	@Dado("^que inclui (\\d+) produto no carrinho$")
	public void que_inclui_produto_no_carrinho(int indiceProduto) throws Throwable {
	   
	}
	
	@Dado("^que o valor unitário do produto é R\\$ \"([^\"]*)\"$")
	public void que_o_valor_unitário_do_produto_é_R$(String arg1) throws Throwable {
	
	}

	@Quando("^decido comprar um produto$")
	public void decido_comprar_um_produto() throws Throwable {
		int indiceProduto = 1;
		paginaDetalheProduto = paginaPesquisa.clicarNoProduto(indiceProduto );
		paginaCarrinho = paginaDetalheProduto.comprar();
	}

	@Quando("^decido comprar um segundo produto$")
	public void decido_comprar_um_segundo_produto() throws Throwable {
		que_inclui_produto_no_carrinho(2);
		decido_comprar_um_produto();		
	}
	
	@Quando("^aumento a quantidade desse produto \"([^\"]*)\" vez$")
	public void aumento_a_quantidade_desse_produto_vez(String arg1) throws Throwable {

	}

	@Então("^visualizo meu carrinho de compras (\\d+) produto.")
	public void visualizo_meu_carrinho_de_compras_produtos(int quantidadeProdutos) throws Throwable {
	    this.visualizo_meu_carrinho_de_compras_produto(quantidadeProdutos);
	}
	
	@Então("^visualizo meu carrinho de compras (\\d+) produto$")
	public void visualizo_meu_carrinho_de_compras_produto(int quantidadeProdutos) throws Throwable {
		assertEquals(quantidadeProdutos, paginaCarrinho.quantidadeProdutos());
	}

	@Então("^o total do carrinho deve ser R\\$ \"([^\"]*)\"$")
	public void o_total_do_carrinho_deve_ser_R$(String arg1) throws Throwable {

	}
}
