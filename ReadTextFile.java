import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ReadTextFile {
	public static void main(String [] args) throws FileNotFoundException {
		HashTableMap<String, Double> hTable = new HashTableMap<>();
		File file = new File("REPLACE WITH TEXT FILE LOCATION");
		if(!file.exists()) { //Throws exception if File doesn't exist
			throw new FileNotFoundException("txt file with course information was not found");
		}
		String courseName = "";
		Scanner scan = new Scanner(file);	
		String checking = ""; //Variable used to check whether String or double
		while(scan.hasNextLine()) { //Loops until no more lines are left in txt file
			courseName = scan.next(); //First course listed is stored
			while(scan.hasNext()) { //Loops to end 
				try { //Tries to 
					checking = scan.next();
					//System.out.println("Course Name: " + courseName); //FOR DEBUGGING
					//System.out.println("Checking: " + Double.parseDouble(checking)); //FOR DEBUGGING
					hTable.put(courseName, Double.parseDouble(checking));
				}
				catch(NumberFormatException e) { //If a NumberFormatException is thrown, then the Scanner must 
					courseName = checking;		 //be checking a course name (key) with characters and numbers
				}	
			}
		}
	}
}
