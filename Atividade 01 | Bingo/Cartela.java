import java.util.Random;


public class Cartela {

  int[][] cartelaGerada = new int[6][6];
  Random gerador = new Random();
  
    
  public Cartela(){
    for(int i = 0; i<6; i++){
      for(int z = 0; z<6; z++){
        cartelaGerada [i][z] = gerador.nextInt(60)+1;
      } 
    }
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
    //int[][] organizador = new int[1][1];
    int organizador;
    for(int c = 0; c<30; c++){
      for(int b = 0; b<5; b++){
        for(int a = 0; a<5; a++){
          if(cartelaGerada[b][a]>cartelaGerada[b][a+1]){
              organizador  = cartelaGerada[b][a];
              cartelaGerada [b][a]   = cartelaGerada[b][a+1];
              cartelaGerada [b][a+1] = organizador;
          }
          if(cartelaGerada[b][4]>cartelaGerada[b+1][0]){
              organizador  = cartelaGerada[b][4];
              cartelaGerada [b][4]   = cartelaGerada[b+1][0];
              cartelaGerada [b+1][0] = organizador;
          }
          if(cartelaGerada[b][a]==cartelaGerada[b][a+1]){
              organizador  = gerador.nextInt(60)+1;
              cartelaGerada [b][a]   = cartelaGerada[b][a+1];
              cartelaGerada [b][a+1] = organizador;
          }
          if(cartelaGerada[b][4]==cartelaGerada[b+1][0]){
              organizador  = gerador.nextInt(60)+1;
              cartelaGerada [b][4]   = cartelaGerada[b+1][0];
              cartelaGerada [b+1][0] = organizador;
          }
        }
      }
    }
  }
        
}
                

  
  

