public class QuickSort {

  public QuickSort(int[] lista){
    
      int inicio = 0;
      int fim = lista.length-1;
    
	    quickOrder(lista,inicio,fim);
  }

  public void quickOrder(int[] lista,int inicio, int fim){
    if(inicio < fim){
	    int part = particao(lista,inicio,fim);
	    quickOrder(lista,inicio,part-1);
	    quickOrder(lista,part+1,fim);
    }
  }

  public int particao(int[] lista,int inicio,int fim){
    
    int pivo = lista[fim];
    int i = inicio;
    
    for(int j = inicio; j<fim; j++){
      if(lista[j]<=pivo){
        int aux  = lista[j];
	      lista[j] = lista[i];
	      lista[i] = aux;
        i = i+1;
      }
    }
    int aux  = lista[fim];
	  lista[fim] = lista[i];
	  lista[i] = aux;

    return i;
  }
    
  public void imprimir(int[] lista) {
    for(int a = 0; a<lista.length; a++)
		  System.out.println(lista[a]);
  }

}






  

