public class QAPController {

	private GalaxyController CG;
	private PacketController CP;
	private Galaxy g;
	private TST<Packet> p;

	/**
	 * 
	 * @param galaxyc
	 * @param packetc
	 */
	public QAPController(GalaxyController galaxyc ,PacketController packetc){
		//Referencias a otros controladores
		CG = galaxyc;
		CP = packetc;
		 
		//Soluci—n y objetos copiados
		oqap = null;
		g = null;
		p = null;
	}

	// Read
	// ---------------------------------------------

	public Galaxy getGalaxy(){
		return g;
	}
	
	public String getQAPtype() {
		//TODO Devolver un string con los posibles tipo de QAP
		//TODO Devolver elementos de una interface
		return "";
	}
	
	// Create
	// ---------------------------------------------

	public void QAP(String GalaxyName, String QAPType) throws Exception {
		
		//1.Comprobar que la galaxia exista , comprobar que existe numPaquetes > 0
		Galaxy gOriginal = CG.getByName(GalaxyName);
		if(gOriginal == null) throw new Exception("Galaxy does not exist");
		if(CP.size() <= 0 ) throw new Exception("No Packets to Assign");
		
		//2.Comprobar que el tipo de QAP exista
		//TODO: Comprobar con una interface
		if(QAPType != "Gilmore Lazy" && QAPType != "Gilmore Eager" && QAPType !="Taboo Search") throw new Exception("Not Exists");
		
		
		//3. Clonamamos el planeta y TST<Paquete>
		//TODO Hecho asi para continuar, pero se debe clonar
		g = gOriginal; //GC.cloneGalaxy(GalaxyName);
		//p = CP.clone();
		
		//4.Entrada
		QAPInput iqap = new QAPInput(g, p);
		
		//5.Seleccion de algoritmo y ejecucion
		//Falta indicar
		QAP alg;
		switch(QAPType){
			case "Gilmore Lazy":
				alg = new QAPEager(iqap); // Hay que pasarle parametros
				break;
			case "Gilmore Eager":
				alg = new QAPLazyGLB(iqap);	//Hay que pasarle parametros
				break;
			default: 
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

	// Save&Load
	// ---------------------------------------------
	//TODO
	
}
