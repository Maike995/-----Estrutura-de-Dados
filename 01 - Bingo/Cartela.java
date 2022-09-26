import java.util.Random;
import java.util.ArrayList;

public class Cartela {

  int[][] cartelaGerada = new int[6][6];
  Random gerador = new Random();
  ArrayList salvarCartelas = new ArrayList();
    
  public Cartela(){

    for(int i = 0; i<6; i++){
      for(int z = 0; z<6; z++){
        cartelaGerada [i][z] = gerador.nextInt(60)+1;
      } 
    }
      salvarCartelas.add(cartelaGerada);
  }

  public void imprimirCartela(){
    for(int v = 0; v<5; v++){
      for(int b = 0; b<5; b++){
        if(cartelaGerada[v][b]<10){
          System.out.print("0");
        }
        System.out.print(cartelaGerada[v][b] + " ");
      }
      System.out.println();
    }
  }
  
  public void ordem(){
    
    int[][] organizador = new int[1][1];

    for(int c = 0; c<30; c++){
      for(int b = 0; b<5; b++){
        for(int a = 0; a<5; a++){
          if(cartelaGerada[b][a]>cartelaGerada[b][a+1]){
              organizador   [0][0]   = cartelaGerada[b][a];
              cartelaGerada [b][a]   = cartelaGerada[b][a+1];
              cartelaGerada [b][a+1] = organizador[0][0];
          }
          if(cartelaGerada[b][4]>cartelaGerada[b+1][0]){
              organizador   [0][0]   = cartelaGerada[b][4];
              cartelaGerada [b][4]   = cartelaGerada[b+1][0];
              cartelaGerada [b+1][0] = organizador[0][0];
          }
          if(cartelaGerada[b][a]==cartelaGerada[b][a+1]){
              organizador   [0][0]   = gerador.nextInt(60)+1;
              cartelaGerada [b][a]   = cartelaGerada[b][a+1];
              cartelaGerada [b][a+1] = organizador[0][0];
          }
          if(cartelaGerada[b][4]==cartelaGerada[b+1][0]){
              organizador   [0][0]   = gerador.nextInt(60)+1;
              cartelaGerada [b][4]   = cartelaGerada[b+1][0];
              cartelaGerada [b+1][0] = organizador[0][0];
          }
        }
      }
    }

  }
             
}
                

  
  

