package dev.harddrillstudio.gen.snakez.genetics;

import java.util.Random;

public class Algorithm {

    Population population;

    final static double MUTATION_RATE = 0.05;

    Random random = new Random();



    private void selection() {
        population.calculateFitness();
    }


    public void initializePopulation() {
        population = new Population();
        System.out.println("Population generated!");
        System.out.println();
    }


    // EVOLUTION
    public Population evolvePopulation(Population pop) {
        Population newPop = new Population();


        for (int i = 0; i < pop.size(); i++) {
            Individual mother = rouletteSelect(population);
            mother.printIndividual();
            Individual father = rouletteSelect(population);
            father.printIndividual();
            Individual offspring = crossover(mother, father);
            newPop.individuals.set(i, offspring);
        }

        return newPop;
    }


    // SELECTION
    private Individual rouletteSelect(Population pop) {
        selection();
        double rand = random.nextDouble() * pop.totalFitness;

        int idx;
        for (idx = 0; idx < pop.popSize && rand > 0; idx++) {
            rand -= pop.individuals.get(idx).fitness;
        }
        System.out.println("Selected index: "+idx);
        return pop.individuals.get(idx);
    }


    // MUTATION
    private Individual mutate(Individual individual) {
        individual.mutate();
        return individual;
    }


    // CROSSOVER
    private Individual crossover(Individual mother, Individual father) {
        Individual offspring = new Individual();
        for (int i = 0; i < Individual.genomeLength; i++) {
            if (i % 2 == 0)
                offspring.genes[i] = mother.genes[i];
            else
                offspring.genes[i] = father.genes[i];
        }

        return offspring;
    }

    /*
    pick 2 parents
    crossover
    mutate
    add to new pop
     */
}
