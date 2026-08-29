public class App {

    public static Integer[] vetorDeNumeros() {
        return new Integer[]{
                10, 14, 63, 29, 95
        };
    }

    public static Integer[] gerarVetorAleatorio(int tamanho) {

        Integer[] vetor = new Integer[tamanho];

        for (int i = 0; i < tamanho; i++) {
            vetor[i] = (int) (Math.random() * 100);
        }

        return vetor;
    }

    public static void main(String[] args) throws Exception {

        int n = 150000;

        long inicio, fim, tempo;

        Integer[] numeros = gerarVetorAleatorio(n);

        // SELECTION SORT
        Integer[] numerosSelectionSort = numeros.clone();

        SelectionSort<Integer> selectionSort = new SelectionSort<>();

        inicio = System.currentTimeMillis();

        selectionSort.sort(numerosSelectionSort);

        fim = System.currentTimeMillis();

        tempo = fim - inicio;

        System.out.println("===== SELECTION SORT =====");
        System.out.println("Comparacoes: "
                + selectionSort.getContaComparacoes());

        System.out.println("Trocas: "
                + selectionSort.getContaTrocas());

        System.out.println("Tempo(ms): " + tempo);


        // BUBBLE SORT
        Integer[] numerosBubbleSort = numeros.clone();

        BubbleSort<Integer> bubbleSort = new BubbleSort<>();

        inicio = System.currentTimeMillis();

        bubbleSort.sort(numerosBubbleSort);

        fim = System.currentTimeMillis();

        tempo = fim - inicio;

        System.out.println();
        System.out.println("===== BUBBLE SORT =====");

        System.out.println("Comparacoes: "
                + bubbleSort.getContaComparacoes());

        System.out.println("Trocas: "
                + bubbleSort.getContaTrocas());

        System.out.println("Tempo(ms): " + tempo);


        // INSERTION SORT
        Integer[] numerosInsertionSort = numeros.clone();

        InsertionSort<Integer> insertionSort = new InsertionSort<>();

        inicio = System.currentTimeMillis();

        insertionSort.sort(numerosInsertionSort);

        fim = System.currentTimeMillis();

        tempo = fim - inicio;

        System.out.println();
        System.out.println("===== INSERTION SORT =====");

        System.out.println("Comparacoes: "
                + insertionSort.getContaComparacoes());

        System.out.println("Trocas/Movimentacoes: "
                + insertionSort.getContaTrocas());

        System.out.println("Tempo(ms): " + tempo);
    }
}

/*
RESULTADOS DAS COMPARAÇÕES (DIA 29-08):

===== SELECTION SORT =====
Comparacoes: 11249925000
Trocas: 149999
Tempo(ms): 12610

===== BUBBLE SORT =====
Comparacoes: 11249925000
Trocas: 5561512176
Tempo(ms): 73959

===== INSERTION SORT =====
Comparacoes: 5561662169
Trocas/Movimentacoes: 5561512176
Tempo(ms): 20790
 */