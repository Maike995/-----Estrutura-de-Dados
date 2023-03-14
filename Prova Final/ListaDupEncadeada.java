package br.edu.ifs.ED.lista;



public class ListaDupEncadeada<T extends Comparable<T>> extends Lista<T>{

    protected No<T> primeiroNo;
    protected No<T> ultimoNo;

    protected int tamanhoLista = 0;
  
    public ListaDupEncadeada() {}


    @Override
    public void incluir(T elemento) throws Exception {
        No<T> novoNo = new No<>(elemento);
        if(primeiroNo == null){
          primeiroNo = novoNo;
          ultimoNo = novoNo;
          tamanhoLista++;
          return;
        }

        No<T> novoNoAux = new No<T>(primeiroNo.conteudo);
        novoNoAux.setNoProximo(primeiroNo.getNoProximo());
        int index = 0;
      
        while(novoNoAux != null && elemento.compareTo(novoNoAux.conteudo) < 0){
            novoNoAux = novoNoAux.getNoProximo();
            index++;
        }
      
        No<T> noAuxiliar = getNo(index);
        
        novoNo.setNoProximo(noAuxiliar);

        if(novoNo.getNoProximo() != null){
            novoNo.setNoPrevio(noAuxiliar.getNoPrevio());
            novoNo.getNoProximo().setNoPrevio(novoNo);
        }else {
            novoNo.setNoPrevio(ultimoNo);
            ultimoNo = novoNo;
        }
        if(index == 0){
            primeiroNo = novoNo;
        }else {
            novoNo.getNoPrevio().setNoProximo(novoNo);
        }
        tamanhoLista++;
    }
  
    @Override
    public T get(int posicao) throws Exception {
        return getNo(posicao).getConteudo();
    }

    private No<T> getNo(int posicao){
      if(posicao<0){
        
      }
        No<T> noAuxiliar = primeiroNo;
        for(int i = 0; (i < posicao) && (noAuxiliar != null); i++){
            noAuxiliar = noAuxiliar.getNoProximo();
        }
        return noAuxiliar;
    }

    @Override
    public int getPosElemento(T elemento) throws Exception {
        No<T> no = primeiroNo;
        int pos = tamanhoLista - 1;

        while (no != null) {
            if (no.conteudo.equals(elemento)) return pos;
            else if (no.conteudo.compareTo(elemento) < 0) break;
            else {
                no = no.noProximo;
                pos--;
            }
        }

        throw new Exception("Elemento solicitado não existe na lista");

    }

    @Override
    public void remover(int posicao) throws Exception {
      if(posicao>=tamanhoLista){
        throw new Exception("Não existe Elemento nessa posição");
      }
       if(posicao == 0){
            primeiroNo = primeiroNo.getNoProximo();
            if(primeiroNo != null){
                primeiroNo.setNoPrevio(null);
            }
        }else{
            No<T> noAuxiliar = getNo(posicao);
            noAuxiliar.getNoPrevio().setNoProximo(noAuxiliar.getNoProximo());
            if(noAuxiliar != ultimoNo){
                noAuxiliar.getNoProximo().setNoPrevio(noAuxiliar.getNoPrevio());
            }else{
                ultimoNo = noAuxiliar.getNoPrevio();
            }
        }
        this.tamanhoLista--;   
    }

    @Override
    public int getTamanho() {
        return tamanhoLista;
    }

    @Override
    public void limpar() {
      primeiroNo = null;
      ultimoNo = null;
      tamanhoLista = 0;
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

    public boolean equals(Object outro) {
        if (this == outro) return true;

        if (!(outro instanceof Lista)) return false;

        return compareTo((Lista<T>) outro) == 0;
    }

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
}
