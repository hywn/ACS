public class Greeter {

	private String name;
	
	public Greeter (String name) { this.name = name; }

	public String sayHello () { return "Hello, " + name; }
	
	public String sayGoodbye () { return "Goodbye, " + name; }
	
	public String refuseHelp () { return String.format ("I am sorry, %s. I am afraid I can't do that.", name); }

}