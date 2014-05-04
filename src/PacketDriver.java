import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author farias
 * 
 */
public class PacketDriver extends AbstractDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Generico del driver
		Packet p = new Packet();
		Resource r = null;
		
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
					if (argv.length < 2)
						_msg_error_param_insuf();
					else {
						p = create_packet_full(argv[1]);
					}
					break;

				case 2:
					p = new Packet();
					break;

				case 3:
					if (argv.length < 2)
						_msg_error_param_insuf();
					else {
						set_packet_name(p, argv[1]);
					}
					break;

				case 4:
					r = ResourceDriver.create_resource(argv[1],argv[2]);
					break;
					
				case 5:
					if (argv.length < 2)
						_msg_error_param_insuf();
					else {
						set_resource_to_a_packet(p, r, Integer.parseInt(argv[1]));
					}
					
					break;
					
				case 6:
					if (argv.length < 4)
						_msg_error_param_insuf();
					else {
						update_resource_to_a_packet(p, argv[1], Integer.parseInt(argv[2]));
					}
					break;

				case 7:
					if (p != null)
						Console.print(p.getName());
					break;
					
				case 8:
					if (p != null)
						Console.print("Quantity: "+p.getQuantity());
					break;
				case 9:
					TST<RelationPacketResource> lr = p.getResources();

					if (lr.size() == 0) {
						Console.print("This packet doesn't have resource");
					} else {
						String[] head = { "Resource", "Type", "Quantity" };
						List<String[]> content = new ArrayList<String[]>();

						for(RelationPacketResource rpr : lr.values()) {
							String[] c = new String[3];

							c[0] = rpr.getResource().getName();
							c[1] = rpr.getResource().getType();
							c[2] = Integer.toString(rpr.getQuantity());
							
							content.add(c);
						}

						Console.table(head, content);
					}

					break;

				case 10:
					if (argv.length < 2)
						_msg_error_param_insuf();
					else {
						remove_resource_from_packet(p, argv[1]);
					}
					break;

				case 11:
					p.removeAllResources();
					break;

				case 12:
					if (p != null)
						Console.print(p.toString());
					break;

				default:
					_msg_opc_invalid();
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

		title = "Packet Driver";

		menu.add("Packet(String name) : Packet"); // 1
		menu.add("Packet() : Packet");
		menu.add("SetName(String name) : void"); // 3
		menu.add("ResourceDriver.create_resource(String name, Strig type) : Resource r");
		menu.add("AddResource(Resource r, int quantity) : void");
		menu.add("updateResource(String name, int qtt) : void"); // 6
		menu.add("GetName() : String"); // 7
		menu.add("GetQuantity() : int");
		menu.add("GetResource(): TST<RelationPacketResource>");
		menu.add("removeResource(Strig ResourceName) : void"); // 9
		menu.add("removeAllResource() : void");
		menu.add("toString() : String");

		print_menu();
	}

	// Actions
	// ---------------------------------------------

	private static void update_resource_to_a_packet(Packet p, String name,
			int qtt) {
		try {
			p.updateResource(name, qtt);
		} catch (Exception e) {
			_msg_error(e.getMessage());
		}
	}
	
	public static Packet create_packet_full(String name) {
		try {
			return new Packet(name);
		} catch (Exception e) {
			_msg_error(e.getMessage());
		}

		return null;
	}

	/**
	 * 
	 * @param p
	 * @param name
	 */
	public static void set_packet_name(Packet p, String name) {
		try {
			p.setName(name);

		} catch (Exception e) {
			_msg_error(e.getMessage());
		}
	}

	/**
	 * 
	 * @param p
	 * @param r
	 * @param qp
	 */
	public static void set_resource_to_a_packet(Packet p, Resource r, int qp) {
		try {
			
			if (p == null)
				throw new Exception("The packet is null");
			
			if (r == null)
				throw new Exception("The resourse is null");
			
			p.addResource(r, qp);
		} catch (Exception e) {
			_msg_error(e.getMessage());
		}
	}

	/**
	 * 
	 * @param p
	 * @param rName
	 */
	public static void remove_resource_from_packet(Packet p, String rName) {
		try {
			p.removeResource(rName);

		} catch (Exception e) {
			_msg_error(e.getMessage());
		}
	}
}
