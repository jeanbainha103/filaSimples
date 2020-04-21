

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

public class Simulador {
    private int nServidor1;
    private int tamanhoFila1;
    private float chegadaMin;
    private float chegadaMax;
    private float saidaMin;
    private float saidaMax;
    private int nServidor2;
    private int tamanhoFila2;
    private float saidaFinalMin;
    private float saidaFinalMax;
    private float[][] estadosFila;
    ArrayList<Eventos> listaEventos;
    Random r = new Random();
    private float[] aleatorios;
    private float tempoExecucao;
    private int filaAtual1;
    private int filaAtual2;

    public Simulador(int s1, int f1, float cmin, float cmax, float smin, float smax, int s2, int f2, float sfmin, float sfmax) {
        nServidor1 = s1;
        tamanhoFila1 = f1;
        chegadaMin = cmin;
        chegadaMax = cmax;
        saidaMin = smin;
        saidaMax = smax;
        nServidor2 = s2;
        tamanhoFila2 = f2;
        saidaFinalMin = sfmin;
        saidaFinalMax = sfmax;
        estadosFila = new float[tamanhoFila1 + 1][tamanhoFila2 + 1];
        listaEventos = new ArrayList<>();
        filaAtual1 = 0;
        filaAtual2= 0;
    }

    public void executa() {
        listaEventos.add(new Eventos(Eventos.tipos.chegada, 3));
        for (float aleatorio : aleatorios) {
            Eventos e = pegaProximoEvento();
            if (e != null) {
                if (e.getTipo() == Eventos.tipos.chegada) {
                    chegada(e.getTempo(), aleatorio);
                } else if (e.getTipo() == Eventos.tipos.saidaInterna) {
                    saidaInterna(e.getTempo(), aleatorio);
                } else if (e.getTipo() == Eventos.tipos.saidaFinal) {
                    saidaFinal(e.getTempo(), aleatorio);
                }
                System.out.println(e.getTipo() + " - " + e.getTempo());
                System.out.println("fila1 - " + filaAtual1);
                System.out.println("fila2 - " + filaAtual2);
            }
        }
        for (int i = 0; i<estadosFila.length; i++) {
            for (int j = 0; j<estadosFila[i].length; j++) {
                System.out.println("Estado: [" + i + "," + j + "] " + String.format("%f", (estadosFila[i][j] / tempoExecucao)));
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
        estadosFila[filaAtual1][filaAtual2] = estadosFila[filaAtual1][filaAtual2] + tempo - tempoExecucao;
        tempoExecucao = tempo;
        if (filaAtual1 < tamanhoFila1) {
            filaAtual1++;
            if (filaAtual1 <= nServidor1) {
                listaEventos.add(new Eventos(Eventos.tipos.saidaInterna, tempoExecucao + ((saidaMax - saidaMin) * aleatorio + saidaMin)));
            }
        }
        listaEventos.add(new Eventos(Eventos.tipos.chegada, tempoExecucao + ((chegadaMax - chegadaMin) * aleatorio + chegadaMin)));
    }

    private void saidaInterna(float tempo, float aleatorio) {
        estadosFila[filaAtual1][filaAtual2] = estadosFila[filaAtual1][filaAtual2] + tempo - tempoExecucao;
        tempoExecucao = tempo;
        if (filaAtual2 < tamanhoFila2) {
            filaAtual1--;
            filaAtual2++;
            if (filaAtual1 >= nServidor1) {
                listaEventos.add(new Eventos(Eventos.tipos.saidaInterna, tempoExecucao + ((saidaMax - saidaMin) * aleatorio + saidaMin)));
            }
            if (filaAtual2 <= nServidor2) {
                listaEventos.add(new Eventos(Eventos.tipos.saidaFinal, tempoExecucao + ((saidaFinalMax - saidaFinalMin) * aleatorio + saidaFinalMin)));
            }
        } else {
            listaEventos.add(new Eventos(Eventos.tipos.saidaInterna, tempoExecucao + ((saidaMax - saidaMin) * aleatorio + saidaMin)));
        }

    }

    private void saidaFinal(float tempo, float aleatorio) {
        estadosFila[filaAtual1][filaAtual2] = estadosFila[filaAtual1][filaAtual2] + tempo - tempoExecucao;
        tempoExecucao = tempo;
        filaAtual2--;
        if (filaAtual2 >= nServidor2) {
            listaEventos.add(new Eventos(Eventos.tipos.saidaFinal, tempoExecucao + ((saidaFinalMax - saidaFinalMin) * aleatorio + saidaFinalMin)));
        }
    }

    public void importarNumberos(float[] numeros) {
        this.aleatorios = numeros;
    }
}
