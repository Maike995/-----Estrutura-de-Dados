import java.util.Scanner;


public class TestArvoreBinInteiro {
    public static void main(String[] args) {
        
        ArvoreBinInteiro arvore = new ArvoreBinInteiro();
        Scanner sc = new Scanner(System.in); 
        int i = 0;
        int opcao = 0;
      
        System.out.println("Bem Vindo a seguir insira o numero do que deseja fazer");

        

        do {
            System.out.println("\nMenu\n"
                    + "1. Inserir um número\n"
                    + "2. Retornar o maior número\n"
                    + "3. Retornar o menor número\n"
                    + "4. Retornar a altura da árvore\n"
                    + "5. Listar números (percurso Pré-Ordem)\n"
                    + "6. Listar números (percurso Pós-Ordem)\n"
                    + "7. Listar números (percurso Simétrico)\n"
                    + "8. Listar números (percurso em níveis)\n"
                    + "9. Listar os números internos\n"
                    + "10. Listar as folhas\n"
                    + "11. Exibir caminho da raiz a um número\n"
                    + "12. Retorna raiz\n"
                    + "13. Remover um número\n"
                    + "0. Sair");

            System.out.print("Opção escolhida: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 0:
                    System.out.println("Saindo do programa...");
                    i++;
                    break;
                case 1:
                    System.out.print("Digite um número: ");
                    int numero = sc.nextInt();
                    arvore.inserir(numero);
                    System.out.println(numero + " inserido com sucesso na árvore.");
                    break;
                case 2:
                    System.out.println("Maior número da árvore: " + arvore.maiorValor());
                    break;
                case 3:
                    System.out.println("Menor número da árvore: " + arvore.menorValor());
                    break;
                case 4:
                    System.out.println("Altura da árvore: " + arvore.altura());
                    break;
                case 5:
                    System.out.println("Listando números em percurso Pré-Ordem: ");
                    arvore.listarPreOrdem();
                    break;
                case 6:
                    System.out.println("Listando números em percurso Pós-Ordem: ");
                    arvore.listarPosOrdem();
                    break;
                case 7:
                    System.out.println("Listando números em percurso Simétrico: ");
                    arvore.listarSimetrica();
                    break;
                case 8:
                    System.out.println("Listando números em percurso em níveis: ");
                    arvore.listarNiveis();
                    break;
                case 9:
                    System.out.println("Listando números internos: ");
                    arvore.listarInternos();
                    break;
                case 10:
                    System.out.println("Listando folhas: ");
                    arvore.listarFolhas();
                    break;
                case 11:
                    System.out.print("Digite o número para encontrar o caminho da raiz: ");
                    int valor = sc.nextInt();
                    System.out.println("Caminho da raiz até " + valor + ": " + arvore.caminho(valor));
                    break;
                case 12:
                    System.out.println("Raiz da árvore: " + arvore.getRaiz());
                    break;
                case 13:
                    System.out.print("Digite o número que sera removido: ");
                    int remove = sc.nextInt();
                    arvore.remover(remove);
                    System.out.println(remove + " removido com sucesso da árvore.");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }

          System.out.println("");
        } while(i<1);


    }

}