package dev.harddrillstudio.gen.snakez.genetics;

import java.util.ArrayList;

public class Population {

    public int popSize;

    ArrayList<Individual> individuals;

    int totalFitness;


    public Population(int size) {
        popSize = size;
        individuals = new ArrayList<>();

        for (int i = 0; i < popSize; i++) {
            individuals.add(new Individual());
            System.out.println(i + ": Individual created!");
        }

        calculateFitness();
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

    public Individual getFittest() {
        Individual fittest = individuals.get(0);

        for (Individual i: individuals) {
            if (i.fitness > fittest.fitness)
                fittest = i;
        }

        return fittest;
    }

}
