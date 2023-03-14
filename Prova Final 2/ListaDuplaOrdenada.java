package lista;

public class ListaDuplaOrdenada<T extends Comparable<T>> extends Lista<T> {
    private No<T> primeiroNo;
    private No<T> ultimoNo;

    private int tamanho;

    public ListaDuplaOrdenada() {
        this.primeiroNo = null;
        this.ultimoNo = null;
        this.tamanho = 0;
    }

    //10 9 8 7 5 6
    @Override
    public void incluir(T elemento) throws Exception {
        No<T> no = new No<>(elemento);
        switch (tamanho) {
            case 0 -> {
                primeiroNo = no;
                ultimoNo = no;
                tamanho++;
            }
            case 1 -> {
                if (elemento.compareTo(primeiroNo.conteudo) > 0) {
                    no.noProximo = primeiroNo;
                    primeiroNo.noPrevio = no;
                    primeiroNo = no;
                } else {
                    no.noPrevio = primeiroNo;
                    primeiroNo.noProximo = no;
                    ultimoNo = no;
                }
                tamanho++;
            }
            default -> {
                No<T> noAux = primeiroNo;
                while (true) {
                    if (elemento.compareTo(noAux.conteudo) < 0) {
                        if (noAux.noProximo == null) {
                            no.noPrevio = ultimoNo;
                            ultimoNo.noProximo = no;
                            ultimoNo = no;
                            tamanho++;
                            return;
                        }
                        if (elemento.compareTo(noAux.noProximo.conteudo) >= 0) {
                            no.noProximo = noAux.noProximo;
                            no.noPrevio = noAux;
                            noAux.noProximo.noPrevio = no;
                            noAux.noProximo = no;
                            tamanho++;
                            return;
                        } else {
                            noAux = noAux.noProximo;
                        }
                    } else {
                        no.noProximo = primeiroNo;
                        primeiroNo.noPrevio = no;
                        primeiroNo = no;
                        tamanho++;
                        return;
                    }
                }
            }
        }
    }

    @Override
    public T get(int posicao) throws Exception {

        return null;
    }

    @Override
    public int getPosElemento(T elemento) throws Exception {
        return  0;
    }

    @Override
    public void remover(int posicao) throws Exception {

    }

    @Override
    public void limpar() {
        this.primeiroNo = null;
        this.ultimoNo = null;
        tamanho =0;
    }

    @Override
    public int getTamanho() {
        return tamanho;
    }

    @Override
    public boolean contem(T elemento) throws Exception {
        return false;
    }

    @Override
    public int compareTo(Lista<T> item) {
        return 0;
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        No<T> noAux = primeiroNo;
        switch (tamanho) {
            case 0 -> builder.append(']');
            case 1 -> builder.append(noAux.conteudo).append("]");
            default -> {
                while (noAux.noProximo != null) {
                    builder.append(noAux.conteudo).append(", ");;
                    noAux = noAux.noProximo;
                }
                builder.append(noAux.conteudo).append(']');
            }
        }
            return builder.toString();
    }
}
