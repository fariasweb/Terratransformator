
public class QAPController {

	private QAPSolution solution;
	private QAP alg;
	private QAPInput input;
	
	public void generateQAPInput(GalaxyController gc, String galaxiName, PacketController pc) {
		//Genera el QAPSolution
	}
	
	public void QAP(String alg_select) {
		
		switch(alg_select) {
		
			case "QAP":
				//alg = new QAP();
			break;
			
			//...
			
			default:
				throw new Exception("Algo exi");
				break;
		
		}
	}
}
