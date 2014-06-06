import java.util.LinkedList;
import java.util.Queue;

public class QAPLazyGLB extends QAP{
	
	
	
	private QAPGilmoreLawerBound GLB;
	private int[] asignacionP;
	private int[] asignacionL;
	
	private double[] coststotal;
	private int[] coststotalnumber;
	private double costs;
	
	private int nombrenivel; //editable
	private int n;
	
	private	 double[] costsparcial;
	private int[] costsparcialnumber;
	private int nivelSparcial;

	//int qwe;
	//int ewq;
	//int q;
	
	public QAPLazyGLB(QAPInput qap) throws Exception{

		super(qap);
		tree = new QAPBaBTree();
		nombrenivel = input.getnivelparametro();
		
		n = input.getMatrixSize();
		GLB = new QAPGilmoreLawerBound(n);
		nivelSparcial = 0;
		
		costs = -1;
		asignacionP = new int[n];
		asignacionL = new int[n];
	

		coststotal = new double[n];
		coststotalnumber = new int[n];
		costsparcial = new double[n];
		costsparcialnumber = new int[n];
		
		QAPType = "GilmoreLazy";
	}
	
	
	public void BranchAndBound(int[] va,int[] val, double[] costlevel,int[] costlevelnumber ,int level){
		for(int i = 0; i < n;i++) {
			if(val[i] == 0) {
				va[level] = i+1;
				val[i] = level+1;
				
			
				//qwe++;
				double minaux = GLB.QAPGLB(input,va, val);
				
			
				
				//System.out.print(qwe + " ");
				
				QAPTNSolucion  spaux = new QAPTNSolucion ();
				spaux.valor(level+1, va, System.nanoTime()-getTime(), minaux);
				tree.addNode(spaux);
				//spaux.show();
				
				
				//anadir la media
				costlevel[level] += minaux;
				costlevelnumber[level]++;
				int aux = 1;
				while(aux <= nombrenivel && level+aux < n-2) {
					
					costlevel[level+aux]+= minaux;
					costlevelnumber[level+aux]++;
						
				
					aux++;
				}
				
				aux = 1;
				while(aux <= nombrenivel && level-aux >= 0) {
						costlevel[level-aux]+= minaux;
						costlevelnumber[level-aux]++;
						
						aux++;
				}
				
				
				//Decide con media calculado
				//caso de respuesta valida
				if(level == n-2){
					
					if(costs == -1 || minaux < costs) {
						
						//System.out.println(costs);
							costs = minaux;
							Util.CopyVectors(va,val,asignacionL,asignacionP);
							Util.CopyVectors( costlevel, costlevelnumber, coststotalnumber , coststotal);
							
							//fewfwef
						//	if(n < 0)	Console.WriteVector(coststotal);
						//	if(n < 0)	Console.WriteVector(coststotalnumber);
							//dwfewe
					}
				}
				//caso de repuesta parcial
				else {
					boolean poda = false;
					if(costs == -1) poda = true; 
					else if (nombrenivel == -1 && minaux < costs) poda = true;
					else {
						int nivelaux = level;
						//if(nombrenivel < level)  nivelaux -= nombrenivel;
						if(nivelaux < nivelSparcial) { 
							
								if(costlevel[nivelaux]/costlevelnumber[nivelaux]
										< costsparcial[nivelaux]/costsparcialnumber[nivelaux])
								{
								//	ewq++;
									poda = true;
								}
								
						}
						else if (costlevel[nivelaux]/costlevelnumber[nivelaux] < coststotal[nivelaux]/coststotalnumber[nivelaux]) {
						//	q++;
							poda = true;
						}
					}
					if(poda == true){
					
						BranchAndBound(va, val, costlevel,costlevelnumber, level+1);
					}
					else if(level >= nivelSparcial){
						nivelSparcial = level;
						Util.CopyVectors( costlevel, costlevelnumber ,costsparcialnumber,costsparcial);
						
						//cafaff
					//	if(n < 1)Console.WriteVector(costsparcial);
					//	if(n < 3)Console.WriteVector(costsparcialnumber);
						//fesfef
						
					}
				}
				
				//quita la media
				costlevel[level] -= minaux;
				costlevelnumber[level]--;
				aux = 1;
				while(aux <= nombrenivel && level+aux < n-2) {
					
					costlevel[level+aux] -= minaux;
					costlevelnumber[level+aux]--;
						
				
					aux++;
				}
				
				aux = 1;
				while(aux <= nombrenivel && level-aux >= 0) {
						costlevel[level-aux] -= minaux;
						costlevelnumber[level-aux]--;
						
						aux++;
				}
				
				va[level] = 0;
				val[i] = 0;
			}
			
		}
	}
	
	public void run() throws Exception {
		isRun = true;
		setTime(System.nanoTime());
		
		
		if(n > 1) {
			int[] va = new int[n];
			int[] val = new int[n];
			double[] costlevel = new double[n];
			int[] costlevelnumber = new int[n];
			
			BranchAndBound(va, val, costlevel, costlevelnumber, 0);
		}
		
		gerateSolucion();
		setTime(System.nanoTime() - getTime());
	
	}
	
	
	public void gerateSolucion() throws Exception {

		//completamos el nodo;		
			for (int m = 0; m < n; m++) {
						
						if(m < n-1) {
							solution[m] = asignacionP[m];
						}
						
						if (asignacionL[m] == 0) {
							solution[n - 1] = m + 1;
							
						}
					
				}
			Console.print("GENERATE SOLUTION!!");
			Console.WriteVector(solution);
		setResult(costs);
	
	}
	
	
	/*
	public void run() throws Exception {
		int nPackets = input.getSizePackets();
		int nPlanets = input.getSizePlanets();
		if(nPackets != nPlanets) throw new Exception("Number of Packets diferent than Number of Planets");
		int sol1[] = new int[nPackets];
		int sol2[] = new int[nPlanets];
		long startTime = System.nanoTime();
		double d = BranchAndBound(input.getDistanceMatrix(), input.getFlowMatrix(), sol1,sol2,0); //Se le anade parametro adicional al Eager
		long endTime = System.nanoTime();
		
		time = endTime - startTime;
		result = d;
		solution = sol2;
		isRun = true;
	}*/
}
