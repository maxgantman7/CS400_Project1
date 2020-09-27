import java.util.Scanner;

public class FrontEnd {
	

	private static void printDivider() {
		for (int i = 0; i < 25; i++) {
			System.out.print("-");
		}
		System.out.println("");
	}

	private static void printHelp() {
		printDivider();
		System.out.print("*Commands and their description: \n" + "*h: display the help menu\n" + "*n: new search\n"
				+ "*q: quit program\n");
		printDivider();
	}

	public static void main(String[] args) {
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
				case "q":
					quit = true;
					break;
				default:
					System.out.println("invalid command: \"" + command + "\" --type h for help");
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

	private static void search() {
		Scanner scnr = new Scanner(System.in);
		String classCode;

		System.out.println("Your class code must not have spaces EX: CS400 or ece353");
		System.out.println("Enter a class code:");

		while (true) { //loop for getting class code and checking if it exists in the table
			while (!(scnr.hasNext())) {
				// wait for the user to input a class code
			}
			classCode = scnr.next();

			if (!containsKey(classCode)) { //check if the class is in the table
				System.out.println("Class \"" + classCode + "\" either does not exist or there is not data on it");
				System.out.println("Enter another class code");
				continue;
			}
		}

		// run a "get" command on our table

		// get the data from whatever is returned in whatever form

		// print it out
		
		//WILL THIS COMMIT SHOW UP

		System.out.println("Enter another command");

	}

}
