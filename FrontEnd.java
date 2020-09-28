// --== CS400 File Header Information ==--
// Name: Dennis Kelly
// Email: dfkelly2@wisc.edu
// Team: FD
// TA: Abhay
// Lecturer: Dahl
// Notes to Grader: <optional extra notes>
import java.util.Scanner;

public class FrontEnd {
	
	private static HashTableMap map = new HashTableMap();
	/**
	 * This is a helper method to print out a divider of 25 "-"
	 */
	private static void printDivider() {
		for (int i = 0; i < 25; i++) {
			System.out.print("-");
		}
		System.out.println("");
	}
	/**
	 * This method prints out the help menu of commands
	 */
	private static void printHelp() {
		printDivider();
		System.out.print("*Commands and their description: \n" 
				+ "*h: display the help menu\n" 
				+ "*n: new search\n"
				+ "*a: add new class\n"
				+ "*q: quit program\n");
		printDivider();
	}

	public static  void main(String[] args) {
		
		Scanner scnr = new Scanner(System.in);
		String command; // variable to store user input
		boolean quit = false; // variable to determine when to quit the program

		printDivider();
		System.out.println("*Enter a command to get started, type \"h\" for help");
		printDivider();

		while (true) {
			if (scnr.hasNext()) {
				command = scnr.next();
				switch (command) {
				case "h":
					printHelp();
					System.out.println("Enter another command:");
					break;
				case "n":
					search();
					break;
				case "a":
					add();
					break;
				case "q":
					quit = true;
					break;
				default:
					System.out.println("Invalid command: \"" + command + "\"  (type h for help)");
					System.out.println("Enter another command:");
				}

			} else {
				continue;
			}
			if (quit) { // will only exit the while loop if quit == true
				System.out.println("Quitting program");
				break;
			}
			continue;
		}
	}
	
	/**
	 * This method will allow a user to add a class and data to the table
	 */
	public static void add() {
		Scanner scnr = new Scanner(System.in);
		
		AcademicClass course;
		String classCode;
		
		double gpa;
		double percentA; 
		double percentF; 
		
		System.out.println("Enter the class code. EX: CS400 or ECE353");
		classCode = scnr.nextLine();
		
		System.out.println("Enter average GPA. EX: 3.10");
		gpa = scnr.nextDouble();
		
		System.out.println("Enter percentage of A's in the class (without the %). EX: 90.8");
		percentA = scnr.nextDouble(); 
		
		System.out.println("Enter percentage of F's in the class (without the %). EX 24.1");
		percentF = scnr.nextDouble(); 
		
		course = new AcademicClass(gpa, percentA, percentF);
		
		if(!map.put(classCode, course)) {
			//TODO NEED TO CHANGE THE PUT TO UPDATE THE CLASS;
		}
		System.out.println("Added class" + classCode);
		System.out.println("Enter another command");
	}
	/**
	 * This method will get the class code from the user and verify if there are statistics for the
	 * class in the table. If it does exist in the table it will print out the statistics.
	 */
	private static void search() {
		Scanner scnr = new Scanner(System.in);
		String classCode;
		AcademicClass course;

		System.out.println("Your class code must not have spaces EX: CS400 or ece353");
		System.out.println("Enter a class code:");

		while (true) { //loop for getting class code and checking if it exists in the table
			while (!(scnr.hasNext())) {
				// wait for the user to input a class code
			}
			classCode = scnr.next(); //check if the use wanted to exit the search
			if (classCode.equals("e")) {
				System.out.println("Enter another command");
				return;
			}
			
			if (!map.containsKey(classCode)) { //check if the class is in the table
				System.out.println("Class \"" + classCode + "\" either does not exist or there is not data for it");
				System.out.println("Enter another class code or \"e\" to exit search");
				continue;
			}
			break;
		}
		//if code made it here, the user entered a class that exists in our table
		
		// run a "get" command on our table
		
		course = (AcademicClass)map.get(classCode);

		// get the data from whatever is returned in whatever form
		printDivider();
		System.out.println("*For " + classCode +":\n"
								+ "*Percentage A's from last year: " + course.getPercentA() + "\n"
								+ "*Percentage F's from last year: " + course.getPercentF() + "\n"
								+ "*Average GPA from last year: " + course.getAvgGPA());
		printDivider();
		// print it out

		System.out.println("Enter another command");

	}

}