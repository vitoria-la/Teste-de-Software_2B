package br.edu.exemplo;

import br.edu.exemplo.model.Produto;
import br.edu.exemplo.repository.ProdutoRepository;
import br.edu.exemplo.service.ProdutoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class ProdutoServiceIntegrationTest {

    @Autowired
    ProdutoService service;
    @Autowired
    ProdutoRepository repository;

    @Test
    void deveCadastrarERecuperarProduto() {
        // TODO EX1: cadastrar Teclado por 150, confirmar ID e buscar pelo repositório.
        // Conferir nome e preço do registro recuperado.

        Produto produtoSalvo = service.cadastrar("Teclado", 150.0);
        assertNotNull(produtoSalvo.getId());

        Produto produtoEncontrado = service.buscar(produtoSalvo.getId());
        assertEquals("Teclado", produtoEncontrado.getNome());
        assertEquals(150.0, produtoEncontrado.getPreco());
    }

    @Test
    void naoDevePersistirProdutoComNomeEmBranco() {
        // TODO EX1: contar registros, tentar cadastrar nome em branco,
        // verificar IllegalArgumentException e que a contagem não mudou.
        int quantidadeDeRegistros = 0;
        Produto produto;
        boolean terminouALista = false;

        do {
            try {
                produto = service.buscar((long) quantidadeDeRegistros);
                quantidadeDeRegistros++;
            } catch (IllegalArgumentException error) {
                System.out.println("Sem registro nesse id");
                terminouALista = true;
            }
        } while (!terminouALista);

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> service.cadastrar("", 150.0)
        );


        int quantidadeDeRegistrosAposTentativa = 0;
        terminouALista = false;

        do {
            try {
                produto = service.buscar((long) quantidadeDeRegistrosAposTentativa);
                quantidadeDeRegistrosAposTentativa++;
            } catch (IllegalArgumentException error) {
                System.out.println("Sem registro nesse id");
                terminouALista = true;
            }
        } while (!terminouALista);


        assertEquals(quantidadeDeRegistros, quantidadeDeRegistrosAposTentativa);
    }

    @Test
    void deveAtualizarPrecoPersistido() {
        // TODO DESAFIO: cadastrar, atualizar preço e buscar novamente no repositório.
        Produto produtoSalvo = service.cadastrar("Teclado", 150.0);
        Produto produtoAtualizado = service.atualizarPreco(produtoSalvo.getId(), 95.0);
        assertEquals(95.0, produtoAtualizado.getPreco());
    }
}