package br.edu.ifs.AV1;

public class NumeroCartela implements Comparable<NumeroCartela> {
    private int valor;

    private boolean sorteado = false;

    public NumeroCartela(int numero) {
        this.valor = numero;
    }

    public int getNumero() {
        return valor;
    }

    public boolean isSorteado() {
        return sorteado;
    }

    public void setSorteado(boolean sorteado) {
        this.sorteado = sorteado;
    }

    @Override
    public String toString() {
        return "[" +this.getNumero() + (this.isSorteado()? "*":"") +"]";
    }

    @Override
    public int compareTo(NumeroCartela numeroCartela) {
        return Integer.compare(getNumero(), numeroCartela.getNumero());
    }

    @Override
    public boolean equals(Object outro) {
        if (this == outro) return true;

        if (!(outro instanceof NumeroCartela)) return false;

        NumeroCartela numeroCartela = (NumeroCartela) outro;

        return valor == numeroCartela.getNumero() && sorteado == numeroCartela.isSorteado();
    }
}
