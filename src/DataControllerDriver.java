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
				case 2: //Save
					if (argv.length < 4)
						_msg_error_param_insuf();
					else {
						
						try {
							boolean append = false;
							
							if (argv[4].equals("true")) append = true;
							
							dc.write(argv[1], argv[2], argv[3], append);
						} catch (Exception e) {
							_msg_error(e.getMessage());
						}
					}
					break;
					
				case 3:
					if (argv.length < 2)
						_msg_error_param_insuf();
					else {
						try {
							Console.print(dc.read(argv[1]));
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

		menu.add("save(String path, String file, String data, boolean is_new) : void");
		menu.add("load(String path) : String");

		print_menu();
	}
}
