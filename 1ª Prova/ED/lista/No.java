package br.edu.ifs.ED.lista;

public class No<T> {
    public T dado;
    public No<T> prox;

    public No() {}

    public No(T dado) {
        this.dado = dado;
    }

    public No(T dado, No<T> prox) {
        this.dado = dado;
        this.prox = prox;
    }
}
