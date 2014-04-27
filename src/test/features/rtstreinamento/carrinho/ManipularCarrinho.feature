# language: pt
@regressão-total
Funcionalidade: Manipular produtos no carrinho
  Como cliente
  Para gerenciar os produtos que irei comprar
  Quero manipular os produtos que estão no meu carrinho de compras

  @validação @funcionalidade-principal
  Cenário: Incluir o primeiro produto no carrinho
    Dado que não existam produtos no meu carrinho
    Quando decido comprar um produto
    Então visualizo meu carrinho de compras 1 produto

  @validação
  Cenário: Continuar comprando após incluir um produto no carrinho
    Dado que inclui 1 produto no carrinho
    Quando decido comprar um segundo produto
    Então visualizo meu carrinho de compras 2 produtos

  @validação
  Esquema do Cenário: Aumentar a quantidade de um produto no carrinho
    Dado que inclui 1 produto no carrinho
    E que o valor unitário do produto é R$ "<valor unitário>"
    Quando aumento a quantidade desse produto "<quantidade>" vez
    Então o total do carrinho deve ser R$ "<total>"

    Cenários: Atualizar a quantidade total
      | valor unitário | quantidade | total |
      | 180            | 1          | 360   |
