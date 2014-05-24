import java.util.Iterator;
import java.util.Scanner;

public class TSTDriver extends AbstractDriver {

	public static void main(String[] args) {

		TST<Entity> Clt = new TST<Entity>();
		Entity r = null;
		Iterator<Entity> it = null;

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
					try {
						r = new Entity();
						r.setName(argv[1]);
					} catch (Exception e) {
						_msg_error(e.getMessage());
					}
					break;

				case 2:
					Console.print("Size: " + Clt.size());
					break;

				case 3:
					if (Clt.contains(argv[1]))
						Console.print("YES");
					if (Clt.contains(argv[1]))
						Console.print("NO");
					break;

				case 4:
					try {
						Entity r2 = Clt.get(argv[1]);
						if (r2 == null)
							Console.print("Resource not present");
						else
							Console.print(r2.toString());
					} catch (Exception e) {
						_msg_error(e.getMessage());
					}

					break;

				case 5:
					try {
						if (r == null)
							throw new Exception("Entity is null");
						Clt.put(r.getName(), r);
					} catch (Exception e) {
						_msg_error(e.getMessage());
					}
					break;

				case 6:
					Iterable<String> it1 = Clt.keys();
					for (String str : it1)
						Console.echo(str + " ");

					Console.print("");
					break;

				case 7:
					Iterable<Entity> it2 = Clt.values();
					for (Entity i : it2)
						Console.print(i.toString());

					break;

				case 8:
					try {
						Iterable<Entity> it4 = Clt.valuesCache(argv[1],
								Integer.parseInt(argv[2]));
						for (Entity i : it4)
							Console.echo(i.toString() + " ");

						Console.print("");
					} catch (Exception e) {
						_msg_error(e.getMessage());
					}
					break;

				case 9:
					try {
						Console.print(Clt.first().toString());
					} catch (Exception e) {
						_msg_error(e.getMessage());
					}
					break;

				case 10:
					try {
						Console.print(Clt.firstKey());
					} catch (Exception e) {
						_msg_error(e.getMessage());
					}
					break;

				case 11:
					Clt.clear();
					break;

				case 12:
					try {
						Clt.remove(argv[1]);
					} catch (Exception e) {
						_msg_error(e.getMessage());
					}
					break;

				case 13:
					//Clt.dump();
					it = Clt.newIterator();
					break;
				case 14:
					try {
						if (it == null)
							throw new Exception("Iterator i is null");
						if (!it.hasNext())
							throw new Exception("Iterator i does not have next");
						
						Console.print(it.next().getName());
						
					} catch (Exception e) {
						_msg_error(e.getMessage());
					}
					break;
				case 15:
					try {
						if (it == null)
							throw new Exception("Iterator i is null");
						
						if (it.hasNext())
							Console.print("Iterator i has next");
						else	
							Console.print("Iterator i does not have next");
					} catch (Exception e) {
						_msg_error(e.getMessage());
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

		title = "TST Driver";

		menu.add("Entity(String namep) : r");

		menu.add("size(): int");
		menu.add("contains(String key) : boolean");
		menu.add("get(String key) : Entity");
		menu.add("put(String r.getName(), r) : void");
		menu.add("keys() : Iterable<String>");
		menu.add("values() : Iterable<Entity>");
		menu.add("valuesCache(String key, int max) : Iterable<Entity>");
		menu.add("first() : Resource");
		menu.add("firstKey() : String");
		menu.add("clear() : void");
		menu.add("remove:(String key)");
		menu.add("newIterator(): Iterator i");
		menu.add("i.next() : Entity");
		menu.add("i.hasNext() : Boolean");

		print_menu();
	}

}