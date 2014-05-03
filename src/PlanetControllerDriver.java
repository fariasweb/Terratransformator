import java.util.*;

public class PlanetControllerDriver extends AbstractDriver {
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Generico del driver
		PlanetController pc = new PlanetController();

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

				switch (opc) {
				case 0:
					break;
				case 1:
					pc = new PlanetController();
					break;
				case 2:
					if (argv.length < 4)
						_msg_error_param_insuf();
					else {
						addPlanet(pc, argv[1], Integer.parseInt(argv[2]),
								Integer.parseInt(argv[3]));
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

				case 5:
					if (argv.length < 2)
						_msg_error_param_insuf();
					else {
						if (pc.existPlanet(argv[1])) {
							Console.print("The planet " + argv[1] + " exist");
						} else {
							Console.print("The planet " + argv[1]
									+ " does not exist");
						}
					}
					break;
				case 6:
					if (argv.length < 3)
						_msg_error_param_insuf();
					else {
						updatePlanetName(pc, argv[1], argv[2]);
					}
					break;
				case 7:
					if (argv.length < 3)
						_msg_error_param_insuf();
					else {
						updateGalaxyPosition(pc, argv[1],
								Integer.parseInt(argv[2]),
								Integer.parseInt(argv[3]));
					}
					break;
				case 8:
					if (argv.length < 2)
						_msg_error_param_insuf();
					else {
						removePlanet(pc, argv[1]);

					}
					break;
				case 9:
					removeAllPlanets(pc);
					break;
					
				case 10:
					Console.print("Size: " + pc.size());
					break;
					
				case 11:
					if (argv.length < 1)
						_msg_error_param_insuf();
					else {
						savePlanetController(pc, argv[1],
								argv[2].equals("true"));
					}
					break;
				case 12:
					if (argv.length < 1)
						_msg_error_param_insuf();
					else {
						loadPlanetController(pc, argv[1]);
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
	
	public static void loadPlanetController(PlanetController pc, String path) {
		try {
			pc.load(path);

		} catch (Exception e) {

			_msg_error(e.getMessage());
		}
	}

	public static void savePlanetController(PlanetController pc,
			String path, boolean append) {
		try {
			pc.save(path, append);

		} catch (Exception e) {

			_msg_error(e.getMessage());
		}

	}

	public static void removeAllPlanets(PlanetController pc) {
		try {

			pc.removeAllPlanets();

		} catch (Exception e) {

			_msg_error(e.getMessage());
		}

	}

	public static void removePlanet(PlanetController pc, String name) {
		try {

			pc.removePlanet(name);

		} catch (Exception e) {

			_msg_error(e.getMessage());
		}

	}

	public static void updateGalaxyPosition(PlanetController pc,
			String name, int x, int y) {
		try {

			pc.updatePlanetPosition(name, x, y);

		} catch (Exception e) {

			_msg_error(e.getMessage());
		}

	}

	public static void updatePlanetName(PlanetController pc, String name,
			String newname) {
		try {

			pc.updatePlanetName(name, newname);

		} catch (Exception e) {

			_msg_error(e.getMessage());
		}

	}

	public static void getByName(PlanetController pc, String name) {
		try {
			
			Console.print(pc.getByNameToString(name));

		} catch (Exception e) {

			_msg_error(e.getMessage());
		}

	}

	public static void addPlanet(PlanetController pc, String name,
			int x, int y) {
		try {

			pc.addPlanet(name, x, y);

		} catch (Exception e) {

			_msg_error(e.getMessage());
		}

	}

	// Menu
	// ---------------------------------------------
	private static void _menu() {
		title = "Planet Controller Driver";

		menu.add("PlanetController() : PlanetController"); // 1

		menu.add("addPlanet(String name, int x, int y) : void"); // 2

		menu.add("getAll() : String"); // 3
		menu.add("getByName(String name) : String");

		menu.add("existPlanet(String name) : boolean"); // 5

		menu.add("updateName(String name, String new_name) : void"); // 6
		menu.add("updatePosition(String name,  int x, int y) : void");

		menu.add("removePlanet(String name) : void"); // 8
		menu.add("removeAllPlanets(): void");

		menu.add("size() : int"); // 10

		menu.add("save(String path, boolean append) : void"); // 11
		menu.add("load(String path) : void");
		print_menu();
	}

}