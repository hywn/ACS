import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TicTacToe extends JPanel {

	static final int SPACES = 3,
		UNIT = 100,
		PADDING = 15;

	static final Font font = new Font ("Times New Roman", Font.BOLD, UNIT / 4);

	boolean playing;
	String text;
	int currPlayer;

	ShapeDrawer[] players = {

		(g2d, a) -> g2d.drawOval (a.x1, a.y1, a.WIDTH, a.HEIGHT), // nought

		(g2d, a) -> { // cross
			g2d.drawLine (a.x1, a.y1, a.x2, a.y2);
			g2d.drawLine (a.x1, a.y2, a.x2, a.y1);
		}

	};

	Space[][] board;

	Area areaBoard, areaText, areaCurrPlayer, areaBut;

	public TicTacToe () {

		setSize (5 * UNIT, 7 * UNIT);

		areaBoard = Area.xu (1, 4, 1, 4);
		areaText = Area.xu (1, 3, 5, 6);
		areaCurrPlayer = Area.xu (2, 3, 5, 6).getPadded (PADDING);
		areaBut = Area.xu (3, 4, 5, 6);

		restart ();

		addMouseListener (new MouseAdapter () {
			@Override
			public void mousePressed (MouseEvent e) {mousePress (e.getX (), e.getY ());}
		});

	}

	/* logic */

	void restart () {

		text = "turn:";

		board = new Space[SPACES][SPACES];

		int spaceSize = areaBoard.WIDTH / SPACES; // this is kind of a duplicate; should it be dried?

		for (int j = 0; j < SPACES; j++)
			for (int i = 0; i < SPACES; i++) {
				board[j][i] = new Space (Area.xx (areaBoard.x1 + i * spaceSize,
							    areaBoard.x1 + (i + 1) * spaceSize,
							    areaBoard.y1 + j * spaceSize,
							    areaBoard.y1 + (j + 1) * spaceSize));
				board[j][i].value = -1;
			}

		currPlayer = 0;

		playing = true;

		repaint ();

	}

	// user input

	void mousePress (int x, int y) {

		if (areaBut.contains (x, y)) restart ();

		if (!playing) return;

		for (int j = 0; j < SPACES; j++)
			for (int i = 0; i < SPACES; i++) {

				if (!board[j][i].contains (x, y)) continue;
				if (board[j][i].value != -1) return;

				selectSpace (j, i);

			}

	}

	void selectSpace (int j, int i) {

		board[j][i].value = currPlayer;
		repaint ();

		getWinner ();

		currPlayer = (currPlayer + 1) % players.length;

	}

	// winner testing

	interface Series {
		Space getInSeries (int n, int i, Space[][] board);
	}

	static Series[] tests = { // n is semi-constant
		(n, i, board) -> (n == 0) ? board[i][i] : board[SPACES - 1 - i][i], // diagonals, will repeat 2 or 3 extra times but oh well
		(n, i, board) -> board[i][n], // horizontals
		(n, i, board) -> board[n][i] // verticals
	};

	int getWinner () {

		int result;

		for (Series test : tests)
			for (int n = 0; n < SPACES; n++)
				if ((result = getWinner (test, n)) != -1) return result;

		return -1;

	}

	int getWinner (Series test, int n) {

		int first = test.getInSeries (n, 0, board).value;

		if (first == -1) return first;

		for (int i = 0; i < SPACES; i++)
			if (first != test.getInSeries (n, i, board).value) return -1;

		for (int i = 0; i < SPACES; i++)
			test.getInSeries (n, i, board).color = Color.GREEN;

		text = "winner:";
		playing = false;
		currPlayer -= 1; // so that it dispalys correct winner

		return first;

	}

	/* graphics */

	@Override
	public void paint (Graphics g) {

		// maintenance
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor (Color.WHITE);
		g2d.fillRect (0, 0, getWidth (), getHeight ());
		g2d.setColor (Color.BLACK);


		for (int j = 0; j < SPACES; j++)
			for (int i = 0; i < SPACES; i++) {

				Space space = board[j][i];

				if (space.value == -1) continue;

				if (space.color != null) {
					g2d.setColor (space.color);

					shapeSpace.draw (g2d, space);

					g2d.setColor (Color.BLACK);
				}

				players[space.value].draw (g2d, space.getPadded (PADDING));

			}

		shapeBoard.draw (g2d, areaBoard);
		shapeRectangle.draw (g2d, areaText);
		shapeRectangle.draw (g2d, areaBut);

		g2d.setFont (font);

		g2d.drawString ("restart", areaBut.x1, areaBut.y1 + areaBut.HEIGHT / 2);
		g2d.drawString (text, areaText.x1, areaText.y1 + areaText.HEIGHT / 2);

		players[currPlayer].draw (g2d, areaCurrPlayer);

	}

	interface ShapeDrawer {
		void draw (Graphics2D g2d, Area area);
	}

	ShapeDrawer shapeRectangle = (g2d, a) -> g2d.drawRect (a.x1, a.y1, a.WIDTH, a.HEIGHT);
	ShapeDrawer shapeSpace = (g2d, a) -> g2d.fillRect (a.x1, a.y1, a.WIDTH, a.HEIGHT);
	ShapeDrawer shapeBoard = (g2d, a) -> {

		int spaceSize = a.WIDTH / SPACES;

		for (int i = 1; i < SPACES; i++) {

			int x3 = a.x1 + i * spaceSize;
			int y3 = a.y1 + i * spaceSize;

			g2d.drawLine (x3, a.y1, x3, a.y2);
			g2d.drawLine (a.x1, y3, a.x2, y3);

		}

	};

	static class Area {

		final int x1, y1, x2, y2, WIDTH, HEIGHT;

		Area (int x1, int y1, int x2, int y2) {
			this.x1 = x1; this.y1 = y1; this.x2 = x2; this.y2 = y2;
			WIDTH = x2 - x1; HEIGHT = y2 - y1;
		}

		static Area xx (int x1, int x2, int y1, int y2) { return new Area (x1, y1, x2, y2); }
		static Area xu (int x1, int x2, int y1, int y2) { return xx (x1 * UNIT, x2 * UNIT, y1 * UNIT, y2 * UNIT); }

		Area getPadded (int padding) {
			return new Area (x1 + padding, y1 + padding,
				       x2 - padding, y2 - padding);
		}

		boolean contains (int x, int y) { return x1 < x && x < x2 && y1 < y && y < y2; }

	}

	static class Space extends Area {

		Color color;
		int value;

		Space (Area a) { super (a.x1, a.y1, a.x2, a.y2); }

	}

}
