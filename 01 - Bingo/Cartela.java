
import java.util.Random;
import java.util.ArrayList;

public class Cartela {

    int[][] cartelaGerada = new int[5][5];

  ArrayList salvarCartelas = new ArrayList();
  
    public Cartela(){
        for(int i = 0; i<5; i++){
          for(int z = 0; z<5; z++){

                    Random gerador = new Random();
                    cartelaGerada [i][z] = gerador.nextInt(60)+1;

                }
            }
      salvarCartelas.add(cartelaGerada);
    }

  public void imprimirCartela(){
      for(int v = 0; v<5; v++){
        for(int b = 0; b<5; b++){
     System.out.print(cartelaGerada[v][b] + " ");
        }System.out.println();
      }
  }

}
    
   