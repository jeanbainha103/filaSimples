import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Leitor {

    public static Leitura lerValores() {
        Leitura leitura = new Leitura();

        File file = new File("dadosEntrada.txt");

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(file));

            String linhaPercorrida = reader.readLine();
            leitura.setNumeroServidores(parseInt(linhaPercorrida));

            linhaPercorrida = reader.readLine();
            leitura.setNumeroFila(parseInt(linhaPercorrida));

            linhaPercorrida = reader.readLine();
            leitura.setChegadaMinima(parseFloat(linhaPercorrida));

            linhaPercorrida = reader.readLine();
            leitura.setChegadaMaxima(parseFloat(linhaPercorrida));

            linhaPercorrida = reader.readLine();
            leitura.setSaidaMinima(parseFloat(linhaPercorrida));

            linhaPercorrida = reader.readLine();
            leitura.setSaidaMaxima(parseFloat(linhaPercorrida));

            linhaPercorrida = reader.readLine();
            leitura.setTamanho(parseInt(linhaPercorrida));

        } catch (IOException e) {
            System.out.println("Arquivo não encontrado ou formato inválido!");
            e.printStackTrace();
        }


        return leitura;
    }

}
