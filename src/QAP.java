/**
 * QAP
 *
 */
public abstract class QAP {
	
	//Clase con las matrices de entrada del QAP
	QAPInput input;
	QAPSolution output;
	//Variables de ejecucion
	
	private boolean isRun;

	private long time; 
	private double result; 
	
	//Solucion generada
	protected int[] solution;
	//Tipo de algoritmo
	protected String QAPType = "QAP";
	
	
	protected QAPBaBTree tree;
	

	// Constructor
	// ---------------------------------------------
		
	/**
	 * Constructora
	 * @param qap
	 * @throws Exception
	 */
	public QAP(QAPInput qap) throws Exception{
		//Asignamos la entrada del QAP
		input = qap;
		//No ha ejecutado nada el algoritmo
		isRun = false;
		time = 0;
	}
	
	// Getters
	// ---------------------------------------------
		
	/**
	 * Devuelve el tipo de QAP
	 */
	public String getQAPType() {
		return QAPType;
	}
	
	/**
	 * @return the isRun
	 */
	public boolean isRun() {
		return isRun;
	}

	/**
	 * @return the time
	 */
	public long getTime() {
		return time;
	}

	/**
	 * @return the result
	 */
	public double getResult() {
		return result;
	}
	
	/**
	 * @return the solution
	 */
	public int[] getSolution() {
		return solution;
	}
	
	public QAPBaBTree getQAPNode(){
		return tree;
	}
	// Setters
	// ---------------------------------------------
	/**
	 * @param isRun the isRun to set
	 */
	public void setRun(boolean isRunp) {
		isRun = isRunp;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(long timep) {
		time = timep;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(double resultp) {
		result = resultp;
	}

	// Run
	// ---------------------------------------------
			
	/**
	 * 
	 * @throws Exception
	 */
	public abstract void run() throws Exception;
	
}
