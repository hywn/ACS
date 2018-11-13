import java.util.Scanner;

public class E5_16 {

	// final is useless
	public static final Grade[] GRADES = {
	
		new Grade ("A+", 4+0.3),
		new Grade ("A",  4+0.0),
		new Grade ("A-", 4-0.3),
		new Grade ("B+", 3+0.3),
		new Grade ("B",  3+0.0),
		new Grade ("B-", 3-0.3),
		new Grade ("C+", 2+0.3),
		new Grade ("C",  2+0.0),
		new Grade ("C-", 2-0.3),
		new Grade ("D+", 1+0.3),
		new Grade ("D",  1+0.0),
		new Grade ("D-", 1-0.3),
		new Grade ("F",  0+0.0),
		
	};

	public static void main (String[] args) {
	
		Scanner scan = new Scanner (System.in);
		
		System.out.print ("Enter a letter grade: ");
		
		String letter = scan.next ();
		
		for (Grade g : GRADES) {
		
			if (g.getLetterGrade ().equals (letter)) {
				
				System.out.printf ("The numeric value is %s.%n", g.getNumericGrade ());
				return;
				
			}
		
		}
		
		System.out.println ("There is no corresponding numeric value.");
	
	}
	
	public static class Grade {

		private String letter;
		private double number;
		
		public Grade (String letter, double number) { this.letter = letter; this.number = number; }
	
		public String getLetterGrade () { return letter; }
		public double getNumericGrade () { return number; }
	
	}

}