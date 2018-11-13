public class Person {

	String name, friends;
	
	public Person (String name) {
	
		this.name = name;
		
		friends = "";
	
	}
	
	public void befriend (Person p) {
	
		friends = friends.concat (" ").concat (p.getName ()).trim ();
	
	}
	
	public void unfriend (Person p) {
		
		String[] fList = friends.split (" ");
		
		for (int i=0; i<fList.length;  i++) {
		
			if (fList[i].equals (p.getName ())) fList[i] = "";
		
		}
		
		StringBuilder b = new StringBuilder ();
		
		for (String friend : fList) if (!friend.isEmpty ()) { b.append (' '); b.append (friend); }
		
		friends = b.toString ().trim ();
	
	}
	
	public String getName () { return name; }
	public String getFriendNames () { return friends; }
	
	public int getFriendCount () { return friends.split (" ").length; }

}