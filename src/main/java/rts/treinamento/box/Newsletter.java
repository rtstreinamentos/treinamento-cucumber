package rts.treinamento.box;

public class Newsletter {

	public void preencherEmail(String email) {
		System.out.println("Preencheu na Newsletter: " + email);
	}

	public void gravar() {
		System.out.println("Gravou a newsletter");
	}

	public boolean exibiuMensagemSucesso() {
		System.out.println("Cadastrou a newsletter");
		return true;
	}

	public boolean exibiuMensagemJaCadastrado() {
		System.out.println("Já estava cadastrado newsletter");
		return true;
	}

	public boolean exibiuAlertaNoCampoEmail() {
		System.out.println("Exibiu alerta");
		return true;
	}
}
