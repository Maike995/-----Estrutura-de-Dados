public class MetodosIterativos {

    //Questao 1
    public int contarApenasInteiros(double[] vetor) {
        int soma = 0;
        for (double v : vetor) {
            if (v == (int) v) {
                soma++;
            }
        }

        return soma;
    }

    //Questao 2
    public int somarVetorDeInteiros(int[] vetor) {
        int soma = 0;
        for (int v : vetor) {
            soma += v;
        }

        return soma;
    }
}