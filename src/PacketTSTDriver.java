import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author farias
 * 
 */
public class PacketTSTDriver extends AbstractDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Generico del driver
		TST<Packet> Clt = new TST<Packet>();
		Packet g = null;

		// Generico del menu
		Scanner in = new Scanner(System.in);

		// Menu
		_menu();

		// Opciones
		do {

			// Lectura de datos
			argv = Console.read_line(in);
			

			if (argv == null) { // Terminaos el fichero
				opc = 0;

			} else if (argv.length > 0) {
				// Recoger la opcion del usuario
				opc = Integer.parseInt(argv[0]);

				// Accion
				switch (opc) {
				case 0: // Exit
					break;

				case 1:
					Clt.clear();
					break;

				case 2:
					if (argv.length < 2)
						_msg_error_param_insuf();
					else {
						if (Clt.contains(argv[1])) {
							Console.print("The key "+argv[1]+" is in TST");
						} else {
							Console.print("The key "+argv[1]+" is not in TST");
						}
					
					}
					break;

				case 3:
					if (argv.length < 2)
						_msg_error_param_insuf();
					else {
						getGalaxyTST(Clt, argv[1]);
					
					}
					break;

				case 4: //Create packet
					if (argv.length < 2)
						_msg_error_param_insuf();
					else {
						g = PacketDriver.create_packet_full(argv[1]);
					}
					
					break;

				case 5:
					add_packet_to_TST(Clt, g);
					break;

				case 6:
					if (argv.length < 2)
						_msg_error_param_insuf();
					else {
						remove_packet_to_TST(Clt, argv[1]);
					}
					break;
					
				case 7:
					Console.print("Size: "+Clt.size());
					break;
					
				case 8: //Keys
					keys_TST(Clt);
					break;
					
				case 9:
					values_TST(Clt);
					break;
					
				}
			}

		} while (opc != 0);

	}

	// Menu
	// ---------------------------------------------

	/**
		 * 
		 */
	private static void _menu() {

		title = "Packet TST Driver";

		menu.add("clear()"); // 1
		menu.add("contains(String key) : boolean");

		menu.add("get(String key)"); // 3

		menu.add("GalaxyDriver.create_packet_full(String name, int x, int y) : Packet g");
		menu.add("put(String g.getName(), g)"); // 5

		menu.add("remove:(String key)");

		menu.add("size(): int"); // 7

		menu.add("keys() : Iterable<String>"); // 8
		menu.add("values() : Iterable<Packet>");

		print_menu();
	}

	// Actions
	// ---------------------------------------------
	
	public static void add_packet_to_TST(TST<Packet> clt, Packet g) {
		try {
			if (g == null) throw new Exception("The packet is null");
			clt.put(g.getName(), g);
			
		} catch(Exception e) {
			_msg_error(e.getMessage());
		}
	}
	
	public static void remove_packet_to_TST(TST<Packet> clt, String key) {
		try {
			clt.remove(key);
			
		} catch(Exception e) {
			_msg_error(e.getMessage());
		}
	}
	
	public static void values_TST(TST<Packet> clt) {
		Iterable<Packet> cltValues = clt.values();
		List<String> content = new ArrayList<String>();
		
		for (Packet g : cltValues) {
		    content.add(g.toString());
		}
		
		Console.simplyTable("Name X Y", content);
		
	}

	public static void keys_TST(TST<Packet> clt) {
		Iterable<String> cltKeys = clt.keys();
		List<String> content = new ArrayList<String>();
		
		for (String g : cltKeys) {
		    content.add(g);
		}
		
		Console.simplyTable("Key", content);
		
	}
	
	
	private static void getGalaxyTST(TST<Packet> clt, String name) {
		try {
			Packet gt = clt.get(name);
			if (gt == null) {
				Console.print("The packet "+name+" doens't exist");
			} else {
				List<String> content = new ArrayList<String>();
				content.add(gt.toString());
				
				Console.simplyTable("Name X Y", content);
			}
		} catch (Exception e) {
			_msg_error(e.getMessage());
		}
		
	}

}
