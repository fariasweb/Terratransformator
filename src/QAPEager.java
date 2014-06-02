import java.util.*;

/**
 * QAPEager
 *
 */
public class QAPEager /*extends QAP*/{
	/**
	 * 
	 * @param qap
	 * @throws Exception
	 */
	
	private QAPGilmoreLawerBound GLB;
	public QAPBaBTree tree;
	public int[] solucion;
	public long time;
	double cost;
	
	public int NombredeBranch;
	private Comparator<QAPEagerSP> comparator;
	
	public QAPEager() {
		tree = new QAPBaBTree();
		NombredeBranch = 1;
		comparator = new QAPEagerSPcomparator();
        
	}
	
	/*
	public QAPEager(QAPInput qap) throws Exception {
		super(qap);
		QAPType = "GilmoreEager";
		
	}*/

	public double BranchAndBound(double[][] d, double[][] f, int[] va,int[] val) {
		
		int n = d.length;
		// Redeclaro la cola de vector
		Queue<QAPEagerSP> q = new LinkedList<QAPEagerSP>();

	
		QAPEagerSP sp = new QAPEagerSP(); // el minimo
		
		sp.level = 0;
		sp.min = 0;
		sp.va = new int[n];
		sp.val = new int[n];
		
		
		
		q.offer(sp);
		PriorityQueue<QAPEagerSP> pq = new PriorityQueue<QAPEagerSP>(NombredeBranch, comparator);
		int levelchange = 0;
		while (!q.isEmpty()) {
			QAPEagerSP nodepare = q.element();
			q.remove();
			if (nodepare.level == n - 1) {
				//este paso de autocompleta se hara fuera
				
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
				
				for (int i = 0; i < n; i++) {
					if (nodepare.val[i] == 0) {
						nodepare.va[nodepare.level] = i + 1;
						nodepare.val[i] = nodepare.level + 1;

						minaux = GLB.QAPGLB(d, f, nodepare.va,
								nodepare.val);
						
						long timaux = System.nanoTime();
						
						timaux = timaux - time;
						QAPTNSolucion  spaux = new QAPTNSolucion ();
						spaux.valor(nodepare.level+1, nodepare.va,
								timaux, minaux);
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
					
					while (!pq.isEmpty() && NombredeBranchlevel > 0) {
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
						
						//se tiene k quitar
	public double run(double[][] d, double[][] f, int[] va,int[] val)// throws Exception {	
	{
		time = System.nanoTime();

		GLB = new QAPGilmoreLawerBound(d.length);
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

		
		double aux =  BranchAndBound( d, f,va,val);

		time = System.nanoTime() - time; 
		return aux;
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
