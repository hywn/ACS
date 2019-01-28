import java.awt.*;

public class BetterRectangle extends Rectangle {

	BetterRectangle (int x, int y, int width, int height) {
		super (x, y, width, height);
	}

	public double getPerimeter () { return 2 * getWidth () + 2 * getHeight (); }

	public double getArea () { return getWidth () * getHeight (); }

}
