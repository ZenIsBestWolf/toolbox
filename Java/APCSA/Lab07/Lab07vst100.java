// Lab07vst00.java
// This the Student Starting file for Lab07.
// This file is specifically for the 100-Point version.

import java.util.ArrayList;

public class Lab07vst100
{
   public static void main (String[] args)
   {
      System.out.println("Lab07v100 by Redacted");
      System.out.println();
      int size = 10;
      School bhs = new School(size);
      bhs.addData("Tom", 21, 1.685);
      bhs.addData("Ann", 34, 3.875);
      bhs.addData("Bob", 18, 2.5);
      bhs.addData("Jan", 45, 4.0);
      bhs.addData("Joe", 27, 2.975);
      bhs.addData("Sue", 19, 3.225);
      bhs.addData("Jay", 30, 3.65);
      bhs.addData("Meg", 38, 2.0);
      bhs.addData("Art", 40, 3.999);
      bhs.addData("Deb", 35, 2.125);
      System.out.println(bhs);
      System.out.println(bhs.linearSearch("Meg"));
      System.out.println(bhs.linearSearch("Sid"));
      System.out.println();
      bhs.selectionSort();
      System.out.println(bhs);
      System.out.println(bhs.binarySearch("Jan"));
      System.out.println(bhs.binarySearch("Sid"));
      System.out.println();
   }     
}

class School
{
   private ArrayList<Student> students = new ArrayList<Student>();
   private int size;
   
   public School (int s) {
      size = s;
   }
   public void addData(String name, int age, double gpa) {
      Student tmp = new Student(name, age, gpa);
      students.add(tmp);
   } 
   public void selectionSort () {
      for (int i=0;i<students.size()-1;i++) {
         int min = i;
         for (int j=i+1;j<students.size();j++)
            if (students.get(j).getName().compareTo(students.get(min).getName()) < 0)
               min = j;
         Student tmp = students.get(i);
         students.set(i, students.get(min));
         students.set(min, tmp);
      }
   }
   public int linearSearch (String str) {
       int val = -1;
       for (int i=0;i<students.size();i++) {
           if (students.get(i).getName() == str)
               val = i;
       }
       return val;
   }
   public int binarySearch (String str) {
      boolean isFound = false;
      int min = 0;
      int max = students.size() - 1;
      int mid = (max+min)/2;
      while (!isFound && max>=min) {
         if (max-1 == mid && mid == min)
            break;
         if(students.get(mid).getName().compareTo(str) == 0) {
            isFound = true;
            break;
         }
         else if (students.get(mid).getName().compareTo(str) > 0)
            max = mid;
         else if (students.get(mid).getName().compareTo(str) < 0)
            min = mid;
         mid = (max+min)/2;
      }
      int ret = -1;
      if (isFound)
         ret = mid;
      return ret;
   }
   public String toString() {
      String ret = "";
      for (int i = 0; i < students.size(); i++)
         if (students.get(i) != null)
            ret = ret + students.get(i);
      return ret;
   }
}