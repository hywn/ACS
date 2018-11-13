import java.util.Arrays;
public class A {   

	public static void main(String[] args)   {      

double[] values = { 1000, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -1, -2, -3, -4, -5, -6, -7, -8, -9, -10 };

double total = 0;
boolean first = true;
for (double d : values)
{
	total += d;
}

System.out.println (total);

	 } 
}