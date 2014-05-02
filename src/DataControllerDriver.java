import java.util.Scanner;

/**
 * 
 */

/**
 * @author farias
 * 
 */
public class DataControllerDriver extends AbstractDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Generico del driver
		DataController dc = new DataController();
		
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
					dc = new DataController();
					break;
				case 2:
					if (argv.length < 3)
						_msg_error_param_insuf();
					else {
						
						try {		
							dc.open(argv[1], argv[2].equals("true"));
						} catch (Exception e) {
							_msg_error(e.getMessage());
						}
					}
					break;
				case 3: //Save
					if (argv.length < 2)
						_msg_error_param_insuf();
					else {
						try {
							dc.write(argv[1]);
						} catch (Exception e) {
							_msg_error(e.getMessage());
						}
					}
					break;
					
				case 4:
					if (argv.length < 1)
						_msg_error_param_insuf();
					else {
						try {
							Console.print(dc.read());
						} catch (Exception e) {
							_msg_error(e.getMessage());
						}
					}
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

		title = "Data Controller Driver";

		menu.add("DataController() : DataController"); // 1

		menu.add("open(String path, boolean append) : void");
		menu.add("save(String data) : void");
		menu.add("load() : String");
		menu.add("close() : void");

		print_menu();
	}
}
