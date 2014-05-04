public class QAPController {

	private GalaxyController CG;
	private PacketController CP;
	private QAPInput iqap;
	private QAP qap;
	private QAPSolution oqap;
	private Galaxy g;
	private String QAPType;
	private String[] planets;
	private String[] packets;

	
	public QAPController(GalaxyController galaxyc ,PacketController packetc){
		CG = galaxyc;
		CP = packetc;
		iqap = null;
		oqap = null;
		g = null;
		qap = null;
	}

	
	public void setGalaxy(String galaxy) throws Exception{
		g = CG.getByName(galaxy);
	}
	
	public void setQAPType(String name){
		QAPType = name;
	}
	
	public Galaxy getGalaxy(){
		return g;
	}
	
	public String getQAPType(){
		return QAPType;
	}
	
	
	
	public void QAP(String GalaxyName) throws Exception {
		
		//1.Comprobar que la galaxia exista , comprobar que existe numPaquetes > 0
		if(g.getPlanets().get(GalaxyName) == null) throw new Exception("Galaxy is not defined");
		if(CP.size() <= 0 ) throw new Exception("No Packets to Assign");
		//2.Comprobar que el tipo de QAP exista
		if(QAPType != "Gilmore Lazy" && QAPType != "Gilmore Eager" && QAPType !="Taboo Search") throw new Exception("Not Exists");
		
		//3.Entrada
		iqap = new QAPInput(g,CP.getAll());
		
		//4.Seleccion de algoritmo y ejecucion
		QAP alg;
		switch(QAPType){
			case "Gilmore Lazy":
				alg = new QAPEager(iqap); // Hay que pasarle parametros
				break;
			case "Gilmore Eager":
				alg = new QAPLazyGLB(iqap);	//Hay que pasarle parametros
				break;
			default: 
				throw new Exception("Not Exists");
		}
		//Ejecucion y salida
		oqap = alg.run();
		
		//Hay que construir la lista de Sends a partir de la salida del algoritm
	}
	
	//FALTA FUNCION DE CLONAR?
	public Galaxy cloneGalaxy(Galaxy g){
		Galaxy g1 = new Galaxy();
		//
		return g1;
		
	}
	
	public Packet clonePacket(Packet p){
		Packet p1 = new Packet();
		p1 = p;
		return p1;
	}
}
