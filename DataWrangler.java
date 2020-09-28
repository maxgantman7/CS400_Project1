import java.io.File;
import java.util.Scanner;

/**
*This method creates an arraylist of AcademicClass objects by reading a text file.
*/
public static void dataWrangler (String fileName){ 
AcademicClass[] classList = new AcademicClass[12];
    int i = 0;
    try {
      File file = new File(fileName);
      Scanner sc = new Scanner(file);
      Scanner sc2;
      while(sc.hasNextLine()){
        String line = sc.nextLine();
        sc2 = new Scanner(line);
        sc2.useDelimiter(",");
        String className = sc2.next();
        String avgGPA = sc2.next().trim();
        String percentA = sc2.next().trim();
        String percentF= sc2.next().trim();
        classList[i] = new AcademicClass(className, avgGPA, percentA, percentF);
        i++;
      }
    } catch(FileNotFoundException e) {
      System.out.println("file not found");
    }
}
