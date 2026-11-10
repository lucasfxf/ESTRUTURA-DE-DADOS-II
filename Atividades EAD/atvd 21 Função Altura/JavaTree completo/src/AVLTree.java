public class AVLTree<T extends Comparable<T>> {
    private Node<T> raiz;

    public AVLTree() {
        this.raiz = null;
    }

    public int altura() {
        return altura(this.raiz);
    }

    private int altura(Node<T> raiz) {
        if (raiz == null) {
            return -1;
        }

        int altEsq = altura(raiz.esquerda);
        int altDir = altura(raiz.direita);
        return Math.max(altEsq, altDir) + 1;
    }

    private Node<T> add(Node<T> raiz, Node<T> novoNo) {
        if (raiz == null) {
            return novoNo;
        } else if (novoNo.dado.compareTo(raiz.dado) < 0) {
            raiz.esquerda = add(raiz.esquerda, novoNo);
        } else {
            raiz.direita = add(raiz.direita, novoNo);
        }

        raiz.fb = altura(raiz.direita) - altura(raiz.esquerda);
        System.out.println("Altura do no " + raiz.dado + ": " + altura(raiz));
        return raiz;
    }

    public void add(T dado) {
        Node<T> novoNo = new Node<>(dado);
        this.raiz = add(raiz, novoNo);
    }

    private void preOrder(Node<T> raiz) {
        if (raiz != null) {
            System.out.print(raiz.dado + "(fb:" + raiz.fb + ") ");
            preOrder(raiz.esquerda);
            preOrder(raiz.direita);
        }
    }

    public void preOrder() {
        preOrder(this.raiz);
        System.out.println();
    }

    private void inOrder(Node<T> raiz) {
        if (raiz != null) {
            inOrder(raiz.esquerda);
            System.out.print(raiz.dado + " ");
            inOrder(raiz.direita);
        }
    }

    public void inOrder() {
        inOrder(this.raiz);
        System.out.println();
    }

    private void postOrder(Node<T> raiz) {
        if (raiz != null) {
            postOrder(raiz.esquerda);
            postOrder(raiz.direita);
            System.out.print(raiz.dado + " ");
        }
    }

    public void postOrder() {
        postOrder(this.raiz);
        System.out.println();
    }

    public T buscar(T dadoBusca) {
        return buscar(this.raiz, dadoBusca);
    }

    private T buscar(Node<T> raiz, T dadoBusca) {
        if (raiz == null) {
            return null;
        }

        System.out.println("Comparando " + dadoBusca + " com " + raiz.dado);
        if (raiz.dado.equals(dadoBusca)) {
            return raiz.dado;
        }

        if (dadoBusca.compareTo(raiz.dado) < 0) {
            return buscar(raiz.esquerda, dadoBusca);
        } else {
            return buscar(raiz.direita, dadoBusca);
        }
    }

    private Node<T> removeNode(Node<T> raiz) {
        Node<T> nova, pai;
        if (raiz.direita == null) {
            return raiz.esquerda;
        }

        pai = raiz;
        nova = raiz.direita;
        while (nova.esquerda != null) {
            pai = nova;
            nova = nova.esquerda;
        }

        if (pai != raiz) {
            pai.esquerda = nova.direita;
            nova.direita = raiz.direita;
        }
        nova.esquerda = raiz.esquerda;
        System.out.println("Retornando nova raiz: " + nova.dado);
        return nova;
    }

    public void remove(T dadoRemover) {
        this.raiz = remove(this.raiz, dadoRemover);
    }

    private Node<T> remove(Node<T> raiz, T dadoRemover) {
        if (raiz == null) {
            System.out.println("Não encontrado - :(");
            return null;
        }
        if (raiz.dado.equals(dadoRemover)) {
            System.out.println("Encontrado - removendo");
            return removeNode(raiz);
        }
        if (dadoRemover.compareTo(raiz.dado) < 0) {
            raiz.esquerda = remove(raiz.esquerda, dadoRemover);
        } else {
            raiz.direita = remove(raiz.direita, dadoRemover);
        }

        return raiz;
    }
}
