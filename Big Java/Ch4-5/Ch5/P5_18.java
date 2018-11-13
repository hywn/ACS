public class P5_18 {

	public static double P_NAUT = 20E-6;
	
	private static int[] levels = { 10000, 130, 120, 100, 90, 60, 30, 0, -10000 };
	
	public static void main (String[] args) {
	
		double db = -100;
		
		int LEVEL = -1;
		
		double lastDistance = Integer.MAX_VALUE;
		
		for (int i=0; i<levels.length; i++) {
		
			double currDistance = Math.abs (levels[i] - db);
			
			if (lastDistance < currDistance) {
			
				LEVEL = i-1;
				break;
			
			}
			
			lastDistance = currDistance;
		
		}
		
		System.out.println (levels[LEVEL]);
	
	}
	
	// Pa to dB
	public static double toDecibels (double p) {
	
		return 20 * Math.log10 (p/P_NAUT);
	
	}

}