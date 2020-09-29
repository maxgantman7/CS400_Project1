// --== CS400 File Header Information ==--
// Name: Aritra Chakraborty
// Email: achakrabor24@wisc.edu
// Team: FD
// TA: Abhay
// Lecturer: Dahl
// Notes to Grader: <optional extra notes>


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


/**
 * Tests all functions of app.
 */
public class TestClassApp {
  // Data Wranglers

    /**
     * Checks if class information like GPA, percentage of As, and percentage
     * of Fs is properly initialized in the class.
     * @return
     */
  public static boolean testConstructor(){ // ECE210 3.97 96.6 0.1
    AcademicClass ECE210 = new AcademicClass("ECE210",3.97, 96.6, .1);
    if(ECE210.getAvgGPA() != 3.97) {
      return false;
    }
    if(ECE210.getAvgGPA() != 3.97) {
      return false;
    }
    if(ECE210.getPercentA() != 96.6) {
      return false;
    }
    if(ECE210.percentF() != .1) {
      return false;
    }

    return true;
  }

  // Reading from text file properly
  public static boolean testReadFile(){
    // If file does not exist
    try {
      FrontEnd.dataWrangler("UWClass.txt");
    } catch (FileNotFoundException e1){
      if(e1.getMessage() == null || !e1.getMessage().equals("File not found!")){
        System.out.println("    FileNotFoundException not working.");
        return false;
      }
    } catch (Exception e2){
      System.out.println("    Another Exception not working.");
      return false;
    }

    // If file does exist
    try {
      FrontEnd.dataWrangler("UWClasses.txt");
    } catch (FileNotFoundException e1){
      if(e1.getMessage() == null || !e1.getMessage().equals("File not found!")){
        System.out.println("    FileNotFoundException not working.");
        return false;
      }
    } catch (Exception e2){
      System.out.println("    Another Exception not working." + e2.getMessage());

      return false;
    }

    return true;
  }


  // Front End

  /**
   *
   * @return
   */
  public static boolean testContainsKey(){
   // HashTableMap classes = new HashTableMap();
   // classes.put("ECE210", new AcademicClass("ECE210",3.97, 96.6, .1));
    try {
      FrontEnd.dataWrangler("UWClasses.txt");
    } catch (FileNotFoundException e){
      System.out.println("File not found!");
    }

    if(!FrontEnd.getMap().containsKey("ECE210")){
      return false;
    }

    if(FrontEnd.getMap().containsKey("CS100")){
      return false;
    }

    return true;
  }

  // BackEnd
  /**
   * Checks if size is correct.
   * @return
   */
  public static boolean testSize(){
    BackEnd classes = new BackEnd();
    classes.put("CS200", new AcademicClass("CS200", 2.5, 90, 10));
    classes.put("CS100", new AcademicClass("CS100", 2.5, 90, 10));
    classes.put("CS300", new AcademicClass("CS300", 2.5, 90, 10));
    classes.put("CS354", new AcademicClass("CS354", 2.5, 90, 10));

    if(classes.size() != 4){
      System.out.println(classes.size());
      return false;
    }

    return true;
  }

  /**
   * Tests if the put method correctly inserts keys and values.
   * @return
   */
  public static boolean testPut() {
    BackEnd classes = new BackEnd();
    classes.put("CS200", new AcademicClass("CS200", 2.5, 90, 10));

    if(!classes.containsKey("CS200")){
      return false;
    }

    return true;
  }

  /**
   *
   * @return
   */
  public static boolean testGet(){
    BackEnd classes = new BackEnd();
    classes.put("CS200", new AcademicClass("CS200", 2.5, 90, 10));
    classes.put("CS100", new AcademicClass("CS100", 2.5, 90, 10));
    classes.put("CS300", new AcademicClass("CS300", 2.5, 90, 10));
    classes.put("CS354", new AcademicClass("CS354", 2.5, 90, 10));

    AcademicClass CS200 = classes.get("CS200");

    if(!CS200.getClassName().equals("Cs200") && CS200.getAvgGPA() != 2.5 && CS200.getPercentA() != 90){
      return false;
    }

    return true;
  }

  /**
   *
   * @return
   */
  public static boolean testRemove(){
    BackEnd classes = new BackEnd();
    classes.put("CS200", new AcademicClass("CS200", 2.5, 90, 10));
    classes.put("CS100", new AcademicClass("CS100", 2.5, 90, 10));
    classes.put("CS300", new AcademicClass("CS300", 2.5, 90, 10));
    classes.put("CS354", new AcademicClass("CS354", 2.5, 90, 10));

    classes.remove("CS200");

    if(classes.containsKey("CS200") && classes.size() != 3){
      return false;
    }

    return true;
  }

  /**
   *
   * @return
   */
  public static boolean testClear(){
    BackEnd classes = new BackEnd();
    classes.put("CS200", new AcademicClass("CS200", 2.5, 90, 10));
    classes.put("CS100", new AcademicClass("CS100", 2.5, 90, 10));
    classes.put("CS300", new AcademicClass("CS300", 2.5, 90, 10));
    classes.put("CS354", new AcademicClass("CS354", 2.5, 90, 10));

    classes.clear();

    if(classes.size() != 0){
      return false;
    }

    return true;
  }

  public static void main(String args[]){
    System.out.println("testConstructor(): "+ testConstructor());
    System.out.println("testContainsKey(): "+ testContainsKey());
    System.out.println("testSize(: "+ testSize());
    System.out.println("testPut(): "+ testPut());
    System.out.println("testGet(): "+ testGet());
    System.out.println("testRemove(): "+ testRemove());
    System.out.println("testClear(): "+ testClear());
    System.out.println("testReadFile(): " + testReadFile());

  }

}
