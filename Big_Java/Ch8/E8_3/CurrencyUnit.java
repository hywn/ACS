class CurrencyUnit {

	private final String name; // this actually won't restrict access from E8_3 since they're technically in the same class
	private final double value;

	CurrencyUnit (String name, double value) { this.name = name; this.value = value; }

	String getName () { return name; } // don't really see why getters are necessary since everything is final
	double getValue () { return value; }

}