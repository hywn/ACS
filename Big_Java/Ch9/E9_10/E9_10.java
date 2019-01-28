public class E9_10 {

	public static void main (String[] args) {

		Question q = new Question ();
		q.setText ("Who was the inventor of Java?");
		q.setAnswer ("James Gosling");

		System.out.println (q);

		System.out.println ();

		ChoiceQuestion first = new ChoiceQuestion ();
		first.setText ("What was the original name of the Java language?");
		first.addChoice ("*7", false);
		first.addChoice ("Duke", false);
		first.addChoice ("Oak", true);
		first.addChoice ("Gosling", false);

		System.out.println (first);

	}

}
