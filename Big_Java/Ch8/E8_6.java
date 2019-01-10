import java.util.Scanner;

import static java.lang.Math.PI;

public class E8_6 {

	public static void main (String[] args) {

		Scanner scan = new Scanner (System.in);

		double r, h;

		System.out.print ("Enter r: "); r = scan.nextDouble ();
		System.out.print ("Enter h: "); h = scan.nextDouble ();

		System.out.println ("Volume of cube: " + Geometry.cubeVolume (h));
		System.out.println ("Surface area of cube: " + Geometry.cubeSurface (h));
		System.out.println ("Volume of sphere: " + Geometry.sphereVolume (r));
		System.out.println ("Surface area of sphere: " + Geometry.sphereSurface (r));
		System.out.println ("Volume of cylinder: " + Geometry.cylinderVolume (r, h));
		System.out.println ("Surface area of cylinder: " + Geometry.cylinderSurface (r, h));
		System.out.println ("Volume of cone: " + Geometry.coneVolume (r, h));
		System.out.println ("Surface area of cone: " + Geometry.coneSurface (r, h));

	}

	static class Geometry {

		public static double cubeVolume (double h) { return cube (h); }

		public static double cubeSurface (double h) { return 6 * square (h); }

		public static double sphereVolume (double r) { return (4.0 / 3.0) * PI * cube (r); }

		public static double sphereSurface (double r) { return 4 * PI * square (r); }

		public static double cylinderVolume (double r, double h) { return h * PI * square (r); }

		public static double cylinderSurface (double r, double h) { return 2 * PI * r * h + 2 * PI * square (r); }

		public static double coneVolume (double r, double h) { return PI * square (r) * h / 3; }

		public static double coneSurface (double r, double h) { return PI * r * (r + Math.sqrt (square (h) + square (r))); }

		private static double square (double d) { return Math.pow (d, 2); }

		private static double cube (double d) { return Math.pow (d, 3); }

	}

}
