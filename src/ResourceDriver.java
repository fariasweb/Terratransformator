import java.util.Scanner;

/**
 * GalaxyDriver
 * 
 */

class ResourceDriver extends AbstractDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Generico del driver
		Resource r = new Resource();
		
		// Generico del menu
		Scanner in = new Scanner(System.in);
		int opc = 0;
		String argv[];
		
		// Menu
		_menu();

		// Opciones
		do {
			// Lectura de datos
			argv = Console.read_line(in);
			
			if (argv == null) {
				opc = 0;
			
			} else if (argv.length > 0) {
				opc = Integer.parseInt(argv[0]);

				switch (opc) {

				case 0:
					break;

				case 1:
					if (argv.length < 3)
						_msg_error_param_insuf();
					else {
						r = create_resource(argv[1], argv[2]);
					}
					break;

				case 2:
					r = new Resource();
					break;

				case 3:
					if (argv.length < 2)
						_msg_error_param_insuf();
					else {
						try {
							r.setName(argv[1]);
						} catch (Exception e) {
							_msg_error(e.getMessage());
						}
					}
					break;

				case 4:
					if (argv.length < 2)
						_msg_error_param_insuf();
					else {
						try {
							r.setType(argv[1]);
						} catch (Exception e) {
							_msg_error(e.getMessage());
						}
					}
					break;

				case 5:
					if (r != null)
						Console.print(r.getName());
					break;

				case 6:
					if (r != null)
						Console.print(r.getType());
					break;

				case 7:
					if (r != null)
						Console.print(r.toString());
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
	
	private static void _menu() {

		title = "Resource Driver";

		menu.add("Resource(String namep, ResourceType typep) : Resource");
		menu.add("Resource() : Resource");
		menu.add("setName(String namep) : void");
		menu.add("setType(String typep) : void");
		menu.add("getName() : String");
		menu.add("getType() : String");
		menu.add("toString() : String");

		print_menu();
	}

	// Actions
	// ---------------------------------------------

	public static Resource create_resource(String name, String type) {
		try {
			return new Resource(name, type);
		} catch (Exception e) {
			_msg_error(e.getMessage());
		}
		
		return null;
	}
}