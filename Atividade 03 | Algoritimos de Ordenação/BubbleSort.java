public class BubbleSort {

  public BubbleSort(int[] lista){
    
    for(int i = 0 ; i<lista.length; i++){
      for(int j = 0 ; j<lista.length-1; j++){
        if (lista[j]>lista[j+1]){
	        int aux  = lista[j];
	        lista[j] = lista[j+1];
	        lista[j+1] = aux;
        }
      }
    }
  }

  public void imprimir(int[] lista) {
    for(int a = 0; a<lista.length; a++){
		  System.out.println(lista[a]);
    }
  }
}






  
