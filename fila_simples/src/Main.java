public class Main {
    public static void main(String args[]) {
        int nServidor = 1;
        int tFila = 3;
        float chegadaMin = 1;
        float chegadaMax = 3;
        float saidaMin = 2;
        float saidaMax = 6;
        Simulador sim = new Simulador(nServidor, tFila, chegadaMin, chegadaMax, saidaMin, saidaMax);
        sim.importNumbers(geraNum(10));
        //sim.executa();
    }

    private static float[] geraNum(int tamanho) {
        float[] calc = new float[tamanho];
        float[] num = new float[tamanho];

        calc[0] = (253*42+82)%237;
        num[0] = calc[0]/237;

        for (int i = 1; i<tamanho; i++) {
            calc[i] = (253*calc[i-1]+82)%237;
            num[i] = calc[i]/237;
        }

        return num;
    }
}
