package br.edu.exemplo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


class CarrinhoTest {

    @Test
    void deveTerValorTotalInicialIgualAZero() {
        Carrinho carrinho = new Carrinho();
        assertEquals(0.0, carrinho.getValorTotal(), 0.001);
    }

    @Test
    void deveAdicionarUmProduto() {
        Produto produto = new Produto("Teclado", 100);
        Carrinho carrinho = new Carrinho();
        carrinho.adicionarProduto(produto);
        assertEquals(100, carrinho.getValorTotal(), 0.001);
    }

    @Test
    void deveAdicionarVariosProdutos() {
        Produto produto = new Produto("Teclado", 100);
        Produto produto2 = new Produto("Teclado2", 200);
        Carrinho carrinho = new Carrinho();
        carrinho.adicionarProduto(produto);
        carrinho.adicionarProduto(produto2);
        assertEquals(300, carrinho.getValorTotal(), 0.001);
    }

    @Test
    void deveRemoverUmProduto() {
        Produto produto = new Produto("Teclado", 100);
        Carrinho carrinho = new Carrinho();
        carrinho.adicionarProduto(produto);
        carrinho.removerProduto(produto);
        assertEquals(0, carrinho.getValorTotal(), 0.001);
    }

    @Test
    void deveImpedirAdicionarProdutoPrecoInvalido() {
        Produto produto = new Produto("Teclado", -100);
        Carrinho carrinho = new Carrinho();
        carrinho.adicionarProduto(produto);
        assertEquals(0, carrinho.getValorTotal(), 0.001);
    }

    @Test
    void deveAplicarDescontoSeValorTotalMaiorIgual500() {
        Produto produto = new Produto("Teclado", 1000);
        Carrinho carrinho = new Carrinho();
        carrinho.adicionarProduto(produto);
        assertEquals(900, carrinho.getValorTotal(), 0.001);
    }

}
