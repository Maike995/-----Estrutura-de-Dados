
public class SelectionSort {

  public SelectionSort(int[] lista){
    for(int j = 0 ; j<lista.length-1; j++){
      int min_index = j;
    
      for(int i = j ; i<lista.length; i++){
        if (lista[i]<lista[min_index]){
	        min_index = i;
        }
        if (lista[j]>lista[min_index]){
	        int aux  = lista[j];
	        lista[j] = lista[min_index];
	        lista[min_index] = aux;
        }
      }
    }
  }

  public void imprimir(int[] lista) {
    for(int a = 0; a<lista.length; a++)
		  System.out.println(lista[a]);
  }

}