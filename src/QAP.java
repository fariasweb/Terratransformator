/**
 * QAP
 *
 */
public abstract class QAP {
	
	//Clase con las matrices de entrada del QAP
	QAPInput input;

	//Variables de ejecucion
	boolean isRun;

	long time; 
	double result; 
	
	//Solucion generada
	int[] solution;
	
	//Tipo de algoritmo
	protected String QAPType = "QAP";


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
	
	// Run
	// ---------------------------------------------
		
	/**
	 * 
	 * @throws Exception
	 */
	public abstract void run() throws Exception;
	
}
