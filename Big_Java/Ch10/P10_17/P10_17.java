import javax.swing.*;

public class P10_17 {

	public static void main (String args[]) {

		JFrame f = new JFrame ("Tic Tac Toe");

		TicTacToe t = new TicTacToe ();

		f.setSize (t.getSize ());
		f.setContentPane (t);
		f.setResizable (false);
		f.setLocationRelativeTo (null);
		f.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

		f.setVisible (true);

	}

}
