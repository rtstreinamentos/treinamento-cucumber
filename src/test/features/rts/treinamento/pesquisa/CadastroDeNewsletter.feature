# language: pt
Funcionalidade: Cadastrar um e-mail para receber Newsletter
  Como cliente
  Para receber promoções 
  Quero cadastra meu e-mail para receber as Newsletter

  Contexto: 
    Dado que a Newsletter esteja ativada

  Cenário: Cadastrar um e-mail válido não cadastrado
    Dado que meu e-mail ainda não foi cadastrado na newsletter
    Quando cadastro meu e-mail
    Então visualizo a mensagem de sucesso do cadastro da newsletter

  Cenário: Tentar cadastrar e-mail já cadastrado
    Dado que meu e-mail ainda já foi cadastrado na newsletter
    Quando cadastro meu e-mail
    Então visualizo a mensagem informando que o e-mail já havia sido cadastrado

  Esquema do Cenário: Tentar cadastrar e-mail inválido
    Quando tento cadastrar o e-mail "<email inválido>"
    Então não consigo cadastrar o email na newsletter

    Cenários: Lista de e-mails inválidos
      | email inválido |
      | aaa@teste      |
      | @teste.com     |
      | aa.teste.com   |
