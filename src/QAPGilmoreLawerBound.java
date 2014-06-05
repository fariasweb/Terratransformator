import java.util.*;

public class QAPGilmoreLawerBound{
	private QAPHungarian h;
	 QAPGilmoreLawerBound(int n) {
		h =  new QAPHungarian(n);
	 }
	public double QAPGLB(QAPInput qapin,int[] va,
			int[] local) {
		
		int n = qapin.getMatrixSize();

		double suma = 0;
		int noasignados = n;//numero de paquetes que queda para asignar

		// step1 calcular el coste de los paquetes ya asignados
		for (int i = 0; i < n; i++) {
			if (va[i] != 0) {
				for (int j = i + 1; j < n; j++) {
					if (va[j] != 0) {
						suma +=  qapin.getElementDistanceMatrixAtIndex(va[i] - 1,va[j] - 1) * 
								qapin.getElementFlowMatrixAtIndex(i,j)
								
								+  qapin.getElementDistanceMatrixAtIndex(va[j] - 1,va[i] - 1) * 
								qapin.getElementFlowMatrixAtIndex(j,i);
					}
				}

				noasignados--; 
			}

		}

		if (noasignados != 0) { //mientra que queda paquetes para asignar
			// step2 calcular el coste respecto a paquetes no asignados a paquete asignados
			double[][] AM = new double[noasignados][noasignados];
			int iam = 0;
			for (int z = 0; z < n; z++) {
				if (va[z] == 0) { //encuentra un paquete no asignados
					int jam = 0;
					for (int l = 0; l < n; l++) {
						if (local[l] == 0) { //encuentra un planeta vacia
							for (int k = 0; k < n; k++) {
								if (va[k] > 0) { //respecto a paquetes que ya tiene asinacion
									AM[iam][jam] +=  qapin.getElementDistanceMatrixAtIndex(l,va[k] - 1) * 
											qapin.getElementFlowMatrixAtIndex(z,k)
											+  qapin.getElementDistanceMatrixAtIndex(va[k] - 1,l) * 
											qapin.getElementFlowMatrixAtIndex(k,z);
								}
							}
							++jam;
						}
					}

					++iam;
				}
			}


			// step3
			double[][] auxd = new double[noasignados][noasignados - 1]; //aqui se guarda 

			int iauxd = 0;
			for (int k = 0; k < n; k++) {
				if (local[k] == 0) {
					double[] auxdv = new double[noasignados - 1];
					int jauxd = 0;
					for (int l = 0; l < k; l++) {
						if (local[l] == 0) {
							auxdv[jauxd] =  qapin.getElementDistanceMatrixAtIndex(k,l);
							jauxd++;
						}
					}

					for (int l = k + 1; l < n; l++) {
						if (local[l] == 0) {
							auxdv[jauxd] =  qapin.getElementDistanceMatrixAtIndex(k,l);
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
							auxf[jam2] = qapin.getElementFlowMatrixAtIndex(i,j);
							jam2++;
						}
					}

					for (int j = i + 1; j < n; j++) {
						if (va[j] == 0) {
							auxf[jam2] = qapin.getElementFlowMatrixAtIndex(i,j);
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
						AM[iam2][j] += auxAM;
					}
					++iam2;
				}
			}
			suma += h.Assigment(AM);
		}

		return suma;
	}
}
