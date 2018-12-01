import java.util.Scanner;

public class P7_8 {

	// TODO: cannot mark over other player
	// TODO: coord validation

	public static char BLANK = '-';
	public static int SIZE = 3;
	public static char[] AXIS_X = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' },
		AXIS_Y = { '1', '2', '3', '4', '5', '6', '7' };

	public static void main (String[] args) {

		char[][] board = new char[SIZE][SIZE];

		for (int i = 0; i < SIZE; i++) for (int j = 0; j < SIZE; j++) board[i][j] = '-';

		final char[] PLAYERS = { 'O', 'X' };
		int turn = 0;

		char winner;

		Scanner scan = new Scanner (System.in);

		while ((winner = getWinner (board)) == ' ') {

			printBoard (board);

			System.out.printf ("Player %c, please enter your mark (e.g. B2): ", PLAYERS[turn]);

			String coord = scan.next ();

			coord = coord.trim ();

			if (coord.length () != 2) { System.out.println ("Improper input, try again."); continue; }

			set (board, coord, PLAYERS[turn]);

			turn = (turn + 1) % PLAYERS.length;

		}

		System.out.printf ("Player %c has won.%n", winner);

		printBoard (board);


	}

	// a series of SIZE numbers
	static interface Series {
		char get (int n, int i, char[][] board);
	}

	static Series[] tests = {
		(n, i, board) -> (n == 0) ? board[i][i] : board[SIZE - 1 - i][i], // diagonals, will repeat 2 or 3 extra times but oh well
		(n, i, board) -> board[i][n], // horizontals
		(n, i, board) -> board[n][i] // verticals
	};

	public static void set (char[][] board, String coord, char toSet) {

		char[] coords = coord.toCharArray ();

		int x = indexOf (AXIS_X, coords[0]), y = indexOf (AXIS_Y, coords[1]);

		board[y][x] = toSet;

	}

	public static int indexOf (char[] array, char val) {

		val = Character.toUpperCase (val);

		for (int i = 0; i < array.length; i++) if (array[i] == val) return i;

		return -1000;

	}

	public static void printBoard (char[][] board) {

		StringBuilder b = new StringBuilder ();

		b.append (' ');

		for (int i = 0; i < SIZE; i++) b.append (AXIS_X[i]);

		b.append ('\n');

		for (int i = 0; i < SIZE; i++) {

			b.append (AXIS_Y[i]);

			for (int j = 0; j < SIZE; j++) {

				b.append (board[i][j]);

			}

			b.append ('\n');

		}

		System.out.print (b);

	}

	public static char getWinner (char[][] board) {

		for (Series test : tests) {

			nTest:
			for (int n = 0; n < SIZE; n++) {

				boolean lost = false;

				char first = test.get (n, 0, board);

				for (int i = 1; i < SIZE; i++) {

					char c = test.get (n, i, board);

					if (c == BLANK) continue nTest;

					if (c != first) lost = true;

				}

				System.out.println (first);

				if (!lost) return first;

			}

		}

		return ' ';

	}


}