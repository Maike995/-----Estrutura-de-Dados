package br.edu.ifs.ED.lista;

/**
 * Lista ordenada de forma ascendente.
 */
public class ListaEncOrdenada <T extends Comparable<T>> extends ListaEnc<T> {
    @Override
    public void incluir(T elemento, int posicao) throws Exception {
        if (posicao < 0 || posicao > tamanho)
            throw new Exception("Posição solicitada não existe na lista e não é igual a getTamanho()");

        if (posicao == tamanho) {
            if (tamanho == 0 || fim.dado.compareTo(elemento) <= 0) {
                fim = new No<>(elemento, fim);
            } else {
                throw new Exception(
                        "Não é possível inserir o elemento nessa posição, pois a lista ficaria desordenada");
            }
        } else {
            No<T> atual = getNo(posicao);
            No<T> anterior = atual.prox;

            if ((anterior != null && anterior.dado.compareTo(elemento) > 0) || atual.dado.compareTo(elemento) < 0)
                throw new Exception(
                        "Não é possível inserir o elemento nessa posição, pois a lista ficaria desordenada");

            atual.prox = new No<>(elemento, anterior);
        }

        tamanho++;
    }

    @Override
    public int getPosElemento(T elemento) throws Exception {
        No<T> no = fim;
        int pos = tamanho - 1;

        while (no != null) {
            if (no.dado.equals(elemento)) return pos;
            else if (no.dado.compareTo(elemento) < 0) break;
            else {
                no = no.prox;
                pos--;
            }
        }

        throw new Exception("Elemento solicitado não existe na lista");
    }

    /**
     * Inclui o elemento na posição correta, mantendo a lista ordenada.
     * O(n).
     */
    public void incluirEmOrdem(T elemento) throws Exception {
        if (estahVazia() || fim.dado.compareTo(elemento) <= 0) {
            incluir(elemento);
            return;
        }

        No<T> atual = fim;

        while (atual.prox != null && atual.prox.dado.compareTo(elemento) > 0) {
            atual = atual.prox;
        }

        atual.prox = new No<>(elemento, atual.prox);
        tamanho++;
    }
}
