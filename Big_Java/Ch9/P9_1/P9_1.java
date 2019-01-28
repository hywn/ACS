
public class P9_1 {

	public static void main (String[] args) {

		Clock c = new Clock ();
		WorldClock wc = new WorldClock (-3);

		System.out.println ("Virginia Clock: " + c.getTime ());
		System.out.print ("California WorldClock: " + wc.getTime ());

	}

}
