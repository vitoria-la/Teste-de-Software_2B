package br.edu.exemplo;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
class EstoqueServiceTest {
    @Test void deveInformarQuandoExisteEstoque(){
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
        assertTrue(estoque.temEstoque(4));
    }
    @Test void deveRetirarQuantidadeDoEstoque(){
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
        estoque.retirar(3);
        assertEquals(1,estoque.getQuantidade());
    }
}
