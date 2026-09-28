public class Candidato implements Comparable<Candidato> {

private String nome;
private double nota;

public Candidato(String nome,double nota){
this.nome=nome;
this.nota=nota;
}

public String getNome(){
return nome;
}

public double getNota(){
return nota;
}

@Override
public int compareTo(Candidato outro){

int resultado=Double.compare(outro.nota,this.nota);

if(resultado==0){
resultado=this.nome.compareTo(outro.nome);
}

return resultado;
}

@Override
public String toString(){
return nome+" - "+nota;
}

}