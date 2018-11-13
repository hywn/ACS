import java.util.Random;

public class E6_22 {

	static Random rand = new Random ();

	public static void main (String[] args) {
		
		final int IT = 1000;
		
		// strategy 1: change answer
		int count1 = 0;
		
		for (int i=0; i < IT; i++) {
		
			Game game = new Game ();
			
			int choice = rand.nextInt (3);
			
			int goat = game.getGoat (choice);
			
			// switch choice
			for (int j=0; j < 3; j++) {
				if (j != choice && j != goat) {
					choice = j;
					break;
				}
			}
			
			if (game.isCorrect (choice)) count1++;
		
		}
		
		// strategy 2: don't change answer
		int count2 = 0;
		
		for (int i=0; i < IT; i++) {
		
			Game game = new Game ();
		
			int choice = rand.nextInt (3);
			
			if (game.isCorrect (choice)) count2++;
		
		}
		
		System.out.printf ("For %d iterations, strategy 1 produced %d wins, and strategy 2 produced %d wins.", IT, count1, count2);
		
	}
	
	static class Game {
	
		int car;
		
		public Game () {
		
			car = rand.nextInt (3);
		
		}
		
		public boolean isCorrect (int choice) { return car == choice; }
		
		// return a goat that isn't equal to choice
		public int getGoat (int choice) {
		
			for (int i=0; i < 3; i++)
				if (i != car && i != choice) return i;
				
			return -1;
			
		}
	
	}

}