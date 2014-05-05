import java.util.ArrayList;
import java.util.List;

public class QAPSolution {

	private String QAPType;
	private long executionTime;
	private double efficiency;

	private List<QAPSend> CltSend;

	private QAP qap;
	private Galaxy g;
	private TST<Packet> p;

	/**
	 * Constructora
	 * 
	 * @param qap
	 * @param g
	 * @param p
	 */
	public QAPSolution(QAP qapp, Galaxy gp, TST<Packet> pg) throws Exception {
		qap = qapp;
		g = gp;
		p = pg;

		setQAPInfo(qap);
		CltSend = new ArrayList<QAPSend>();
	}

	private void setQAPInfo(QAP qap) {
		// Informacion como tiempo, typo y eficiencia
		QAPType = qap.getQAPType();
		executionTime = qap.getTime();
		efficiency = qap.getResult();
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
		for (int i = 0; i < solution.length; ++i) {
			Planet auxPlanet = g.getPlanets().get(namePlanets[i]); // Al planeta
																	// i se le
																	// asigna el
																	// paquete
																	// solution[i]
			Packet auxPacket = p.get(namePackets[solution[i] - 1]);

			// Creamos y asignamos el envio
			QAPSend j = new QAPSend(auxPlanet, auxPacket);
			CltSend.add(j);
		}
	}

	/**
	 * A–ade un envio al conjunto de envios
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

	public double getEfficiency() {
		return efficiency;
	}

	public long getExecutionTime() {
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
	public QAPSend getSendWithPlanet(Planet p) throws Exception { // Devuelve
																	// Send que
																	// tenga
																	// paquete =
																	// p;
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

		// Informacion basica
		String r = QAPType + " " + executionTime + " " + efficiency;

		return r;
	}

}
