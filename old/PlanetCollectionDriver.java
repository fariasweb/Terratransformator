import java.util.*;
public class PlanetCollectionDriver extends AbstractDriver{ /* Solo sirve para comprobar errores*/ 

	public static void main(String args[]){

		//Generico del driver
		PlanetCollection p = new PlanetCollection();
		Planet muestra1 = null;
		//Generico del menu
		Scanner in = new Scanner(System.in);
		int opc = 0;
		String argv[];		
		//Menu
		_menu();
		do {
			argv = Console.read_line(in);
			opc = Integer.parseInt(argv[0]);
			if (argv == null) opc = 0;
       	    else if (argv.length > 0){
				switch (opc){
					case 1:
						p = create_PlanetCollection() ;
						break;
					case 2:
					    p = new PlanetCollection();
						break;
					case 3:
						add_planet_full(p,muestra1);
						break;
					case 4:
						remove_planet_full(p,muestra1);
						break;
					case 5:
						removePlanetByName(p,argv[1]);
						break;
					case 6:
						clear(p); //Create a packet or assign it
						break;
					case 7:
						List<Planet> planets = p.getAll();
						for(Planet i : planets){
							Console.print(i.getName() + "\n");
						}
						break;
					case 8:
						Planet aux = p.getPlanetByName(argv[1]);
						Console.print(aux.getName() + " " + aux.getPosition().getX() + " " + aux.getPosition().getY() + "\n");
						break;
					case 9:
						p.exist(argv[1]);
						break;
					case 10:
						p.existByName();
						break;
					case 11:
						Console.print("" + p.size());	
				}		
			}
		} 
		while(opc != 0);
	}
	private static void _menu(){
		title = "Planet Collection Driver";

		menu.add("PlanetCollection() : PlanetCollection");
		menu.add("AddPlanet(Planet p)"); //3
		menu.add("RemovePlanet(int x_pos, int y_pos)");
		menu.add("RemovePlanetByName(String name)");
		menu.add("Clear()");
		menu.add("GetAll() : List<String>"); //7
		menu.add("GetPlanetByName(String name) : Planet");
		menu.add("ExistsPlanet();");
		menu.add("ExistByName(String name)");
		menu.add("Size():int");
		print_menu();
	}
	/**
	 * 
	 * @return
	 */
	private static PlanetCollection create_PlanetCollection() { //Creo que innecesario
		try{
			return new PlanetCollection();
		}
		catch (Exception e){
			_msg_error(e.getMessage());
		}
		return null;
	}

	/**
	 * 
	 * @param p
	 * @param muestra
	 * @return
	 */
	private static boolean addPlanet(PlanetCollection p ,String muestra){
		try{
			return p.add(muestra); 
		}
		catch(Exception e){
			_msg_error(e.getMessage());
		}
		return false;
	}

	/**
	 * 
	 * @param p
	 * @param muestra1
	 * @return
	 */
	private static boolean remove_planet_full(PlanetCollection p ,Planet muestra1){
		try{
			p.remove(muestra1);
		}
		catch(Exception e){
			_msg_error(e.getMessage());
		}
		return false;
	}

	/**
	 * 
	 * @param p
	 * @param name
	 * @return
	 */
	private static boolean removePlanetByName(PlanetCollection p,String name){
		try{
			return p.removePlanetByName(name);
		}
		catch(Exception e){
			_msg_error(e.getMessage());
		}
		return false;
	}

	/**
	 * 
	 * @param p
	 */
	private static void clear(PlanetCollection p){
		try{
			p.clear();
		}
		catch(Exception e){
			_msg_error(e.getMessage());
		}
	}
}