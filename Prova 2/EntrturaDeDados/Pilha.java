package EntrturaDeDados;

import Execoes.PilhaCheiaException;
import Execoes.PilhaVaziaException;

public class Pilha{

	private char[] elementos;
	private int entrada;

	public Pilha(){
		this.elementos = new char[1000];
		this.entrada = -1;
	}

	public void push(char novoElemento)throws PilhaCheiaException {
    if (this.entrada < this.elementos.length - 1) {
      this.elementos[++entrada] = novoElemento;
    }else{
      throw new PilhaCheiaException("Pilha cheia.");
    }
	}

	public char pop() throws PilhaVaziaException {
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

 