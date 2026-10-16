package br.edu.exemplo;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PedidoServiceIntegrationTest {

    @Test void deveRealizarPedidoERetirarProdutoDoEstoque(){
        ProdutoEntity produto1 = new ProdutoEntity("Produto 1");
        ProdutoEntity produto2 = new ProdutoEntity("Produto 2");
        ProdutoEntity produto3 = new ProdutoEntity("Produto 3");
        ProdutoEntity produto4 = new ProdutoEntity("Produto 4");

        ArrayList<ProdutoEntity> produtos = new ArrayList<>();
        produtos.add(produto1);
        produtos.add(produto2);
        produtos.add(produto3);
        produtos.add(produto4);

        EstoqueService estoque = new EstoqueService(produtos);
        PedidoService pedido = new PedidoService(estoque);
        assertTrue(pedido.realizarPedido(1));
        assertEquals(3,estoque.getQuantidade());
    }

    @Test void naoDeveRealizarPedidoSemEstoqueSuficiente(){
        ProdutoEntity produto1 = new ProdutoEntity("Produto 1");
        ProdutoEntity produto2 = new ProdutoEntity("Produto 2");
        ProdutoEntity produto3 = new ProdutoEntity("Produto 3");
        ProdutoEntity produto4 = new ProdutoEntity("Produto 4");

        ArrayList<ProdutoEntity> produtos = new ArrayList<>();
        produtos.add(produto1);
        produtos.add(produto2);
        produtos.add(produto3);
        produtos.add(produto4);

        EstoqueService estoque = new EstoqueService(produtos);
        PedidoService pedido = new PedidoService(estoque);
        assertFalse(pedido.realizarPedido(10));
        assertEquals(4,estoque.getQuantidade());
    }
}