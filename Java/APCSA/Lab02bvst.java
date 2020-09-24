// Lab02bvst.java
// The Mortgage Payment Program
// This the student, starting version of the Lab02b assignment.
// Redacted

public class Lab02bvst
{
	public static void main(String[] args)
	{
		System.out.println("Lab02b, Student Version\n");
		double principal  = 250000;
		double annualRate = 4.85;
		double numYears   = 30;
		double months = numYears*12.0;
		double mR = (annualRate/12.0)/100.0;
		double powerBall = Math.pow(mR+1,months);
		double monthlyPayment = (mR*powerBall/(powerBall-1.0))*principal;
		double roundedMonthlyPayment = Math.ceil(monthlyPayment*100)/100;
		System.out.println("Principal:        $" + principal);
		System.out.println("Annual Rate:      " + annualRate + "%");
		System.out.println("Years:            " + numYears);
		System.out.println("Monthly Payment:  $" + roundedMonthlyPayment);
		System.out.println("Total Payment:    $" + roundedMonthlyPayment * months);
		System.out.println("Total Interest:   $" + (roundedMonthlyPayment * months - principal));
	}
}