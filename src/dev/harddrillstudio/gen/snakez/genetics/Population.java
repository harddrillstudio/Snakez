package dev.harddrillstudio.gen.snakez.genetics;

import java.util.ArrayList;
import java.util.Random;

public class Population {

    ArrayList<Individual> individuals;

    int bestFitIndex, worstFitIndex;

    public static double mutationRate = 0.9;

    Random random = new Random();

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

    public Individual getWorstIndividual() {
        int minFit = 0;
        for (int i = 0; i < individuals.size(); i++) {
            if (minFit > individuals.get(i).fitness) {
                minFit = individuals.get(i).fitness;
                //worstIndividual = individuals.get(i);
                worstFitIndex = i;
            }
        }

        return individuals.get(worstFitIndex);
    }

    public Individual getBestIndividual() {
        int maxFit = 0;
        for (int i = 0; i < individuals.size(); i++) {
            if (maxFit < individuals.get(i).fitness) {
                maxFit = individuals.get(i).fitness;
                bestFitIndex = i;
                //worstIndividual = individuals.get(i);
            }
        }

        return individuals.get(bestFitIndex);
    }

    public int getHighestFitness() {
        int maxFit = 0;
        for (Individual i: individuals) {
            if (maxFit < i.fitness) {
                maxFit = i.fitness;
                //fittest = i;
            }
        }
        return maxFit;
    }

    public void mutation() {
        if (random.nextDouble() < mutationRate) {
            individuals.get(0).mutate();
            individuals.get(1).mutate();
        }
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

    public void breed() {
        getWorstIndividual();
        getBestIndividual();

        Individual x = individuals.get(worstFitIndex);

        //worstIndividual = breedIndividual(fittest, individuals.get(3));
    }

}
