public class Instructor extends Person {

	private int salaryDollarsPerYear;

	public Instructor (String name, int yearOfBirth, int salaryDollarsPerYear) {
		super (name, yearOfBirth);

		this.salaryDollarsPerYear = salaryDollarsPerYear;
	}

	public int getSalary () { return salaryDollarsPerYear; }

	public String toString () {
		return super.toString () +
			String.format (" I make %s dollars per year.", salaryDollarsPerYear);
	}

}
