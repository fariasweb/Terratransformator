import java.util.ArrayList;
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
class GalaxyControllerDriver extends AbstractDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Generico del driver
		GalaxyController gc = new GalaxyController();

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
					break;

				case 2:
					break;

				case 3:

					break;

				case 4:
					break;

				case 5: // addPlanet

					break;

				case 6:
					break;

				case 7:
					break;

				case 8: // Get Planets
					break;
					
				case 9:
					
					break;

				case 10:
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

		title = "Galaxy Controller Driver";

		menu.add("GalaxyController() : GalaxyController"); // 1

		menu.add("addGalaxy(String name, int x, int y)"); // 3
		
		menu.add("getAll() : List<String[]>");
		menu.add("getByName(String name) : List<String[]>");

		menu.add("updateGalaxy(String name, String new_name, int x, int y) : void"); // 6
		
		menu.add("removeGalaxy(String name) : void");
		menu.add("removeAllGalaxy(): void");
		
		//Operaciones sobre las galaxias
		
		menu.add("addPlanet(String GalaxyName, ...)"); //TODO
		
		menu.add("getPlanetsFromGalaxy(String name) : ...");
		menu.add("getPlanets() : ...");
		
		menu.add("removePlanetFromGalaxy(String GalaxyName, String Planetname) : void");
		menu.add("removePlanetsFromGalaxy(String GalaxyName) : void");

		print_menu();
	}

	// Actions
	// ---------------------------------------------

}
