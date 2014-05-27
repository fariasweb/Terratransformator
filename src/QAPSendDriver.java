import java.util.*;

class QAPSendDriver extends AbstractDriver{ 
	
	/**
	 * @param args
	 */
	public static void main(String args[]){
		//Generico del driver
		Planet planet = new Planet();
		Packet packet = new Packet();
		QAPSend q = new QAPSend(null,null);
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
						q = new QAPSend(planet,packet);
					}
					break;
				case 2:
					if (argv.length < 4)
						_msg_error_param_insuf();
					else {
						planet = PlanetDriver.create_planet(argv[1],Integer.parseInt(argv[2]), Integer.parseInt(argv[3]));
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
					if (argv.length < 1)
						_msg_error_param_insuf();
					else {
						set_planet(q,planet);
					}
					break;
				case 5:
					if (argv.length < 1)
						_msg_error_param_insuf();
					else {
						set_packet(q,packet);
					}
					break;
				case 6:
					Console.print("" + q.getPlanet().getName());
					break;
				case 7:
					Console.print("" + q.getPacket().getName());
					break;
			}
		}
		}while(opc != 0);
	}
	
	
	// Actions
	// ---------------------------------------------

	/**
	 * @param q
	 * @param p
	 */
	public static void set_planet(QAPSend q, Planet p){
		try{
			q.setPlanet(p);
		}
		catch (Exception e) {
			_msg_error(e.getMessage());
		}
	}

	/**
	 * @param q
	 * @param p
	 */
	public static void set_packet(QAPSend q, Packet p){
		try{
			q.setPacket(p);
		} catch (Exception e) {
			_msg_error(e.getMessage());
		}
	}
	
	// To Basic
	//---------------------------------------------
	/**
	 * @param q
	 * @return
	 */
	public static String ToString(QAPSend q){
		return q.getPlanet().getName() + " " + q.getPacket().getName();
	}
	
	// Menu
	// ---------------------------------------------

	private static void _menu(){
		title = "QAPSend Driver";
		
		menu.add("QAPSend(Planet pl , Packet pa ) : QAPSend"); 
		menu.add("PlanetDriver.create_planet(String name, int x, int y) : Planet");
		menu.add("PacketDriver.create_packet_full(String name) : Packet");
		menu.add("setPlanet(Planet p) : void");
		menu.add("setPacket(Packet p) : void"); //3
		menu.add("getPlanet() : Planet");
		menu.add("getPacket() : Packet");
		menu.add("ToString() : String");
		print_menu();
	}
}
