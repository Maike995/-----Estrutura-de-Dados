package br.edu.ifs.ED.lista;

/**
 * 0    1    2    3    4    5
 * a <- b <- c <- d <- e <- f
 *                          ^
 *                         fim
 */
public class ListaEnc<T extends Comparable<T>> extends Lista<T> {
    protected No<T> fim;
    protected int tamanho;

    public ListaEnc() {}

    @Override
    public void incluir(T elemento) throws Exception {
        incluir(elemento, tamanho);
    }

    @Override
    public void incluirInicio(T elemento) throws Exception {
        incluir(elemento, 0);
    }

    @Override
    public void incluir(T elemento, int posicao) throws Exception {
        if (posicao < 0 || posicao > tamanho)
            throw new Exception("Posição solicitada não existe na lista e não é igual a getTamanho()");

        if (posicao == tamanho) {
            fim = new No<>(elemento, fim);
        } else {
            No<T> atual = getNo(posicao);

            atual.prox = new No<>(elemento, atual.prox);
        }

        tamanho++;
    }

    @Override
    public T get(int posicao) throws Exception {
        return getNo(posicao).dado;
    }

    @Override
    public int getPosElemento(T elemento) throws Exception {
        No<T> no = fim;
        int pos = tamanho - 1;

        while (no != null) {
            if (no.dado.equals(elemento)) return pos;
            else {
                no = no.prox;
                pos--;
            }
        }

        throw new Exception("Elemento solicitado não existe na lista");
    }

    @Override
    public void remover(int posicao) throws Exception {
        if (posicao < 0 || posicao >= tamanho) throw new Exception("Posição solicitada não existe na lista");

        if (posicao == tamanho - 1) {
            fim = fim.prox;
        } else {
            No<T> posterior = getNo(posicao + 1);
            posterior.prox = posterior.prox.prox;
        }

        tamanho--;
    }

    @Override
    public int getTamanho() {
        return tamanho;
    }

    @Override
    public void limpar() {
        fim = null;
        tamanho = 0;
    }

    @Override
    public boolean contem(T elemento) throws Exception {
        try {
            getPosElemento(elemento);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Retorna o nó que está na posição.
     * O(n).
     * @throws Exception
     */
    protected No<T> getNo(int posicao) throws Exception {
        if (posicao < 0 || posicao >= tamanho) throw new Exception("Posição solicitada não existe na lista");

        No<T> no = fim;
        int pos = tamanho - 1;

        while (pos != posicao) {
            no = no.prox;
            pos--;
        }

        return no;
    }
}
