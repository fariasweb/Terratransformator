import java.util.*;

/**
 * QAPEager
 *
 */
public class QAPEager extends QAP{
	/**
	 * 
	 * @param qap
	 * @throws Exception
	 */
	public QAPEager(QAPInput qap) throws Exception {
		super(qap);
		QAPType = "GilmoreEager";
	}

	public static double BranchAndBound(double[][] d, double[][] f, int[] va,int val[]) {
		int n = d.length;
		// Redeclaro la cola de vector
		Queue<QAPEagerSP> q = new LinkedList<QAPEagerSP>();

		// Hago un push de los vectores de nivel 1

		int vaaux[] = new int[n];
		int valaux[] = new int[n];

		vaaux[0] = 1;
		valaux[0] = 1;

		QAPEagerSP sp = new QAPEagerSP(); // el minimo
		sp.level = 1;
		sp.min = QAPGilmoreLawerBound.QAPGLB(d, f, vaaux, valaux);
		sp.va = new int[n];
		sp.val = new int[n];

		valaux[0] = 0;
		int mini = 0;
		for (int i = 1; i < n; i++) {
			vaaux[0] = i + 1;
			valaux[i] = 1;
			double minaux = QAPGilmoreLawerBound.QAPGLB(d, f, vaaux, valaux);

			if (minaux < sp.min) {
				sp.min = minaux;
				mini = i;
			}
			valaux[i] = 0;
		}

		sp.va[0] = mini + 1;
		sp.val[mini] = 1;

		q.offer(sp);

		while (!q.isEmpty()) {
			QAPEagerSP nodepare = q.element();
			q.remove();
			if (nodepare.level == n - 1) {
				for (int m = 0; m < n; m++) {
					if (nodepare.val[m] == 0) {
						nodepare.va[n - 1] = m + 1;
						nodepare.val[m] = n;
					}
				}

				if (sp.level < n - 1 || nodepare.min < sp.min) {
					sp.valor(nodepare.level + 1, nodepare.va, nodepare.val,
							nodepare.min);
				}
			} else {
				double minaux;
				QAPEagerSP nodepeor = new QAPEagerSP();
				boolean haybuena = false;
				for (int i = 0; i < n; i++) {
					if (nodepare.val[i] == 0) {
						nodepare.va[nodepare.level] = i + 1;
						nodepare.val[i] = nodepare.level + 1;

						minaux = QAPGilmoreLawerBound.QAPGLB(d, f, nodepare.va,
								nodepare.val);

						if (minaux < nodepare.min) {
							haybuena = true;
							QAPEagerSP nodebuena = new QAPEagerSP();

							nodebuena.valor(nodepare.level + 1, nodepare.va,
									nodepare.val, minaux);

							q.offer(nodebuena);

						} else if (nodepeor.level == 0 || minaux < nodepeor.min) {
							nodepeor.valor(nodepare.level + 1, nodepare.va,
									nodepare.val, minaux);

						}
						nodepare.val[i] = 0;

					}
				}
				if (!haybuena) {
					q.offer(nodepeor);

				}
			}
		}

		for (int b = 0; b < n; b++) {
			va[b] = sp.va[b];
			val[b] = sp.val[b];
		}
		return sp.min;

	}

	public void run() throws Exception{	
		//Numero de planetas/paquetes
		int nPackets = input.getSizePackets();
		int nPlanets = input.getSizePlanets();
		
		if(nPackets != nPlanets) throw new Exception("Number of Packets diferent than Number of Planets");
		
		//Matrices de entrada
		int sol1[] = new int[nPackets];
		int sol2[] = new int[nPlanets];
		
		//Inicio de tiempo
		long startTime = System.nanoTime();
		
		//Algoritmo
		double d = BranchAndBound(input.getDistanceMatrix(), input.getFlowMatrix(), sol1,sol2);
		
		//Fin de ejecuci—n
		long endTime = System.nanoTime();
		
		//Guardamos los datos de la ejecuci—n
		isRun = true;
		time = endTime - startTime;
		result = d;
		solution = sol2;
	}
}
