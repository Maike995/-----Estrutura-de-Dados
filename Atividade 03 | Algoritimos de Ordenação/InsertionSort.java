public class InsertionSort {

  public InsertionSort(int[] lista){
    for(int i = 1; i<lista.length; i++){
      int chave = lista[i];
	    int j = i - 1;
      
	    while(j>=0 && lista[j] > chave){
		    lista[j+1] = lista[j];
		    j = j - 1;
	    }
    
      lista[j+1]= chave;
    }
  }
  
  public void imprimir(int[] lista) {
    for(int a = 0; a<lista.length; a++)
		  System.out.println(lista[a]);
  }

}






  
