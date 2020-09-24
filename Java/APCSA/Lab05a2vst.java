// Lab05a2vst.java
// The Rational Class Program II
// This is the student starting version of the Lab05a2 assignment.
import java.util.*;
public class Lab05a2vst {
    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);
        Scanner s2 = new Scanner(System.in);
        Scanner s3 = new Scanner(System.in);
        Scanner s4 = new Scanner(System.in);
        System.out.print("\nEnter the 1st numerator ----> ");
        int num1 = s1.nextInt();
        System.out.print("\nEnter the 1st denominator --> ");
        int den1 = s2.nextInt();
        System.out.print("\nEnter the 2nd numerator ----> ");
        int num2 = s3.nextInt();
        System.out.print("\nEnter the 2nd denominator --> ");
        int den2 = s4.nextInt();
        System.out.println();

        Rational r1 = new Rational(num1, den1);
        Rational r2 = new Rational(num2, den2);
        Rational r3 = new Rational();

        r3.showMultiply(r1, r2); // required for 80-points
        r3.showDivide(r1, r2); // required for 80-points
        r3.showAdd(r1, r2); // required for 100-points
        r3.showSubtract(r1, r2); // required for 100-points
    }
}

class Rational {
    private int num;
    private int den;

    // Required for 80-points
    public Rational() {
        num = 0;
        den = 0;
    }

    // Required for 80-points
    public Rational(int n, int d) {
        num = n;
        den = d;
    }

    // Required for 80-points
    public String getRational() {
        return "" + num + "/" + den;
    }

    // Required for 80-points
    private int getGCF(int n1, int n2) {
        int remainder = 1;
        int gcf = 1;
        while (remainder != 0) {
            remainder = n1 % n2;
            if (remainder == 0) {
                gcf = n2;
            } else {
                n1 = n2;
                n2 = remainder;
            }
        }
        return gcf;
    }

    // Required for 80-points
    public String getReduced(int n, int d) {
        int gcf = getGCF(n, d);
        int rNum = n / gcf;
        int rDen = d / gcf;
        return "" + rNum + "/" + rDen;
    }

    // Required for 80-points
    public void showMultiply(Rational r1, Rational r2) {
        int newN = r1.num * r2.num;
        int newD = r1.den * r2.den;
        System.out.println(r1.getRational() + " * " + r2.getRational() + " = " + getReduced(newN, newD) + "\n");
    }

    // Required for 80-points
    public void showDivide(Rational r1, Rational r2) {
        int newN = r1.num * r2.den;
        int newD = r1.den * r2.num;
        System.out.println(r1.getRational() + " / " + r2.getRational() + " = " + getReduced(newN,newD) + "\n");
    }

    // Required for 100-points
    public void showAdd(Rational r1, Rational r2) {
        int tN1 = r1.num * r2.den;
        int tN2 = r2.num * r1.den;
        int newD = r1.den * r2.den;
        int newN = tN1 + tN2;
        System.out.println(r1.getRational() + " + " + r2.getRational() + " = " + getReduced(newN, newD) + "\n");
    }

    // Required for 100-points
    public void showSubtract(Rational r1, Rational r2) {
        int tN1 = r1.num * r2.den;
        int tN2 = r2.num * r1.den;
        int newD = r1.den * r2.den;
        int newN = tN1 - tN2;
        System.out.println(r1.getRational() + " - " + r2.getRational() + " = " + getReduced(newN, newD) + "\n");
    }

}