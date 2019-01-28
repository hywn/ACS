public class E9_11 {

	public static void main (String[] args) {

		Person bob = new Person ("Bob", 2000);
		Student bobStudent = new Student ("BobStudent", 2001, "English");
		Instructor bobInstructor = new Instructor ("BobInstructor", 2002, 92000);

		test (bob, "Hi! My name is Bob, and I was born in 2000.");
		test (bobStudent, "Hi! My name is BobStudent, and I was born in 2001. My major is English.");
		test (bobInstructor, "Hi! My name is BobInstructor, and I was born in 2002. I make 92000 dollars per year.");

	}

	public static void test (Object obj, String expected) {

		System.out.println (obj);
		System.out.println ("Expected: " + expected);
		System.out.println ("Match: " + obj.toString ().equals (expected));
		System.out.println ();

	}

}
