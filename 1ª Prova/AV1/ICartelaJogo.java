package br.edu.ifs.AV1;

import br.edu.ifs.ED.lista.ListaEncOrdenada;

public interface ICartelaJogo extends Comparable<ICartelaJogo> {
    void setEstahEmUso(boolean estahEmUso);

    boolean estahEmUso();

    static ICartelaJogo gerarCartelaJogo(int N, int M) {
        return null;
    }

    /**
     * Marca o número como sorteado caso ele exista na matriz NxM
     * @param N número que deve ser encontrado na matriz NxM
     */
    void marcarNumeroSorteado(int N) throws Exception;

    /**
     * Identifica se todos os números em uma determinada linha ou coluna foram
     sorteados.
     * @param verificarPorLinha caso verdadeiro (@true) o programa deverá verificar
    por
     * linha (horizontal). Caso seja falso (@false) deverá verificar
     * por coluna (vertical)
     *
     * @return Verdadeiro se todos os números de uma linha ou coluna foram sorteados.
     */
    boolean ehCartelaVencedora(boolean verificarPorLinha) throws Exception;

    /**
     * Retorna uma lista ordenada com os números que ainda não foram sorteados.
     * Os números duplicados deverão ser ignorados.
     * @return
     */
    ListaEncOrdenada<Integer> getNumerosNaoSorteados();

    int compareTo(ICartelaJogo iCartelaJogo);

    int[][] getDados() throws Exception;

    void desmarcarTodosOsNumeros() throws Exception;
}
