public class Eventos {
    public enum tipos {
        chegada, saida;
    }
    private tipos tipo;
    private float tempo;
    public Eventos (tipos tipo, float tempo){
        this.tipo = tipo;
        this.tempo = tempo;
    }

    public float getTempo() {
        return tempo;
    }

    public tipos getTipo() {
        return tipo;
    }
}
