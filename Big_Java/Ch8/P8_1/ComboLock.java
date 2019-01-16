public class ComboLock {

	private static final int SIZE = 40;

	private int currTick;
	private int[] secret;
	private int currSecret;
	private boolean[] unlocked;

	public ComboLock (int... secret) {

		this.secret = secret;

		reset ();

	}

	public void reset () {

		unlocked = new boolean[secret.length];

		currTick = currSecret = 0;

	}

	private void turn (int ticks) {

		currTick = Math.floorMod (currTick + ticks, SIZE);

		System.out.println ("Turned to " + currTick);

		if (currTick == secret[currSecret]) {

			unlocked[currSecret++] = true;

			if (currSecret == secret.length) System.out.println ("big click");
			else System.out.println ("click");

		}

	}

	// the modulo checks only allow even (0th, 2nd, etc.) layers to turn left and odd (1st, 3rd, etc.) layers to turn right
	public void turnLeft (int ticks) { if (currSecret % 2 == 1) turn (-ticks); } // turn counter-clockwise
	public void turnRight (int ticks) { if (currSecret % 2 == 0) turn (ticks); } // turn clockwise

	public boolean open () { // isOpen

		for (boolean layerUnlocked : unlocked) if (!layerUnlocked) return false; return true;

	}

}