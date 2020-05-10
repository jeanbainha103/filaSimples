
public class Eventos {
    public enum tipos {
        chegada, chegadaInicial, saida, saidaFinal
    }
    private tipos tipo;
    private int fila;
    private float tempo;
    public Eventos (tipos tipo, int fila, float tempo){
        this.tipo = tipo;
        this.fila = fila;
        this.tempo = tempo;
    }

    public float getTempo() {
        return tempo;
    }

    public tipos getTipo() {
        return tipo;
    }

    public int getFila() {
        return fila;
    }
}
