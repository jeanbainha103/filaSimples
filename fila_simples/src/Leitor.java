

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import static java.util.Arrays.stream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Leitor {

    public static Leitura lerValores() {
        Leitura leitura = new Leitura();

        File file = new File("dadosEntrada.txt");

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(file));

            String[] linhaPercorrida = reader.readLine().split("");
            leitura.setNumeroFilas(parseInt(linhaPercorrida[0]));

            linhaPercorrida = reader.readLine().split(" ");
            leitura.setCapacidadeFila(toIntegerList(linhaPercorrida));

            linhaPercorrida = reader.readLine().split(" ");
            leitura.setNumeroServidores(toIntegerList(linhaPercorrida));

            linhaPercorrida = reader.readLine().split(" ");
            leitura.setChegadaMinima(toFloatList(linhaPercorrida));

            linhaPercorrida = reader.readLine().split(" ");
            leitura.setChegadaMaxima(toFloatList(linhaPercorrida));

            linhaPercorrida = reader.readLine().split(" ");
            leitura.setSaidaMinima(toFloatList(linhaPercorrida));

            linhaPercorrida = reader.readLine().split(" ");
            leitura.setSaidaMaxima(toFloatList(linhaPercorrida));

//            linhaPercorrida = reader.readLine().split(" ");
//            leitura.setSaidaFila(toIntegerList(linhaPercorrida));

            for (int i = 0; i < leitura.getNumeroFilas(); i++) {
                linhaPercorrida = reader.readLine().split(" ");
                leitura.setSaidaFila(toIntegerList(linhaPercorrida));
            }

        } catch (IOException e) {
            System.out.println("Arquivo não encontrado ou formato inválido!");
            e.printStackTrace();
        }


        return leitura;
    }

    private static List<Integer> toIntegerList(String[] linhaPercorrida) {
        List<Integer> lista = new ArrayList<>();
        stream(linhaPercorrida)
                .forEach(linha -> lista.add(parseInt(linha)));
        return lista;
    }

    private static List<Float> toFloatList(String[] linhaPercorrida) {
        List<Float> lista = new ArrayList<>();
        stream(linhaPercorrida)
                .forEach(linha -> lista.add(parseFloat(linha)));
        return lista;
    }

}
