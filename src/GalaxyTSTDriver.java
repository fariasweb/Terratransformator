import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author farias
 * 
 */
public class GalaxyTSTDriver extends AbstractDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Generico del driver
		TST<Galaxy> Clt = new TST<Galaxy>();
		Galaxy g = null;

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
					Clt.clear();
					break;

				case 2:
					if (argv.length < 2)
						_msg_error_param_insuf();
					else {
						if (Clt.contains(argv[1])) {
							Console.print("The key "+argv[1]+" is in TST");
						} else {
							Console.print("The key "+argv[1]+" is not in TST");
						}
					
					}
					break;

				case 3:
					if (argv.length < 2)
						_msg_error_param_insuf();
					else {
						getGalaxyTST(Clt, argv[1]);
					
					}
					break;

				case 4: //Create galaxy
					if (argv.length < 4)
						_msg_error_param_insuf();
					else {
						g = GalaxyDriver.create_galaxy_full(argv[1], Integer.parseInt(argv[2]), Integer.parseInt(argv[3]));
					}
					
					break;

				case 5:
					add_galaxy_to_TST(Clt, g);
					break;

				case 6:
					if (argv.length < 2)
						_msg_error_param_insuf();
					else {
						remove_galaxy_to_TST(Clt, argv[1]);
					}
					break;
					
				case 7:
					Console.print("Size: "+Clt.size());
					break;
					
				case 8: //Keys
					keys_TST(Clt);
					break;
					
				case 9:
					values_TST(Clt);
					break;
					
				case 10:
					if (argv.length < 2)
						_msg_error_param_insuf();
					else {
						wildcardMatch_TST(Clt, argv[1]);
					}
					break;
					
				case 11:
					if (argv.length < 2)
						_msg_error_param_insuf();
					else {
						String s = Clt.longestPrefixOf(argv[1]);
						if (s == null) {
							Console.print("Longest prefix does not found");
						} else {
							Console.print("Longest prefix: "+s);
						}
					}
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

		title = "Galaxy TST Driver";

		menu.add("clear()"); // 1
		menu.add("contains(String key) : boolean");

		menu.add("get(String key)"); // 3

		menu.add("GalaxyDriver.create_galaxy_full(String name, int x, int y) : Galaxy g");
		menu.add("put(String g.getName(), g)"); // 5

		menu.add("remove:(String key)");

		menu.add("size(): int"); // 7

		menu.add("keys() : Iterable<String>"); // 8
		menu.add("values() : Iterable<Galaxy>");

		menu.add("longestPrefixOf(String s) : String"); // 10
		menu.add("wildcardMatch(String pat) : Iterable<String>");

		print_menu();
	}

	// Actions
	// ---------------------------------------------
	
	public static void add_galaxy_to_TST(TST<Galaxy> clt, Galaxy g) {
		try {
			if (g == null) throw new Exception("The galaxy is null");
			clt.put(g.getName(), g);
			
		} catch(Exception e) {
			_msg_error(e.getMessage());
		}
	}
	
	public static void remove_galaxy_to_TST(TST<Galaxy> clt, String key) {
		try {
			clt.remove(key);
			
		} catch(Exception e) {
			_msg_error(e.getMessage());
		}
	}
	
	public static void values_TST(TST<Galaxy> clt) {
		Iterable<Galaxy> cltValues = clt.values();
		List<String> content = new ArrayList<String>();
		
		for (Galaxy g : cltValues) {
		    content.add(g.toString());
		}
		
		Console.simplyTable("Name X Y", content);
		
	}

	public static void keys_TST(TST<Galaxy> clt) {
		Iterable<String> cltKeys = clt.keys();
		List<String> content = new ArrayList<String>();
		
		for (String g : cltKeys) {
		    content.add(g);
		}
		
		Console.simplyTable("Key", content);
		
	}
	
	public static void wildcardMatch_TST(TST<Galaxy> clt, String s) {
		Iterable<String> cltKeys = clt.wildcardMatch(s);
		List<String> content = new ArrayList<String>();
		
		for (String g : cltKeys) {
		    content.add(g);
		}
		
		Console.simplyTable("Wildcard Match", content);
	}
	
	private static void getGalaxyTST(TST<Galaxy> clt, String name) {
		try {
			Galaxy gt = clt.get(name);
			if (gt == null) {
				Console.print("The galaxy "+name+" doens't exist");
			} else {
				List<String> content = new ArrayList<String>();
				content.add(gt.toString());
				
				Console.simplyTable("Name X Y", content);
			}
		} catch (Exception e) {
			_msg_error(e.getMessage());
		}
		
	}

}
