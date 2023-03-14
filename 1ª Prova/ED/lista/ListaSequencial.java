package br.edu.ifs.ED.lista;


public class ListaSequencial<T extends Comparable<T>> extends Lista<T>{
    protected T[] lista;

    protected int qtdMax;

    protected int finalLista;

    @SuppressWarnings("unchecked")
    public ListaSequencial(Class<T> dataType){
        super();

        qtdMax = 10;
        this.lista = (T[]) java.lang.reflect.Array.newInstance(dataType, qtdMax);
        finalLista = -1;
    }

    @Override
    public void incluir(T elemento) throws Exception {
        incluir(elemento, finalLista + 1);
    }

    @Override
    public void incluirInicio(T elemento) throws Exception {
        incluir(elemento, 0);
    }

    @Override
    public void incluir(T elemento, int posicao) throws Exception {
        if (finalLista == qtdMax - 1) throw new Exception("Lista cheia");

        if (posicao < 0 || posicao > finalLista + 1) throw new Exception("Posição solicitada não existe na lista");

        finalLista++;
        for (int i = finalLista; i > posicao; i--) {
            lista[i] = lista[i - 1];
        }

        lista[posicao] = elemento;
    }

    @Override
    public T get(int posicao) throws Exception {
        if (posicao < 0 || posicao > finalLista) throw new Exception("Posição solicitada não existe na lista");

        return lista[posicao];
    }

    @Override
    public int getPosElemento(T elemento) throws Exception {
        for (int pos = 0; pos <= finalLista; pos++) {
            if (lista[pos].equals(elemento)) return pos;
        }

        throw new Exception("Elemento solicitado não existe na lista");
    }

    @Override
    public void remover(int posicao) throws Exception {
        if (posicao < 0 || posicao > finalLista) throw new Exception("Posição solicitada não existe na lista");

        finalLista--;
        for (int i = posicao; i <= finalLista; i++) {
            lista[i] = lista[i + 1];
        }
    }

    @Override
    public int getTamanho() {
        return finalLista + 1;
    }

    @Override
    public void limpar() {
        finalLista = -1;
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
}
