// Lab06bvst.java
// This is the student starting file of Lab06a.

public class Lab06bvst
{
   public static void main (String[] args)
   {
      System.out.println("Lab06bv100 by Redacted\n");
      int size = 10;
      School bhs = new School(size);
      String[] names = {"R","e","d","a","c","t","e","d","!","!!"};
      int[] ages = {19,23,15,47,27,65,15,19,14,14};
      double[] gpas = {0.4,3.8,4.0,3.0,3.7,2.8,3.9,4.4,3.7,4.0};
      for (int i=0;i<10;i++)
         bhs.addData(names[i], ages[i], gpas[i]);
      System.out.println("Original:\n" + bhs);
      bhs.bubbleSortGPA();
      System.out.println("Bubble Sort by GPA:\n" + bhs);
      bhs.bubbleSortAge();
      System.out.println("Bubble Sort by Age:\n" + bhs);
      bhs.bubbleSortName();
      System.out.println("Bubble Sort by Name:\n" + bhs);
   }     
}

class School
{
   private Student[] students;
   private int size;
   private int used = 0;
   
   public School (int s)
   {
      size = s;
      students = new Student[size];
   }
   
   public void addData(String name, int age, double gpa)
   {
      Student tmp = new Student(name, age, gpa);
      if (used >= size) {
         System.out.println("addData of \"" + name + "\" failed, school is full.");
      } else {
         students[used] = tmp;
         used++;
      }
   }  
   public void bubbleSortGPA() {
      boolean sorted = false;
      while (sorted == false) {
         boolean flip = true;
         for (int i=0;i<students.length-1;i++) {
            if (students[i].getGPA() > students[i+1].getGPA()) {
               Student tmp = students[i];
               students[i] = students[i+1];
               students[i+1] = tmp;
               flip = false;
            }
         }
         if (flip == true)
            sorted = true;
      }
   }
   public void bubbleSortAge() {
      boolean sorted = false;
      while (sorted == false) {
         boolean flip = true;
         for (int i=0;i<students.length-1;i++) {
            if (students[i].getAge() > students[i+1].getAge()) {
               Student tmp = students[i];
               students[i] = students[i+1];
               students[i+1] = tmp;
               flip = false;
            }
         }
         if (flip == true)
            sorted = true;
      }
   }
   public void bubbleSortName() {
      boolean sorted = false;
      while (sorted == false) {
         boolean flip = true;
         for (int i = 0; i < students.length - 1; i++) {
            if (students[i].getName().substring(0,1).compareTo("A") > students[i+1].getName().substring(0,1).compareTo("A")) {
               Student tmp = students[i];
               students[i] = students[i + 1];
               students[i + 1] = tmp;
               flip = false;
            }
         }
         if (flip == true)
            sorted = true;
      }
   }
   public String toString()
   {
      String ret = "";
      for (int i=0;i<students.length;i++)
         if (students[i] != null)
            ret = ret + students[i];
      return ret;
   }
}