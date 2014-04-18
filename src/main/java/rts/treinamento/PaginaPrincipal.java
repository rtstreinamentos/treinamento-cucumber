package rts.treinamento;

public class PaginaPrincipal {

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

}
