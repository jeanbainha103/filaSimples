import java.util.ArrayList;
import java.util.List;

public class Fila {
    private int idFila;
    private int tamanhoFila;
    private int numeroServidores;
    private List<Float> probalidade;
    private Float chegadaMinima;
    private Float chegadaMaxima;
    private Float saidaminima;
    private Float saidaMaxima;
    private ArrayList<Float> estados;
    private int estadoAtual;
    private ArrayList<Integer> saidas;

    public void setEstadoAtual(int estadoAtual) {
        this.estadoAtual = estadoAtual;
    }

    public int getEstadoAtual() {
        return estadoAtual;
    }

    public Fila() {
        estados = new ArrayList<>();
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

    public Float getChegadaMinima() {
        return chegadaMinima;
    }

    public void setChegadaMinima(Float chegadaMinima) {
        this.chegadaMinima = chegadaMinima;
    }

    public Float getChegadaMaxima() {
        return chegadaMaxima;
    }

    public void setChegadaMaxima(Float chegadaMaxima) {
        this.chegadaMaxima = chegadaMaxima;
    }

    public Float getSaidaminima() {
        return saidaminima;
    }

    public void setSaidaminima(Float saidaminima) {
        this.saidaminima = saidaminima;
    }

    public Float getSaidaMaxima() {
        return saidaMaxima;
    }

    public void setSaidaMaxima(Float saidaMaxima) {
        this.saidaMaxima = saidaMaxima;
    }

    public List<Float> getEstados() {
        return estados;
    }

    public void setEstados(ArrayList<Float> estados) {
        this.estados = estados;
    }

    public void addEstado(float valor) {
        this.estados.add(valor);
    }

    public void atualisaEstado(int id, float valor) {
        this.estados.set(id,this.estados.get(id) + valor);
    }

    public List<Integer> getSaidas() {
        return saidas;
    }

    public void setSaidas(ArrayList<Integer> saidas) {
        this.saidas = saidas;
    }

    public List<Float> getProbalidade() {
        return probalidade;
    }

    public void setProbalidade(List<Float> probalidade) {
        this.probalidade = probalidade;
    }

}
