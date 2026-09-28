public class Main {

public static void main(String[] args){

Candidato[] candidatos=new Candidato[5];

candidatos[0]=new Candidato("Carlos",85.5);
candidatos[1]=new Candidato("Ana",92.0);
candidatos[2]=new Candidato("Bruno",85.5);
candidatos[3]=new Candidato("Daniel",92.0);
candidatos[4]=new Candidato("Beatriz",97.5);

System.out.println("ANTES DA ORDENACAO:");

for(Candidato c:candidatos){
System.out.println(c);
}

Sorts<Candidato> sorts=new Sorts<>();

sorts.insertionSort(candidatos);

System.out.println("\nDEPOIS DA ORDENACAO:");

for(int i=0;i<candidatos.length;i++){
System.out.println((i+1)+" - "+candidatos[i]);
}

}
}