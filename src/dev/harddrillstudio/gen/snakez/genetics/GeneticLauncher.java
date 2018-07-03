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

        population.printPopulation();
        System.out.println("Highest fitness:" + population.getHighestFitness());

        while(population.getHighestFitness() < 5) {
            selection();
            crossover();
            mutation();
            population.calculateFitness();
            population.printPopulation();
        }

    }

    private void selection() {
        population.selectDuo();
    }

    private void crossover() {

    }

    private void mutation() {

    }

    private void initializePopulation() {
        population = new Population();
        System.out.println("Population generated!");
    }

}
