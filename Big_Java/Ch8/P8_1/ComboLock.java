public class ComboLock {

	private int currOrder;
	private int[] secret;
	private boolean[] unlocked;

	public ComboLock (int... secret) {
		this.secret = secret;
		unlocked = new boolean[secret.length];
		currOrder = 0;
	}
	public void reset () {}
	public void turnLeft (int ticks) {}
	public void turnRight (int ticks) {}
	public boolean open () {}

}