package dev.harddrillstudio.gen.snakez.genetics;

public class GeneticLauncher {

    Algorithm algorithm;

    public GeneticLauncher() {
        algorithm = new Algorithm();

        algorithm.initializePopulation();
        algorithm.population.printPopulation();

        int genCount = 0;

        while(algorithm.population.getFittest().fitness < 15) {

            algorithm.population = algorithm.evolvePopulation(algorithm.population);

            genCount++;
            algorithm.population.printPopulation();
            System.out.println("Generation: " + genCount + " Fittest: " + algorithm.population.getFittest().fitness);
        }
    }

}
