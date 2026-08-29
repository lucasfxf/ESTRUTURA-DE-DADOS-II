import java.util.Comparator;

public class InsertionSort<T extends Comparable<T>> {

    private long contaComparacoes;
    private long contaTrocas;

    public long getContaComparacoes() {
        return contaComparacoes;
    }

    public long getContaTrocas() {
        return contaTrocas;
    }

    public T[] sort(T[] array, Comparator<T> comparador) {

        contaComparacoes = 0;
        contaTrocas = 0;

        for (int i = 1; i < array.length; i++) {

            T atual = array[i];
            int j = i - 1;

            while (j >= 0) {

                contaComparacoes++;

                if (comparador.compare(array[j], atual) > 0) {

                    array[j + 1] = array[j];
                    contaTrocas++;

                    j--;

                } else {

                    break;

                }
            }

            array[j + 1] = atual;
        }

        return array;
    }

    public T[] sort(T[] array) {
        return sort(array, (a, b) -> ((Comparable<T>) a).compareTo(b));
    }
}