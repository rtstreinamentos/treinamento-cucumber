package rts.treinamento;

import rts.treinamento.box.Newsletter;

public class PaginaPrincipal {

	private Newsletter boxNewsletter;

	public PaginaPrincipal() {
		boxNewsletter = new Newsletter();
	}
	
	public void abrir() {
		System.out.println("Abriu a página [PaginaPrincipal]");
	}

	public boolean existeProdutoDisponivel() {
		return true;
	}

	public PaginaResultadoPesquisa pesquisarPor(String string) {
		return new PaginaResultadoPesquisa();
	}

	public boolean existeProduto(String string) {
		return true;
	}

	public boolean existeProdutoIndisponivel() {
		return true;
	}

	public boolean exibiuNewsletter() {
		return true;
	}

	public Newsletter newsletter() {
		return boxNewsletter;
	}
}
