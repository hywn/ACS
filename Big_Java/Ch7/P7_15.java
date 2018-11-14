import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class P7_15 {

	// example 100 number input:
	// 0 0 1 15 59 74 30 2 57 175 0 2 5 6 5 4 1 18 136 229 10 55 111 125 96 42 10 65 193 236 57 183 234 234 216 160 85 147 227 211 137 243 251 237 229 229 203 218 230 151 192 252 248 186 157 220 240 237 185 68 204 252 239 123 45 124 186 167 81 13 161 241 241 156 32 21 41 36 12 1 95 202 235 186 47 2 34 86 71 20 166 223 234 164 35 3 71 181 149 42

	/* used heightmap from johnflower.org/heightmap/stewart-island */

	// can be increased
	final static int STEPS = 10;

	public static void main (String[] args) throws IOException, InterruptedException {

		double[][] heights;

		/* this asks user for 100 values */
		heights = getTextbookInput ();

		/* these read values from images */
		/* make sure to put the "heightmaps" folder in an Eclipse project's root folder or jGRASP's working folder. alternatively, just change paths to absolute paths. */
		//heights = getPixelArea ("heightmaps/ste.png");
		//heights = getPixelArea ("heightmaps/smi.png");
		//heights = getPixelArea ("heightmaps/med.png");
		//heights = getPixelArea ("heightmaps/big.png");

		Terrain t = new Terrain (heights);

		double stepLevel = Math.ceil (t.getMaxHeight () / (STEPS - 1));

		for (int step = 0; step < STEPS; step++) {

			System.out.println (t.getFloodMap (step * stepLevel));
			Thread.sleep (1000);

		}


	}

	public static class Terrain {

		double[][] heights;

		public Terrain (double[][] heights) { this.heights = heights; }

		public String getFloodMap (double waterLevel) {

			StringBuilder b = new StringBuilder ();

			for (double row[] : heights) {

				for (double val : row) {

					if (waterLevel > val) b.append ("@@");
					else b.append ("  ");

				}

				b.append ('\n');

			}

			return b.toString ();

		}

		public double getMaxHeight () { double max = 0; for (double[] row : heights) for (double val : row) max = Math.max (max, val); return max; }

	}

	public static double[][] getTextbookInput () {

		Scanner scan = new Scanner (System.in);

		System.out.print ("Enter your 100 values: ");

		double[][] heights = new double[10][10];

		for (int row = 0; row < heights.length; row++) for (int col = 0; col < heights[0].length; col++) heights[row][col] = scan.nextDouble ();

		System.out.println ("Input finished");

		return heights;

	}


	// gets heights from 0 to 255 from images
	public static double[][] getPixelArea (String file, int x, int y, int width, int height) throws IOException {

		BufferedImage img = ImageIO.read (Files.newInputStream (Paths.get (file)));

		if (width < 0) width = img.getWidth ();
		if (height < 0) height = img.getHeight ();

		double[][] pixels = new double[width][height];

		for (int i = 0; i < width; i++) for (int j = 0; j < height; j++) pixels[j][i] = img.getRGB (x + i, y + j) & 0xFF;

		return pixels;

	}

	public static double[][] getPixelArea (String file) throws IOException { return getPixelArea (file, 0, 0, -1, -1); }

}
