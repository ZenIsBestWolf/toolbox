// Lab03vst.java
// The Speeding Ticket Program
// This the student starting file for Lab03.
import java.util.Scanner;
public class Lab03vst
{
	public static void main(String[] args)
	{
        System.out.println("Redacted Classmate & Redacted");
		  System.out.println("Lab03, Student Starting Version\n");
        System.out.println("Speeding Ticket Program");
        double postedSpeed,goingSpeed,ticket,speedDifference;
        String isSchoolZone,isWorkZone,wasWorkerHit;
        ticket = 0.0;
        Scanner intKeyboard = new Scanner(System.in);
        Scanner strKeyboard = new Scanner(System.in);
        System.out.print("Enter posted speed limit     ==> ");
        postedSpeed = intKeyboard.nextInt();
        System.out.print("Enter actual driving speed   ==> ");
        goingSpeed = intKeyboard.nextInt();
        speedDifference = goingSpeed - postedSpeed;
        System.out.println("You drove " + speedDifference + " over the speed limit.");
        if (goingSpeed > postedSpeed) {
            ticket+=75.0;
            System.out.println("You will receive a speeding ticket.\nThe minimum ticket is $75.00");
        }
        System.out.println("\nTicket so far: " + ticket + "\n");
        System.out.println("Any driving speed higher than 5 miles over the limit\nadds $10.00 for each mile over the speed limit.");
        if (speedDifference > 5.0) {
            ticket+=(speedDifference*10.0);
        }
        System.out.println("\nTicket so far: " + ticket + "\n");
        System.out.println("Any speeding in a school zone doubles the ticket amount.");
        System.out.print("Did speeding happen in a school zone ==> ");
        isSchoolZone = strKeyboard.nextLine();
        if (isSchoolZone.compareToIgnoreCase("y") == 0) {
            ticket*=2.0;
        }
        System.out.println("\nTicket so far: " + ticket + "\n");
        System.out.println("Any speeding in a work zone doubles the ticket amount.");
        System.out.print("Did speeding happen in a work zone   ==> ");
        isWorkZone = strKeyboard.nextLine();
        if (isWorkZone.compareToIgnoreCase("y") == 0) {
            ticket*=2.0;
        }
        System.out.println("\nTicket so far: " + ticket + "\n");
        System.out.println("Hitting a worker adds $10000.00 to the ticket.");
        System.out.print("Was a worker hit in a work zone ==> ");
        wasWorkerHit = strKeyboard.nextLine();
        if (wasWorkerHit.compareToIgnoreCase("y") == 0) {
            ticket+=10000.0;
        }
        System.out.println("\nTicket so far: " + ticket + "\n");
        System.out.println("Driving more than 80mph is considered reckless.\nThis adds $100.00 for every mile over 80 MPH.");
        if (goingSpeed > 80.0) {
            ticket+=(goingSpeed - 80.0) * 100.0;
        }
        System.out.println("\nYour total ticket is $" + ticket);
   } 
}