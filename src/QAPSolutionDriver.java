import java.util.*;
public class QAPSolutionDriver extends AbstractDriver{
	public static void main(String args[]) throws Exception{
		
		//Generico del driver
		Planet planet = new Planet();
		Packet packet = new Packet();
		Galaxy galaxy = new Galaxy();
		Resource resource = new Resource();
		TST<Packet> packets = new TST<Packet>(); 
		QAPSend qsend = new QAPSend(planet,packet);
		QAPInput q = new QAPInput(galaxy,packets);
		

		QAPEager qa = new QAPEager(q);
		QAPLazyGLB qb = new QAPLazyGLB(q);
		QAPSolution qs = new QAPSolution(qa,galaxy,packets);
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
						qs = new QAPSolution(qa,galaxy,packets);
					}
					break;
				case 2:
					if (argv.length < 1)
						_msg_error_param_insuf();
					else {
						q = new QAPInput(galaxy,packets);
					}
					break;
				case 3:
					if (argv.length < 1)
						_msg_error_param_insuf();
					else {
						//qap = new QAP(q);
					}
					break;
				case 4:
					if (argv.length < 4)
						_msg_error_param_insuf();
					else {
						planet = PlanetDriver.create_planet(argv[1],Integer.parseInt(argv[2]),Integer.parseInt(argv[3]));
					}
					break;
				case 5:
					if (argv.length < 2)
						_msg_error_param_insuf();
					else {
						packet = PacketDriver.create_packet_full(argv[1]);
					}
					break;
				case 6:
					if (argv.length < 4)
						_msg_error_param_insuf();
					else {
						galaxy = GalaxyDriver.create_galaxy_full(argv[1],Integer.parseInt(argv[2]),Integer.parseInt(argv[3]));
					}
					break;
				case 7:
					if (argv.length < 2)
						_msg_error_param_insuf();
					else {
						resource = ResourceDriver.create_resource(argv[1],argv[2]);
					}
					break;

				case 8:
					if (argv.length < 1)
						_msg_error_param_insuf();
					else {
						qsend = new QAPSend(planet,packet);
					}
				case 9:
					if (argv.length < 1)
						_msg_error_param_insuf();
					else {
						GalaxyDriver.add_planet_to_galaxy(galaxy, planet);

					}
					break;
				case 10:
					if (argv.length < 1)
						_msg_error_param_insuf();
					else {
						PacketTSTDriver.add_packet_to_TST(packets,packet);
					}
					break;
				case 11:
					if (argv.length < 2)
						_msg_error_param_insuf();
					else {
						PacketDriver.set_resource_to_a_packet(packet,resource, Integer.parseInt(argv[1])); 
					}
					break;
				case 12:
					if (argv.length < 2)
						_msg_error_param_insuf();
					else {
						//run(qa, argv[1], argv[2]);
					}
					break;
				case 13:
					if (argv.length < 1)
						_msg_error_param_insuf();
					else {
						setQAPInfo(qs,qa);			
					}
					break;
				case 14:
					if (argv.length < 1)
						_msg_error_param_insuf();
					else {
						setQAPSend(qs);
					}
					break;
				case 15:
					if (argv.length < 1)
						_msg_error_param_insuf();
					else {
						addSend(qs,qsend);
					}
					break;
				case 16:
					if (argv.length < 1)
						_msg_error_param_insuf();
					else {
						Console.print(qs.getQAPType());
					}
					break;
				
				case 17:
					if (argv.length < 4)
						_msg_error_param_insuf();
					else {
						Console.print(qs.getEfficiency() + "");
					}
					break;
				
				case 18:
					if (argv.length < 4)
						_msg_error_param_insuf();
					else {
						Console.print(qs.getExecutionTime() + ""); // 5
					}
					break;
				
				case 19:
					List<QAPSend> l = qs.getCltSend();
					for(QAPSend i : l){
						Console.print(i.getPlanet().getName() + i.getPacket().getName());
					}
					break;
				
				case 20:
					qsend = qs.getSendWithPlanet(planet);
					break;
				
				}
			}
		}while(opc != 0);
	}
	
	/**
	 * 
	 * @param qs
	 * @param qap
	 */
	private static void setQAPInfo(QAPSolution qs, QAP qap) {
		try {
			qs.setQAPInfo(qap);

		} catch (Exception e) {
			_msg_error(e.getMessage());
		}
	}

	/**
	 * 
	 * @param qap
	 * @param qs
	 */
	public static void setQAPSend(QAPSolution qs) {
		try {
			qs.setQAPSend();

		} catch (Exception e) {
			_msg_error(e.getMessage());
		}
	}

	/**
	 * 
	 * @param qs
	 * @param s
	 */
	public static void addSend(QAPSolution qs, QAPSend s){
		try {
			qs.addSend(s);

		} catch (Exception e) {
			_msg_error(e.getMessage());
		}
	}


	// Update
	// ---------------------------------------------

	/**
	 * 
	 * @param s1
	 * @param s2
	 */
	public static void swapSends(QAPSend s1, QAPSend s2) {
		Packet r = s1.getPacket();
		s1.setPacket(s2.getPacket());
		s2.setPacket(r);
	}

	private static void _menu(){
		title = "QAPSolution Driver";
		menu.add("QAPSolution(QAP qapp, Galaxy gp, TST<Packet> pg) : QAPSolution");
		menu.add("QAPInput(Galaxy galaxy, TST<Packet> packets) : QAPInput"); //1
		menu.add("QAP(QAPInput):QAP");

		menu.add("PlanetDriver.create_planet(String name, int x, int y) : Planet");   
		menu.add("PacketDriver.create_packet(String name) : Packet");	
		menu.add("GalaxyDriver.create_galaxy_full(String name, int x, int y) : Galaxy");
		menu.add("ResourceDriver.create_resource(String name, String type)");
		menu.add("QAPSend(Planet planet, Packet packet) : QAPSend");

		menu.add("GalaxyDriver.addPlanet(Planet p)"); // 5
		menu.add("TSTPacketDriver.addPacket(Packet p)");
		menu.add("PacketDriver.addResource(String namePacket, Resource res)");

		menu.add("QAPLazy.run()");
		menu.add("QAPEager.run()");
		menu.add("setQAPInfo(QAP qap)"); //1
		menu.add("setQAPSend()");   // 2
		menu.add("addSend(QAPSend s)");	
		menu.add("getQAPType() : String");
		menu.add("getEfficiency() : double");

		menu.add("getExecutionTime() : long"); // 5
		menu.add("getCltSend() : List<QAPSend>");
		menu.add("getSendWithPlanet(Planet p)");

		menu.add("swapSends(QAPSend s1, QAPSend s2)"); //// HASTA AQUI
		menu.add("toString()"); 

		print_menu();
	}
}