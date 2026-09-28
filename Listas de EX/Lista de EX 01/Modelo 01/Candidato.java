public class Candidato implements Comparable<Candidato> {

    private String nome;
    private double nota;

    public Candidato(String nome, double nota) {
        this.nome = nome;
        this.nota = nota;
    }

    public String getNome() {
        return nome;
    }

    public double getNota() {
        return nota;
    }

    @Override
    public int compareTo(Candidato outro) {

        // Maior nota primeiro
        int resultado = Double.compare(outro.nota, this.nota);

        // Se a nota for igual, ordem alfabética
        if (resultado == 0) {
            resultado = this.nome.compareTo(outro.nome);
        }

        return resultado;
    }

    @Override
    public String toString() {
        return nome + " - " + nota;
    }
}