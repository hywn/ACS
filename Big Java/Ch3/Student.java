public class Student {

	private String name;
	private int scoreTotal, numTotal;
	
	public Student (String name) {
	
		this.name = name;
		
		scoreTotal = numTotal = 0;
	
	}
	
	public int getAverageScore () {
	
		if (numTotal == 0) return 0;
	
		return scoreTotal/numTotal;
		
	}
	
	public void addQuiz (int score) { numTotal++; scoreTotal += score; }
	
	public String getName () { return name; }
	
}