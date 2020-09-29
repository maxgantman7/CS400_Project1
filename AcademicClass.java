public class AcademicClass{
private double avgGPA;
private double percentA;
private double percentF;
private String className;


public AcademicClass(String className, double gpa, double a, double f) {
    this.avgGPA = gpa;
    this.percentA = a;
    this.percentF = f;
    this.className = className;
    }

  
    public String getClassName() {
        return this.className;
    }

public double getAvgGPA() {
    return this.avgGPA;
    }

public double getPercentA() {
    return this.percentA;
    }

public double percentF() {
    return this.percentF;
    }

  
public void setClassName(String className) {
        this.className = className;
    }

public void setAvgGPA(double gpa) {
    this.avgGPA = gpa;
    }

public void setPercentA(double percent) {
    this.percentA = percent;
    }

public void setPercentF(double percent) {
    this.percentF = percent;
    }
    }
