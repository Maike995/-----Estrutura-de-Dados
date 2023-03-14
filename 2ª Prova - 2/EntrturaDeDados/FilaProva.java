package EntrturaDeDados;


import Execoes.FilaCheiaException;
import Execoes.FilaVaziaException;


public class FilaProva<T> implements IFila<T> {
    protected int max = 0;
    protected T[] dados;
    protected int tamanho;
  
    public FilaProva(int tamanho){
      this.tamanho = tamanho;
      this.dados =  (T[]) java.lang.reflect.Array.newInstance(Object.class, this.tamanho);
    }
  
    public void incluir(T valor) throws FilaCheiaException {
      if(max == tamanho){
        throw new FilaCheiaException("A fila está cheia");
      }
      this.dados[max] = valor;
      max++;
    }
  
    public T remover() throws FilaVaziaException{
      if (estaVazia()) {
        throw new FilaVaziaException("A fila está vazia");
      } 
      T temp = dados[0];
      
      for(int i = 0; i < this.max; i++) {
        this.dados[i] = this.dados[i+1];
      }
      max--;
      return (T)temp;
    }
  
    public boolean estaVazia() {
        return max==0 ? true : false;
    }
  
    public void limpar(){
      for(int i = 0; i < this.max; i++) {
        this.dados[i] = null;
      }
      this.max = 0;
    }

    public T visualizarProximo() throws FilaVaziaException{
      if (estaVazia()) {
        throw new FilaVaziaException("A fila está vazia");
      }
        return this.dados[0];
    }

   public boolean saoIguais(FilaProva<T> fila1, FilaProva<T> fila2) {
     if(fila1.max == fila2.max){
        for (int i = 0; i < this.max; i++){
			    if(fila1.dados[i] != fila2.dados[i]){
             return false;
          }
		    }
      }else{
        return false;
      }
      return true;
   }

}