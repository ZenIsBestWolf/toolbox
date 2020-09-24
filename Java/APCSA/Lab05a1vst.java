// Lab05a1vst.java
// The Rational Class Program I
// This is the student starting Version of the Lab05a1 assignment.
import java.util.*;
public class Lab05a1vst
{
	public static void main (String[] args)
	{
        Scanner s1 = new Scanner(System.in);
        Scanner s2 = new Scanner(System.in);
        System.out.print("\nEnter the numerator ----> ");
		int num = s1.nextInt();
		System.out.print("\nEnter the denominator --> ");
		int den = s2.nextInt();
		Rational r = new Rational(num,den);
		r.displayData();
	}
}


class Rational
{
	private int num;
	private int den;

   // Complete for 80-Points
	public Rational(int initNum, int initDen) 
	{
        num = initNum;
        den = initDen;
	}

   // Complete for 80-Points
	public double getDecimal() 
   { 
      return (double) num / (double) den;
   }
   
   // Complete for 80-Points
   public String getRational() 
   { 
      return "" + num + "/" + den;
   }

   // Complete for 100-Points
	public String getReduced() 
   {
       int gcf = getGCF(num, den);
       int rNum = num/gcf;
       int rDen = den/gcf;
       return "" + rNum + "/" + rDen;
   }

   // Method for 80-Points; Change for 100-Points
	public void displayData()
	{
		System.out.println();
		System.out.println(getRational() + " equals " + getDecimal());
        System.out.println();
        System.out.println("and reduces to " + getReduced());
	}

   // Complete for 100-Points
	private int getGCF(int n1,int n2)
	{
        int remainder = 1;
        int gcf = 1;
        while (remainder != 0) {
            remainder = n1%n2;
            if (remainder == 0) {
                gcf = n2;
            } else {
                n1 = n2;
                n2 = remainder;
            }
        }
        return gcf;
	}
}