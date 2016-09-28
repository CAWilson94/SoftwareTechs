package geneticHelloWorld;

import java.util.Random;

public class Chromosome {

	final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz,./<>?!�$%^&*()_+-=[];#{}:@~'";
	final String target = "Hello, World!";
	public int fitness = 0;
	public String chromoStr = null;
	public String chromoString = null;

	Random rnd = new Random();

	public Chromosome(String chromoString, int fitness) {
		this.fitness = fitness; // Defaults at 0
		this.chromoStr = chromoString;
	}

	public Chromosome() {
		// Basically just want to be able to initalize in whatever way I want..
	}

	/**
	 * Sets String associated with chromosome
	 * 
	 * @param String
	 *            chromoStr
	 */
	public void setChromoStr(String chromoStr) {
		this.chromoStr = chromoStr;
	}

	/**
	 * Returns String associated with chromosome
	 * 
	 * @return String chromoStr
	 */
	public String getChromoStr() {
		return chromoStr;

	}

	/**
	 * Returns fitness associated with chromosome
	 * 
	 * @return int fitness
	 */
	public int getFitness() {
		return fitness;
	}

	/**
	 * Sets fitness associated with chromosome
	 * 
	 * @param int
	 *            fitness
	 */
	public void setFitness(int fitness) {
		this.fitness = fitness;
	}

	/**
	 * Returns the string of a chromosome directly: might be useless...
	 * 
	 * @return chromosome String
	 */
	public String randomChromosome() {
		String chromosome = null;
		StringBuilder sb = new StringBuilder(13);

		for (int i = 0; i < 13; i++) {
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		}
		chromosome = sb.toString();
		return chromosome;
	}

	/**
	 * Returns the chromosome objects generated randomly
	 * 
	 * @return Chromosome object with initialized chromosome string
	 */
	public Chromosome randomChromo() {
		Chromosome chromosome = new Chromosome();
		StringBuilder sb = new StringBuilder(13);

		for (int i = 0; i < 13; i++) {
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		}
		chromosome.setChromoStr(sb.toString());
		return chromosome;
	}

	/**
	 * Generate random chromosome String from random numbers
	 * 
	 * @return Chromosome chromosome
	 */
	public Chromosome randomChromoFromNum() {
		StringBuilder sb = new StringBuilder(13);
		for (int i = 0; i < 13; i++) {
			sb.append(genRandGene());
		}
		this.setChromoStr(sb.toString());
		return this;
	}

	public String genRandGene() {
		String randGene = null;
		int boop = rnd.nextInt(31 - 0 + 1) + 31;
		randGene = String.valueOf(Character.toChars(boop));
		return randGene;
	}

	public static void main(String[] args) {
		Chromosome c = new Chromosome();
		c.randomChromoFromNum();
		System.out.println(c.getChromoStr());

	}
}
