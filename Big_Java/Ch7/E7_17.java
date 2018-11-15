public class E7_17 {

	public static void main (String[] args) {

		int[][] myValues = {
			{ 1, 2, 3, 3, 5 },
			{ 6, 7, 8, 9, 0 },
			{ 1, 2, 3, 4, 5 }
		};

		Table myTable = new Table (0, 0);

		myTable.set (myValues);

		System.out.println (myTable.sum (1, false));
		System.out.println (myTable.sum (1, true));

	}

	static class Table {
		
		private int[][] values;

		public Table (int rows, int columns) { values = new int[rows][columns]; }

		public void set (int i, int j, int n) { values[i][j] = n; }

		public void set (int[][] values) { this.values = values; }

		public double sum (int i, boolean horizontal) {

			int size = horizontal ? values[0].length : values.length;
			int sum = 0;

			// probably actually not ideal because it has to check horizontal? every single time
			for (int j = 0; j < size; j++) sum += values[horizontal ? i : j][horizontal ? j : i];

			return sum;

		}

	}
}
