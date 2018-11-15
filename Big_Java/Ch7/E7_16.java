public class E7_16 {

	public static void main (String[] args) {

		int[][] myValues = {
			{ 1, 2, 3, 3, 5 },
			{ 6, 7, 8, 9, 0 },
			{ 1, 2, 3, 4, 5 }
		};

		Table myTable = new Table (0, 0);

		myTable.set (myValues);

		System.out.println (myTable.neighborAverage (0, 4));

	}

	static class Table {
		private int[][] values;

		public Table (int rows, int columns) { values = new int[rows][columns]; }

		public void set (int i, int j, int n) { values[i][j] = n; }

		public void set (int[][] values) { this.values = values; }

		public double neighborAverage (int row, int column) {

			int sum, count;
			sum = count = 0;

			for (int i = -1; i <= 1; i++) {

				for (int j = -1; j <= 1; j++) {

					if (!exists (row + i, column + j)) continue;
					if (i == 0 && j == 0) continue;

					sum += values[row + i][column + j];
					count++;

				}

			}

			return (double) sum / count;

		}

		public boolean exists (int i, int j) { return inRange (i, 0, values.length) && inRange (j, 0, values[0].length); }

		private boolean inRange (int i, int a, int b) { return (a <= i) && (i < b); }
	}

}
