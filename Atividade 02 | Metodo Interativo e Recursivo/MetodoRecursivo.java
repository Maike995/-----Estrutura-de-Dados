public class MetodoRecursivo{

  int soma;
  public MetodoRecursivo(int[] lista){

    int aux = 0;
    contadorRecursivo(lista,soma,aux);
      
  }

  public int contadorRecursivo(int[] lista, int soma, int aux){
    this.soma = soma + lista[aux];
    aux++;
    if(aux==lista.length){
      return 1;
    }
    else{
      return contadorRecursivo(lista,this.soma,aux);
    }
  }

  public void imprimir(int[] lista) {
		  System.out.println(soma);
  }
}