# Relatório:

## CT01:
No teste deveCadastrarERecuperarProduto(), foi:
- Cadastrado um produto por service local;
- Conferido se o id do novo produto não era null;
- Buscado o produto usando o id;
- Verificado se os dados do produto foram cadastrados corretamente;

## CT02:
No teste naoDevePersistirProdutoComNomeEmBranco(), foi:
- Feito um loop para contar a quantidade de registros existentes no banco;
- Foi feita uma tentativa de cadastrar um produto sem nome;
- Foi refeito o loop para contar a qauntidade de registros após a tentativa;
- Verificou se as duas quantidades eram iguais;
- Esse teste usou um service locaL;


## CT03:
No teste deveAtualizarPrecoPersistido(), foi:
- Cadastrado um produto via service local;
- Atualizado o preço via service local;
- Comparado se o preço foi realmente atualizado;

## CT04:
No teste deveCadastrarProdutoPelaApi() utiliza-se:
- MockMvc para realizar o método Post;
- Verificar se foi método foi realizado com sucesso.

## CT05:
No teste deveBuscarProdutoPelaApi() utiliza-se:
- MockMvc para realizar o método Post e verificar se foi realizado com sucesso.
- ObjectMapper e JsonNode para pegar o id atribuído ao produto pelo post.
- MockMvc para realizar o método Get e verificar se buscou o produto correto.




