public class Question {

	private String text, answer;

	public Question (String text, String answer) { setText (text); setAnswer (answer); }
	public Question () { this ("", ""); }

	public void setText (String text) { this.text = text; }
	public void setAnswer (String answer) { this.answer = answer;}

	public boolean checkAnswer (String response) { return response.equals (answer); }

	public void display () { System.out.println (text); }

	public String toString () {

		return text;

	}

}
