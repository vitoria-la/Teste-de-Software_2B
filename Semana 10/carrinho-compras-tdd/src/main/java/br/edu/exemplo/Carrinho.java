package br.edu.exemplo;


public class Carrinho {
    double valorTotal;

    public Carrinho() {
        this.valorTotal = 0;
    }


    public double getValorTotal() {
        if (valorTotal >= 500) {
            return this.valorTotal*0.9;
        }
        return this.valorTotal;
    }

    public void adicionarProduto(Produto produto) {
        if (produto.getPreco() > 0) {
            this.valorTotal += produto.getPreco();
        }
    }

    public void removerProduto(Produto produto) {
        if (produto.getPreco() > 0) {
            this.valorTotal -= produto.getPreco();
        }
    }

}
