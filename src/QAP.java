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
	String QAPType = "QAP";

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
	
	/**
	 * 
	 * @throws Exception
	 */
	public abstract void run() throws Exception;
	
}
