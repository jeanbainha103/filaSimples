import java.util.List;

public class Leitura {

    private int numeroFilas;
    private List<Integer> capacidadeFila;
    private List<Integer>  numeroServidores;
    private List<Float>  chegadaMinima;
    private List<Float> chegadaMaxima;
    private List<Float> saidaMinima;
    private List<Float> saidaMaxima;
    private List<List<Integer>>  saidaFila;

    public int getNumeroFilas() {
        return numeroFilas;
    }

    public void setNumeroFilas(int numeroFilas) {
        this.numeroFilas = numeroFilas;
    }

    public List<Integer> getCapacidadeFila() {
        return capacidadeFila;
    }

    public void setCapacidadeFila(List<Integer> capacidadeFila) {
        this.capacidadeFila = capacidadeFila;
    }

    public List<Integer> getNumeroServidores() {
        return numeroServidores;
    }

    public void setNumeroServidores(List<Integer> numeroServidores) {
        this.numeroServidores = numeroServidores;
    }

    public List<Float> getChegadaMinima() {
        return chegadaMinima;
    }

    public void setChegadaMinima(List<Float> chegadaMinima) {
        this.chegadaMinima = chegadaMinima;
    }

    public List<Float> getChegadaMaxima() {
        return chegadaMaxima;
    }

    public void setChegadaMaxima(List<Float> chegadaMaxima) {
        this.chegadaMaxima = chegadaMaxima;
    }

    public List<Float> getSaidaMinima() {
        return saidaMinima;
    }

    public void setSaidaMinima(List<Float> saidaMinima) {
        this.saidaMinima = saidaMinima;
    }

    public List<Float> getSaidaMaxima() {
        return saidaMaxima;
    }

    public void setSaidaMaxima(List<Float> saidaMaxima) {
        this.saidaMaxima = saidaMaxima;
    }

    public List<List<Integer>> getSaidaFila() {
        return saidaFila;
    }

    public void setSaidaFila(List<Integer> saidaFila) {
        this.saidaFila.add( saidaFila);
    }
}
