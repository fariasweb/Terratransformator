import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class ResourceTSTDriver extends AbstractDriver{
	
	public static void main(String[] args){

		TST<Resource> Clt = new TST<Resource>();
		Resource r;

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
					// r = ResourceDriver.new Resource(argv[1], argv[2]);
					break;

				case 2:
					Console.print(Clt.size());
					break;

				case 3:
					if(Clt.contains(argv[1])) Console.print("YES");
					if(Clt.contains(argv[1])) Console.print("NO");
					break;

				case 4:
					r = Clt.get(argv[1]);
					if(r == null) Console.print("Resource not present");
					else Console.print(r.ResourceDriver.toString());
					break;

				case 5:
					try{
						Clt.put(argv[1], r);
					}
					catch (Exception e) {
						Console.print("Exception: ");
						e.printStackTrace();
					}
					break;

				case 6:
					Console.print(Clt.longestPrefixOf(argv[1]));
					break;

				case 7:
					Iterable<String> it1 = Clt.keys();
					for(String str : it1)
						Console.echo(str+" ");

					Console.print("");
					break;

				case 8:
					Console.print(Clt.prefixMatch(argv[1]));
					break;

				case 9:
					Iterable<Resource> it2 = Clt.values();
					for(Resource i : it2)
						Console.echo(i.toString()+" ");

					Console.print("");
					break;

				case 10:
					Iterable<String> it3 = Clt.wildcardMatch(argv[1]);
					for(String str : it3)
						Console.echo(str+" ");

					Console.print("");
					break;

				case 11:
					try{
						Iterable<Resource> it4 = Clt.valuesCache(argv[1], Integer.parseInt(argv[2]));
						for(Resource i : it4)
							Console.echo(i.toString()+" ");

						Console.print("");
					}
					catch (Exception e) {
						Console.print("Exception: ");
						e.printStackTrace();
					}
					break;

				case 12:
					try{
						Consolo.print(Clt.first().toString());
					}
					catch (Exception e) {
						Console.print("Exception: ");
						e.printStackTrace();
					}
					break;

				case 13:
					try{
						Consolo.print(Clt.firstKey());
					}
					catch (Exception e) {
						Console.print("Exception: ");
						e.printStackTrace();
					}
					break;

				case 14:
					Clt.clear();
					break;

				case 15:
					try{
						Clt.remove(argv[1]);
					}
					catch (Exception e) {
						Console.print("Exception: ");
						e.printStackTrace();
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

		title = "Galaxy TST Driver";

		menu.add("[AUX]ResourceDriver.Resource(String namep, ResourceType typep) : Resource");

		menu.add("size(): int");
		menu.add("contains(String key) : boolean");
		menu.add("get(String key) : Resource");
		menu.add("put(String g.getName(), g)");
		menu.add("longestPrefixOf(String s) : String");
		menu.add("keys() : Iterable<String>");
		menu.add("prefixMatch(String prefix) : Iterable<String>");
		menu.add("values() : Iterable<Resource>");
		menu.add("wildcardMatch(String pat) : Iterable<String>");
		menu.add("valuesCache(String key, int max) : Iterable<Resource>");
		menu.add("first() : Resource");
		menu.add("firstKey() : String");
		menu.add("clear() : void");
		menu.add("remove:(String key)");

		print_menu();
	}

}