public class Clock {

	public int getHours () {
		return Math.floorMod (
			Integer.valueOf (java.time.Instant.now ().toString ().
				substring (11, 13)) - 5, 24); // EST is GMT -5
	}

	public int getMinutes () {
		return Integer.valueOf (java.time.Instant.now ().toString ()
			.substring (14, 16));
	}

	public String getTime () {
		return pad (getHours ()) + ":" + pad (getMinutes ());
	}

	protected String pad (int num) { return String.format ("%02d", num); }

}