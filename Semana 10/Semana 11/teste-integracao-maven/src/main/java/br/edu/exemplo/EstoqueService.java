package br.edu.exemplo;
import java.util.ArrayList;

public class EstoqueService {

    private ArrayList<ProdutoEntity> produtos;

    public EstoqueService(ArrayList<ProdutoEntity> produtos) {
        this.produtos = produtos;
    }

    public boolean temEstoque(int quantidadeSolicitada){
        return produtos.size() >= quantidadeSolicitada;
    }

    public void retirar(int quantidade){
        produtos.subList(0, quantidade - 1);
        ArrayList<ProdutoEntity> produtosRetirar = new ArrayList<>();

        for(int x = 0; x < quantidade; x++) {
            produtosRetirar.add(produtos.get(x));
        }

        produtos.removeAll(produtosRetirar);
    }

    public int getQuantidade(){
        return produtos.size();
    }
}
