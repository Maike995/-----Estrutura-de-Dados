package br.edu.ifs.AV1;

import br.edu.ifs.ED.lista.Lista;
import br.edu.ifs.ED.lista.ListaEnc;
import br.edu.ifs.ED.lista.ListaEncOrdenada;
import br.edu.ifs.ED.lista.ListaEncOrdenadaInteiro;

import java.util.Date;
import java.util.Random;


public class Cartela implements ICartelaJogo{
    protected Lista<Lista<NumeroCartela>> dados;

    protected Integer identificador = 0;

    protected Date dataGeracao;

    protected static int idsGerados = 0;

    protected boolean estahEmUso = false;

    protected final int n;

    protected final int m;

    /**
     * Cria a cartela com os números conforme a matriz N x M.
     * Um número identificador (geralmente um sequencial) deverá ser informado.
     * @param n
     * @param m
     * @param identificador
     * @throws Exception
     */
    public Cartela(int n, int m, int identificador) throws Exception {
        if (n <= 0 || m <= 0) throw new Exception("Dimensões inválidas");

        this.n = n;
        this.m = m;
        dados = new ListaEnc<>();
        this.identificador = identificador;
        dataGeracao = new Date();

        Random random = new Random();

        for (int i = 0; i < n; i++) {
            ListaEncOrdenada<NumeroCartela> linha = new ListaEncOrdenada<>();

            for (int j = 0; j < m; j++) {
                linha.incluirEmOrdem(new NumeroCartela(random.nextInt(60) + 1));
            }

            dados.incluir(linha);
        }
    }

    public Cartela(int tamanhoMatriz, int identificador) throws Exception {
        this(tamanhoMatriz, tamanhoMatriz, identificador);
    }

    public static ICartelaJogo gerarCartelaJogo(int n, int m) throws Exception {
        return new Cartela(n, m, ++idsGerados);
    }

    public Integer getIdentificador() {
        return identificador;
    }

    public Date getDataGeracao() {
        return dataGeracao;
    }

    @Override
    public boolean estahEmUso() {
        return estahEmUso;
    }

    @Override
    public void setEstahEmUso(boolean estahEmUso) {
        this.estahEmUso = estahEmUso;
    }

    @Override
    public int[][] getDados() throws Exception {
        int[][] valores = new int[n][m];

        for (int i = 0; i < n; i++) {
            Lista<NumeroCartela> linha = dados.get(i);

            for (int j = 0; j < m; j++) {
                valores[i][j] = linha.get(j).getNumero();
            }
        }

        return valores;
    }

    @Override
    public void desmarcarTodosOsNumeros() throws Exception {
        for (int i = 0; i < n; i++) {
            ListaEncOrdenada<NumeroCartela> linha = (ListaEncOrdenada<NumeroCartela>) dados.get(i);

            for (int j = 0; j < m; j++) {
                linha.get(j).setSorteado(false);
            }
        }
    }

    /**
     * Procura se o número está na cartela e o marca como sorteado.
     * @param numero número que acabou de ser sorteado e que deve ser marcado na cartela
     * @throws Exception
     */
    @Override
    public void marcarNumeroSorteado(int numero) throws Exception {
        NumeroCartela numeroCartela = new NumeroCartela(numero);

        for (int i = 0; i < n; i++) {
            ListaEncOrdenada<NumeroCartela> linha = (ListaEncOrdenada<NumeroCartela>) dados.get(i);

            while (true) {
                try {
                    int pos = linha.getPosElemento(numeroCartela);
                    linha.get(pos).setSorteado(true);
                } catch (Exception e) {
                    if (!e.getMessage().equals("Elemento solicitado não existe na lista")) throw e;
                    else break;
                }
            }
        }
    }

    /**
     * Identifica se a cartela é vencedora conforme o parâmetro @verificarPorLinha
     * @param verificarPorLinha caso verdadeiro (@true) o programa deverá verificar
       por linha (horizontal). Caso seja falso (@false) deverá verificar se todos os números
       foram sorteados.
     * @return
     * @throws Exception
     */
    @Override
    public boolean ehCartelaVencedora(boolean verificarPorLinha) throws Exception {
        if (!estahEmUso) return false;

        boolean linhaVencedora = true;

        for (int i = 0; i < n; i++) {
            ListaEncOrdenada<NumeroCartela> linha = (ListaEncOrdenada<NumeroCartela>) dados.get(i);
            linhaVencedora = true;

            for (int j = 0; j < m; j++) {
                if (!linha.get(j).isSorteado()) {
                    if (verificarPorLinha) {
                        linhaVencedora = false;
                        break;
                    }
                    else {
                        return false;
                    }
                }
            }

            if (verificarPorLinha && linhaVencedora) {
                return true;
            }
        }

        return linhaVencedora;
    }

    /**
     * Retorna uma lista encadeada ordenada com os números da cartela.
     * Poderão existir números duplicados
     * @return
     */
    @Override
    public ListaEncOrdenada<Integer> getNumerosNaoSorteados() {
        ListaEncOrdenadaInteiro numerosNaoSorteados = new ListaEncOrdenadaInteiro();
        Lista<NumeroCartela> linha;

        for (int i = 0; i < n; i++) {
            try {
                linha = dados.get(i);

                for (int j = 0; j < m; j++) {
                    NumeroCartela numero = linha.get(j);

                    if (!numero.isSorteado() && !numerosNaoSorteados.contem(numero.getNumero()))
                        numerosNaoSorteados.incluirEmOrdem(numero.getNumero());
                }
            } catch (Exception e) { }
        }

        return numerosNaoSorteados;
    }

    /**
     * Deverá observar se os números das duas cartelas são iguais por linha.
     * @param iCartelaJogo
     * @return
     */
    @Override
    public int compareTo(ICartelaJogo iCartelaJogo) {
        try {
            int[][] valores = iCartelaJogo.getDados();

            if (n != valores.length || m != valores[0].length) return -1;

            for (int i = 0; i < n; i++) {
                ListaEncOrdenada<NumeroCartela> linha = (ListaEncOrdenada<NumeroCartela>) dados.get(i);
                ListaEncOrdenada<Integer> outraLinha = new ListaEncOrdenada<>();

                for (int j = 0; j < m; j++) {
                    outraLinha.incluirEmOrdem(valores[i][j]);
                }

                for (int j = 0; j < m; j++) {
                    if (linha.get(j).getNumero() != outraLinha.get(j)) return -1;
                }
            }

            return 0;
        } catch (Exception e) {
            return -1;
        }
    }

    @Override
    public boolean equals(Object outro) {
        if (this == outro) return true;

        if (!(outro instanceof ICartelaJogo)) return false;

        ICartelaJogo outraCartela = (ICartelaJogo) outro;

        return compareTo(outraCartela) == 0;
    }
}
