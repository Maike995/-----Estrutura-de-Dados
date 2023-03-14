package br.edu.ifs.ED.lista;

public abstract class Lista<T extends Comparable> implements Comparable<Lista<T>> {
    /**
     * Adiciona um elemento no final da lista
     * O(1)
     * @param elemento
     * @throws Exception
     */
    public abstract void incluir(T elemento) throws Exception;

    /**
     * Adiciona um elemento no início da lista
     * O(n)
     * @param elemento
     * @throws Exception
     */
    public abstract void incluirInicio(T elemento) throws Exception;

    /**
     * Adiciona um elemento em uma posição específica da lista
     * O(n)
     * @param elemento
     * @param posicao
     * @throws Exception
     */
    public abstract void incluir(T elemento, int posicao) throws Exception;

    /**
     * Retorna o elemento que está na posição
     * O(n)
     * @param posicao
     * @return
     * @throws Exception
     */
    public abstract T get(int posicao)  throws Exception;

    /**
     * Retorna a posição do elemento
     * O(n)
     * @param elemento
     * @return
     * @throws Exception
     */
    public abstract int getPosElemento(T elemento)  throws Exception;

    /**
     * Remove o elemento da posição
     * O(n)
     * @param posicao
     * @throws Exception
     */
    public abstract void remover(int posicao) throws Exception;

    /**
     * Remove todos os elementos da lista.
     * O(1)
     */
    public abstract void limpar();

    /**
     * Retorna a quantidade de elementos na lista
     * O(1)
     * @return
     */
    public abstract int getTamanho();

    /**
     * Indica se contém ou não o elemento na lista
     * O(n)
     * @param elemento
     * @return
     * @throws Exception
     */
    public abstract boolean contem(T elemento) throws Exception;

    /**
     * Indica se a lista está vazia
     * O(1)
     * @return
     */
    public boolean estahVazia() {
        return getTamanho() == 0;
    }

    @Override
    public int compareTo(Lista<T> item) {
        if ( item instanceof Lista ) {
            Lista<T> lista = (Lista<T>) item;

            int comparacao1 = Integer.compare(this.getTamanho(), lista.getTamanho());
            if (comparacao1 != 0)
                return comparacao1;

            boolean ehIgual = true;
            int i = 0;
            while (ehIgual && i < this.getTamanho()) {
                try {
                    ehIgual = lista.get(i).equals(this.get(i));
                    i++;
                } catch (Exception e) {
                    return -1;
                }
            }
            return ehIgual ? 0 : -1;

        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("[");

        for (int i = 0; i < getTamanho(); i++) {
            try {
                str.append(get(i).toString()).append(" ");
            } catch (Exception e) {
                str.append("? ");
            }
        }

        str.append("]");

        return str.toString();
    }

    @Override
    public boolean equals(Object outro) {
        if (this == outro) return true;

        if (!(outro instanceof Lista)) return false;

        return compareTo((Lista<T>) outro) == 0;
    }
}
