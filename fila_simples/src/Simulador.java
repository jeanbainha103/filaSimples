import java.util.ArrayList;
import java.util.Random;

public class Simulador {

    //private String mode1;
    //private String mode2;
    private int nServidor;
    private int tFila;
    private float chegadaMin;
    private float chegadaMax;
    private float saidaMin;
    private float saidaMax;
    private int [] estadosFila;
    ArrayList<Eventos> listaEventos;
    Random r = new Random();
    private float[] aleatorios;

    public Simulador(int s, int f, float cmin, float cmax, float smin, float smax) {
        //mode1 = args[0];
        //mode2 = args[1];
        nServidor = s;
        tFila = f;
        chegadaMin = cmin;
        chegadaMax = cmax;
        saidaMin = smin;
        saidaMax = smax;
        estadosFila = new int[tFila + 1];
        listaEventos = new ArrayList<>();
    }

    public void executa(){
        listaEventos.add(new Eventos(Eventos.tipos.c, 1));

    }

    private static void chegada() {
        /*
        contabiliza tempo

        se fila <3
            fila ++
            se fila<=nServidores
                agenda saida(T+rand(saidmin..saidmax)
        agenda chegada
         */
    }

    private static void saida() {
        /*
        contabiliza tempo
        fila--
        se fila>0
            agenda saida(T+rnd(saidamin..saidmax
         */
    }

    public void importNumbers(float[] importa) {
        this.aleatorios = importa;
    }
}
