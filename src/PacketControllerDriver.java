import java.util.Scanner;

/**
 * PacketControllerDriver
 * 
 */
class PacketControllerDriver extends AbstractDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Generico del driver
		ResourceController rc = new ResourceController();
		PacketController pc = new PacketController(rc);
		

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
					pc = new PacketController(rc);
					break;

				case 2:
					if (argv.length < 2)
						_msg_error_param_insuf();
					else {
						addPacket(pc, argv[1]);
					}
					break;

				case 3:
					Console.print(pc.getAll());
					break;

				case 4:
					if (argv.length < 2)
						_msg_error_param_insuf();
					else {
						getByName(pc, argv[1]);
					}

					break;

				case 5: // exist
					if (argv.length < 2)
						_msg_error_param_insuf();
					else {
						if (pc.existPacket(argv[1])) {
							Console.print("The packet " + argv[1] + " exist");
						} else {
							Console.print("The packet " + argv[1]
									+ " does not exist");
						}
					}
					break;

				case 6:
					if (argv.length < 3)
						_msg_error_param_insuf();
					else {
						updatePacketName(pc, argv[1], argv[2]);

					}
					break;

				case 7:
					if (argv.length < 2)
						_msg_error_param_insuf();
					else {
						removePacket(pc, argv[1]);

					}
					break;

				case 8: // Remove All
					removeAllPacket(pc);

					break;
					
				case 9:
					Console.print("Size: "+pc.size());
					break;

				case 10:
					if (argv.length < 3)
						_msg_error_param_insuf();
					else {
						createResourceInResourceController(rc, argv[1], argv[2]);
					}
					break;

				case 11:
					if (argv.length < 3)
						_msg_error_param_insuf();
					else {
						addResourceToPacket(pc, rc, argv[1], argv[2], Integer.parseInt(argv[3]));
					}
					break;

				case 12:
					if (argv.length < 2)
						_msg_error_param_insuf();
					else {
						getResourcesFromPacket(pc, argv[1]);
					}
					break;
					
				case 13:
					if (argv.length < 4)
						_msg_error_param_insuf();
					else {
						updateResourcesFromPacket(pc, argv[1], argv[2], Integer.parseInt(argv[3]));
					}
					break;

				case 14:
					if (argv.length < 3)
						_msg_error_param_insuf();
					else {
						removeResourceFromPacket(pc, argv[1], argv[2]);
					}
					break;

				case 15:
					if (argv.length < 1)
						_msg_error_param_insuf();
					else {
						removeAllResourcesFromPacket(pc, argv[1]);
					}
					break;
					
				case 16: //save
					if (argv.length < 1)
						_msg_error_param_insuf();
					else {
						savePacketController(pc, argv[1], argv[2].equals("true"));
					}
					break;
					
				case 17: //load
					if (argv.length < 1)
						_msg_error_param_insuf();
					else {
						loadPacketController(pc, argv[1]);
					}
					break;

				default:
					_msg_opc_invalid();
					break;
				}
			}

		} while (opc != 0);
	}

	// Actions
	// ---------------------------------------------

	private static void updateResourcesFromPacket(PacketController pc,
			String PacketName, String ResourceName, int q) {
		try {
			pc.updateResourceQuantity(PacketName, ResourceName, q);

		} catch (Exception e) {

			_msg_error(e.getMessage());
		}
	}

	public static void loadPacketController(PacketController pc, String path) {
		try {
			pc.load(path);

		} catch (Exception e) {

			_msg_error(e.getMessage());
		}
	}

	public static void savePacketController(PacketController pc, String path, boolean append) {
		try {
			pc.save(path, append);

		} catch (Exception e) {

			_msg_error(e.getMessage());
		}
	}

	public static void addResourceToPacket(PacketController pc,
			ResourceController rc, String PacketName, String ResourceName, int q) {
		try {

			pc.addResource(PacketName, ResourceName, q);

		} catch (Exception e) {

			_msg_error(e.getMessage());
		}
		
	}

	private static void createResourceInResourceController(ResourceController rc,
			String name, String type) {
		try {

			rc.addResource(name, type);

		} catch (Exception e) {

			_msg_error(e.getMessage());
		}
	}

	public static void removeAllPacket(PacketController pc) {
		try {

			pc.removeAllPacket();

		} catch (Exception e) {

			_msg_error(e.getMessage());
		}
	}

	public static void removeAllResourcesFromPacket(PacketController pc,
			String name) {
		try {

			pc.removeResourcesFromPacket(name);

		} catch (Exception e) {

			_msg_error(e.getMessage());
		}
	}

	public static void getResourcesFromPacket(PacketController pc,
			String PacketName) {
		try {

			Console.print(pc.getResourcesFromPacket(PacketName));

		} catch (Exception e) {

			_msg_error(e.getMessage());
		}
	}

	public static void removeResourceFromPacket(PacketController pc,
			String PacketName, String Resourcename) {
		try {

			pc.removeResourceFromPacket(PacketName, Resourcename);

		} catch (Exception e) {

			_msg_error(e.getMessage());
		}
	}

	public static void removePacket(PacketController pc, String name) {
		try {

			pc.removePacket(name);

		} catch (Exception e) {

			_msg_error(e.getMessage());
		}
	}

	public static void getByName(PacketController pc, String name) {
		try {

			Console.print(pc.getByNameToString(name));

		} catch (Exception e) {

			_msg_error(e.getMessage());
		}

	}

	public static void updatePacketName(PacketController pc, String name,
			String newname) {
		try {

			pc.updatePacketName(name, newname);

		} catch (Exception e) {

			_msg_error(e.getMessage());
		}

	}

	public static void addPacket(PacketController pc, String name) {
		try {

			pc.addPacket(name);

		} catch (Exception e) {

			_msg_error(e.getMessage());
		}
	}

	// Menu
	// ---------------------------------------------

	/**
	 * Menu
	 */
	private static void _menu() {

		title = "Packet Controller Driver";

		//Operaciones con conjunto galaxias
		
		menu.add("PacketController() : PacketController"); // 1

		menu.add("addPacket(String name) : void"); // 2

		menu.add("getAll() : String"); // 3
		menu.add("getByName(String name) : String");

		menu.add("existPacket(String name) : boolean"); // 5

		menu.add("updatePacketName(String name, String new_name) : void"); // 6

		menu.add("removePacket(String name) : void"); // 7
		menu.add("removeAllPacket(): void");
		
		menu.add("size() : int"); //9

		// Operaciones sobre las galaxias

		menu.add("ResourceController.addResource(String name, String type) : Resource"); // 10
		menu.add("addResource(String PacketName, String ResourceName, Int quantity, ResourceController rc) : void"); // 9

		menu.add("getResourceFromPacket(String name) : String"); // 12

		menu.add("updateResourceFromPacket(String PacketName, String ResourceName, int quantity) : void");
		
		menu.add("removeResourceFromPacket(String PacketName, String ResourceName) : void"); // 13
		menu.add("removeResourceFromPacket(String PacketName) : void");

		//Save&Load
		menu.add("save(String path, boolean append) : void"); //16
		menu.add("load(String path) : void");
		
		print_menu();
	}

}
