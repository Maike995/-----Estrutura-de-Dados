public class MergeSort {

  public MergeSort(int[] lista){
    
      int inicio = 0;
      int fim = lista.length-1;
    
	    mergeOrder(lista,inicio,fim);
  }

  public void mergeOrder(int[] lista,int inicio, int fim){
    if(inicio < fim){
	    int meio = (inicio + fim) / 2;
	    mergeOrder(lista,inicio,meio);
	    mergeOrder(lista,meio+1,fim);
	    intercalador(lista,inicio,meio,fim);
    }
  }

  public void intercalador(int[] lista,int inicio,int meio ,int fim){
    int[] aux = new int[lista.length];
    
    for(int y = inicio; y<=fim;y++){
      aux[y] = lista[y];
    }

      int i = inicio;
      int j = meio+1;

	    for (int k = inicio; k <=fim; k++){
        if(i > meio){
          lista[k] = aux[j++];
        }
        else if(j > fim){
          lista[k] = aux[i++];
        }
        else if(aux[i] < aux[j]){
          lista[k] = aux[i++];
        }
        else {
          lista[k] = aux[j++];
        }
      }
    
  }
    
  public void imprimir(int[] lista) {
    for(int a = 0; a<lista.length; a++)
		  System.out.println(lista[a]);
  }

}






  
