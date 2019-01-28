public class Student extends Person {

	private String major;

	public Student (String name, int yearOfBirth, String major) {
		super (name, yearOfBirth);

		this.major = major;
	}

	public String getMajor () { return major; }

	public String toString () { return super.toString () + String.format (" My major is %s.", major); }

}
