import java.util.Scanner;

/**
 * ResourceControllerDriver
 * 
 */
public class ResourceControllerDriver extends AbstractDriver {
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Generico del driver
		PacketController pc = new PacketController();
		ResourceController rc = new ResourceController(pc);

		// Generico del menu
		Scanner in = new Scanner(System.in);

		// Menu
		_menu();

		// Opciones
		do {

			// Lectura de datos
			argv = Console.read_line(in);

			if (argv == null)
				opc = 0;

			else if (argv.length > 0) {
				opc = Integer.parseInt(argv[0]);

				switch (opc) {
				case 0:
					break;
				case 1:
					rc = new ResourceController(pc);
					break;
				case 2:
					if (argv.length < 3)
						_msg_error_param_insuf();
					else {
						addResource(rc, argv[1], argv[2]);
					}
					break;
				case 3:
					Console.print(rc.getAll());
					break;

				case 4:
					if (argv.length < 2)
						_msg_error_param_insuf();
					else {
						getByName(rc, argv[1]);
					}
					break;

				case 5:
					if (argv.length < 2)
						_msg_error_param_insuf();
					else {
						if (rc.existResource(argv[1])) {
							Console.print("The resource " + argv[1] + " exist");
						} else {
							Console.print("The resource " + argv[1]
									+ " does not exist");
						}
					}
					break;
				case 6:
					if (argv.length < 3)
						_msg_error_param_insuf();
					else {
						updateResourceName(rc, argv[1], argv[2]);
					}
					break;
				case 7:
					if (argv.length < 3)
						_msg_error_param_insuf();
					else {
						updateResourceType(rc, argv[1], argv[2]);
					}
					break;
				case 8:
					if (argv.length < 2)
						_msg_error_param_insuf();
					else {
						removeResource(rc, argv[1]);

					}
					break;
				case 9:
					removeAllResources(rc);
					break;

				case 10:
					Console.print("Size: " + rc.size());
					break;

				case 11:
					if (argv.length < 1)
						_msg_error_param_insuf();
					else {
						saveResourceController(rc, argv[1],
								argv[2].equals("true"));
					}
					break;
				case 12:
					if (argv.length < 1)
						_msg_error_param_insuf();
					else {
						loadResourceController(rc, argv[1]);
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
	public static void loadResourceController(ResourceController rc, String path) {
		try {
			rc.load(path);

		} catch (Exception e) {

			_msg_error(e.getMessage());
		}
	}

	public static void saveResourceController(ResourceController rc, String path,
			boolean append) {
		try {
			rc.save(path, append);

		} catch (Exception e) {

			_msg_error(e.getMessage());
		}

	}

	public static void removeAllResources(ResourceController rc) {
		try {

			rc.removeAllResources();

		} catch (Exception e) {

			_msg_error(e.getMessage());
		}

	}

	public static void removeResource(ResourceController rc, String name) {
		try {

			rc.removeResource(name);

		} catch (Exception e) {

			_msg_error(e.getMessage());
		}

	}

	public static void updateResourceType(ResourceController rc, String name,
			String type) {
		try {

			rc.updateResourceType(name, type);

		} catch (Exception e) {

			_msg_error(e.getMessage());
		}

	}

	public static void updateResourceName(ResourceController rc, String name,
			String newname) {
		try {

			rc.updateResourceName(name, newname);

		} catch (Exception e) {

			_msg_error(e.getMessage());
		}

	}

	public static void getByName(ResourceController rc, String name) {
		try {

			Console.print(rc.getByNameToString(name));

		} catch (Exception e) {

			_msg_error(e.getMessage());
		}

	}

	public static void addResource(ResourceController rc, String name, String type) {
		try {

			rc.addResource(name, type);

		} catch (Exception e) {

			_msg_error(e.getMessage());
		}

	}

	// Menu
	// ---------------------------------------------
	private static void _menu() {
		title = "Resource Controller Driver";

		menu.add("ResourceController(PacketController pc) : ResourceController"); // 1

		menu.add("addResource(String name,  String type) : void"); // 2

		menu.add("getAll() : String"); // 3
		menu.add("getByName(String name) : String");

		menu.add("existResource(String name) : boolean"); // 5

		menu.add("updateName(String name, String new_name) : void"); // 6
		menu.add("updateType(String name, String type) : void");

		menu.add("removeResource(String name) : void"); // 8
		menu.add("removeAllResources(): void");

		menu.add("size() : int"); // 10

		menu.add("save(String path, boolean append) : void"); // 11
		menu.add("load(String path) : void");

		print_menu();
	}

}
