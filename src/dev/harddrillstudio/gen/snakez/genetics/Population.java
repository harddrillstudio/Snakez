package dev.harddrillstudio.gen.snakez.genetics;

import java.util.ArrayList;

public class Population {

    final static int popSize = 10;

    ArrayList<Individual> individuals;

    int totalFitness;


    public Population() {
        individuals = new ArrayList<>();

        for (int i = 0; i < popSize; i++) {
            individuals.add(new Individual());
            System.out.println(i + ": Individual created!");
        }

        //printPopulation();
    }

    public void calculateFitness() {
        totalFitness = 0;
        for (Individual i: individuals) {
            i.calculateFitness();
            totalFitness += i.fitness;
        }
    }

    public void printPopulation() {
        for (int i = 0; i < popSize; i++) {
            System.out.print(i + ": ");
            individuals.get(i).printIndividual();
        }
        System.out.println();
    }

    public int size() {
        return popSize;
    }

}
