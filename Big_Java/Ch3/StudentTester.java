public class StudentTester {

	public static void main (String[] args) {
	
		Student s = new Student ("Thursday");
		
		System.out.println ("Expected: 0"); printS (s);
		
		s.addQuiz (50);
		
		System.out.println ("Expected: 50"); printS (s);
		
		s.addQuiz (100);
		
		System.out.println ("Expected: 75"); printS (s);
		
		
	
	}
	
	public static void printS (Student s) { System.out.printf ("%s %s\n", s.getName (), s.getAverageScore ()); }

}