public class QAPLazyGLB extends QAP{

	public QAPLazyGLB(QAPInput qap) throws Exception {
		super(qap);
		// TODO Auto-generated constructor stub
	}

	public static double BranchAndBound(double[][] d, double[][] f, int[] va,int val[], int level) {

		int n = d.length;
		double min = 0;
		// caso base
		if (level >= n - 1) {

			for (int i = 0; i < n; i++) {
				if (val[i] == 0) {
					va[level] = i + 1;
					val[i] = level + 1;
				}
			}
			min = QAPGilmoreLawerBound.QAPGLB(d, f, va, val);
		}
		// caso recursivo
		else {

			// Step 1: hace primero Branch y coge el resulta de Branch como el
			// minimo resultado
			int[] vaaux = new int[n];
			int[] valaux = new int[n];
			int i = 0;

			for (; i < n; i++) {
				if (val[i] == 0) {

					vaaux = Util.CopyVector(va);
					vaaux[level] = i + 1;
					valaux = Util.CopyVector(val);
					valaux[i] = level + 1;
					min = BranchAndBound(d, f, vaaux, valaux, level + 1);
					i++;
					break;
				}
			}

			// Step 2: Miro los restos de los bounds del mismo nivel para saber
			// si hay algun resultado mas pequeno
			boolean masBranch = false;
			int[] valaux2 = new int[n];
			int[] vaaux2 = new int[n];
			vaaux2 = Util.CopyVector(va);
			valaux2 = Util.CopyVector(val);

			for (; i < n; i++) {
				if (val[i] == 0) {

					vaaux2[level] = i + 1;

					valaux2[i] = level + 1;

					double minaux = QAPGilmoreLawerBound.QAPGLB(d, f, vaaux2,
							valaux2);
					if (minaux < min) {
						min = minaux;
						vaaux = Util.CopyVector(vaaux2);
						valaux = Util.CopyVector(valaux2);
						masBranch = true;
					}
					vaaux2[level] = 0;
					valaux2[i] = 0;
				}
			}

			// Step 3: si existe una rama que da resultado mas pequeno hace mas
			// branch
			if (masBranch) {
				if (level == n - 2) {
					for (int m = 0; m < n; m++) {
						if (valaux[m] == 0) {
							vaaux[level + 1] = m + 1;

							valaux[m] = level + 2;
						}
					}

				} else
					min = BranchAndBound(d, f, vaaux, valaux, level + 1);
			}
			for (int b = 0; b < n; b++) {
				va[b] = vaaux[b];
				val[b] = valaux[b];
			}
		}

		return min;

	}
	
	public QAPSolution run() throws Exception {
		int nPackets = input.getSizePackets();
		int nPlanets = input.getSizePlanets();
		if(nPackets != nPlanets) throw new Exception("Number of Packets diferent than Number of Planets");
		int sol1[] = new int[nPackets];
		int sol2[] = new int[nPlanets];
		double d = BranchAndBound(input.getDistanceMatrix(), input.getFlowMatrix(), sol1,sol2,0);
		output.setSolution(sol2);
		output.setResult((int) d);
		output.setPackets(input.getPackets());
		output.setPlanets(input.getPlanets());
		output.setGalaxy(input.getGalaxy());
		output.setQAPType("Gilmore Lazy");
		// TODO Auto-generated method stub
		return output;
	}


	public void convertSolutionSends() throws Exception{
		QAPSolution q = run();
		QAPSend qs = new QAPSend();
		TST<Planet> nameP = input.getGalaxy().getPlanets();
		TST<Packet> namePk = input.getPacket();
		String auxP[] = input.getPlanets();
		String auxPk[] = input.getPackets();
		for(int i = 0; i < q.getSolution().length; ++i ){
			Send s = new Send();
			
			s.setPlanet(nameP.get(auxP[i]));
			s.setPacket(namePk.get(auxPk[i]));
			qs.addSend(s);
		}
		q.setQAPSend(qs);
	}
}
