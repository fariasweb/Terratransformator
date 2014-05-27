import java.util.Scanner;

class QAPInputDriver extends AbstractDriver{ 

	public static void main(String args[]) throws Exception{
		
		//Generico del driver
		Planet planet = new Planet();
		Packet packet = new Packet();
		Galaxy galaxy = new Galaxy();
		Resource resource = new Resource();
		TST<Packet> packets = new TST<Packet>(); 
		QAPInput q = new QAPInput(galaxy,packets);
		//Generico del menu
		Scanner in = new Scanner(System.in);
		int opc = 0;
		String argv[];		
		
		//Menu
		_menu();
		
		do {
			argv = Console.read_line(in);
			
			if (argv == null) opc = 0;
			else if (argv.length > 0){
				opc = Integer.parseInt(argv[0]);
				switch (opc){
				case 0:
					break;
				case 1:
					if (argv.length < 1)
						_msg_error_param_insuf();
					else {
						q = new QAPInput(galaxy,packets);
					}
					break;
				case 2:
					if (argv.length < 4)
						_msg_error_param_insuf();
					else {
						planet = PlanetDriver.create_planet(argv[1],Integer.parseInt(argv[2]),Integer.parseInt(argv[3]));
					}
					break;
				case 3:
					if (argv.length < 2)
						_msg_error_param_insuf();
					else {
						packet = PacketDriver.create_packet_full(argv[1]);
			

					}
					break;
				case 4:
					if (argv.length < 4)
						_msg_error_param_insuf();
					else {
						galaxy = GalaxyDriver.create_galaxy_full(argv[1],Integer.parseInt(argv[2]),Integer.parseInt(argv[3]));
					}
					break;
				case 5:
					if (argv.length < 2)
						_msg_error_param_insuf();
					else {
						resource = ResourceDriver.create_resource(argv[1],argv[2]);
					}
					break;

				case 6:
					if (argv.length < 1)
						_msg_error_param_insuf();
					else {
						GalaxyDriver.add_planet_to_galaxy(galaxy, planet);

					}
					break;
				case 7:
					if (argv.length < 1)
						_msg_error_param_insuf();
					else {
						PacketTSTDriver.add_packet_to_TST(packets,packet);
					}
					break;
				case 8:
					if (argv.length < 2)
						_msg_error_param_insuf();
					else {
						PacketDriver.set_resource_to_a_packet(packet,resource, Integer.parseInt(argv[1])); // ME FALLA ESTO
					}
					break;
				case 9:
					if (argv.length < 1)
						_msg_error_param_insuf();
					else {
						setDistanceMatrix(q,galaxy);
					}
					break;
				case 10:
					if (argv.length < 1)
						_msg_error_param_insuf();
					else {
						setFlowMatrix(q,packets);
					}
					break;
				case 11:
					if (argv.length < 1)
						_msg_error_param_insuf();
					else {
						setVectorPackets(q,packets);
					}
					break;
				case 12:
					if (argv.length < 1)
						_msg_error_param_insuf();
					else {
						setVectorPlanets(q,galaxy);
					}
					break;
				
				case 13:
					if (argv.length < 4)
						_msg_error_param_insuf();
					else {
						setElementDistanceMatrix(q, Double.parseDouble(argv[1]),Integer.parseInt(argv[2]), Integer.parseInt(argv[3]));					
					}
					break;
				
				case 14:
					if (argv.length < 4)
						_msg_error_param_insuf();
					else {
						setElementFlowMatrix(q, Double.parseDouble(argv[1]),Integer.parseInt(argv[2]), Integer.parseInt(argv[3]));					
					}
					break;
				
				case 15:
					Console.print(q.getElementDistanceMatrixAtIndex(Integer.parseInt(argv[1]), Integer.parseInt(argv[2])) + "");					
					break;
				
				case 16:
					Console.print(q.getElementFlowMatrixAtIndex(Integer.parseInt(argv[1]), Integer.parseInt(argv[2])) + "");					
					break;
				case 17:
					String[] auxPlanets = q.getPlanets();
					for(int i = 0; i < auxPlanets.length; ++i){
						Console.print(auxPlanets[i] + "");
					}				
					break;
				case 18:
					String[] auxPackets = q.getPackets();
					for(int i = 0; i < auxPackets.length; ++i){
						Console.print(auxPackets[i] + "");
					}				
					break;
				case 19:
					Console.print(q.getSizePlanets() + "");
					break;
				case 20:
					Console.print(q.getSizePackets() +  "");
					break;
				}
			}
		}while(opc != 0);
	}
	
	/**
	 * 
	 * @param q
	 * @param g
	 */
	public static void setDistanceMatrix(QAPInput q, Galaxy g) {
		try {
			q.setDistanceMatrix(g);

		} catch (Exception e) {
			_msg_error(e.getMessage());
		}
	}

	/**
	 * 
	 * @param packets
	 */
	public static void setFlowMatrix(QAPInput q, TST<Packet> packets) {
		try {
			q.setFlowMatrix(packets);

		} catch (Exception e) {
			_msg_error(e.getMessage());
		}
	}

	/**
	 * 
	 * @param q
	 * @param p
	 */
	public static void setVectorPackets(QAPInput q, TST<Packet> p){
		try {
			q.setVectorPackets(p);

		} catch (Exception e) {
			_msg_error(e.getMessage());
		}
	}

	/**
	 * 
	 * @param q
	 * @param g
	 */
	public static void setVectorPlanets(QAPInput q, Galaxy g){
		try {
			q.setVectorPlanets(g);

		} catch (Exception e) {
			_msg_error(e.getMessage());
		}
	}
	
	/**
	 * 
	 * @param q
	 * @param value
	 * @param i
	 * @param j
	 */
	public static void setElementDistanceMatrix(QAPInput q, double value, int i , int j){
		try {
			q.setElementDistanceMatrix(value,i,j);
			q.setElementDistanceMatrix(value,j,i);

		} catch (Exception e) {
			_msg_error(e.getMessage());
		}
	}

	/**
	 * 
	 * @param q
	 * @param value
	 * @param i
	 * @param j
	 */
	public static void setElementFlowMatrix(QAPInput q, double value, int i , int j){
		try {
			q.setElementFlowMatrix(value,i,j);
			q.setElementFlowMatrix(value,j,i);

		} catch (Exception e) {
			_msg_error(e.getMessage());
		}
	}
	
	/**
	 * 
	 * @param p
	 * @param packet
	 */
	public static void put(TST<Packet> p, Packet packet){
		try {
			p.put(packet.getName(), packet);
		} catch (Exception e) {
			_msg_error(e.getMessage());
		}
	}
	
	// Menu
	// ---------------------------------------------

	private static void _menu(){
		title = "QAPInput Driver";
		
		menu.add("QAPInput(Galaxy galaxy, TST<Packet> packets) : QAPInput"); //1
		menu.add("PlanetDriver.create_planet(String name, int x, int y) : Planet");   // 2
		menu.add("PacketDriver.create_packet(String name) : Packet");	
		menu.add("GalaxyDriver.create_galaxy_full(String name, int x, int y) : Galaxy");
		menu.add("ResourceDriver.create_resource(String name, String type)");

		menu.add("GalaxyDriver.addPlanet(Planet p)"); // 5
		menu.add("TSTPacketDriver.addPacket(Packet p)");
		menu.add("PacketDriver.addResource(String namePacket, Resource res)");

		menu.add("setDistanceMatrix(Galaxy g)"); // 7
		menu.add("setFlowMatrix(TST<Packet> packets)"); 
		menu.add("setVectorPackets(TST<Packet> p)");
		menu.add("setVectorPlanets(Galaxy g)"); // 10
		menu.add("setElementDistanceMatrix(double value, int i , int j)");
		menu.add("setElementFlowMatrix(double value, int i , int j)");

		menu.add("getElementDistanceMatrixAtIndex(int i, int j ) : double"); //13
		menu.add("getElementFlowMatrixAtIndex(int i , int j) : double");
		
		menu.add("getPlanets() : String[]"); //15
		menu.add("getPackets() : String[]");
		menu.add("getSizePlanets() : int");
		menu.add("getSizePackets() : int");//18

		print_menu();
	}
}
