// Student.java
// Used by the Lab06 and Lab07 Assignments.

public class Student
{
   private String name;
   private int age;
   private double gpa;
   
   public Student (String n, int a, double g)
   {
      name = n;
      age = a;
      gpa = g;
   }
   
   public String getName() { return name; }  
   public int getAge()     { return age; }  
   public double getGPA()  { return gpa; }
      
   public String toString()
   {
      String temp = name + "  " + age + "  " + gpa + "\n";
      return temp;
   }
}
      
			

