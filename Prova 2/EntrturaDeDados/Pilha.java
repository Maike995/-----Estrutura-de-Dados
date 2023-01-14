package EntrturaDeDados;

import Execoes.PilhaCheiaException;
import Execoes.PilhaVaziaException;

public class Pilha<T> {

	private T[] elementos;
	private int entrada;
  private int tamanho;

	public Pilha(int tamanho){
    this.tamanho = tamanho;
		this.elementos = (T[]) java.lang.reflect.Array.newInstance(Object.class, this.tamanho);
		this.entrada = -1;
	}

	public void push(T novoElemento)throws PilhaCheiaException {
    if (this.entrada < this.elementos.length - 1) {
      this.elementos[++entrada] = novoElemento;
    }else{
      throw new PilhaCheiaException("Pilha cheia.");
    }
	}

	public T pop() throws PilhaVaziaException {
    if (isEmpty()) {
            throw new PilhaVaziaException("Pilha vazia");
        }
    return this.elementos[this.entrada--];
	}
  
	public boolean isEmpty(){
		if (this.entrada == -1) {
      return true;
    }
    return false;
	}



  
}

 
