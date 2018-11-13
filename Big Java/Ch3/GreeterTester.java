public class GreeterTester {

	public static void main (String[] args) {
	
		String myName = "AAAAAAAAAA";
	
		Greeter g = new Greeter (myName);
		
		// expected?
		System.out.println (g.sayHello ()); System.out.printf ("Expected: Hello, %s\n", myName);
		System.out.println (g.sayGoodbye ()); System.out.printf ("Expected: Goodbye, %s\n", myName);
		System.out.println (g.refuseHelp ()); System.out.printf ("Expected: I am sorry, %s. I am afraid I can't do that.\n", myName);
		
	}

}