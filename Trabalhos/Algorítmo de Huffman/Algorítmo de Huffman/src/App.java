
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite uma palavra ou frase: ");
        String texto = entrada.nextLine();

        if (texto.isEmpty()) {
            System.out.println("Nenhum texto digitado.");
            entrada.close();
            return;
        }

        Huffman huffman = new Huffman();
        huffman.montarArvore(texto);

        System.out.println("\nFrequencia das letras:");
        huffman.mostrarFrequencias();

        System.out.println("\nCodigos de Huffman:");
        huffman.mostrarCodigos();

        String compactado = huffman.compactar(texto);
        String descompactado = huffman.descompactar(compactado);

        System.out.println("\nTexto original: " + texto);
        System.out.println("Texto compactado: " + compactado);
        System.out.println("Texto descompactado: " + descompactado);
        System.out.println("Quantidade de bits: " + compactado.length());

        entrada.close();
    }
}
