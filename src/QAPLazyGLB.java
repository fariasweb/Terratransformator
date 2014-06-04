import java.util.LinkedList;
import java.util.Queue;

public class QAPLazyGLB extends QAP{
	
	
	
	private QAPGilmoreLawerBound GLB;
	private int[] asignacionP;
	private int[] asignacionL;
	private double costs[];
	private int nombrenivel; //editable
	private int n;
	
	public QAPLazyGLB(QAPInput qap) throws Exception{
		
		super(qap);
		QAPType = "GilmoreLazy";
	}
	
	
	public void BranchAndBound(int[] va,int[] val, double[] costlevel, int level){

		for(int i = 0; i < n;i++) {
			if(val[i] == 0) {
				va[level] = i+1;
				val[i] = level+1;

			
				
				double minaux = GLB.QAPGLB(input,va, val);
				
			
				
				QAPTNSolucion  spaux = new QAPTNSolucion ();
				spaux.valor(level+1, va, System.nanoTime()-getTime(), minaux);
				tree.addNode(spaux);
				spaux.show();
				
				costlevel[level] = minaux;
				
				//caso de respuesta valida
				if(level == n-2){
					if(costs[n-2] == -1 || minaux < costs[n-2]) {
							Util.CopyVector(costlevel,costs);
							Util.CopyVectors(va,val,asignacionL,asignacionP);
					}
				}
				
				else {
					boolean poda = false;
					if(costs[n-2] == -1) poda = true; 
					else {
						if (nombrenivel == -1 && minaux < costs[n-2]){
							poda = true;
							
						}
						else if(minaux < costs[level]) poda = true;
						else {
							int aux = 1;
							while(aux <= nombrenivel && level+aux < n-2) {
								if(minaux < costs[level+aux]) {
									poda = true;
								}
								aux++;
							}
							if(poda == false) {
								aux = 1;
								while(aux <= nombrenivel && level-aux >= 0) {
									if(minaux < costs[level-aux]) {
										poda = true;
									}
									aux++;
								}
							}
						 }
					}
					
					if(poda == true){
						BranchAndBound(va, val, costlevel, level+1);
					}
				}
				costlevel[level] = 0;
				va[level] = 0;
				val[i] = 0;
			}
			
		}
	}
	
	public void run() throws Exception {
	
		setTime(System.nanoTime());
		
		tree = new QAPBaBTree();
		nombrenivel = input.getnivelparametro();
		
		n = input.getMatrixSize();
		GLB = new QAPGilmoreLawerBound(n);
		
		int[] va = new int[n];
		int[] val = new int[n];
		double[] costlevel = new double[n];
		costs = new double[n];
		asignacionP = new int[n];
		asignacionL = new int[n];
		if(n > 1) {
			costs[n-2] = -1;
			BranchAndBound(va, val, costlevel, 0);
			
		
			//completamos el nodo;
			for (int m = 0; m < n; m++) {
					if(m < n-1) {
						solution[m] = va[m];
					}
					
					if (val[m] == 0) {
						solution[n - 1] = m + 1;
						
					}
				
			}
		}
		setResult(costs[n-2]);
		output = new QAPSolution(this, input.getgalaxy(), input.getpackets());
		
		setTime(System.nanoTime() - getTime());

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
