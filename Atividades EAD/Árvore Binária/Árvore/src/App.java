
import java.util.*;

public class App {

    static int menu(){
        Scanner leia = new Scanner(System.in);
        System.out.println("Arvore Binária de Busca");
        System.out.println("1. Inserir aluno");
        System.out.println("2. Remover elemento");
        System.out.println("3. Buscar aluno");
        System.out.println("4. Exibir árvore");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
        return leia.nextInt();
    }

    public static void main(String[] args) throws Exception {

        Scanner leia = new Scanner(System.in);
        BinarySearchTree<Aluno> arvore = new BinarySearchTree<>();
        int opcao = 0;

        do {
            System.out.println("----------------------------------");
            opcao = menu();

            switch(opcao){

                case 1:
                    System.out.print("Digite a matrícula: ");
                    int matricula = leia.nextInt();
                    leia.nextLine();

                    System.out.print("Digite o nome: ");
                    String nome = leia.nextLine();

                    Aluno aluno = new Aluno(nome, matricula);
                    arvore.add(aluno);

                    System.out.println("Aluno inserido com sucesso!");
                    break;

                case 2:
                    System.out.println("Remoção não implementada.");
                    break;

                case 3:
                    System.out.print("Digite a matrícula para buscar: ");
                    int matBusca = leia.nextInt();

                    Aluno busca = new Aluno("", matBusca);
                    Aluno encontrado = arvore.buscar(busca);

                    if(encontrado != null){
                        System.out.println("Aluno encontrado: " + encontrado);
                    } else {
                        System.out.println("Aluno não encontrado!");
                    }
                    break;

                case 4:
                    System.out.println("Exibindo a árvore em pré-ordem:");
                    arvore.preOrder();

                    System.out.println("Exibindo a árvore em ordem:");
                    arvore.inOrder();

                    System.out.println("Exibindo a árvore em pós-ordem:");
                    arvore.postOrder();
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

        } while(opcao != 0);
    }
}
