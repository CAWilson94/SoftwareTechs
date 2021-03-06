package geneticHelloWorld;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * Basic idea is the source, we can view as the DNA of the organism It
 * will randomly mutate some of the DNA then judge the new mutated
 * strings fitness.
 * 
 * So, in this instance, how do we determine fitness? Take the value of
 * each character in the String and see how much it differs from the
 * same character in the target string.
 * 
 * So this is the distance between two characters, we then add all those
 * differences which leads to a single value which is the fitness
 * function.
 * 
 * A fitness of 0 is perfect while a fitness of 1 means one of the
 * characters is off by 1 eh hello and hellp both have a fitness of one
 * - the higher the fitness number the less the fit actually is.
 */

public class Demo {

	public static void fileWriting(String someString) {
		try {
			FileWriter fileWriter = new FileWriter(new File("File.txt"), true);
			fileWriter.write(someString);
			fileWriter.close();
		} catch (IOException e) {
			System.out.println("yer maw");
		}
	}

	public static void GAPerformance(int runSize, int popSize) {

		List<Double> time = new ArrayList<Double>();
		List<Integer> gen = new ArrayList<Integer>();

		int generation = 0;

		for (int i = 0; i < runSize; i++) {

			long startTime = System.currentTimeMillis();
			generation = GA.GAlgorithm();
			long endTime = System.currentTimeMillis();

			gen.add(generation);
			double duration = (endTime - startTime);// seconds
			time.add(duration);
		}

		System.out.println("\n Peformance Results: GA\n");

		for (int i = 0; i < time.size(); i++) {
			String content = ("time:	" + time.get(i) + "ms " + "Gen:	" + gen.get(i) + "	:	" + Constants.POP_SIZE);
			System.out.println(content);
			fileWriting(content + "	:	GA\n");
		}
	}

	public static void hillClimbPerformance() {

		long startTime = System.currentTimeMillis();
		GA.randomRestart();
		long endTime = System.currentTimeMillis();

		long duration = (endTime - startTime);

		System.out.println("\n Peformance Results: Random Restart \n");

		String content = ("time:	" + duration  +"ms");
		System.out.println(content);
		fileWriting("\n" + content + "	:	Random Restart\n");
	}

	public static void randomPerformance() {

		System.out.println("\nRandom function: ");

		long startRand = System.currentTimeMillis();
		Chromosome randGen = GA.random();
		long endRand = System.currentTimeMillis();

		double randDuration = Math.round((endRand - startRand) / 1000);
		System.out.println("\n");
		System.out.println("\n Performance Results: random\n");
		String content = ("time:	" + randDuration + "ms " + 	"best string: " + randGen.getChromoStr() + "   :	"
				+ "	with fitness : " + randGen.getFitness() + "	:	" + Constants.POP_SIZE);
		fileWriting("\n" + content + "	:	random	");
		System.out.println(content + "\n");
	}

	public static void main(String[] args) throws IOException {

		Scanner scan = new Scanner(System.in);
		String s = null;

		while (true) {
			System.out.println("\nWould you like to test: ");
			System.out.println("1: GA");
			System.out.println("2: Random");
			System.out.println("3: Random Restart (hill climbing)");

			try {
				s = scan.nextLine();
			} catch (NumberFormatException e) {
				System.out.println("Not a number ya tit");
			}
			char input = s.charAt(0);

			switch (input) {
			case '1':
				Demo.GAPerformance(10, 1000);
				break;
			case '2':
				Demo.randomPerformance();
				break;
			case '3':
				Demo.hillClimbPerformance();
				break;
			}
		}
	}
}
