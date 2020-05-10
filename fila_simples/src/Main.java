

public class Main {
    public static void main(String[] args) {
        Fila[] leitura = Leitor.lerValores();
        Simulador sim = new Simulador(leitura);

       sim.importarNumberos(geraNum(100000));
       sim.executa();
        System.out.println();
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
