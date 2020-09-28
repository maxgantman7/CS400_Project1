
public class AcademicClass.java {
  private double avgGPA;
  private double percentA;
  private double percentF;
  
  //TODO: write constructor
  public AcademicClass() {
    // avgGPA = 0.0;
    // percentA = 0.0;
    // percentF = 0.0;
  }
  
  // Needs to include class name as a parameter
  public AcademicClass(double gpa, double a, double f) {
    	avgGPA = gpa;
    	percentA = a;
    	percentF = f;
  }
  
  // Needs to include set ad get class name
  
  protected double getAvgGPA() {
    return avgGPA;
  }
  
  protected double getPercentA() {
    return percentA;
  }
  
  protected double percentF() {
    return percentF();
  }
  
  protected void setAvgGPA(double gpa) {
    avgGPA = gpa;
  }
  
  protected void setPercentA(double percent) {
    percentA = percent;
  }
  
  protected void setPercentF(double percent) {
    percentF = percent;
  }
}
