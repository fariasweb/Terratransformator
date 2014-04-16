import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * 
 */

//import AbstractDriver;

/**
 * @author farias
 * 
 */
public class GalaxyCollectionDriver extends AbstractDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Generico del driver
		GalaxyCollection gc = new GalaxyCollection();

		// Generico del menu
		Scanner in = new Scanner(System.in);
		int opc = 0;
		String[] argv;

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

				switch (opc) {
				case 1: //TODO: Quitar

					/*gc = new GalaxyCollection();
					
					//Leemos los parametros de tres en tres
					int num = (argv.length - 1) / 3;
					for (int i = 0; i < num; i++) {
						int pos = i * 3;
						//Creamos la galaxia
						Galaxy g = GalaxyDriver.create_galaxy_full(
								argv[1 + pos], Integer.parseInt(argv[2 + pos]),
								Integer.parseInt(argv[3 + pos]));
						
						//A–adimos al conjunto de galaxia
						add_galaxy_to_collection(gc, g);

					}*/

					break;

				case 2:
					gc = new GalaxyCollection();
					break;

				case 3:
					if (argv.length < 4)
						_msg_error_param_insuf();
					else {
						//Creamos la galaxia
						Galaxy g = GalaxyDriver.create_galaxy_full(argv[1],
								Integer.parseInt(argv[2]),
								Integer.parseInt(argv[3]));
						//A–adimos al conjunto de galaxia
						add_galaxy_to_collection(gc, g);

					}
					break;

				case 4: //TODO: Como le paso esa galaxia??À

					break;

				case 5:
					clear_galaxycollection(gc);
					break;

				case 6:
					String[] head = { "Name", "X", "Y" };
					Console.table(head, list_galaxycollection(gc));
					break;

				case 7:

					break;

				case 8:

					if (gc.existByName(argv[1])) {
						Console.print(argv[1]+" exist");
					} else {
						Console.print(argv[1]+" dont exist");
					}
					
					break;

				case 9:
					Console.print("Size: " + gc.size());
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

		title = "Galaxy Collection Driver";

		//menu.add("GalaxyCollection(String nameGalaxy1, int xGalaxy1, int yGalaxy1, String nameGalaxy2, ...) : GalaxyCollection"); // 1
		menu.add("GalaxyCollection() : GalaxyCollection");
		menu.add("add(String nameGalaxy, int xGalaxy, int yGalaxy) : void"); // 3
		menu.add("remove(String nameGalaxy, int xGalaxy, int yGalaxy) : void");
		menu.add("clear() : void");
		menu.add("getAll() : List<Galaxy>"); // 6
		menu.add("exist(String nameGalaxy, int xGalaxy, int yGalaxy) : boolean");
		menu.add("existByName(String nameGalaxy) : boolean");
		menu.add("size() : int");

		print_menu();
	}

	// Actions
	// ---------------------------------------------

	public static void add_galaxy_to_collection(GalaxyCollection gc, Galaxy g) {
		try {

			if (g != null && gc != null) {
				gc.add(g);
			}

		} catch (Exception e) {
			_msg_error(e.getMessage());
		}

	}

	public static void clear_galaxycollection(GalaxyCollection gc) {
		try {

			if (gc != null) {
				gc.clear();
			}

		} catch (Exception e) {
			_msg_error(e.getMessage());
		}

	}

	public static List<String[]> list_galaxycollection(GalaxyCollection gc) {

		List<Galaxy> l = gc.getAll();
		List<String[]> content = new ArrayList<String[]>();

		for (Galaxy g : l) {

			PairInt p = g.getSize();
			String[] c = new String[3];

			c[0] = g.getName();
			c[1] = Integer.toString(p.getX());
			c[2] = Integer.toString(p.getY());

			content.add(c);
		}

		return content;

	}

}
