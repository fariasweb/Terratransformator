
public class AlgorithmThread implements Runnable{
	QAPInputControllerView aux; 
	public AlgorithmThread(QAPInputControllerView qp){
		aux = qp;
	}
	public void run(){
		try{
			Console.print("You are in Algorithm thread: ");
			((QAPController)aux.get_controller()).runQAP();
		}
		catch(Exception t){
			Console.print("E: Executing Thread");
		}
	}
}
