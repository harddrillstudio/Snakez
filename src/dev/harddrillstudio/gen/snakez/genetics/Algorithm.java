package dev.harddrillstudio.gen.snakez.genetics;

import java.util.Random;

public class Algorithm {

    Population population;

    final static double MUTATION_RATE = 0.05;
    final static int tournamentSize = 4;

    Random random = new Random();



    public void initializePopulation() {
        population = new Population(10);
        System.out.println("Population generated!");
        System.out.println();

    }


    // EVOLUTION
    public Population evolvePopulation(Population pop) {
        Population newPop = new Population(pop.size());


        for (int i = 0; i < pop.size(); i++) {
            Individual mother = tournamentSelect(population);
            //mother.printIndividual();
            Individual father = tournamentSelect(population);
            //father.printIndividual();
            Individual offspring = crossover(mother, father);

            offspring = mutate(offspring);

            newPop.individuals.set(i, offspring);
        }

        newPop.calculateFitness();
        return newPop;
    }


    // SELECTION
    private Individual rouletteSelect(Population pop) {
        pop.calculateFitness();
        double rand = random.nextDouble() * pop.totalFitness;

        int idx;
        for (idx = 0; idx < pop.popSize-1 && rand > 0; ++idx) {
            rand -= pop.individuals.get(idx).fitness;
        }
        //System.out.println("Selected index: "+idx);
        return pop.individuals.get(idx);
    }

    private Individual tournamentSelect(Population pop) {
        pop.calculateFitness();

        Population tournament = new Population(tournamentSize);
        for (int i = 0; i < tournamentSize; i++) {
            int randomId = (int) (Math.random() * pop.size());
            tournament.individuals.add(pop.individuals.get(randomId));
        }

        // get fittest
        Individual fittest = tournament.getFittest();
        return fittest;
    }

    // MUTATION
    private Individual mutate(Individual individual) {
        double rand = random.nextDouble();
        if (rand < MUTATION_RATE) {
            individual.mutate();
        }
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
