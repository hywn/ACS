public class ComboLock {

	private int[] secret;

	public ComboLock (int... secret) { this.secret = secret; }
	public void reset () {}
	public void turnLeft (int ticks) {}
	public void turnRight (int ticks) {}
	public boolean open () {}
	
}