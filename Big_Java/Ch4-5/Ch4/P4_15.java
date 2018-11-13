public class P4_15 {
	
	static final int CELL_WIDTH = 2,
	                 CELL_HEIGHT = 1,
			 SECTIONS_X = 3,
			 SECTIONS_Y = 3;
			 
	static final String HORIZ_SEP = "+",
	                    HORIZ_FILL = "-",
			    VERT_SEP = "|",
			    VERT_FILL = " ";
			 
	
	public static void main (String[] args) {
	
		final String LINE_HORIZ = separatedLine (HORIZ_SEP, HORIZ_FILL, CELL_WIDTH, SECTIONS_X);
		final String LINE_VERT = separatedLine (VERT_SEP, VERT_FILL, CELL_WIDTH, SECTIONS_X);
		
		StringBuilder b = new StringBuilder ();
		
		appendLine (b, LINE_HORIZ);
		
		for (int i=0; i<SECTIONS_Y; i++) {
		
			for (int j=0; j<CELL_HEIGHT; j++) appendLine (b, LINE_VERT);
			
			appendLine (b, LINE_HORIZ);
		
		}
		
		System.out.print (b.toString ());
	
	}
	
	public static void appendLine (StringBuilder b, final String LINE)
	{
		b.append (LINE);
		b.append (System.lineSeparator ());
	}
	
	public static String separatedLine (final String SEPARATOR,
	                                    final String FILLER,
					    final int CELL_WIDTH,
					    final int NUM_SECTIONS)
	{
		StringBuilder b = new StringBuilder (SEPARATOR);
		
		for (int i=0; i<NUM_SECTIONS; i++)
		{
			for (int j=0; j<CELL_WIDTH; j++) b.append (FILLER);
			b.append (SEPARATOR);
		}
		
		return b.toString ();
	}

}