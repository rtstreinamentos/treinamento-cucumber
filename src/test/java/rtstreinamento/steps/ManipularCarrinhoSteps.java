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
	public void que_inclui_produto_no_carrinho(int quantidadeProdutosCarrinho) throws Throwable {
	   this.que_não_existam_produtos_no_meu_carrinho();
	   for (int i = 1; i <= quantidadeProdutosCarrinho; i++) {
		   paginaCarrinho = paginaPesquisa.clicarNoProduto(i).comprar();
	   }
	}
	
	@Dado("^que o valor unitário do produto é \"([^\"]*)\"$")
	public void que_o_valor_unitário_do_produto_é_R$(String valorUnitario) throws Throwable {
		assertEquals(valorUnitario, paginaCarrinho.valorUniatioPrimeiroProduto());
	}

	@Quando("^decido comprar um produto$")
	public void decido_comprar_um_produto() throws Throwable {
		int indiceProduto = 1;
		paginaDetalheProduto = paginaPesquisa.clicarNoProduto(indiceProduto);
		paginaCarrinho = paginaDetalheProduto.comprar();
	}

	@Quando("^decido comprar um segundo produto$")
	public void decido_comprar_um_segundo_produto() throws Throwable {
		paginaCarrinho.clicarLogo();
		paginaCarrinho = paginaPesquisa.clicarNoProduto(2).comprar();
	}
	
	@Quando("^aumento a quantidade desse produto para (\\d+)$")
	public void aumento_a_quantidade_desse_produto_vez(int quantidade) throws Throwable {
		paginaCarrinho.aumentarQuantidadePara(quantidade);
	}

	@Então("^visualizo meu carrinho de compras (\\d+) produto.")
	public void visualizo_meu_carrinho_de_compras_produtos(int quantidadeProdutos) throws Throwable {
	    this.visualizo_meu_carrinho_de_compras_produto(quantidadeProdutos);
	}
	
	@Então("^visualizo meu carrinho de compras (\\d+) produto$")
	public void visualizo_meu_carrinho_de_compras_produto(int quantidadeProdutos) throws Throwable {
		assertEquals(quantidadeProdutos, paginaCarrinho.quantidadeProdutos());
	}

	@Então("^o total do carrinho deve ser \"([^\"]*)\"$")
	public void o_total_do_carrinho_deve_ser_R$(String total) throws Throwable {
		assertEquals(total, paginaCarrinho.valorTotal());
	}
}
