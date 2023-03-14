package EntrturaDeDados;

import Execoes.PilhaCheiaException;
import Execoes.PilhaVaziaException;

public class PilhaCheck{

  protected boolean pass = false;
  
  public PilhaCheck() {
    
  }

  public void checkPass(String expresao)throws PilhaCheiaException, PilhaVaziaException {
    this.pass = checagem(expresao);

  if(pass == true){
      System.out.println("Os escopos estão posicionados de forma correta");
    }else{
      System.out.println("Os escopos não estão posicionados de forma correta");
  }
  }

public static boolean checagem(String conta) throws PilhaCheiaException, PilhaVaziaException  {
		Pilha<Character> pilha = new Pilha<>(1000);
  
    for (char character : conta.toCharArray()) {
      if(character == '('){
        pilha.push(character);
      }
      if(character == '['){
        pilha.push(character);
      }
      if(character == '{'){
        pilha.push(character);
      }
      if(character == ')'){
        if (pilha.isEmpty()){
					return false;
        }
				else {
					char d = pilha.pop();
					if ('(' != d){
            return false;
          }
				}
      }
      if(character == ']'){
        if (pilha.isEmpty()){
					return false;
        }
				else {
					char d = pilha.pop();
					if ('[' != d){
            return false;
          }
				}
      }
      if(character == '}'){
        if (pilha.isEmpty()){
					return false;
        }
				else {
					char d = pilha.pop();
					if ('{' != d){
            return false;
          }
				}
      }
    }
  
		return pilha.isEmpty();
	}


  
}
