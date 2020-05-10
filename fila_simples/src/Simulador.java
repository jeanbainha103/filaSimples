import java.util.ArrayList;
import java.util.List;

public class Simulador {
    ArrayList<Eventos> listaEventos;
    private float[] aleatorios;
    private int countAleatorio;
    private float tempoExecucao;
    private boolean[] filaInicial;
    Fila[] filas;
    private int perdas;


    public Simulador(Fila[] filas) {
        this.filas = filas;
        filaInicial = new boolean[filas.length];
        for (int i = 0; i < filas.length; i++) {
            filas[i].setEstadoAtual(0);
            if (filas[i].getChegadaMinima() > 0)
                filaInicial[i] = true;


        }
        listaEventos = new ArrayList<>();
    }

    public void atualizaEstados(float tempo) {
        for (Fila f : filas) {
            try {
                f.atualisaEstado(f.getEstadoAtual(), tempo - tempoExecucao);
            } catch (Exception e) {
                f.addEstado(tempo - tempoExecucao);
            }
        }
    }

    public void chegada(float tempo) {
        for (int i = 0; i < filaInicial.length; i++) {
            if (filaInicial[i]) {
                atualizaEstados(tempo);
                tempoExecucao = tempo;
                if (filas[i].getTamanhoFila() == -1 || filas[i].getEstadoAtual() < filas[i].getTamanhoFila()) {
                    filas[i].setEstadoAtual(filas[i].getEstadoAtual() + 1);
                    if (filas[i].getEstadoAtual() <= filas[i].getNumeroServidores()) {
                        listaEventos.add(new Eventos(Eventos.tipos.saida,
                                filas[i].getIdFila(),
                                tempoExecucao + ((filas[i].getSaidaMaxima() - filas[i].getSaidaminima() * aleatorios[countAleatorio] + filas[i].getSaidaminima()))));
                        countAleatorio++;
                    }
                }
                listaEventos.add(new Eventos(Eventos.tipos.chegada,
                        filas[i].getIdFila(),
                        tempoExecucao + ((filas[i].getChegadaMaxima() - filas[i].getChegadaMinima()) * aleatorios[0] + filas[i].getChegadaMinima())));
            }
        }
    }

    public void chegada(float tempo, int fila) {
        atualizaEstados(tempo);
        tempoExecucao = tempo;
        if (filas[fila - 1].getTamanhoFila() == -1 || filas[fila - 1].getEstadoAtual() < filas[fila - 1].getTamanhoFila()) {
            filas[fila - 1].setEstadoAtual(filas[fila - 1].getEstadoAtual() + 1);
            if (filas[fila - 1].getEstadoAtual() <= filas[fila - 1].getNumeroServidores()) {
                listaEventos.add(new Eventos(Eventos.tipos.saida,
                        filas[fila - 1].getIdFila(),
                        tempoExecucao + ((filas[fila - 1].getSaidaMaxima() - filas[fila - 1].getSaidaminima() * aleatorios[countAleatorio] + filas[fila - 1].getSaidaminima()))));
                countAleatorio++;
            }
        } else {
            perdas++;
        }
        listaEventos.add(new Eventos(Eventos.tipos.chegada,
                filas[fila - 1].getIdFila(),
                tempoExecucao + ((filas[fila - 1].getChegadaMaxima() - filas[fila - 1].getChegadaMinima()) * aleatorios[0] + filas[fila - 1].getChegadaMinima())));
    }

    private void saida(float tempo, int fila) {
        atualizaEstados(tempo);
        tempoExecucao = tempo;
        int saida = calculaProb(fila - 1);
        if (saida == 0) {
            countAleatorio++;
            filas[fila - 1].setEstadoAtual(filas[fila - 1].getEstadoAtual() - 1);
            if (countAleatorio < aleatorios.length) {
                if (filas[fila - 1].getEstadoAtual() >= filas[fila - 1].getNumeroServidores()) {
                    listaEventos.add(new Eventos(Eventos.tipos.saida, fila,
                            tempoExecucao + ((filas[fila - 1].getSaidaMaxima() - filas[fila - 1].getSaidaminima()) * aleatorios[countAleatorio] + filas[fila - 1].getSaidaminima())));
                    countAleatorio++;
                }
            }
        } else if (filas[saida - 1].getEstadoAtual() < filas[saida - 1].getTamanhoFila()) {
            countAleatorio++;
            if (countAleatorio < aleatorios.length) {
                filas[fila - 1].setEstadoAtual(filas[fila - 1].getEstadoAtual() - 1);
                filas[saida - 1].setEstadoAtual(filas[saida - 1].getEstadoAtual() + 1);
                if (filas[fila - 1].getEstadoAtual() >= filas[fila - 1].getNumeroServidores()) {
                    listaEventos.add(new Eventos(Eventos.tipos.saida, fila,
                            tempoExecucao + ((filas[fila - 1].getSaidaMaxima() - filas[fila - 1].getSaidaminima()) * aleatorios[countAleatorio] + filas[fila - 1].getSaidaminima())));
                    countAleatorio++;
                }
                if (filas[saida - 1].getEstadoAtual() <= filas[saida - 1].getNumeroServidores()) {
                    listaEventos.add(new Eventos(Eventos.tipos.saida, saida,
                            tempoExecucao + ((filas[saida - 1].getSaidaMaxima() - filas[saida - 1].getSaidaminima()) * aleatorios[countAleatorio] + filas[saida - 1].getSaidaminima())));
                    countAleatorio++;
                }
            }
        } else {
            listaEventos.add(new Eventos(Eventos.tipos.saida, fila,
                    tempoExecucao + ((filas[fila - 1].getSaidaMaxima() - filas[fila - 1].getSaidaminima()) * aleatorios[countAleatorio] + filas[fila - 1].getSaidaminima())));
            countAleatorio++;
        }
    }

    private int calculaProb(int fila) {
        List<Float> prob = filas[fila].getProbalidade();
        float proabilidadeAcumulada = 0;
        for (int i = 0; i < prob.size(); i++) {
            proabilidadeAcumulada = proabilidadeAcumulada + prob.get(i);
            if (aleatorios[countAleatorio] < proabilidadeAcumulada) {
                return filas[fila].getSaidas().get(i);
            }
        }
        return 0;
    }

    public void executa() {
        listaEventos.add(new Eventos(Eventos.tipos.chegadaInicial, 1, 1));
        for (countAleatorio = 0; countAleatorio < aleatorios.length; countAleatorio++) {
            Eventos e = pegaProximoEvento();
            if (e != null) {
                if (e.getTipo() == Eventos.tipos.chegadaInicial) {
                    chegada(e.getTempo());
                } else if (e.getTipo() == Eventos.tipos.chegada) {
                    chegada(e.getTempo(), e.getFila());
                } else if (e.getTipo() == Eventos.tipos.saida) {
                    saida(e.getTempo(), e.getFila());
                }
                System.out.println("-------------------------------------------------------------------------------------");
                System.out.println(e.getTipo() + " - " + e.getTempo());
                for (Fila f : filas) {
                    System.out.println("Fila - " + f.getIdFila());
                    System.out.println("Estdo atual - " + f.getEstadoAtual());
                    System.out.println("Estados - " + f.getEstados().toString());
                    System.out.println("Perdas - " + perdas + " clientes");
                }
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

    public void importarNumberos(float[] numeros) {
        this.aleatorios = numeros;
    }
}
