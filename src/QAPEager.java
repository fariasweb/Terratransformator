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
	
	private QAPGilmoreLawerBound GLB;
	
	int n;
	public int NombredeBranch;
	private Comparator<QAPEagerSP> comparator;
	private int[] va;
	private int[] val;
	
	public QAPEager(QAPInput qap) throws Exception {
		super(qap);
		n = input.getMatrixSize();
		QAPType = "GilmoreEager";
		tree = new QAPBaBTree();
		NombredeBranch = input.getnivelparametro();
		GLB = new QAPGilmoreLawerBound(n);
		comparator = new QAPEagerSPcomparator();
		va = new int[n];
		val = new int[n];
	}

	public double BranchAndBound() {
		
		// Redeclaro la cola de vector
		Queue<QAPEagerSP> q = new LinkedList<QAPEagerSP>();

	
		QAPEagerSP sp = new QAPEagerSP(); // el minimo
		
		sp.level = 0;
		sp.min = 0;
		//sp.va = va;
		//sp.val = val;
		
		
		sp.va = new int[n];
		sp.val = new int[n];
		
		
		
		q.offer(sp);
		PriorityQueue<QAPEagerSP> pq = new PriorityQueue<QAPEagerSP>(10, comparator);
		int levelchange = 0;
		while (!q.isEmpty()) {
			QAPEagerSP nodepare = q.element();
			q.remove();
			if (nodepare.level == n - 1) {
				if (sp.level < n - 1 || nodepare.min < sp.min) {
					sp.valor(nodepare.level + 1, nodepare.va, nodepare.val,
							nodepare.min);
				}
			} else {
				double minaux;
				
				for (int i = 0; i < n; i++) {
					if (nodepare.val[i] == 0) {
						nodepare.va[nodepare.level] = i + 1;
						nodepare.val[i] = nodepare.level + 1;

						minaux = GLB.QAPGLB(input,  nodepare.va,
								nodepare.val);
						
						
						QAPTNSolucion  spaux = new QAPTNSolucion ();
						spaux.valor(nodepare.level+1, nodepare.va, System.nanoTime()-getTime(), minaux);
						tree.addNode(spaux);
							
						//mejor que padre  esta parte se reserva!!!!!!
						/*
						if (minaux < nodepare.min) {
							QAPEagerSP nodebuena = new QAPEagerSP();
							nodebuena.valor(nodepare.level + 1, nodepare.va,
									nodepare.val, minaux);
							q.offer(nodebuena);
							 NombredeBranchlevel--;
						}
						else {*/
							QAPEagerSP node = new QAPEagerSP();
							node.valor(nodepare.level + 1, nodepare.va,
									nodepare.val, minaux);
							pq.offer(node);
						//}

						nodepare.val[i] = 0;

					}
				}
				if(q.isEmpty()) {
					levelchange = nodepare.level;
					int NombredeBranchlevel = NombredeBranch;//subirlo
					
					while (!pq.isEmpty() && (NombredeBranchlevel > 0 || NombredeBranchlevel == -1)) {
						q.offer(pq.poll());
						NombredeBranchlevel--;
					}
					pq.clear();
				}
				
			}
		}
		
		
		Util.CopyVectors(sp.va, sp.val, val, va);
		
		return sp.min;

	}
						
	public void run() throws Exception {	
		isRun = true;
		setTime(System.nanoTime());
		//output = new  QAPSolution();
		/*
		//Numero de planetas/paquetes
		int nPackets = input.getSizePackets();
		int nPlanets = input.getSizePlanets();
		
		if(nPackets != nPlanets) throw new Exception("Number of Packets diferent than Number of Planets");
		
		//Matrices de entrada
		int sol1[] = new int[nPackets];
		int sol2[] = new int[nPlanets];
		*/
		//Inicio de tiempo

		setResult(BranchAndBound());

		for (int m = 0; m < n; m++) {
			if(m < n-1) {
				solution[m] = va[m];
			}
			
			if (val[m] == 0) {
				solution[n - 1] = m + 1;
				
			}
		}
		setTime(System.nanoTime() - getTime());
		

		//Algoritmo
		//double d = BranchAndBound(input.getDistanceMatrix(), input.getFlowMatrix(), sol1,sol2);
		/*
		//Fin de ejecucion
		
		//Guardamos los datos de la ejecucion
		isRun = true;
		time = endTime - time;
		result = d;
		solution = sol2;*/

	}

}
