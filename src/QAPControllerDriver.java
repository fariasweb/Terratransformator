import java.util.Scanner;

/**
 * QAPControllerDriver
 * 
 */
public class QAPControllerDriver extends AbstractDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Generico del driver

		// Galaxias y Planetas
		PlanetController pc = new PlanetController();
		GalaxyController gc = new GalaxyController(pc);

		// Paquetes y Recursos
		PacketController kc = new PacketController();
		ResourceController rc = new ResourceController(kc);

		kc.setResourceController(rc);

		// QAP Controller
		QAPController qapc = new QAPController(gc, kc);

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

				// QAP
				// -------------------------------------
				case 1:
					// Inicializar QAPController
					qapc = new QAPController(gc, kc);
					break;
				case 2:
					// Listado de typos QAP
					Console.print(qapc.getQAPtype());
					break;

				// List
				// -------------------------------------
				case 3:
					Console.print(gc.getAll());
					break;
				case 4:
					Console.print(pc.getAll());
					break;
				case 5:
					Console.print(kc.getAll());
					break;
				case 6:
					Console.print(rc.getAll());
					break;

				// Galaxy
				// -------------------------------------
				case 7:
					if (argv.length < 4)
						_msg_error_param_insuf();
					else {
						GalaxyControllerDriver.addGalaxy(gc, argv[1],
								Integer.parseInt(argv[2]),
								Integer.parseInt(argv[3]));
					}
					break;
				case 8:
					if (argv.length < 2)
						_msg_error_param_insuf();
					else {
						GalaxyControllerDriver.removeGalaxy(gc, argv[1]);
					}
					break;
				case 9:
					if (argv.length < 3)
						_msg_error_param_insuf();
					else {
						GalaxyControllerDriver.addPlanetToGalaxy(gc, pc,
								argv[1], argv[2]);
					}
					break;
				case 10:
					if (argv.length < 3)
						_msg_error_param_insuf();
					else {
						GalaxyControllerDriver.removePlanetFromGalaxy(gc,
								argv[1], argv[2]);
					}
					break;

				// Planet
				// -------------------------------------
				case 11:
					if (argv.length < 4)
						_msg_error_param_insuf();
					else {
						PlanetControllerDriver.addPlanet(pc, argv[1],
								Integer.parseInt(argv[2]),
								Integer.parseInt(argv[3]));
					}
					break;
				case 12:
					if (argv.length < 2)
						_msg_error_param_insuf();
					else {
						PlanetControllerDriver.removePlanet(pc, argv[1]);

					}
					break;

				// Packet
				// -------------------------------------
				case 13:
					if (argv.length < 2)
						_msg_error_param_insuf();
					else {
						PacketControllerDriver.addPacket(kc, argv[1]);
					}
					break;
				case 14:
					if (argv.length < 2)
						_msg_error_param_insuf();
					else {
						PacketControllerDriver.removePacket(kc, argv[1]);

					}
					break;
				case 15:
					if (argv.length < 3)
						_msg_error_param_insuf();
					else {
						PacketControllerDriver.addResourceToPacket(kc, rc,
								argv[1], argv[2], Integer.parseInt(argv[3]));
					}
					break;
				case 16:
					if (argv.length < 3)
						_msg_error_param_insuf();
					else {
						PacketControllerDriver.removeResourceFromPacket(kc,
								argv[1], argv[2]);
					}
					break;

				// Resource
				// -------------------------------------
				case 17:
					if (argv.length < 3)
						_msg_error_param_insuf();
					else {
						ResourceControllerDriver.addResource(rc, argv[1],
								argv[2]);
					}
					break;
				case 18:
					if (argv.length < 2)
						_msg_error_param_insuf();
					else {
						ResourceControllerDriver.removeResource(rc, argv[1]);
					}
					break;

				// QAP
				// -------------------------------------
				case 19:
					if (argv.length < 3)
						_msg_error_param_insuf();
					else {
						runQAP(qapc, argv[1], argv[2]);
					}
					break;
				case 20:
					Console.print(qapc.getGalaxy());
					break;
				case 21:
					Console.print(qapc.getPackets());
					break;
				case 22:
					Console.print(qapc.getQAPSolution());
					break;
				case 23:
					Console.print(qapc.getQAPSolutionSend());
					break;
				case 24:
					if (argv.length < 3)
						_msg_error_param_insuf();
					else {
						exchangePackets(qapc, argv[1], argv[2]);
					}
					break;
				// QAP
				// -------------------------------------
				case 25:
					if (argv.length < 3)
						_msg_error_param_insuf();
					else {
						saveQAPController(qapc, argv[1], argv[2].equals("true"));
					}
					break;

				case 26:
					if (argv.length < 2)
						_msg_error_param_insuf();
					else {
						loadQAPController(qapc, argv[1]);
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

	private static void loadQAPController(QAPController qapc, String path) {
		try {
			qapc.load(path);

		} catch (Exception e) {

			_msg_error(e.getMessage());
		}
	}

	public static void saveQAPController(QAPController qapc, String path,
			boolean append) {
		try {
			qapc.save(path, append);

		} catch (Exception e) {

			_msg_error(e.getMessage());
		}
		
	}

	public static void exchangePackets(QAPController qapc, String PlanetA,
			String PlanetB) {
		try {

			qapc.exchangePackets(PlanetA, PlanetB);

		} catch (Exception e) {

			_msg_error(e.getMessage());
		}

	}

	public static void runQAP(QAPController qapc, String GalaxyName,
			String QAPType) {
		try {

			qapc.QAP(GalaxyName, QAPType);

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
		title = "QAP Controller Driver";

		// Operaciones con QAP
		menu.add("QAPController() : QAPController"); // 1
		menu.add("getQAPtype() : String");

		// Listados
		menu.add("GalaxyController.getAll() : String"); // 3
		menu.add("PlanetController.getAll() : String");
		menu.add("PacketController.getAll() : String");
		menu.add("ResourceController.getAll() : String");

		// Operaciones con Galaxia //7
		menu.add("GalaxyControllerDriver.addGalaxy(GalaxyController gc, String name, int x, int y) : void");
		menu.add("GalaxyControllerDriver.removeGalaxy(GalaxyController gc, String name) : void");
		menu.add("GalaxyControllerDriver.addPlanetToGalaxy(GalaxyController gc, PlanetController pc, String GalaxyName, String PlanetName) : void");
		menu.add("GalaxyControllerDriver.removePlanetFromGalaxy(GalaxyController gc, String GalaxyName, String Planetname) : void");

		// Operaciones con Planetas //11
		menu.add("PlanetControllerDriver.addPlanet(PlanetController pc, String name, int x, int y) : void");
		menu.add("PlanetControllerDriver.removePlanet(PlanetController pc, String name) : void");

		// Operaciones con Paquetes //13
		menu.add("PacketControllerDriver.addPacket(PacketController pc, String name) : void");
		menu.add("PacketControllerDriver.removePacket(PacketController pc, String name) : void");
		menu.add("PacketControllerDriver.addResourceToPacket(PacketController pc, ResourceController rc, String PacketName, String ResourceName, int q) : void");
		menu.add("PacketControllerDriver.removeResourceFromPacket(PacketController pc, String PacketName, String Resourcename) : void");

		// Operaciones con Recursos //17
		menu.add("ResourceControllerDriver.addResource(ResourceController rc, String name, String type) : void");
		menu.add("ResourceControllerDriver.removeResource(ResourceController rc, String name) : void");

		// Lanzar QAP //19
		menu.add("QAP(String GalaxyName, String QAPType) : void");
		menu.add("getGalaxy() : String");
		menu.add("getPackets() : String");
		menu.add("getQAPSolution() : String");
		menu.add("getQAPSolutionSends() : String");
		menu.add("exchangePackets(String PlanetA, String PlanetB) : void");

		// Load&save //25
		menu.add("save(String path, boolean append) : void");
		menu.add("load(String path) : void");

		print_menu();
	}
}
