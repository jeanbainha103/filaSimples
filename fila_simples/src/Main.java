public class Main {
    public static void main(String[] args) {
        Leitura leitura = Leitor.lerValores();
        Simulador sim = new Simulador(
                leitura.getNumeroServidores(),
                leitura.getNumeroFila(),
                leitura.getChegadaMinima(),
                leitura.getChegadaMaxima(),
                leitura.getSaidaMinima(),
                leitura.getSaidaMaxima()
        );

        sim.importarNumberos(geraNum(leitura.getTamanho()));
        sim.executa();
    }

    private static float[] geraNum(int tamanho) {
        float[] calc = new float[tamanho];
        float[] num = new float[tamanho];

        calc[0] = (253 * 42 + 82) % 237;
        num[0] = calc[0] / 237;

        for (int i = 1; i < tamanho; i++) {
            calc[i] = (253 * calc[i - 1] + 82) % 237;
            num[i] = calc[i] / 237;
        }

        return num;
    }
}
