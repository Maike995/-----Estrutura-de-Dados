import java.util.ArrayList;

public class Bingo{

ArrayList<Cartela> salvarCartelas = new ArrayList();

  
public Bingo(int quantidade){

for(int q=0;q<quantidade;q++){
      System.out.println();
      System.out.println("  Cartela "+(q+1) );
    Cartela gerar = new Cartela();
      gerar.ordem();
      gerar.imprimirCartela();
      
salvarCartelas.add(gerar);
  
}



  
}}




  