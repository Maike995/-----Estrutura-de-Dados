import EntrturaDeDados.FilaProva;
import EntrturaDeDados.PilhaCheck;



class Main {
  public static void main(String[] args) throws Exception  {
    System.out.println();

    
      // Criei uma classe pra realizar a checagem das expreções
    
    PilhaCheck test = new PilhaCheck();
    test.checkPass("{A + B ∗ (C)) + D ∗ (E)}");
    test.checkPass("{A + B ∗ ((C)) + D ∗ (E)}");
    test.checkPass("{A + B ∗ (C + D ∗ (E)}");
    
   

     FilaProva<Integer>  filaTest1 = new FilaProva<>(10);
        filaTest1.incluir(1);
        filaTest1.incluir(2);
        filaTest1.incluir(3);
        

        FilaProva<Integer>  filaTest2 = new FilaProva<>(4);
        filaTest2.incluir(1);
        filaTest2.incluir(2);
        filaTest2.incluir(3);
        filaTest2.incluir(4);
        

      if(filaTest1.saoIguais(filaTest1, filaTest2) == true){
      System.out.println("As filas são iguais");
    }else{
      System.out.println("As filas são diferentes");
    }

  }
  


  
}
