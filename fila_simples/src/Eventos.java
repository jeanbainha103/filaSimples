public class Eventos {
    public enum tipos {
        c, s;
    }
    private tipos tipo;
    private float tempo;
    public Eventos (tipos tipo, float tempo){
        this.tipo = tipo;
        this.tempo = tempo;
    }
}
