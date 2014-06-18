import java.util.ArrayList;
import java.util.List;

public class QAPSolution {

	private String QAPType;
	
	private List<QAPSend> CltSend;
	private Galaxy g;
	private QAP qap;
	private TST<Packet> p;
	
	
	/**
	 * Constructora
	 * 
	 * @param qap
	 * @param g
	 * @param p
	 */
	public QAPSolution(QAP qapp, Galaxy gp, TST<Packet> pg) throws Exception {
		g = gp;
		p = pg;
		qap = qapp;
		CltSend = new ArrayList<QAPSend>();
	}

	public void setQAPInfo(QAP qap) {
		// Informacion como tiempo, typo y eficiencia
		QAPType = qap.getQAPType();
	}
	
	
	public void setQAPSend() throws Exception {
		// 1.Recoger el vector solucion de QAP
		if (!qap.isRun())
			throw new Exception("The QAP has not run yet");
		int[] solution = qap.getSolution();
		// 2. Generar los arrays que antes estaban en QAPInput
		// No hace falta guardarlos
		String[] namePackets = qap.input.getPackets();
		String[] namePlanets = qap.input.getPlanets();
		// 3. Generar los QAPSend y guardamos en CltSend
		// Priemro inicializar CltSeend por si acaso
		CltSend = new ArrayList<QAPSend>();
		Console.print("" + namePackets.length);
		
		if(namePackets.length == namePlanets.length){
			for (int i = 0; i < namePackets.length; ++i) {
				Planet auxPlanet = new Planet();
				Packet auxPacket = new Packet();
				auxPlanet = g.getPlanets().get(namePlanets[i]);
				auxPacket = p.get(namePackets[solution[i]-1]);
			
				QAPSend j = new QAPSend(auxPlanet, auxPacket);
				CltSend.add(j);
			}
		}
		else if(namePackets.length > namePlanets.length){
			for (int i = 0; i < namePackets.length; ++i) {
				Planet auxPlanet = new Planet();
				Packet auxPacket = new Packet();
				if(solution[i] <= namePlanets.length) auxPlanet = g.getPlanets().get(namePlanets[solution[i]-1]);
				auxPacket = p.get(namePackets[i]);
			
				QAPSend j = new QAPSend(auxPlanet, auxPacket);
				CltSend.add(j);
			}
		}
		else{
			for (int i = 0; i < namePlanets.length; ++i) {
				Planet auxPlanet = new Planet();
				Packet auxPacket = new Packet();
				if(solution[i] <= namePackets.length) auxPacket = p.get(namePackets[solution[i]-1]);
				auxPlanet = g.getPlanets().get(namePlanets[i]);
	
				QAPSend j = new QAPSend(auxPlanet, auxPacket);
				CltSend.add(j);
			}
		}
		
		/*for (int i = 0; i < namePackets.length; ++i) {
			Planet auxPlanet = new Planet();
			if(solution[i] <= namePlanets.length){
				Console.print( g.getPlanets().get(namePlanets[i]) + " <- QAPSEnd");
				
				auxPlanet = g.getPlanets().get(namePlanets[i]); 								
			}
			Console.print( p.get(namePackets[i]) + " <- QAPSEnd");
			Packet auxPacket = p.get(namePackets[solution[i]-1]);

			// Creamos y asignamos el envio
			QAPSend j = new QAPSend(auxPlanet, auxPacket);
			CltSend.add(j);
		}*/
	}

	/**
	 * Anade un envio al conjunto de envios
	 * 
	 * @param s
	 */
	public void addSend(QAPSend s) throws Exception{
		CltSend.add(s);
	}

	// Getters
	// ---------------------------------------------

	public String getQAPType() {
		return QAPType;
	}
	/*
	public double getEfficiency() {
		return efficiency;
	}

	public long getExecutionTime() {
		return executionTime;
	}
	*/
	public List<QAPSend> getCltSend() {
		return CltSend;
	}

	/**
	 * 
	 * @param p
	 * @return
	 * @throws Exception
	 */
	public QAPSend getSendWithPlanet(Planet p) throws Exception { 
		for (QAPSend i : CltSend) {
			if (p == i.getPlanet())
				return i;
		}
		throw new Exception("Planet " + p.getName() + " not found");
	}

	/**
	 * 
	 * @return
	 */
	public int size() {
		return CltSend.size();
	}

	// Update
	// ---------------------------------------------

	/**
	 * 
	 * @param s1
	 * @param s2
	 */
	public void swapSends(QAPSend s1, QAPSend s2) {
		Packet r = s1.getPacket();
		s1.setPacket(s2.getPacket());
		s2.setPacket(r);
	}


	// Basic Types
	// ---------------------------------------------
	/**
	 * post: Convierte a String los atributos de un paquete
	 * @return String 
	 */
	public String toString() {
		String r = null;
		for(int i = 0; i < CltSend.size(); ++i){
			r += CltSend.get(i).getPlanet().getName().toString() + " " + CltSend.get(i).getPacket().toString();
		}
		return r;
	}
	
}
