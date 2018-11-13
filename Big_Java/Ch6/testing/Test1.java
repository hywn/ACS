import java.util.Scanner;

public class Test1 {

	public static void main (String[] args)
				{

Scanner scan = new Scanner (System.in);

String next = null;

while (!(next = scan.next ()).equals ("END")) {
	
	String nameFirst, nameLast;
	
	nameFirst = next;
	nameLast = scan.next ();

	int sum, count;
	
	sum = count = 0;

	while (!(next = scan.next ()).equals("-1")) {

		sum += Integer.valueOf (next);
		count++;
		
	}

	System.out.printf ("%s %s: %d%n", nameFirst, nameLast, sum / count);

}

				}

}