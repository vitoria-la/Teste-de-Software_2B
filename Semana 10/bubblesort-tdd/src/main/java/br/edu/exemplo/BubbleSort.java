package br.edu.exemplo;

public class BubbleSort {

    private int[] numeros;

    public BubbleSort(int[] numeros) {
        this.numeros = numeros;
    }

    public void ordenar() {
        for(int x = 0; x < numeros.length - 1; x++) {
            for(int y = x + 1; y < numeros.length; y++) {
                if (numeros[x] > numeros[y]) {
                    int tmp = numeros[x];
                    numeros[x] = numeros[y];
                    numeros[y] = tmp;
                }
            }
        }
    }

    public int[] getNumeros() {
        return numeros;
    }
}
