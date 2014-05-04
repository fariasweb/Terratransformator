
public class QAPController {

	//Referencia a los valores actuales
	private GalaxyController CG;
	private PacketController CP;
	//Private and general
	protected DataController dCont;
	
	//Copias de los valores en el momento de ejecutar la solucion
	private Galaxy g;
	private TST<Packet> p;
	
	//Solucion dada para galaxua g y paquetes p
	private QAPSolution oqap;
	
	//Enum QAPType
	public enum QAPTypeList {
		GilmoreLazy, GilmoreEager
	}

	/**
	 * 
	 * @param galaxyc
	 * @param packetc
	 */
	public QAPController(GalaxyController galaxyc ,PacketController packetc){
		//Referencias a otros controladores
		CG = galaxyc;
		CP = packetc;
		dCont = new DataController();
		 
		//Soluci—n y objetos copiados
		oqap = null;
		g = null;
		p = null;
	}

	// Read
	// ---------------------------------------------
	
	/**
	 * Devuelve un string con todos los valores posibles para
	 * selecionar el tipo de QAP
	 * @return
	 */
	public String getQAPtype() {
		String t = "";

		//Cogemos todos los tipos posibles de QAP
		for(QAPTypeList c: QAPTypeList.values()){
	        t += c.name()+"\n";
		}

		return t;
	}
	
	/**
	 * Comprueba si el elemento se encuentra en en enum
	 * @param n
	 * @return
	 */
	private boolean containsQAPType(String n) {

	    for (QAPTypeList c : QAPTypeList.values()) {
	        if (c.name().equals(n)) {
	            return true;
	        }
	    }

	    return false;
	}
	
	/**
	 * Pre: Debe exisitir una solucion
	 * @return
	 */
	public String getQAPSolution() {
		if (oqap != null)
			return oqap.toString();
		
		return "";
	}
	
	// Create
	// ---------------------------------------------

	public void QAP(String GalaxyName, String QAPType) throws Exception {
		
		//1.Comprobar que la galaxia exista , comprobar que existe numPaquetes > 0
		Galaxy gOriginal = CG.getByName(GalaxyName);
		if (gOriginal == null) throw new Exception("Galaxy does not exist");
		if (gOriginal.getPlanets().size() == 0) throw new Exception("Galaxy must have planets");
		if (CP.size() <= 0 ) throw new Exception("No Packets to Assign");
		
		//2.Comprobar que el tipo de QAP exista
		if (!containsQAPType(QAPType)) 
			throw new Exception("QAP type does Not Exists");
	
		//3. Clonamamos el planeta y TST<Paquete>
		g = CG.cloneGalaxy(gOriginal);		
		p = CP.cloneCollection(); 
		
		//4.Entrada
		QAPInput iqap = new QAPInput(g, p);
		
		//5.Seleccion de algoritmo y ejecucion
		QAP alg;
		
		if (QAPType.equals(QAPTypeList.GilmoreLazy.name())) {
			alg = new QAPLazyGLB(iqap);
		} else if (QAPType.equals(QAPTypeList.GilmoreEager.name())) {
			alg = new QAPEager(iqap);
		} else {
			throw new Exception("QAPType is not defined");
		}
		
		//6.Ejecucion del QAP
		alg.run();
		
		//7.Generar salida
		oqap = new QAPSolution(alg, g, p);
	}
	
	
	// ---------------------------------------------
	// QAP Solution
	// TODO Reasignar paquetes,...
	// ---------------------------------------------
	
	// Update
	// ---------------------------------------------
	
	/**
	 * Pre: Los planetas deben de ser de la galaxia para la cual
	 * se ha generado la solucion.
	 * Los planetas deben de tener un paquete asignado
	 * 
	 * Post: Cambia los paquete de planetas
	 * 
	 * @param PlanetA
	 * @param PlanetB
	 * @throws Exception
	 */
	public void exchangePackets(String PlanetA, String PlanetB) throws Exception {
		if (oqap == null)
			throw new Exception("Any solution created");
		
		Planet p1 = g.getPlanets().get(PlanetA);
		Planet p2 = g.getPlanets().get(PlanetB);
		
		if (p1 == null || p2 == null)
			throw new Exception("The planets must be in the galaxy");
		
		QAPSend s1 = oqap.getSendWithPlanet(p1);
		QAPSend s2 = oqap.getSendWithPlanet(p2);
		
		if (s1 == null || s2 == null)
			throw new Exception("The planets does not have sends");
		
		oqap.swapSends(s1, s2);
		
	}

	// Save&Load
	// ---------------------------------------------
	//TODO
	
}
