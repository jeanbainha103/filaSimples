package com.jeanbainha;

public class Main {
    public static void main(String[] args) {
        Leitura leitura = Leitor.lerValores();
        Simulador sim = new Simulador(
                leitura.getNumeroServidores(),
                leitura.getNumeroFila(),
                leitura.getChegadaMinima(),
                leitura.getChegadaMaxima(),
                leitura.getSaidaMinima(),
                leitura.getSaidaMaxima(),
                leitura.getNumeroServidores2(),
                leitura.getNumeroFila2(),
                leitura.getSaidaFinalMinima(),
                leitura.getSaidaFinalMaxima()
        );

        sim.importarNumberos(geraNum(leitura.getTamanho()));
        sim.executa();
    }

    private static float[] geraNum(int tamanho) {
        float[] calc = new float[tamanho];
        float[] num = new float[tamanho];

        calc[0] = (253 * 42 + 82) % 214748364;
        num[0] = calc[0] / 214748364;

        for (int i = 1; i < tamanho; i++) {
            calc[i] = (253 * calc[i - 1] + 82) % 214748364;
            num[i] = calc[i] / 214748364;
        }

        return num;
    }
}
