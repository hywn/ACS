import java.util.Scanner;

public class P7_8 {

	public static char BLANK = '-', NULL = ' ';
	public static int SIZE = 3; // can make bigger up to 9
	public static char[] AXIS_X = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I' }, AXIS_Y = { '1', '2', '3', '4', '5', '6', '7', '8', '9' };

	public static void main (String[] args) {

		char[][] board = new char[SIZE][SIZE];
		for (int i = 0; i < SIZE; i++) for (int j = 0; j < SIZE; j++) board[i][j] = BLANK; // fill board with blanks

		final char[] PLAYERS = { 'X', 'O' }; // can add any number more players
		int turn = 0;
		char winner;

		Scanner scan = new Scanner (System.in);

		while ((winner = getWinner (board)) == NULL) {

			printBoard (board);

			System.out.printf ("Player %c, please enter your mark (e.g. B2): ", PLAYERS[turn]);

			if (!set (board, scan.next ().trim (), PLAYERS[turn])) {

				System.out.println ("You can't move there!");
				continue;

			}

			turn = (turn + 1) % PLAYERS.length;

		}

		System.out.printf ("Player %c has won.%n", winner);
		printBoard (board);

	}

	// returns whether it set correctly
	static boolean set (char[][] board, String coord, char toSet) {

		try {

			if (coord.length () != 2) return false;

			char[] coords = coord.toCharArray ();

			int x = indexOf (AXIS_X, coords[0]);
			int y = indexOf (AXIS_Y, coords[1]);

			if (board[y][x] != BLANK) return false;

			board[y][x] = toSet;

			return true;

		}

		catch (ArrayIndexOutOfBoundsException e) { return false; }

	}

	static int indexOf (char[] array, char val) {

		val = Character.toUpperCase (val);

		for (int i = 0; i < array.length; i++) if (array[i] == val) return i;

		return -1000;

	}

	static final int PADDING = 2;

	static void printBoard (char[][] board) {

		StringBuilder b = new StringBuilder ("\n "); pad (b, PADDING);

		for (int i = 0; i < SIZE; i++) { b.append (AXIS_X[i]); pad (b, PADDING); } // print horiz. axis

		b.append ('\n');

		for (int i = 0; i < SIZE; i++) {

			b.append (AXIS_Y[i]); pad (b, PADDING); // print vert. axis

			for (int j = 0; j < SIZE; j++) { b.append (board[i][j]); pad (b, PADDING); } // print each board space

			b.append ('\n');

		}

		System.out.print (b);

	}

	static void pad (StringBuilder b, int num) { for (int i = 0; i < num; i++) b.append (' '); }

	// a series of SIZE numbers
	static interface Series {
		char get (int n, int i, char[][] board);
	}

	static Series[] tests = { // should work with any-sized board
		(n, i, board) -> (n == 0) ? board[i][i] : board[SIZE - 1 - i][i], // diagonals, will repeat 2 or 3 extra times but oh well
		(n, i, board) -> board[i][n], // horizontals
		(n, i, board) -> board[n][i] // verticals
	};

	static char getWinner (char[][] board) {

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

				if (!lost) return first;

			}

		}

		return NULL;

	}


}
