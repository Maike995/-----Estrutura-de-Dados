public class MetodoInterativo {

  int soma;
  
  public MetodoInterativo(int[] lista){

    for(int i = 0; i<lista.length; i++){
      soma = soma + lista[i];
    }
  }


  public void imprimir(int[] lista) {
		  System.out.println(soma);
  }
}