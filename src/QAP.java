//ALGORITMOS IRAN AQUI Y EN NINGUN SITIO MAS
public abstract class QAP {
	QAPInput input;
	//QAPSolution output;
	boolean isRun;
	long time; 
	double result; 
	int[] solution;
	String QAPType;

	public QAP(QAPInput qap) throws Exception{
		input = qap;
	}
	
	
	public abstract void run() throws Exception;
	
}
