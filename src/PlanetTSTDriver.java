import java.util.Scanner;

public class PlanetTSTDriver extends AbstractDriver {

	public static void main(String[] args) {

		TST<Planet> Clt = new TST<Planet>();
		Planet r = new Planet();

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
					// llamar al otro driver? como?
					try {
						r = new Planet(argv[1], Integer.parseInt(argv[2]), Integer.parseInt(argv[3]));
					} catch (Exception e) {
						Console.print("Exception: ");
						e.printStackTrace();
					}
					break;

				case 2:
					Console.print(Integer.valueOf(Clt.size()).toString());
					break;

				case 3:
					if (Clt.contains(argv[1]))
						Console.print("YES");
					if (Clt.contains(argv[1]))
						Console.print("NO");
					break;

				case 4:
					try {
						r = Clt.get(argv[1]);
						if (r == null)
							Console.print("Planet not present");
						else
							Console.print(r.toString());// llamar al otro
														// driver? como?
					} catch (Exception e) {
						Console.print("Exception: ");
						e.printStackTrace();
					}
					break;

				case 5:
					try {
						Clt.put(r.getName(), r);
					} catch (Exception e) {
						Console.print("Exception: ");
						e.printStackTrace();
					}
					break;

				case 6:
					Console.print(Clt.longestPrefixOf(argv[1]));
					break;

				case 7:
					Iterable<String> it1 = Clt.keys();
					for (String str : it1)
						Console.echo(str + " ");

					Console.print("");
					break;

				case 8:
					Iterable<Planet> it3 = Clt.values();
					for (Planet i : it3)
						Console.echo(i.toString() + " ");

					Console.print("");
					break;

				case 9:
					try {
						Iterable<Planet> it5 = Clt.valuesCache(argv[1],
								Integer.parseInt(argv[2]));
						for (Planet i : it5)
							Console.echo(i.toString() + " ");

						Console.print("");
					} catch (Exception e) {
						Console.print("Exception: ");
						e.printStackTrace();
					}
					break;

				case 10:
					try {
						Console.print(Clt.first().toString());
					} catch (Exception e) {
						Console.print("Exception: ");
						e.printStackTrace();
					}
					break;

				case 11:
					try {
						Console.print(Clt.firstKey());
					} catch (Exception e) {
						Console.print("Exception: ");
						e.printStackTrace();
					}
					break;

				case 12:
					Clt.clear();
					break;

				case 13:
					try {
						Clt.remove(argv[1]);
					} catch (Exception e) {
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

	private static void _menu() {

		title = "Galaxy TST Driver";

		menu.add("PlanetDriver.Planet(String namep, PlanetType typep) : Planet");

		menu.add("size(): int");
		menu.add("contains(String key) : boolean");
		menu.add("get(String key) : Planet");
		menu.add("put(String r.getName(), r)");
		menu.add("longestPrefixOf(String s) : String");
		menu.add("keys() : Iterable<String>");
		menu.add("values() : Iterable<Planet>");
		menu.add("valuesCache(String key, int max) : Iterable<Planet>");
		menu.add("first() : Planet");
		menu.add("firstKey() : String");
		menu.add("clear() : void");
		menu.add("remove:(String key)");

		print_menu();
	}

}