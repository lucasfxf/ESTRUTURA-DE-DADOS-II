
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;

// BLOCO 1 

public class Huffman {
    NoHuffman raiz;

    Map<Character, Integer> frequencias = new LinkedHashMap<>();
    Map<Character, String> codigos = new LinkedHashMap<>();

    // BLOCO 2 

    public void montarArvore(String texto) {
        frequencias.clear();
        codigos.clear();
        raiz = null;

        for (char letra : texto.toCharArray()) {
            frequencias.put(letra, frequencias.getOrDefault(letra, 0) + 1);
        }

        // BLOCO 3 

        PriorityQueue<NoHuffman> fila = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.frequencia, b.frequencia)
        );

        for (char letra : frequencias.keySet()) {
            fila.add(new NoHuffman(letra, frequencias.get(letra)));
        }

        // BLOCO 4 

        while (fila.size() > 1) {
            NoHuffman esquerda = fila.poll();
            NoHuffman direita = fila.poll();

            NoHuffman novo = new NoHuffman(
                '\0', esquerda.frequencia + direita.frequencia
            );

            novo.esquerda = esquerda;
            novo.direita = direita;

            fila.add(novo);
        }

        // BLOCO 5 

        if (!fila.isEmpty()) {
            raiz = fila.poll();
            gerarCodigos(raiz, "");
        }
    }

    // BLOCO 6 

    private void gerarCodigos(NoHuffman no, String caminho) {
        if (no.esquerda == null && no.direita == null) {
            codigos.put(no.letra, caminho.isEmpty() ? "0" : caminho);
            return;
        }

        gerarCodigos(no.esquerda, caminho + "0");
        gerarCodigos(no.direita, caminho + "1");
    }

    // BLOCO 7 

    public String compactar(String texto) {
        StringBuilder resultado = new StringBuilder();

        for (char letra : texto.toCharArray()) {
            resultado.append(codigos.get(letra));
        }

        return resultado.toString();
    }

    // BLOCO 8 

    public String descompactar(String bits) {
        StringBuilder resultado = new StringBuilder();

        if (raiz == null) return "";

        if (raiz.esquerda == null && raiz.direita == null) {
            for (int i = 0; i < bits.length(); i++) {
                resultado.append(raiz.letra);
            }
            return resultado.toString();
        }

        // BLOCO 9 

        NoHuffman atual = raiz;

        for (char bit : bits.toCharArray()) {
            if (bit == '0')
                atual = atual.esquerda;
            else
                atual = atual.direita;

            if (atual.esquerda == null && atual.direita == null) {
                resultado.append(atual.letra);
                atual = raiz;
            }
        }

        return resultado.toString();
    }

    // BLOCO 10 

    public void mostrarFrequencias() {
        for (char letra : frequencias.keySet()) {
            System.out.println(letra + ": " + frequencias.get(letra));
        }
    }

    // BLOCO 11 

    public void mostrarCodigos() {
        for (char letra : frequencias.keySet()) {
            System.out.println(letra + ": " + codigos.get(letra));
        }
    }
}
