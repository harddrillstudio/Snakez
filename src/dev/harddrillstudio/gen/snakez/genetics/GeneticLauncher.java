package dev.harddrillstudio.gen.snakez.genetics;

public class GeneticLauncher {

    Population population;

    /*
        START
        Generate the initial population
        Compute fitness
        REPEAT
            Selection
            Crossover
            Mutation
            Compute fitness
        UNTIL population has converged
        STOP
     */
    public void start() {
        initializePopulation();
        //population.printPopulation();

        population.calculateFitness();

        //population.printPopulation();


        while(population.getHighestFitness() < 5) {

            crossover();

            mutation();

            population.calculateFitness();

            System.out.println("Highest fitness:" + population.getHighestFitness());

            breed();

            population.printPopulation();
        }

    }

    private void breed() {
        population.breed();
    }

    private void crossover() {

    }

    private void mutation() {
        population.mutation();
    }

    private void initializePopulation() {
        population = new Population();
        System.out.println("Population generated!");
    }

}
