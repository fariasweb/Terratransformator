import java.util.ArrayList;
import java.util.List;


public class QAPSolution{

	private String QAPType;
	private int executionTime;
	private int efficiency;
	
	private List<QAPSend> CltSend;
	

	/**
	 * Constructora
	 * @param qap
	 * @param g
	 * @param p
	 */
	public QAPSolution(QAP qap, Galaxy g, TST<Packet> p){
		setQAPInfo(qap);
		setQAPSend(qap, g, p);
	}
	
	
	private void setQAPInfo(QAP qap) {
		//TODO
		//Informacion como tiempo, typo y eficiencia
		QAPType = "";
		executionTime = 0;
		efficiency = 0;
	}
	
	private void setQAPSend(QAP qap, Galaxy g, TST<Packet> p) {
		//1.Recoger el vector solucion de QAP
		
		//2. Generar los arrays que antes estaban en QAPInput
		//No hace falta guardarlos
		
		//3. Generar los QAPSend y guardamos en CltSend
		//Priemro inicializar CltSeend por si acaso
		CltSend = new ArrayList<QAPSend>();
	}
	
	// Getters
	//---------------------------------------------
	
	public String getQAPType() {
		return QAPType;
	}

	public int getEfficiency() {
		return efficiency;
	}
	
	public int getExecutionTime() {
		return executionTime;
	}
	
	public List<QAPSend> getCltSend() {
		return CltSend;
	}
	
	/**
	 * 
	 * @param p
	 * @return
	 * @throws Exception
	 */
	public QAPSend getSendWithPlanet(Planet p) throws Exception{  // Devuelve Send que tenga paquete = p;
		for(QAPSend i :CltSend){
			if(p == i.getPlanet()) return i;
		}
		throw new Exception("Planet not found");
	}
	
	/**
	 * 
	 * @param p
	 * @return
	 * @throws Exception
	 */
	public QAPSend getSendWithPacket(Packet p) throws Exception{ // Devuelve Send que tenga paquete = p;
		for(QAPSend i :CltSend){
			if(p == i.getPacket()) return i;
		}
		throw new Exception("Packet not found");
	}
	
	/**
	 * 
	 * @param packet
	 * @param planet
	 * @return
	 * @throws Exception
	 */
	public QAPSend getSendWithPacketAndPlanet(Packet packet, Planet planet) throws Exception{
		for(QAPSend i :CltSend){
			if(packet == i.getPacket() && planet== i.getPlanet()) return i;
		}
		throw new Exception("Packet or Planet not found");
	}
	
	/**
	 * 
	 * @return
	 */
	public int size(){
		return CltSend.size();
	}
	
	// Update
	//---------------------------------------------
	
	/**
	 * 
	 * @param s1
	 * @param s2
	 */
	public void swapSends (Send s1, Send s2){
		Packet r = s1.getPacket();
		s1.setPacket(s2.getPacket());
		s2.setPacket(r);
	}
	
	// Deleters
	//---------------------------------------------

	/**
	 * 
	 * @param p
	 */
	public void removePacketSolution(Packet p) throws Exception{
		QAPSend i = getSendWithPacket(p);
		i.setPacket(null);
	}
	
	// To basic
	//---------------------------------------------
	/**
	 * TODO 
	 */
	public String toString() {
		String r = new String();
		for(QAPSend i : CltSend){
			r += i.getPlanet().getName() + " " + i.getPacket().getName();
		}
		return r;	
	}

}
