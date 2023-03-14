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

    @Override
    public abstract int compareTo(Lista<T> item);

    
}
