import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class TSTDriver extends AbstractDriver{
	
	public static void main(String[] args){

		TST<Integer> Tree = new TST<Integer>();

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
					try{
					Tree.put(argv[1], Integer.parseInt(argv[2]));
					}
					catch(Exception e){
						Console.print("Exception: "+e);
					}
					break;

				case 2:
					try{
						Tree.remove(argv[1]);
					}
					catch(Exception e){
						Console.print("Exception: "+e);
					}
					break;

				case 3:
					try{
						Integer i = Tree.get(argv[1]);
						if (i != null) Console.print(i.toString());
						else Console.print("Doesn't exist!");
					}
					catch(Exception e){
						Console.print("Exception: "+e);
					}
					break;

				case 4:
					Iterable<String> list = Tree.keys();
					for (String str : list)
						Console.print(str);
					Console.print("");
					break;

				case 5: // TODO

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

		title = "TST Driver";

		menu.add("Set"); // 1
		menu.add("Remove");
		menu.add("Get"); // 3
		menu.add("GetAll"); 

		print_menu();

	}

}