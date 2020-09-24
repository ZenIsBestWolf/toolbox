public class Lab03v100 {
	public static void main(String[] args) {
		System.out.println("Lab03, 100 Point Version\n");
		int ms = 10000123;
		int hours = ms/3600000;
		int minutes = (ms%360000)/60000;
		int seconds = ((ms%360000)%60000)/1000;
		int remainingMS = ((ms%360000)%60000)%1000;
		System.out.println("Given Milliseconds:      " + ms);
		System.out.println("Hours:                   " + hours);
		System.out.println("Minutes:                 " + minutes);
		System.out.println("Seconds:                 " + seconds);
		System.out.println("Remaining Milliseconds:  " + remainingMS);
	}
}