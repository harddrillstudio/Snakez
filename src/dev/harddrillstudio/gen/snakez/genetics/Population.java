package dev.harddrillstudio.gen.snakez.genetics;

import java.util.ArrayList;

public class Population {

    ArrayList<Individual> individuals;

    Individual fittest, secondFittest;

    public Population() {
        individuals = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            individuals.add(new Individual());
            System.out.println(i + ": Individual created!");
        }
    }

    public void printPopulation() {
        for (Individual i: individuals) {
            i.printIndividual();
        }
        System.out.println();
    }

    public void calculateFitness() {
        for (Individual i: individuals) {
            i.calculateFitness();
        }
    }

    public int getHighestFitness() {
        int maxFit = 0;
        for (Individual i: individuals) {
            if (maxFit < i.fitness) {
                maxFit = i.fitness;
                fittest = i;
            }
        }
        return maxFit;
    }

    public Individual breedIndividual(Individual mother, Individual father) {
        Individual offspring = new Individual();
        for (int i = 0; i < Individual.genomeLength; i++) {
            if (i % 2 == 0)
                offspring.genes[i] = mother.genes[i];
            else
                offspring.genes[i] = father.genes[i];
        }

        return offspring;
    }

    public void selectDuo() {

    }

}
