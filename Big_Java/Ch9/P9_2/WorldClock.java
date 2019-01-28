public class WorldClock extends Clock {

	private int hourOffset;

	public WorldClock (int hourOffset) {
		this.hourOffset = hourOffset;
	}

	public int getHours () {
		int hours = super.getHours ();

		return Math.floorMod (hours + hourOffset, 24);
	}

}