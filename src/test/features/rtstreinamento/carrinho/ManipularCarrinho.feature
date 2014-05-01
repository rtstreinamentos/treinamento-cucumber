# language: pt
@regressão-total
Funcionalidade: Manipular produtos no carrinho
  Como cliente
  Para gerenciar os produtos que irei comprar
  Quero manipular os produtos que estão no meu carrinho de compras

  @validação
  Cenário: Incluir o primeiro produto no carrinho
    Dado que não existam produtos no meu carrinho
    Quando decido comprar um produto
    Então visualizo meu carrinho de compras 1 produto

  @validação @funcionalidade-principal
  Cenário: Continuar comprando após incluir um produto no carrinho
    Dado que inclui 1 produto no carrinho
    Quando decido comprar um segundo produto
    Então visualizo meu carrinho de compras 2 produtos

  @validação @funcionalidade-principal
  Esquema do Cenário: Aumentar a quantidade de um produto no carrinho
    Dado que inclui 1 produto no carrinho
    E que o valor unitário do produto é "<valor unitário>"
    Quando aumento a quantidade desse produto para <quantidade>
    Então o total do carrinho deve ser "<total>"

    Cenários: Atualizar o preço após aumentar quantidade de um produto
      | valor unitário | quantidade | total     |
      | R$ 200,00      | 2          | R$ 400,00 |
      | R$ 200,00      | 3          | R$ 600,00 |
