import lista.*;


public class Main {

    public static void main(String[] args) throws Exception {

        System.out.println();

        test();

    }

    public static void test() throws Exception {
        Lista<Integer> lista = new ListaDuplaOrdenada<>();

        /*for (int i = 0; i < 10; i++) {
            lista.incluir(i);
            System.out.println(lista);
        }
        lista.limpar();
        for (int i = 10; i > 0; i--) {
            lista.incluir(i);
            System.out.println(lista);
        }*/
        lista.limpar();
        for (int i = 10; i < 100; i += 10) {
            lista.incluir(i);
//            System.out.println(lista);
        }
        System.out.println(lista);
        lista.incluir(95);

        System.out.println(lista);
        lista.incluir(7);


        System.out.println(lista);
        lista.incluir(55);

        System.out.println(lista);
    }

}