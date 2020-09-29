/**
* Class used to hold data for academic classes in the hash table
*/
public class AcademicClass{
    //variables pertaining to each academic class
    private double avgGPA;
    private double percentA;
    private double percentF;
    private String className;

    /**
    * Constructor that sets all data for a new academic class
    */
    public AcademicClass(String className, double gpa, double a, double f) {
        this.avgGPA = gpa;
        this.percentA = a;
        this.percentF = f;
        this.className = className;
    }

    /**
    * getter method for name of the academic class
    */
    public String getClassName() {
        return this.className;
    }
    
    /**
    * getter method for the average GPA of the academic class
    */
    public double getAvgGPA() {
        return this.avgGPA; 
    }

    /**
    * getter method for percent of students who received As in the academic class
    */
    public double getPercentA() {
        return this.percentA;
    }

    /**
    * getter method for percent of students who failed the academic class
    */
    public double getPercentF() {
        return this.percentF;
    }

    /**
    * setter method for name of the academic class
    */
    public void setClassName(String className) {
            this.className = className;
    }

    /**
    * setter method for GPA of the academic class
    */
    public void setAvgGPA(double gpa) {
        this.avgGPA = gpa;
    }

    /**
    * setter method for percent of students who failed in the academic class
    */
    public void setPercentA(double percent) {
        this.percentA = percent;
    }

    /**
    * setter method for the percent of students who failed the academic class
    */
    public void setPercentF(double percent) {
        this.percentF = percent;
    }
}
