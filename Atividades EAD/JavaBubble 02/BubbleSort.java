import java.util.Comparator;

public class BubbleSort<T extends Comparable<T>> {

    private void troca(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // Bubble Sort normal
    public void sortNormal(T[] array, Comparator<T> comparator) {

        int fases = 0;
        int comparacoes = 0;
        int trocas = 0;

        int n = array.length;

        for (int fase = 1; fase < n; fase++) {

            fases++;

            for (int j = 0; j < n - fase; j++) {

                comparacoes++;

                if (comparator.compare(array[j], array[j + 1]) > 0) {

                    troca(array, j, j + 1);
                    trocas++;

                }

            }

        }

        System.out.println("===== Bubble Sort Normal =====");
        System.out.println("Fases: " + fases);
        System.out.println("Comparações: " + comparacoes);
        System.out.println("Trocas: " + trocas);

    }

    // Bubble Sort otimizado
    public void sortOtimizado(T[] array, Comparator<T> comparator) {

        int fases = 0;
        int comparacoes = 0;
        int trocas = 0;

        int n = array.length;

        for (int fase = 1; fase < n; fase++) {

            fases++;

            boolean trocou = false;

            for (int j = 0; j < n - fase; j++) {

                comparacoes++;

                if (comparator.compare(array[j], array[j + 1]) > 0) {

                    troca(array, j, j + 1);
                    trocas++;
                    trocou = true;

                }

            }

            if (!trocou)
                break;

        }

        System.out.println();
        System.out.println("===== Bubble Sort Otimizado =====");
        System.out.println("Fases: " + fases);
        System.out.println("Comparações: " + comparacoes);
        System.out.println("Trocas: " + trocas);

    }

}