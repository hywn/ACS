import java.util.ArrayList;

public class ChoiceQuestion extends Question {

	private ArrayList<String> choices;

	public ChoiceQuestion () { choices = new ArrayList (); }

	public void addChoice (String choice, boolean correct) {

		choices.add (choice);

		if (correct) setAnswer (String.valueOf (choices.size ()));

	}

	public void display () {

		super.display ();

		for (int i = 0; i < choices.size (); i++)
			System.out.printf ("%d: %s%n", i + 1, choices.get (i));

	}

	public String toString () {

		String str = super.toString ();

		for (int i = 0; i < choices.size (); i++)
			str += String.format ("%n%d: %s", i + 1, choices.get (i));

		return str;

	}

}
