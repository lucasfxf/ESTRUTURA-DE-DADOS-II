import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class App {

    static int lerDadosDoArquivo(BinarySearchTree<Aluno> arvore, String nomeArquivo) {
        int quantidade = 0;
        try (BufferedReader leitor = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;

            while ((linha = leitor.readLine()) != null) {
                linha = linha.trim();
                if (linha.isEmpty()) {
                    continue;
                }

                // Separa os dados delimitados por vírgula: "105,Ana" -> ["105", "Ana"]
                String[] dados = linha.split(",");
                if (dados.length == 2) {
                    int matricula = Integer.parseInt(dados[0].trim());
                    String nome = dados[1].trim();

                    Aluno aluno = new Aluno(nome, matricula);
                    arvore.add(aluno);
                    quantidade++;
                }
            }
            return quantidade;
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Erro na conversão do código numérico: " + e.getMessage());
        }
        return -1;
    }

    static int menu(Scanner leia, boolean modoAlunos) {
        System.out.println(modoAlunos ? "Arvore Binária de Busca - Alunos" : "Arvore AVL - Inteiros");
        System.out.println("1. Inserir elemento");
        System.out.println("2. Remover elemento");
        System.out.println("3. Buscar elemento");
        System.out.println("4. Exibir árvore");
        if (modoAlunos) {
            System.out.println("5. Carregar dados do arquivo");
        }
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
        return leia.nextInt();
    }

    public static void cadastrarDadosInteiros(Scanner leia) {
        AVLTree<Integer> arvore = new AVLTree<>(); // Instanciar a arvore AVL
        int opcao = 0;
        do {
            System.out.println("----------------------------------");
            opcao = menu(leia, false);
            switch (opcao) {
                case 1:
                    System.out.print("Digite o elemento a ser inserido: ");
                    Integer elementoInserir = leia.nextInt();
                    arvore.add(elementoInserir); // inserir
                    System.out.println("Elemento inserido com sucesso!");
                    break;
                case 2:
                    System.out.print("Digite o elemento a ser removido: ");
                    Integer elementoRemover = leia.nextInt();
                    // Implementar a remoção do elemento na árvore
                    System.out.println("Elemento removido com sucesso!");
                    break;
                case 3:
                    System.out.print("Digite o elemento a ser buscado: ");
                    Integer elementoBuscar = leia.nextInt();
                    if (arvore.buscar(elementoBuscar) != null) { // buscar
                        System.out.println("Elemento encontrado!");
                    } else {
                        System.out.println("Elemento não encontrado!");
                    }
                    break;
                case 4:
                    System.out.println("Exibindo a árvore em pré-ordem:");
                    arvore.preOrder(); // exibir
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
        } while (opcao != 0);
    }

   

    static void cadastrarDadosAlunos(Scanner leia) {
        BinarySearchTree<Aluno> arvore = new BinarySearchTree<>(); // Instanciar a arvore
        int opcao = 0;
        do {
            System.out.println("----------------------------------");
            opcao = menu(leia, true);
            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do aluno: ");
                    String nome = leia.nextLine();
                    System.out.print("Digite a matrícula do aluno: ");
                    int matricula = leia.nextInt(); leia.nextLine(); // Consumir a quebra de linha
                    Aluno aluno = new Aluno(nome, matricula);
                    arvore.add(aluno); // inserir
                    System.out.println("Aluno inserido com sucesso!");
                    break;
                case 2:
                    System.out.print("Digite a matrícula do aluno a ser removido: ");
                    int matriculaRemover = leia.nextInt();
                    Aluno alunoRemover = new Aluno("", matriculaRemover); // Criar um objeto temporário para remoção
                    arvore.remove(alunoRemover);
                    System.out.println("Aluno removido com sucesso!");
                    break;
                case 3:
                    System.out.print("Digite a matrícula do aluno a ser buscado: ");
                    int matriculaBuscar = leia.nextInt();
                    Aluno alunoBusca = new Aluno("", matriculaBuscar); // Criar um objeto temporário para busca
                    if (arvore.buscar(alunoBusca) != null) { // buscar
                        System.out.println("Aluno encontrado!");
                    } else {
                        System.out.println("Aluno não encontrado!");
                    }
                    break;
                case 4:
                    System.out.println("Exibindo a árvore em pré-ordem:");
                    arvore.preOrder(); // exibir
                    System.out.println("Exibindo a árvore em ordem:");
                    arvore.inOrder();
                    System.out.println("Exibindo a árvore em pós-ordem:");
                    arvore.postOrder();

                    break;
                case 5:
                    System.out.println("Carregando dados do arquivo dados_alunos.txt...");
                    int quantidade = lerDadosDoArquivo(arvore, "dados_alunos.txt");
                    if (quantidade >= 0) {
                        System.out.println(quantidade + " aluno(s) carregado(s) com sucesso.");
                    }
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);
    }

    public static void main(String[] args) throws Exception {
        Scanner leia = new Scanner(System.in);
        System.out.println("Escolha o modo de execução:");
        System.out.println("1. Testar AVL com números inteiros");
        System.out.println("2. Gerenciar alunos e carregar dados_alunos.txt");
        System.out.print("Opção: ");
        int modo = leia.nextInt();

        if (modo == 1) {
            cadastrarDadosInteiros(leia);
        } else if (modo == 2) {
            cadastrarDadosAlunos(leia);
        } else {
            System.out.println("Opção inválida.");
        }
    }
}
