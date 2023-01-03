package EntrturaDeDados;

import Execoes.FilaCheiaException;
import Execoes.FilaVaziaException;

public interface IFila <T>{
    public void incluir(T valor) throws FilaCheiaException;
    public T remover() throws FilaVaziaException;
    public boolean estaVazia();
    public void limpar();
    public T visualizarProximo() throws FilaVaziaException;
}