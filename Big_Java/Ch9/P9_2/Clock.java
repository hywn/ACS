public class Clock {

	private int alarmNumber = Integer.MAX_VALUE;
	private boolean alarmDone = false;

	public int getHours () {
		return Math.floorMod (
			Integer.valueOf (java.time.Instant.now ().toString ().
				substring (11, 13)) - 5, 24); // EST is GMT -5
	}

	public int getMinutes () {
		return Integer.valueOf (java.time.Instant.now ().toString ()
			.substring (14, 16));
	}

	public void setAlarm (int hours, int minutes) { // cannot set alarm for tomorrow
		alarmNumber = getAlarmNumber (hours, minutes);
	}

	public String getTime () {
		String str = pad (getHours ()) + ":" + pad (getMinutes ());

		if (!alarmDone && alarmNumber <= getAlarmNumber (getHours (), getMinutes ())) {
			str += " Alarm";
			alarmDone = true;
		}

		return str;
	}

	private int getAlarmNumber (int hours, int minutes) {
		return Integer.valueOf (pad (hours) + pad (minutes));
	}

	protected String pad (int num) { return String.format ("%02d", num); }

}