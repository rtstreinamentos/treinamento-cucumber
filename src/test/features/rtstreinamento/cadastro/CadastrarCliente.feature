# language: pt
@regressão-total
Funcionalidade: Manipular produtos no carrinho
  Como cliente
  Para poder comprar na loja
  Quero me cadastrar
  
  Contexto:
  	Dado que quero me cadastrar
 
 # Como exemplo não está sendo executado / implementado 
 # Cenário: Conseguir me cadastrar
 #   Quando informo todos os meus dados válidos
 #   Então visualizo que consegui me cadastrar

   Cenário: Tentar cadastrar com confirmação de e-mail diferente do e-mail
    E que meu e-mail é "treinamento123@mailnator.com"
    Quando tentar me cadastrar informando a confirmação de e-mail "treinamento@mailnator.com"
    Então visualizo uma mensagem dizendo que não é possível fazer o cadastro

  