public class App {
    public static void main(String[] args){
        int[] numeros = {4, 2, 2, 1, 3};

        System.out.println("Antes: ");

        for(int numero : numeros){
            System.out.print(numero + " ");
        }
        CountingSort.sort(numeros);

        System.out.println();

        System.out.println("Depois:");

        for (int numero : numeros) {
            System.out.print(numero + " ");
        }
    }
}
