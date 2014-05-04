//ALGORITMOS IRAN AQUI Y EN NINGUN SITIO MAS
public abstract class QAP {
	QAPInput input;
	QAPSolution output;
	
	public abstract void convertSolutionSends() throws Exception;
	
	public QAP(QAPInput qap) throws Exception{
		input = qap;
	}
	
	
	public abstract QAPSolution run() throws Exception;
	
	
}
