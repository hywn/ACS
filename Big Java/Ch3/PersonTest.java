public class PersonTest {

	public static void main (String [] args) {
	
		Person joe, sam, alice, thursday;
		
		joe = new Person ("Joe");
		sam = new Person ("Sam");
		alice = new Person ("Alice");
		thursday = new Person ("Thursday");
		
		thursday.befriend (joe);
		thursday.befriend (alice);
		thursday.befriend (sam);
		
		System.out.println (thursday.getFriendNames () + " " + thursday.getFriendCount ());
		
		thursday.unfriend (alice);
		
		System.out.println (thursday.getFriendNames () + " " + thursday.getFriendCount ());
		
		thursday.befriend (alice);
		
		thursday.befriend (new Person ("Alice_Jr."));
		
		System.out.println (thursday.getFriendNames () + " " + thursday.getFriendCount ());
		
	}

}