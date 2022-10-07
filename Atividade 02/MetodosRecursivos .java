public class MetodosRecursivos {
    //Questao 3
    //Em ambas, a passagem de 'tamanho' como parâmetro será igual ao length do vetor -1
    public int contarApenasInteiros(double[] vetor, int tamanho) {
        if (tamanho < 0) {
            return 0;
        } else {
            if (vetor[tamanho] == (int) vetor[tamanho]) {
                return contarApenasInteiros(vetor, tamanho - 1) + 1;
            } else {
                return contarApenasInteiros(vetor, tamanho - 1);
            }
        }


    }
    public int somarVetorDeInteiros(int[] vetor, int tamanho) {
        if (tamanho < 0) {
            return 0;
        } else {
            if (vetor[tamanho] == (int) vetor[tamanho]) {
                return somarVetorDeInteiros(vetor, tamanho - 1) + vetor[tamanho];
            } else {
                return somarVetorDeInteiros(vetor, tamanho - 1);
            }
        }
    }

}