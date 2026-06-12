class DnaStructure{

    StringBuilder dnaSequence;

    public DnaStructure(String dnaSequence) {
        this.dnaSequence = new StringBuilder(dnaSequence);
    }

    public void ingestSequence(char[] sensorData) {
        this.dnaSequence.append(sensorData);
    }

    public void mutateDNA(String target, String replacement){

        int startIndex = this.dnaSequence.indexOf(target);
        if(startIndex != -1){
            int endIndex = startIndex + target.length();
            this.dnaSequence.replace(startIndex, endIndex, replacement);
        }
    }

    public String getDnaSequence() {
        return this.dnaSequence.toString();
    }
}

public class DNA{

    public static void main(String[] args) {
        DnaStructure dna = new DnaStructure("ACGT");
        System.out.println("Initial DNA Sequence: " + dna.getDnaSequence());

        char[] sensorData = {'G', 'T', 'A'};
        dna.ingestSequence(sensorData);
        System.out.println("After Ingesting Sensor Data: " + dna.getDnaSequence());

        dna.mutateDNA("CGT", "AAA");
        System.out.println("After Mutation: " + dna.getDnaSequence());
    }

}