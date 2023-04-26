import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ArvoreBinInteiro implements Serializable {
    private NoArvoreBinInteiro raiz;

    public ArvoreBinInteiro() {
        this.raiz = null;
    }

    // 1. Inserir um número
    public void inserir(int valor) {
        NoArvoreBinInteiro novoNo = new NoArvoreBinInteiro(valor);
        if (this.raiz == null) {
            this.raiz = novoNo;
        } else {
            NoArvoreBinInteiro atual = this.raiz;
            while (true) {
                if (valor < atual.valor) {
                    if (atual.esquerda == null) {
                        atual.esquerda = novoNo;
                        break;
                    } else {
                        atual = atual.esquerda;
                    }
                } else {
                    if (atual.direita == null) {
                        atual.direita = novoNo;
                        break;
                    } else {
                        atual = atual.direita;
                    }
                }
            }
        }
    }

    // 2. Retornar o maior número
    public int maiorValor() {
        NoArvoreBinInteiro atual = this.raiz;
        while (atual.direita != null) {
            atual = atual.direita;
        }
        return atual.valor;
    }

    // 3. Retornar o menor número
    public int menorValor() {
        NoArvoreBinInteiro atual = this.raiz;
        while (atual.esquerda != null) {
            atual = atual.esquerda;
        }
        return atual.valor;
    }

    // 4. Retornar a altura da árvore
    public int altura() {
        return altura(this.raiz);
    }

    private int altura(NoArvoreBinInteiro no) {
        if (no == null) {
            return 0;
        } else {
            int alturaEsquerda = altura(no.esquerda);
            int alturaDireita = altura(no.direita);
            return 1 + Math.max(alturaEsquerda, alturaDireita);
        }
    }

    // 5. Listar números (percurso Pré-Ordem)
    public void listarPreOrdem() {
        listarPreOrdem(this.raiz);
    }

    private void listarPreOrdem(NoArvoreBinInteiro no) {
        if (no != null) {
            System.out.println(no.valor);
            listarPreOrdem(no.esquerda);
            listarPreOrdem(no.direita);
        }
    }

    // 6. Listar números (percurso Pós-Ordem)
    public void listarPosOrdem() {
        listarPosOrdem(this.raiz);
    }

    private void listarPosOrdem(NoArvoreBinInteiro no) {
        if (no != null) {
            listarPosOrdem(no.esquerda);
            listarPosOrdem(no.direita);
            System.out.println(no.valor);
        }
    }

    // 7. Listar números (percurso Simétrico)
    public void listarSimetrica() {
        listarSimetrica(this.raiz);
    }

    private void listarSimetrica(NoArvoreBinInteiro no) {
        if (no != null) {
            listarSimetrica(no.esquerda);
            System.out.println(no.valor);
            listarSimetrica(no.direita);
        }
    }

    public void listarNiveis() {
    if (this.raiz == null) {
        return;
    }

    Queue<NoArvoreBinInteiro> fila = new LinkedList<>();
    fila.offer(this.raiz);

    while (!fila.isEmpty()) {
        int size = fila.size();
        for (int i = 0; i < size; i++) {
            NoArvoreBinInteiro atual = fila.poll();
            System.out.print(atual.valor + " ");
            if (atual.esquerda != null) {
                fila.offer(atual.esquerda);
            }
            if (atual.direita != null) {
                fila.offer(atual.direita);
            }
        }
        System.out.println();
    }
}

    //8. Listar números (percurso em níveis)
    public void listarInternos() {
    listarInternos(this.raiz);
    }

    //9. Listar os números internos
    private void listarInternos(NoArvoreBinInteiro no) {
      if (no == null || (no.esquerda == null && no.direita == null)) {
          return;
      }
    System.out.print(no.valor + " ");
    listarInternos(no.esquerda);
    listarInternos(no.direita);
    }

    //10. Listar as folhas
    public void listarFolhas() {
      listarFolhas(this.raiz);
    }

    private void listarFolhas(NoArvoreBinInteiro no) {
      if (no == null) {
          return;
      }
      if (no.esquerda == null && no.direita == null) {
        System.out.print(no.valor + " ");
      }
    listarFolhas(no.esquerda);
    listarFolhas(no.direita);
    }

    //11. Exibir caminho da raiz a um número
    public List<Integer> caminho(int valor) {
      List<Integer> caminho = new ArrayList<>();
      caminho(this.raiz, valor, caminho);
      return caminho;
    }

    private boolean caminho(NoArvoreBinInteiro no, int valor, List<Integer> caminho) {
      if (no == null) {
          return false;
      }

      caminho.add(no.valor);

      if (no.valor == valor) {
          return true;
      }

      if (caminho(no.esquerda, valor, caminho) || caminho(no.direita, valor, caminho)) {
          return true;
      }

      caminho.remove(caminho.size() - 1);
      return false;
    }

    //12. Retorna raiz
    public int getRaiz() {
      return this.raiz.valor;
    }


    //13. Remover um número
    public void remover(int valor) {
        if (raiz == null) {
            return;
        }

        // Encontra o nó a ser removido
        NoArvoreBinInteiro atual = raiz;
        NoArvoreBinInteiro pai = null;
        while (atual != null) {
            if (atual.valor == valor) {
                break;
            }
            pai = atual;
            if (valor < atual.valor) {
                atual = atual.esquerda;
            } else {
                atual = atual.direita;
            }
        }

        // Se o nó não existe na árvore
        if (atual == null) {
            return;
        }

        // Caso 1: O nó a ser removido não tem filhos
        if (atual.esquerda == null && atual.direita == null) {
            if (pai == null) {
                raiz = null;
            } else if (pai.esquerda == atual) {
                pai.esquerda = null;
            } else {
                pai.direita = null;
            }

        // Caso 2: O nó a ser removido tem apenas um filho
        } else if (atual.esquerda == null) {
            if (pai == null) {
                raiz = atual.direita;
            } else if (pai.esquerda == atual) {
                pai.esquerda = atual.direita;
            } else {
                pai.direita = atual.direita;
            }
        } else if (atual.direita == null) {
            if (pai == null) {
                raiz = atual.esquerda;
            } else if (pai.esquerda == atual) {
                pai.esquerda = atual.esquerda;
            } else {
                pai.direita = atual.esquerda;
            }

        // Caso 3: O nó a ser removido tem dois filhos
        } else {
            NoArvoreBinInteiro sucessor = atual.direita;
            NoArvoreBinInteiro paiSucessor = atual;
            while (sucessor.esquerda != null) {
                paiSucessor = sucessor;
                sucessor = sucessor.esquerda;
            }
            atual.valor = sucessor.valor;
            if (paiSucessor.esquerda == sucessor) {
                paiSucessor.esquerda = sucessor.direita;
            } else {
                paiSucessor.direita = sucessor.direita;
            }
        }
    }

}
    