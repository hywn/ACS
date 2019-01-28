
public class P9_2 {

	public static void main (String[] args) {

		Clock c = new Clock ();
		WorldClock wc = new WorldClock (-3);

		c.setAlarm (0, 0);

		System.out.println ("Virginia Clock: " + c.getTime ());
		System.out.println ("Virginia Clock (Again): " + c.getTime ());
		System.out.print ("California WorldClock: " + wc.getTime ());

	}

}
