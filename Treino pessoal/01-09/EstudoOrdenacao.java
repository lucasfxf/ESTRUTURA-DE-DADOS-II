
public class EstudoOrdenacao {

    public static void main(String[] args) {

        Integer[] numeros = {5, 3, 8, 1, 2};

        System.out.println("Antes:");

        for (Integer numero : numeros) {
            System.out.print(numero + " ");
        }

        System.out.println();

        for(int fase = 1; fase < numeros.length; fase++){
            for(int j = 0; j < numeros.length - fase; j++){

            if(numeros[j] > numeros[j + 1]){
                int temp = numeros[j];

                numeros[j] = numeros[j + 1];

                numeros[j + 1] = temp;

                } 
            }
        }
        System.out.println();

        // Bubble terminou aqui
        System.out.println("Primeira fase: ");
        for (Integer numero : numeros) {
        System.out.print(numero + " ");

        }
    }
}