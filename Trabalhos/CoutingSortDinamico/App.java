package CoutingSortDinamico;

import java.util.Scanner;

public class App {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o tamanho do vetor: ");
        int tamanho = sc.nextInt();
        int[] numeros = new int[tamanho];

        for(int i = 0; i < tamanho; i++){
            System.out.println("Digite o " + (i+1) + "º valor:" );
            numeros[i] = sc.nextInt();
        } 

        CountingDinamico.sort(numeros);
        System.out.println();

        System.out.println("Vetor Atualizado: ");
        for(int numero : numeros){
            System.out.print(numero + " ");
        }
        
        sc.close();
    }
}