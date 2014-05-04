import java.util.*;

public class QAPGilmoreLawerBound{
	

	public static double QAPGLB(double[][] d, double[][] f, int[] va,
			int[] local) {
		int n = d.length;

		double suma = 0;
		int noasignados = n;
		;

		// step1

		for (int i = 0; i < n; i++) {
			if (va[i] != 0) {
				for (int j = i + 1; j < n; j++) {
					if (va[j] != 0) {
						suma += d[va[i] - 1][va[j] - 1] * f[i][j]
								+ d[va[j] - 1][va[i] - 1] * f[j][i];
					}
				}

				noasignados--;
			}

		}

		if (noasignados != 0) {
			// step2
			double[][] AM1 = new double[noasignados][noasignados];
			int iam = 0;
			for (int z = 0; z < n; z++) {
				if (va[z] == 0) {
					int jam = 0;
					for (int l = 0; l < n; l++) {
						if (local[l] == 0) {
							for (int k = 0; k < n; k++) {
								if (va[k] > 0) {
									AM1[iam][jam] += d[l][va[k] - 1] * f[z][k]
											+ d[va[k] - 1][l] * f[k][z];
								}
							}
							++jam;
						}
					}

					++iam;
				}
			}

			suma += QAPHungarian.Assigment(AM1);

			// step3
			double[][] AM2 = new double[noasignados][noasignados];
			double[][] auxd = new double[noasignados][noasignados - 1];

			int iauxd = 0;
			for (int k = 0; k < n; k++) {
				if (local[k] == 0) {
					double[] auxdv = new double[noasignados - 1];
					int jauxd = 0;
					for (int l = 0; l < k; l++) {
						if (local[l] == 0) {
							auxdv[jauxd] = d[k][l];
							jauxd++;
						}
					}

					for (int l = k + 1; l < n; l++) {
						if (local[l] == 0) {
							auxdv[jauxd] = d[k][l];
							jauxd++;
						}
					}

					Arrays.sort(auxdv);
					int last = noasignados - 2;
					for (int j = 0; j < noasignados - 1; j++) {
						auxd[iauxd][j] = auxdv[last];
						last--;

					}
					iauxd++;
				}
			}


			double[] auxf = new double[noasignados - 1];
			int iam2 = 0;
			for (int i = 0; i < n; i++) {
				if (va[i] == 0) {
					int jam2 = 0;
					for (int j = 0; j < i; j++) {

						if (va[j] == 0) {
							auxf[jam2] = f[i][j];
							jam2++;
						}
					}

					for (int j = i + 1; j < n; j++) {
						if (va[j] == 0) {
							auxf[jam2] = f[i][j];
							jam2++;
						}
					}

					Arrays.sort(auxf);

					for (int j = 0; j < noasignados; j++) {
						double auxAM = 0;

						for (int z = 0; z < noasignados - 1; z++) {
							auxAM += auxf[z] * auxd[j][z];

						}
						;
						AM2[iam2][j] = auxAM;
					}
					++iam2;
				}
			}

			suma += QAPHungarian.Assigment(AM2);

		}

		return suma;
	}
}
