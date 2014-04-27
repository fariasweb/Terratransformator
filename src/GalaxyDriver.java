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
class GalaxyDriver extends AbstractDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Generico del driver
		Galaxy g = new Galaxy();
		Planet p = null;

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

				case 5: // addPlanet
					if (argv.length < 4)
						_msg_error_param_insuf();
					else {
						p = PlanetDriver.create_planet(argv[1],
								Integer.parseInt(argv[2]),
								Integer.parseInt(argv[3]));
					}

					break;
				
				case 6:
					add_planet_to_galaxy(g, p);
					break;

				case 7:
					if (g != null)
						Console.print(g.getName());
					break;

				case 8:
					if (g != null) {
						PairInt pi = g.getSize();
						Console.print(pi.getX() + " " + pi.getY());
					}
					break;

				case 9: // Get Planets
					TST<Planet> lr = g.getPlanets();
					if (lr.size() == 0) {
						Console.print("This galaxy doesn't have planets");
					} else {
						String[] head = { "Name", "X", "Y" };
						List<String[]> content = new ArrayList<String[]>();

						for (Planet pp : lr.values()) {
							String[] c = new String[3];

							c[0] = pp.getName();
							
							PairInt pi = pp.getPosition();
							c[1] = Integer.toString(pi.getX());
							c[2] = Integer.toString(pi.getY());

							content.add(c);
						}

						Console.table(head, content);
					}
					break;
					
				case 10:
					if (argv.length < 3)
						_msg_error_param_insuf();
					else {
						Planet p2 = g.getPlanetInPost(Integer.parseInt(argv[1]), Integer.parseInt(argv[2]));
						if (p2 != null) {
							Console.print("Planet in position "+argv[1]+" "+argv[2]+": " + p2.getName());
						} else {
							Console.print("Any planet in the position "+ argv[1] + " " + argv[2]);
						}
					}
					
					break;

				case 11:
					if (argv.length < 3)
						_msg_error_param_insuf();
					else {
						
						if (g.existPlanetInPos(Integer.parseInt(argv[1]), Integer.parseInt(argv[2]))) {
							Console.print("Exist planet in this position");
						} else {
							Console.print("Doesn't exist planet in this position");
						}
						
					}
					break;
					
				case 12:
					if (argv.length < 2)
						_msg_error_param_insuf();
					else {
						remove_planet_to_galaxy(g, argv[1]);
					}
					
					break;
					
				case 13:
					remove_all_planets_to_galaxy(g);
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
		menu.add("PlanetDriver.createPlanet(String name, int x, int y) : Planet p");
		menu.add("addPlanet(Planet p)");

		menu.add("GetName() : String"); // 7
		menu.add("GetSize() : PairInt");
		menu.add("GetPlanets(): TST<Planet>");

		menu.add("GetPlanetInPost(int x, int y) : Planet"); //9

		menu.add("ExistPlanetInPos(int x, int y) : Boolean"); // 10

		menu.add("removePlanet(String PlanetName)");
		menu.add("removeAllPlanets() : Boolean");
		
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

	/**
	 * 
	 * @param g
	 * @param p
	 */
	public static void add_planet_to_galaxy(Galaxy g, Planet p) {
		try {
			
			g.addPlanet(p);

		} catch (Exception e) {
			_msg_error(e.getMessage());
		}
	}
	
	public static void remove_planet_to_galaxy(Galaxy g, String PlanetName) {
		try {
			
			g.removePlanet(PlanetName);

		} catch (Exception e) {
			_msg_error(e.getMessage());
		}
	}
	
	public static void remove_all_planets_to_galaxy(Galaxy g) {
		try {
			
			g.removeAllPlanets();

		} catch (Exception e) {
			_msg_error(e.getMessage());
		}
	}

}
