public class CountingSort {

    public static void sort(int[] vetor) {

        int maior = vetor[0];

        for (int i = 1; i < vetor.length; i++) {
            if (vetor[i] > maior) {
                maior = vetor[i];
            }
        }

        int[] contador = new int[maior + 1];

        for (int numero : vetor) {
            contador[numero]++;
        }

        int posicao = 0;

        for (int i = 0; i < contador.length; i++) {
            while (contador[i] > 0) {
                vetor[posicao] = i;
                posicao++;
                contador[i]--;
            }
        }
    }
}