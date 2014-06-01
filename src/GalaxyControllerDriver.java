import java.util.Scanner;

/**
 * GalaxyControllerDriver
 * 
 */
class GalaxyControllerDriver extends AbstractDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Generico del driver
		PlanetController pc = new PlanetController();
		GalaxyController gc = new GalaxyController(pc);
		

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
					gc = new GalaxyController(pc);
					break;

				case 2:
					if (argv.length < 4)
						_msg_error_param_insuf();
					else {
						addGalaxy(gc, argv[1], Integer.parseInt(argv[2]),
								Integer.parseInt(argv[3]));
					}
					break;

				case 3:
					Console.print(gc.getAll());
					break;

				case 4:
					if (argv.length < 2)
						_msg_error_param_insuf();
					else {
						getByName(gc, argv[1]);
					}

					break;

				case 5: // exist
					if (argv.length < 2)
						_msg_error_param_insuf();
					else {
						if (gc.existGalaxy(argv[1])) {
							Console.print("The galaxy " + argv[1] + " exist");
						} else {
							Console.print("The galaxy " + argv[1]
									+ " does not exist");
						}
					}
					break;

				case 6:
					if (argv.length < 3)
						_msg_error_param_insuf();
					else {
						updateGalaxyName(gc, argv[1], argv[2]);

					}
					break;

				case 7:
					if (argv.length < 2)
						_msg_error_param_insuf();
					else {
						removeGalaxy(gc, argv[1]);

					}
					break;

				case 8: // Remove All
					removeAllGalaxy(gc);

					break;
					
				case 9:
					Console.print("Size: "+gc.size());
					break;

				case 10:
					if (argv.length < 4)
						_msg_error_param_insuf();
					else {
						createPlanetInPlanetController(pc, argv[1],
								Integer.parseInt(argv[2]),
								Integer.parseInt(argv[3]));
					}
					break;

				case 11:
					if (argv.length < 3)
						_msg_error_param_insuf();
					else {
						addPlanetToGalaxy(gc, pc, argv[1], argv[2]);
					}
					break;

				case 12:
					if (argv.length < 2)
						_msg_error_param_insuf();
					else {
						getPlanetsFromGalaxy(gc, argv[1]);
					}
					break;

				case 13:
					if (argv.length < 3)
						_msg_error_param_insuf();
					else {
						removePlanetFromGalaxy(gc, argv[1], argv[2]);
					}
					break;

				case 14:
					if (argv.length < 1)
						_msg_error_param_insuf();
					else {
						removeAllPlanetsFromGalaxy(gc, argv[1]);
					}
					break;
					
				case 15: //save
					if (argv.length < 1)
						_msg_error_param_insuf();
					else {
						saveGalaxyController(gc, argv[1], argv[2].equals("true"));
					}
					break;
					
				case 16: //load
					if (argv.length < 1)
						_msg_error_param_insuf();
					else {
						loadGalaxyController(gc, argv[1]);
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

	public static void loadGalaxyController(GalaxyController gc, String path) {
		try {
			gc.load(path);

		} catch (Exception e) {

			_msg_error(e.getMessage());
		}
	}

	public static void saveGalaxyController(GalaxyController gc, String path, boolean append) {
		try {
			gc.save(path, append);
		} catch (Exception e) {
			e.printStackTrace();
			_msg_error(e.getMessage());
		}
	}

	public static void addPlanetToGalaxy(GalaxyController gc,
			PlanetController pc, String GalaxyName, String PlanetName) {
		try {

			gc.addPlanet(GalaxyName, PlanetName);

		} catch (Exception e) {

			_msg_error(e.getMessage());
		}
		
	}

	private static void createPlanetInPlanetController(PlanetController pc,
			String name, int x, int y) {
		try {

			pc.addPlanet(name, x, y);

		} catch (Exception e) {

			_msg_error(e.getMessage());
		}
	}

	public static void removeAllGalaxy(GalaxyController gc) {
		try {

			gc.removeAllGalaxy();

		} catch (Exception e) {

			_msg_error(e.getMessage());
		}
	}

	public static void removeAllPlanetsFromGalaxy(GalaxyController gc,
			String name) {
		try {

			gc.removePlanetsFromGalaxy(name);

		} catch (Exception e) {

			_msg_error(e.getMessage());
		}
	}

	public static void getPlanetsFromGalaxy(GalaxyController gc,
			String GalaxyName) {
		try {

			Console.print(gc.getPlanetsFromGalaxy(GalaxyName));

		} catch (Exception e) {

			_msg_error(e.getMessage());
		}
	}

	public static void removePlanetFromGalaxy(GalaxyController gc,
			String GalaxyName, String Planetname) {
		try {

			gc.removePlanetFromGalaxy(GalaxyName, Planetname);

		} catch (Exception e) {

			_msg_error(e.getMessage());
		}
	}

	public static void removeGalaxy(GalaxyController gc, String name) {
		try {

			gc.removeGalaxy(name);

		} catch (Exception e) {

			_msg_error(e.getMessage());
		}
	}

	public static void getByName(GalaxyController gc, String name) {
		try {

			Console.print(gc.getByNameToString(name));

		} catch (Exception e) {

			_msg_error(e.getMessage());
		}

	}

	public static void updateGalaxyName(GalaxyController gc, String name,
			String newname) {
		try {

			gc.updateGalaxyName(name, newname);

		} catch (Exception e) {

			_msg_error(e.getMessage());
		}

	}

	public static void addGalaxy(GalaxyController gc, String name, int x, int y) {
		try {

			gc.addGalaxy(name, x, y);

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

		title = "Galaxy Controller Driver";

		//Operaciones con conjunto galaxias
		
		menu.add("GalaxyController() : GalaxyController"); // 1

		menu.add("addGalaxy(String name, int x, int y) : void"); // 2

		menu.add("getAll() : String"); // 3
		menu.add("getByName(String name) : String");

		menu.add("existGalaxy(String name) : boolean"); // 5

		menu.add("updateGalaxyName(String name, String new_name) : void"); // 6

		menu.add("removeGalaxy(String name) : void"); // 7
		menu.add("removeAllGalaxy(): void");
		
		menu.add("size() : int"); //9

		// Operaciones sobre las galaxias

		menu.add("PlanetController.addPlanet(String name, int x, int y) : Planet");
		menu.add("addPlanet(String GalaxyName, String PlanetName, PlanetController pc) : void"); // 9

		menu.add("getPlanetsFromGalaxy(String name) : String"); // 13

		menu.add("removePlanetFromGalaxy(String GalaxyName, String Planetname) : void"); // 13
		menu.add("removePlanetsFromGalaxy(String GalaxyName) : void");

		menu.add("save(String path, boolean append) : void"); //16
		menu.add("load(String path) : void");
		
		print_menu();
	}

}
