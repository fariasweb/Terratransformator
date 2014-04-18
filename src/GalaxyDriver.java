import java.util.Scanner;

/**
 * 
 */

//import AbstractDriver;

/**
 * @author farias
 * 
 */
class GalaxyDriver extends AbstractDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Generico del driver
		Galaxy g = new Galaxy();

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
				case 0: //Exit
					break;
				case 1:
					if (argv.length < 4)
						_msg_error_param_insuf();
					else {
						g = create_galaxy_full(argv[1],
								Integer.parseInt(argv[2]),
								Integer.parseInt(argv[3]));
					}
					break;

				case 2:
					g = new Galaxy();
					break;

				case 3:
					if (argv.length < 2)
						_msg_error_param_insuf();
					else {
						set_galaxy_name(g, argv[1]);
					}

					break;

				case 4:
					if (argv.length < 3)
						_msg_error_param_insuf();
					else {
						set_galaxy_size(g, Integer.parseInt(argv[1]),
								Integer.parseInt(argv[2]));
					}
					break;

				case 5: // TODO

					break;

				case 6:
					if (g != null)
						Console.print(g.getName());
					break;

				case 7:
					if (g != null) {
						PairInt p = g.getSize();
						Console.print(p.getX() + " " + p.getY());
					}
					break;

				case 8: // TODO

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

		title = "Galaxy Driver";

		menu.add("Galaxy(String name, int x, int y) : Galaxy"); // 1
		menu.add("Galaxy() : Galaxy");
		menu.add("SetName(String name)"); // 3
		menu.add("SetSize(int x, int y)");
		menu.add("SetPlanet(Planet p, int x, int y)");
		menu.add("GetName() : String"); // 6
		menu.add("GetSize() : PairInt");
		menu.add("GetPlanets(): List<Planet>");

		print_menu();
	}

	// Actions
	// ---------------------------------------------

	/**
	 * 
	 * @param name
	 * @param x
	 * @param y
	 * @return Galaxy
	 */
	public static Galaxy create_galaxy_full(String name, int x, int y) {
		try {
			return new Galaxy(name, x, y);
			
		} catch (Exception e) {
			_msg_error(e.getMessage());
		}

		return null;
	}

	/**
	 * 
	 * @param g
	 * @param name
	 */
	public static void set_galaxy_name(Galaxy g, String name) {
		try {
			g.setName(name);

		} catch (Exception e) {
			_msg_error(e.getMessage());
		}
	}

	/**
	 * 
	 * @param g
	 * @param x
	 * @param y
	 */
	public static void set_galaxy_size(Galaxy g, int x, int y) {
		try {
			g.setSize(x, y);

		} catch (Exception e) {
			_msg_error(e.getMessage());
		}
	}

}
