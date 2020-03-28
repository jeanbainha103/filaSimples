import java.util.ArrayList;
import java.util.Random;

public class Simulador {

    //private String mode1;
    //private String mode2;
    private int nServidor;
    private int tamanhoFila;
    private float chegadaMin;
    private float chegadaMax;
    private float saidaMin;
    private float saidaMax;
    private float [] estadosFila;
    ArrayList<Eventos> listaEventos;
    Random r = new Random();
    private float[] aleatorios;
    private float tempoExecucao;
    private int filaAtual;

    public Simulador(int s, int f, float cmin, float cmax, float smin, float smax) {
        //mode1 = args[0];
        //mode2 = args[1];
        nServidor = s;
        tamanhoFila = f;
        chegadaMin = cmin;
        chegadaMax = cmax;
        saidaMin = smin;
        saidaMax = smax;
        estadosFila = new float[tamanhoFila + 1];
        listaEventos = new ArrayList<>();
        filaAtual = 0;
    }

    public void executa(){
        listaEventos.add(new Eventos(Eventos.tipos.chegada, 3));
        for (int i = 0; i < aleatorios.length; i++) {
            Eventos e = pegaProximoEvento();
            if (e!= null) {
                if (e.getTipo() == Eventos.tipos.chegada) {
                    chegada(e.getTempo(), aleatorios[i]);
                } else if (e.getTipo() == Eventos.tipos.saida) {
                    saida(e.getTempo(), aleatorios[i]);
                }
                System.out.println(e.getTipo() + " - " + e.getTempo());
                System.out.println("fila - " + filaAtual);
            }
        }
        System.out.println(tempoExecucao);
    }

    private Eventos pegaProximoEvento() {
        if (listaEventos.get(0) != null) {
            Eventos menor = listaEventos.get(0);
            for (Eventos e : listaEventos) {
                if (menor.getTempo() > e.getTempo())
                    menor = e;
            }
            listaEventos.remove(menor);
            return menor;
        } else {
            return null;
        }
    }

    private void chegada(float tempo, float aleatorio) {
        estadosFila[filaAtual] = estadosFila[filaAtual] + tempo - tempoExecucao;
        tempoExecucao = tempo;
        if (filaAtual < tamanhoFila) {
            filaAtual++;
            if (filaAtual<= nServidor) {
                listaEventos.add(new Eventos(Eventos.tipos.saida, tempoExecucao + ((saidaMax-saidaMin)*aleatorio+saidaMin)));
            }
        }
        listaEventos.add(new Eventos(Eventos.tipos.chegada, tempoExecucao + ((chegadaMax-chegadaMin)*aleatorio+chegadaMin)));

        /*
        contabiliza tempo

        se fila < tamanho da fila
            fila ++
            se fila<=nServidores
                agenda saida(T+rand(saidmin..saidmax)
        agenda chegada
         */
    }

    private void saida(float tempo, float aleatorio) {
        estadosFila[filaAtual] = estadosFila[filaAtual] + tempo - tempoExecucao;
        tempoExecucao = tempo;
        filaAtual--;
        if (filaAtual>=1) {
            listaEventos.add(new Eventos(Eventos.tipos.saida, tempoExecucao + ((saidaMax-saidaMin)*aleatorio+saidaMin)));
        }
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
