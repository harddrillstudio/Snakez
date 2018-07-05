package dev.harddrillstudio.gen.snakez.genetics;

import java.util.Random;

public class Individual {

    public int[] genes;
    public int fitness;
    public static int genomeLength = 5;

    public Individual() {
        genes = new int[genomeLength];
        fitness = 0;

        randomizeGenome();
    }

    public void printIndividual() {
        System.out.println("F: " +fitness+ " G: " + getGenesInString());
    }

    public void calculateFitness() {
        int newFit = 0;
        for (int i = 0; i < genes.length; i++) {
            newFit += genes[i];
        }
        this.fitness = newFit;
    }

    public void mutate() {
        Random random = new Random();
        int index = random.nextInt(genomeLength);
        this.genes[index] = (this.genes[index] + 1 ) % 2;
    }

    private void randomizeGenome() {
        Random random = new Random();
        for (int i = 0; i < genes.length; i++) {
            genes[i] = random.nextInt(2);
        }
    }

    private String getGenesInString() {
        StringBuilder builder = new StringBuilder();

        for (int chunk : this.genes) {
            builder.append(String.valueOf(chunk));
        }

        return builder.toString();
    }

}
