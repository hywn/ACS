import java.util.Scanner;

public class P5_1 {

	public static String[][] HOROSCOPES = {
		{"Aries", "21/3", "20/4", "Your code is very beautiful."},
		{"Taurus", "21/4", "21/5", "Your formatting skills are off the charts!"},
		{"Gemini", "22/5", "21/6", "Your work earns the respect of others."},
		{"Cancer", "22/6", "22/7", "You are very logic-oriented."},
		{"Leo", "23/7", "22/8", "Others praise your work."},
		{"Virgo", "23/8", "23/9", "Your work has great value."},
		{"Libra", "24/9", "23/10", "Your work is has great impact on its users."},
		{"Scorpio", "24/10", "22/11", "Your work will soon find greatness."},
		{"Sagittarius", "23/11", "21/12", "You are a great person, and your work reflects this."},
		{"Capricorn", "22/12", "20/1", "Your pseudocode is complex yet elegant."},
		{"Aquarius", "21/1", "19/2", "The programs that you design impress the best."},
		{"Pisces", "20/2", "20/3", "Your programs work very well."},
	};
	
	public static final int START=1, END=2;
	
	// very bad and not good
	public static int[] fetchDate (int index, int startEnd) {
		
		int[] date = new int[2];
		String[] parts = HOROSCOPES[index][startEnd].split("/");
		for (int i=0; i<2; i++) date[i] = Integer.parseInt (parts[i]);
		return date;
	
	}
	
	public static void main (String[] args) {
	
		Scanner scan = new Scanner (System.in);
	
		System.out.print ("Please enter your birthday (month and day): ");
	
		int month = scan.nextInt ();
		int day = scan.nextInt ();
		
		for (int i=0; i<HOROSCOPES.length; i++) {
		
			int[] startDate = fetchDate (i, START);
			int[] endDate = fetchDate (i, END);
			
			// this only works because all periods start in one month and end in the next
			if ((month == startDate[1] && day >= startDate[0]) // after start
				|| (month == endDate[1] && day <= endDate[0])) { // before end
		
				System.out.println (HOROSCOPES[i][0] + " - " + HOROSCOPES[i][3]);
				return;
		
			}
		
		}
		
		System.out.println ("Could not find horoscope ):");
	
	}

}