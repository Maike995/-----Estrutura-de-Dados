
class Main {
  public static void main(String[] args) {
    System.out.println("");

    int[] lista = {100,5,2,7,4,8,17,16,37,15,93,3,6,30,1,-10,-34};
    
    MetodoInterativo test = new MetodoInterativo(lista);
    MetodoRecursivo  test1 = new MetodoRecursivo(lista);
    
    test.imprimir(lista);
    test1.imprimir(lista);

  }
}