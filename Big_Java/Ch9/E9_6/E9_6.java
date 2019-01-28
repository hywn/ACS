public class E9_6 {

	public static void main (String[] args) {

		Question q = new Question ();
		q.setText ("Who was the inventor of Java?");
		q.setAnswer ("James Gosling");

		q.display ();

		String response = "JaME s G O SLI              ng";

		System.out.println ("Response: " + response);

		System.out.println (q.checkAnswer (response));

	}

}
