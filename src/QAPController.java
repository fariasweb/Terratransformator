import java.util.ArrayList;
import java.util.Iterator;

public class QAPController extends AbstractController{

	// Referencia a los valores actuales
	private GalaxyController CG;
	private PacketController CP;
	// Private and general
	protected DataController dCont;

	// Copias de los valores en el momento de ejecutar la solucion
	private Galaxy g;
	private TST<Packet> p;
	private int nivel;
	// Solucion dada para galaxua g y paquetes p
	private QAPSolution oqap;

	// Enum QAPType
	public enum QAPTypeList {
		GilmoreLazy, GilmoreEager
	}

	/**
	 * 
	 * @param galaxyc
	 * @param packetc
	 */
	public QAPController(GalaxyController galaxyc, PacketController packetc) {
		// Referencias a otros controladores
		CG = galaxyc;
		CP = packetc;
		dCont = new DataController();

		// Solucion y objetos copiados
		oqap = null;
		g = null;
		p = null;
	}
	

	
	// Read
	// ---------------------------------------------

	/**
	 * Devuelve un string con todos los valores posibles para selecionar el tipo
	 * de QAP
	 * 
	 * @return
	 */
	public String getQAPtype() {
		String t = "";

		// Cogemos todos los tipos posibles de QAP
		for (QAPTypeList c : QAPTypeList.values()) {
			t += c.name() + "\n";
		}

		return t;
	}

	/**
	 * Comprueba si el elemento se encuentra en en enum
	 * 
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

	public int getNumberGalaxies(){
		return CG.size();
	}

	public String getAllGalaxies(){
		return CG.getAll();
	}
	/**
	 * Pre: Debe exisitir una solucion
	 * 
	 * @return
	 */
	public String getQAPSolution() {
		if (oqap != null)
			return oqap.toString();

		return "";
	}

	/**
	 * Pre: Debe exisitir una solucion
	 * 
	 * @return
	 */
	public String getQAPSolutionSend() {
		if (oqap != null) {
			String r = "";

			// Envios
			for (QAPSend i : oqap.getCltSend()) {
				r += i.getPlanet().getName() + " " + i.getPacket().getName()+ "\n";
			}

			return r;
		}
		return "";
	}

	/**
	 * Pre: Debe exisitir una galaxia
	 * 
	 * @return
	 */
	public String getGalaxy() {
		if (g != null)
			return g.toString();

		return "";
	}

	/**
	 * Pre: Debe exisitir una galaxia
	 * 
	 * @return
	 */
	public String getPackets() {
		if (p != null) {
			String r = "";

			for (Packet i : p.values()) {
				r += i.toString() + "\n";
			}

			return r;
		}

		return "";
	}

	// Create
	// ---------------------------------------------

	public void QAP(String GalaxyName, String QAPType,int nivel) throws Exception {

		// 1.Comprobar que la galaxia exista , comprobar que existe numPaquetes
		// > 0
		Galaxy gOriginal = CG.getByName(GalaxyName);
		if (gOriginal == null)
			throw new Exception("Galaxy does not exist");
		if (gOriginal.getPlanets().size() == 0)
			throw new Exception("Galaxy must have planets");
		if (CP.size() <= 0)
			throw new Exception("No Packets to Assign");

		// 2.Comprobar que el tipo de QAP exista
		if (!containsQAPType(QAPType))
			throw new Exception("QAP type does Not Exists");

		// 3. Clonamamos el planeta y TST<Paquete>
		g = CG.cloneGalaxy(gOriginal);
		p = CP.cloneCollection();

		// 4.Entrada
		QAPInput iqap = new QAPInput(g, p,nivel);

		// 5.Seleccion de algoritmo y ejecucion
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

		// 7.Generar salida
		oqap = new QAPSolution(alg, g, p);
		oqap.setQAPSend();
	}

	// ---------------------------------------------
	// QAP Solution
	// ---------------------------------------------

	// Update
	// ---------------------------------------------

	/**
	 * Pre: Los planetas deben de ser de la galaxia para la cual se ha generado
	 * la solucion. Los planetas deben de tener un paquete asignado
	 * 
	 * Post: Cambia los paquete de planetas
	 * 
	 * @param PlanetA
	 * @param PlanetB
	 * @throws Exception
	 */
	public void exchangePackets(String PlanetA, String PlanetB)
			throws Exception {
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

	/**
	 * Post: Guarda los datos de memoria a archivo
	 * 
	 * @param path
	 * @param append
	 * @throws Exception
	 */
	public void save(String path, boolean append) throws Exception {

		// Guardamos si existen datos
		if (oqap != null) {

			int num;
			String encodeS = "";
			String _last_key = "";

			// Abrimos el archivo
			dCont.open(path, append);

			// 1. Guardamos la galaxia
			PairInt pi = g.getSize();
			dCont.write("G " + g.getName() + " " + pi.getX() + " " + pi.getY());

			// 2. Guardar planetas
			ArrayList<Planet> list;
			num = (int) Math
					.ceil((double) g.getPlanets().size() / (double) 100);

			// Primer elemento
			encodeS = "";
			_last_key = g.getPlanets().first().getName();

			for (int i = 0; i < num; i++) {

				// Codificamos una parte - cache
				list = g.getPlanets().valuesCache(_last_key, 100);

				// Pasamos objetos a cache
				for (Planet p : list) {
					encodeS += "P " + p.toString() + ";";
					_last_key = p.getName();
				}

				// Gaurdamos en disco
				if (encodeS.length() > 0)
					dCont.write(encodeS);

				// Limpiamos el string
				encodeS = "";
			}

			// 3. Guardamos los paquetes
			ArrayList<Packet> listK;
			num = (int) Math.ceil((double) p.size() / (double) 100);

			// Primer elemento
			encodeS = "";
			_last_key = p.first().getName();

			for (int i = 0; i < num; i++) {

				// Codificamos una parte - cache
				listK = p.valuesCache(_last_key, 100);

				// Pasamos objetos a cache
				for (Packet p : listK) {
					encodeS += "K " + p.toString() + ";";
					_last_key = p.getName();
				}

				// Gaurdamos en disco
				if (encodeS.length() > 0)
					dCont.write(encodeS);

				// Limpiamos el string
				encodeS = "";
			}

			// 4. Guardamos la solucion
			dCont.write("S " + oqap.toString());

			// 5. Guardamos los envios
			num = (int) Math.ceil((double) oqap.getCltSend().size() / (double) 100);

			for (int i = 0; i < num; i++) {

				encodeS = "";
				
				// Codificamos una parte - cache
				int j = i * 100;
				while ( j <= ((i+1) * 100) && j < oqap.getCltSend().size()) {
					
					encodeS += "SS " +oqap.getCltSend().get(j).ToString() + ";";
					j += 1;
				}

				// Gaurdamos en disco
				if (encodeS.length() > 0)
					dCont.write(encodeS);

				// Limpiamos el string
				encodeS = "";
			}

			dCont.close();

		} else
			throw new Exception("Is necessary a solution to save");
	}
	
	/**
	 * Pre: El archivo path debe exisitir
	 * Post: Carga los datos del archvio a memoria
	 * @param path
	 * @throws Exception
	 */
	protected void load(String path) throws Exception {

		// Llamar la funcion load de archivo
		dCont.open(path, true);
		
		//Reiniciamos valores
		g = null;
		p = new TST<Packet>();
		oqap = null;

		// Bucle de lectura
		String cache;
		String error = "";
		String[] parseS;
		
		int total = 0;
		
		while ((cache = dCont.read()) != null) {
			parseS = cache.split(";");

			// Descomponemos el objeto
			for (int i = 0; i < parseS.length; i++) {
				//Aumentamos el numero de registros leidos
				total += 1;
				//Lanzamos la decodificacion y carga
				try {
					if (parseS.length == 0)
						throw new Exception("Error in string length");
					
					//Separro por espacios
					String[] s = parseS[i].split(" ");
					
					//Separamos segun el tipo
					if (s[0].equals("G")) { //Galaxia
						if (s.length != 4)
							throw new Exception("The record to galaxy is not correct");
						
						g = new Galaxy(s[1], Integer.parseInt(s[2]), Integer.parseInt(s[3]));
						
					} else if (s[0].equals("P")) { //Planeta
						if (s.length != 4)
							throw new Exception("The record to planet is not correct");
						//Precondiciones
						if (g == null) 
							throw new Exception("Galaxy is not defined");
						
						//Anadimos el planeta
						g.addPlanet(new Planet(s[1], Integer.parseInt(s[2]), Integer.parseInt(s[3])));
						
					} else if (s[0].equals("K")) { //Paquetes
						
						if (s.length != 3)
							throw new Exception("The record to Packets is not correct");
							
							//Cremos el paquete con el totoal de recuross
							Packet k = new Packet(s[1]);
							Resource r = new Resource("Resources", "HUMAN");
							k.addResource(r, Integer.parseInt(s[2]));
							
							p.put(k.getName(), k);

					} else if (s[0].equals("S")) { //Solucion
						
						if (s.length != 5) //HE AUMENTADO EL NUMERO POR EL INT NIVEL
							throw new Exception("The record to QAPsolution is not correct");
						
						//Creamos el input
						QAPInput iqap = new QAPInput(g, p,nivel);
						
						//Creamos el algoritmo
						QAP alg;

						/*if (s[1].equals(QAPTypeList.GilmoreLazy.name())) {
							alg = new QAPLazyGLB(iqap);
						} else if (s[1].equals(QAPTypeList.GilmoreEager.name())) {
							alg = new QAPEager(iqap);
						} else {
							throw new Exception("QAPType is not defined");
						}
						
						//Datos basicos
						alg.setResult(Float.parseFloat(s[2]));
						//alg.setTime();
						alg.setRun(true);*/
						
						//oqap = new QAPSolution(alg ,g, p);
						
					} else if (s[0].equals("SS")) { //Envio

						if (s.length != 3)
							throw new Exception("The record to QAPsolution is not correct");
						if (oqap == null)
							throw new Exception("The QAPSolution is null");
						
						//Cogemos paqiete y planeta
						Planet auxPlanet = g.getPlanets().get(s[1]); //Al planeta i se le asigna el paquete solution[i]
						Packet auxPacket = p.get(s[2]);
						
						if (auxPlanet == null)
							throw new Exception ("The planet does not exist");
						if (auxPacket == null)
							throw new Exception ("The packet does not exist");

						//Asignamos un envio a la solucion
						oqap.addSend(new QAPSend(auxPlanet, auxPacket));
					}
					
				} catch(Exception e) {
					error += "Record "+total+": "+e.getMessage()+"\n";
				}
			}

		}
		
		//Cerrar el archivo
		dCont.close();
		
		//En caso de haber errores en la carga, lanzamos 
		if (error.length() > 0) throw new Exception("Fail to load information\n"+error);
	}


	@Override
	protected void decodeString(String l) throws Exception {
		// TODO Auto-generated method stub
		
	}


	@Override
	protected String encodeString() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int size() {
		return 0;
	}


	@Override
	protected Iterator getIterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
