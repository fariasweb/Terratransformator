import java.util.*;

public class QAPHungarian {

	public static void Clear(int[] v, int n) {
		for (int i = 0; i < n; i++)
			v[i] = 0;
	}

	public static double result(double[][] cm, int[] a) {
		double r = 0;
		for (int i = 0; i < cm.length; i++) {
			if (a[i] != 0)
				r += cm[i][a[i] - 1];

		}

		return r;
	}

	public static void step4(double[][] cm, int[] r, int[] c, int row, int col) {
		double min = 0;
		int z = 0;
		int y = 0;
		int found = 0;
		for (z = 0; z < row; z++) {
			if (r[z] == 1) {
				for (y = 0; y < col; y++) {
					if (c[y] == 0) {
						min = cm[z][y];
						found = 1;
						break;
					}
				}
			}
			if (found == 1)
				break;
		}

		for (int i = z; i < row; i++) {
			if (r[i] == 1) {
				for (int j = y; j < col; j++) {
					if (c[j] == 0 && cm[i][j] < min) {
						min = cm[i][j];
					}
				}
			}
		}

		for (int i = 0; i < row; i++) {
			if (r[i] == 1) {
				for (int j = 0; j < col; j++) {
					if (c[j] == 0) {
						cm[i][j] -= min;
						if (cm[i][j] < 0)
							cm[i][j] = 0;
					}
				}
			} else {
				for (int j = 0; j < col; j++) {
					if (c[j] == 1) {
						cm[i][j] += min;
					}
				}
			}
		}
	}

	private static int maxmatching(double[][] c, int[] var, int[] vac) {
		QAPmatching m = new QAPmatching();
		List<PairInt> rel = new ArrayList<PairInt>();
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c.length; j++) {
				if (c[i][j] == 0) {
					rel.add(new PairInt(i, j));
				}
			}
		}
		int n = m.runMatching(c.length, c.length, rel);
		int[] auxv = m.getMatchingList();
		for (int i = 0; i < c.length; i++) {
			if (auxv[i] >= 0) {
				var[auxv[i]] = i + 1;
				vac[i] = auxv[i] + 1;
			}

		}

		return n;
	}

	public static double Assigment(double[][] cm) {
		if (cm == null)
			return 0;
		else if (cm.length == 1)
			return cm[0][0];
		else if (cm.length == 2) {
			if (cm[0][0] + cm[1][1] <= cm[0][1] + cm[1][0])
				return cm[0][0] + cm[1][1];
			else
				return cm[0][1] + cm[1][0];
		} else {
			int row = cm.length;
			int col = cm[0].length;
			double[][] c = Util.CopyMatrix(cm);

			int n = 0;
			// step 1
			for (int i = 0; i < row; i++) {
				double min = c[i][0];
				for (int j = 1; j < col; j++) {
					if (c[i][j] < min) {
						min = c[i][j];
					}
				}
				for (int j = 0; j < col; j++) {
					c[i][j] -= min;
				}
			}

			// step 2
			for (int i = 0; i < row; i++) {
				double min = c[0][i];
				for (int j = 1; j < row; j++) {
					if (c[j][i] < min)
						min = c[j][i];
				}
				for (int j = 0; j < col; j++) {
					c[j][i] -= min;
				}
			}

			int[] vac = new int[col];

			int[] var = new int[col];
			n = maxmatching(c, var, vac);
			while (n < row) {

				int[] rowcobber = new int[row];
				int[] colcobber = new int[col];
				// step 3
				for (int i = 0; i < row; i++) {
					if (var[i] == 0) {
						rowcobber[i] = 1;
						for (int j = 0; j < col; j++) {
							if (c[i][j] == 0) {
								colcobber[j] = 1;
								if (vac[j] != 0)
									rowcobber[vac[j] - 1] = 1;
							}
						}
					}
				}
				int repeate = 1;
				while (repeate == 1) {
					repeate = 0;
					for (int i = 0; i < row; i++) {
						if (rowcobber[i] == 1) {
							for (int j = 0; j < col; j++) {

								if (c[i][j] == 0) {
									colcobber[j] = 1;
									if (vac[j] != 0 && rowcobber[vac[j] - 1] == 0) {
										if (vac[j] - 1 < i)
											repeate = 1;
										rowcobber[vac[j] - 1] = 1;
									}
								}
							}
						}
					}
				}
				step4(c, rowcobber, colcobber, row, col);
				vac = new int[col];

				var = new int[col];

				n = maxmatching(c, var, vac);
			}
			return result(cm, var);
		}
	}
}
