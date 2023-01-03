package EntrturaDeDados;

public interface IFilaAvaliacao<T> extends IFila<T>  {
    public boolean saoIguais(IFila<T> fila1, IFila<T> fila2);
}