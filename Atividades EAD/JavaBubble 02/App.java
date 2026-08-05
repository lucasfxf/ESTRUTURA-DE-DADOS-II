import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;

public class App {

    public static Integer[] carregarArquivo(String nomeArquivo) throws IOException {

        List<String> linhas = Files.readAllLines(Paths.get(nomeArquivo));

        Integer[] numeros = new Integer[linhas.size()];

        for (int i = 0; i < linhas.size(); i++) {

            numeros[i] = Integer.parseInt(linhas.get(i).trim());

        }

        return numeros;

    }

    public static void main(String[] args) throws Exception {

        BubbleSort<Integer> bubble = new BubbleSort<>();

        Integer[] numeros = carregarArquivo("numeros.txt");

        bubble.sortNormal(numeros.clone(), Comparator.naturalOrder());

        bubble.sortOtimizado(numeros.clone(), Comparator.naturalOrder());

    }

}