import java.util.List;

public class Fila {
    private int idFila;
    private int tamanhoFila;
    private int numeroServidores;
    private int probalidade;
    private long chegadaMinima;
    private long chegadaMaxima;
    private long saidaminima;
    private long saidaMaxima;
    private List<Float> estados;
    private List<Fila> saidas;

    public Fila(int idFila, int tamanhoFila, int numeroServidores, int probalidade,
                long chegadaMinima, long chegadaMaxima, long saidaminima, long saidaMaxima,
                List<Float> estados, List<Fila> saidas) {
        this.idFila = idFila;
        this.tamanhoFila = tamanhoFila;
        this.numeroServidores = numeroServidores;
        this.probalidade = probalidade;
        this.chegadaMinima = chegadaMinima;
        this.chegadaMaxima = chegadaMaxima;
        this.saidaminima = saidaminima;
        this.saidaMaxima = saidaMaxima;
        this.estados = estados;
        this.saidas = saidas;
    }

    public int getIdFila() {
        return idFila;
    }

    public void setIdFila(int idFila) {
        this.idFila = idFila;
    }

    public int getTamanhoFila() {
        return tamanhoFila;
    }

    public void setTamanhoFila(int tamanhoFila) {
        this.tamanhoFila = tamanhoFila;
    }

    public int getNumeroServidores() {
        return numeroServidores;
    }

    public void setNumeroServidores(int numeroServidores) {
        this.numeroServidores = numeroServidores;
    }

    public int getProbalidade() {
        return probalidade;
    }

    public void setProbalidade(int probalidade) {
        this.probalidade = probalidade;
    }

    public long getChegadaMinima() {
        return chegadaMinima;
    }

    public void setChegadaMinima(long chegadaMinima) {
        this.chegadaMinima = chegadaMinima;
    }

    public long getChegadaMaxima() {
        return chegadaMaxima;
    }

    public void setChegadaMaxima(long chegadaMaxima) {
        this.chegadaMaxima = chegadaMaxima;
    }

    public long getSaidaminima() {
        return saidaminima;
    }

    public void setSaidaminima(long saidaminima) {
        this.saidaminima = saidaminima;
    }

    public long getSaidaMaxima() {
        return saidaMaxima;
    }

    public void setSaidaMaxima(long saidaMaxima) {
        this.saidaMaxima = saidaMaxima;
    }

    public List<Float> getEstados() {
        return estados;
    }

    public void setEstados(List<Float> estados) {
        this.estados = estados;
    }

    public List<Fila> getSaidas() {
        return saidas;
    }

    public void setSaidas(List<Fila> saidas) {
        this.saidas = saidas;
    }
}
