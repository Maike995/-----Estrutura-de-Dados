package br.edu.ifs.AV1;

import br.edu.ifs.ED.lista.Lista;
import br.edu.ifs.ED.lista.ListaEnc;

import java.util.Random;

public class Bingo {
    private final Lista<ICartelaJogo> cartelas;

    /**
     * Cria a classe gerenciadora do bingo, com as cartelas.
     * @param qtd
     * @param qtdLinhas
     * @param qtdColunas
     * @throws Exception
     */
    public Bingo(int qtd, int qtdLinhas, int qtdColunas) throws Exception {
        if (qtd <= 0 || qtdLinhas <= 0 || qtdColunas <= 0) throw new Exception("Parâmetros inválidos");

        cartelas = new ListaEnc<>();

        for (int i = 0; i < qtd; i++) {
            ICartelaJogo cartela = Cartela.gerarCartelaJogo(qtdLinhas, qtdColunas);
            cartela.setEstahEmUso(true);

            cartelas.incluir(cartela);
        }
    }

    public Lista<ICartelaJogo> getCartelas(SituacaoCartela situacaoCartela) throws Exception {
        Lista<ICartelaJogo> cartelasResultado = new ListaEnc<>();

        for (int i = 0; i < cartelas.getTamanho(); i++) {
            ICartelaJogo cartela = cartelas.get(i);

            if (situacaoCartela == SituacaoCartela.Valida && !cartela.estahEmUso()) continue;
            else if (situacaoCartela == SituacaoCartela.Cancelada && cartela.estahEmUso()) continue;

            cartelasResultado.incluir(cartela);
        }

        return cartelasResultado;
    }
    public Lista<ICartelaJogo> getCartelasVencedoras(boolean verificarPorLinha) throws Exception {
        Lista<ICartelaJogo> cartelasVencedoras = new ListaEnc<>();

        for (int i = 0; i < cartelas.getTamanho(); i++) {
            ICartelaJogo cartela = cartelas.get(i);

            if (cartela.ehCartelaVencedora(verificarPorLinha)) cartelasVencedoras.incluir(cartela);
        }

        return cartelasVencedoras;
    }

    /**
     * Realiza o sorteio de um número e marca na cartela o número sorteado;
     * @return
     */
    public int SortearNumero() throws Exception {
        int numero = new Random().nextInt(60) + 1;

        for (int i = 0; i < cartelas.getTamanho(); i++)
            cartelas.get(i).marcarNumeroSorteado(numero);

        return numero;
    }

    /**
     * Limpa o número sorteado da cartela em questão
     * @param cartela
     * @throws Exception
     */
    public void LimparNumerosSorteados(ICartelaJogo cartela) throws Exception {
        cartela.desmarcarTodosOsNumeros();
        cartela.setEstahEmUso(true);
    }

    /**
     * Limpa todos os números marcados em todas as cartelas para permitir realizar o bingo com um novo
     * prêmio;
     * @throws Exception
     */
    public void LimparNumerosSorteados() throws Exception {
        for (int i = 0 ; i < cartelas.getTamanho(); i++)
            LimparNumerosSorteados(cartelas.get(i));
    }
    public void RemoverCartelaDoBingo(ICartelaJogo cartela) throws Exception {
        int pos = cartelas.getPosElemento(cartela);

        cartelas.get(pos).setEstahEmUso(false);
    }
    public int obterQuantidadeDeCartelas(SituacaoCartela situacaoCartela) throws Exception {
        return getCartelas(situacaoCartela).getTamanho();
    }
}
