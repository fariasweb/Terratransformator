import java.util.Scanner;

class PlanetDriver extends AbstractDriver{ 

	public static void main(String args[]){
		
		//Generico del driver
		Planet p = new Planet();
		Galaxy g = new Galaxy();

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
				//Console.print(argv.length + "");
				opc = Integer.parseInt(argv[0]);
				switch (opc){
				case 0:
					break;
				case 1:
					if (argv.length < 4)
						_msg_error_param_insuf();
					else {
						p = create_planet(argv[1], Integer.parseInt(argv[2]), Integer.parseInt(argv[3]));
					}
					break;
				case 2:
					p = new Planet();
					break;
				case 3:
					if (argv.length < 2)
						_msg_error_param_insuf();
					else {
						set_name(p,argv[1]);
					}
					break;
				case 4:
					if (argv.length < 3)
						_msg_error_param_insuf();
					else {
						set_position(p,Integer.parseInt(argv[1]) , Integer.parseInt(argv[2]));
					}
					
					break;
				case 5:
					if (argv.length < 3)
						_msg_error_param_insuf();
					else {
						g = GalaxyDriver.create_galaxy_full(argv[1], Integer.parseInt(argv[2]), Integer.parseInt(argv[3]));
					}
					
					break;
				case 6:
					addGalaxyToPlanet(p, g);
					break;
				case 7:
					if (p != null)
						Console.print(p.getName());
					break;
				case 8:
					if (p != null)
						Console.print(p.getPosition().getX() + " " + p.getPosition().getY());
					break;
				case 9:
					
					Galaxy gg = p.getGalaxy();
					if (gg == null) {
						Console.print("This planet doen not have galaxy");
					} else {
						Console.print(gg.toString());
					}
					break;
				case 10:
					removeGalaxyToPlanet(p);
					break;
				case 11:
					if (p != null)
						Console.print(p.toString());
					break;
				default:
					_msg_opc_invalid();
					break;
				}
			}
		}
		while(opc != 0);
	}
	
	
	// Actions
	// ---------------------------------------------

	private static void removeGalaxyToPlanet(Planet p) {
		try{
			p.removeGalaxy();
		}
		catch(Exception e){
			_msg_error(e.getMessage());
		}
		
	}


	/**
	 * @param namep
	 * @param x
	 * @param y
	 * @return Planet
	 */
	public static Planet create_planet(String namep, int x, int y) {
		try{
			return new Planet(namep,x,y); //El parametro 0 es el nombre del planeta
		}
		catch (Exception e){
			_msg_error(e.getMessage());
		}
		return null;
	}
	
	/**
	 * @param p
	 * @param param
	 */
	public static void set_name(Planet p,String param){
		try{
			p.setName(param);
		}
		catch(Exception e){
			_msg_error(e.getMessage());
		}
	}
	
	/**
	 * @param p
	 * @param x
	 * @param y
	 */
	public static void set_position(Planet p,int x, int y){
		try{
			p.setPosition(x, y);
		}
		catch(Exception e){
			_msg_error(e.getMessage());
		}
	}
	
	private static void addGalaxyToPlanet(Planet p, Galaxy g) {
		try {
			
			p.setGalaxy(g);

		} catch (Exception e) {
			_msg_error(e.getMessage());
		}
		
	}
	
	// Menu
	// ---------------------------------------------

	private static void _menu(){
		title = "Planet Collection Driver";
		
		menu.add("Planet(String name,int x_pos, int y_pos) : Planet"); 
		menu.add("Planet() : Planet");
		menu.add("SetName(String namePlanet)"); //3
		menu.add("SetPosition(int x_pos, int y_pos) : void");
		menu.add("GalaxyDriver(String name, int x, int y) : Galaxy g");
		menu.add("SetGalaxy(Galaxy g) : void");
		menu.add("GetName() : String"); //7
		menu.add("GetPosition() : PairInt");
		menu.add("GetGalaxy() : Galaxy");
		menu.add("removeGalaxy() : void");
		menu.add("toString() : String"); //11
		print_menu();
	}
	
}
