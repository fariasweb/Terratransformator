import java.util.Scanner;

class PairIntDriver extends AbstractDriver{ 

	public static void main(String args[]){
		
		//Generico del driver
		PairInt p = new PairInt();

		//Generico del menu
		Scanner in = new Scanner(System.in);
		int opc = 0;
		String argv[];		
		
		//Menu
		_menu();
		
		do {
			argv = Console.read_line(in);
			
			if (argv == null) opc = 0;
			else if (argv.length > 0){
				opc = Integer.parseInt(argv[0]);
				switch (opc){
				case 0:
					break;
				case 1:
					if (argv.length < 2)
						_msg_error_param_insuf();
					else {
						p = create_pairInt(Integer.parseInt(argv[1]), Integer.parseInt(argv[2]));
					}
					break;
				case 2:
					p = new PairInt();
				case 3:
					Console.print(p.getX() + "" );
					break;
				case 4:
					Console.print(p.getY() + "" );
					break;
				case 5:
					if (argv.length < 2)
						_msg_error_param_insuf();
					else {
						setX(p,Integer.parseInt(argv[1]));
					}
					break;
				case 6:
					if (argv.length < 2)
						_msg_error_param_insuf();
					else {
						setY(p,Integer.parseInt(argv[1]));
					}
					break;
				}
			}
		}
		while(opc != 0);
	}
	
	
	// Actions
	// ---------------------------------------------

	/**
	 * 
	 * @param p
	 * @param x
	 */
	private static void setX(PairInt p ,int x){
		try{
			p.setX(x);
		}
		catch(Exception e){
			_msg_error(e.getMessage());
		}
		
	}
	
	/**
	 * 
	 * @param p
	 * @param y
	 */
	private static void setY(PairInt p ,int y){
		try{
			p.setY(y);
		}
		catch(Exception e){
			_msg_error(e.getMessage());
		}
		
	}

	/**
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	private static PairInt create_pairInt(int x, int y){
		try{
			return new PairInt(x,y);
		}
		catch(Exception e){
			_msg_error(e.getMessage());
		}
		return null;
	}
	
	// Menu
	// ---------------------------------------------

	private static void _menu(){
		title = "PairInt Driver";
		
		menu.add("PairInt(int v1, int v2) : PairInt"); 
		menu.add("PairInt() : PairInt");
		menu.add("getX(): int"); //3
		menu.add("getY(): int");
		menu.add("setX(int xp)");
		menu.add("setY(int yp)");
		print_menu();
	}
}
