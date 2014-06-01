import java.util.*;/*
public class QAPMatchingDriver extends AbstractDriver {

	public static void main(String[] args){
		// Generico del driver
		QAPmatching q = new QAPmatching();
		List<PairInt> rel = new ArrayList<PairInt>();

		Scanner in = new Scanner(System.in);
		_menu();
	    do {

			// Lectura de datos
			argv = Console.read_line(in);

			if (argv == null) opc = 0;
			else if (argv.length > 0) {
				// Recoger la opcion del usuario
				opc = Integer.parseInt(argv[0]);

				// Accion
				switch (opc) {
					case 0: // Exit
						break;
					case 1:
						if (argv.length < 1)
							_msg_error_param_insuf();
						else {
							q = new QAPmatching();
						}
					break;
					case 2:
						if (argv.length < 3)
							_msg_error_param_insuf();
						else {
							addEdgeToList(Integer.parseInt(argv[1]),Integer.parseInt(argv[2]),rel);
						}
					break;
					case 3:
						if (argv.length < 3)
							_msg_error_param_insuf();
						else {
							init(q,Integer.parseInt(argv[1]), Integer.parseInt(argv[2]),rel);
						}
					break;
					case 4:
						if (argv.length < 1)
							_msg_error_param_insuf();
						else {
							Console.print(q.maxMatching() + "");
						}
					break;
				}
			}
		} while (opc != 0);
	}


	private static void _menu() {

		title = "QAPMatchingDriver Driver";

		menu.add("QAPMatching() : QAPMatching");
		menu.add("addEdgeToList(int v1,int v2)");
		menu.add("init(int x, int y, List<PairInt> rel)");
		menu.add("getMaxMatching() : int");
		print_menu();
	}
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @param rel
	 */
	/*private static void addEdgeToList(int x, int y,List<PairInt> rel) {
		try {
			rel.add(new PairInt(x,y));

		} catch (Exception e) {
			_msg_error(e.getMessage());
		}
	}
	
	/**
	 * 
	 * @param q
	 * @param x
	 * @param y
	 * @param rel
	 */
	/*private static void init(QAPmatching q, int x, int y,List<PairInt> rel) {
		try {
			q.init(x,y,rel);

		} catch (Exception e) {
			_msg_error(e.getMessage());
		}
	}
};*/