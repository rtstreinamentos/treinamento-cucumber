# language: pt

Funcionalidade: Pesquisar produtos na loja
	Como cliente
	Para facilitar a compra de um produto
	Quero pesquisar um produto na loja
	
Cenário: Pesquisar um produto disponível
	Dado que exista um produto disponível 
	Quando realizo uma pesquisa pelo produto
	Então visualizo o produto pesquisado
	
Cenário: Pesquisar produtos com nomes semelhantes
	Dado que existam produtos com nomes semelhantes
	Quando realizo uma pesquisa por parte do nome
	Então visualizo os produtos com nomes semelhantes	

Cenário: Pesquisar um produto indisponível
	Dado que exista um produto indisponível
	Quando realizo a pesquisa por um produto indisponível
	Então visualo o produto marcado como indisponível

Cenário: Pesquisar produto não cadastrado
	Dado que existam produtos não cadastrados
	Quando realizo a pesquisa por seu nome
	Então visualizo uma mensagem dizendo que o produto não foi encontrado 
	