package dev.harddrillstudio.gen.snakez.genetics;

public class GeneticLauncher {

    Algorithm algorithm;

    public GeneticLauncher() {
        algorithm = new Algorithm();

        algorithm.initializePopulation();
        algorithm.population.printPopulation();

        int genCount = 0;

        while(genCount < 10) {
            System.out.println("Generation: " + genCount);

            genCount++;
        }
    }

}
