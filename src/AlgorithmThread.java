
public class AlgorithmThread implements Runnable{
	QAPInputControllerView aux; 
	
	
	/**
	 * 
	 * @param qp
	 */
	public AlgorithmThread(QAPInputControllerView qp){
		aux = qp;
	}
	
	/**
	 * 
	 */
	public void run(){
		try{
			//Lanzamos el algortimos
			((QAPController)aux.get_controller()).runQAP();
			
			//Indicamos que hemos terminado
			aux.set_stop();

			//Notificamos que ha terminado
			aux.show_success("Algorithm has just finished.");
			
		}
		catch(Exception t){
			aux.show_error(t.getMessage());
		}
	}
}
