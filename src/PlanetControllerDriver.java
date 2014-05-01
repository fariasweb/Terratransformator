import java.util.*;

public class PlanetControllerDriver extends AbstractDriver{
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Generico del driver
		PlanetController p = new PlanetController();
		TST<Planet> cjtPlanet;
		Planet planet = new Planet();
		Packet packet;
		List<String> list = new ArrayList<String>();
		//Generico del menu
		Scanner in = new Scanner(System.in);
		int opc = 0;
		String argv[];		
		//Menu
		_menu();       
		do {
            argv = Console.read_line(in);
            if(argv == null ) opc = 0;
            else if(argv.length > 0){
            	opc = Integer.parseInt(argv[0]);
				switch(opc) {
                    case 1:
                        p = create_PlanetController();
                        break;
                    case 2:
                    	create_Planet(p,argv[1], Integer.parseInt(argv[2]), Integer.parseInt(argv[3]));
                    	break;
                    case 3:
                    	remove_Packet(p,argv[1]);
                        break;
                            
                    case 4:
                    	set_Packet(p,argv[1],argv[2]);
                        break;
                                
                    case 5:
                        set_Name(p,argv[1], argv[2]);
                        break;
                    case 6:
                      	set_Position(p,argv[1], Integer.parseInt(argv[2]),Integer.parseInt(argv[3]));
                        break;
                    case 7:
                    	PairInt value = get_Position(p,argv[1]);
                    	Console.print(value.getX() + " " + value.getY());
                    	break;
                    case 8:
                    	packet = get_Packet(p,argv[1]);
                    	break;
                    case 9:
                    	clear(p);
                    	break;
                    case 10:
                      	remove_PlanetByName(p,argv[1]);
                        break;
                    case 11:
                      	list = get_All(p);
                        break;
                    case 12:
                      	cjtPlanet = get_AllPlanet(p);
                        break;
                    case 13:
                     	planet = get_PlanetByName(p,argv[1]);
                        break;
                    case 14:
                     	if(exists(p,planet)) Console.print("YES");
                     	else Console.print("NO");
                        break;
                	case 15:
                		if(exist_ByName(p,argv[1])) Console.print("YES");
                		else Console.print("NO");
                    case 16:
                      	Console.print("" + size(p));
                        break;
                    case 17:
                      	save(p,argv[1], argv[2], Integer.parseInt(argv[3]));
                        break;
                    case 18:
                      	load(p);
                        break;   
				}
			}
		} 
		while (opc != 0);
	}

	private static void _menu(){
		title = "Planet Controller Driver";

		menu.add("PlanetController() : PlanetController");  //
		menu.add("Planet(String name,int x, int y): Planet"); //
		menu.add("removePacket(String name)"); //
		menu.add("setPacket(String namep)");	//
		menu.add("setName(String oldName, String newName) "); //
		menu.add("setPosition(String namep, int x, int y) "); //
		menu.add("getPosition(String name) : PairInt"); //
		menu.add("getPacket(String name) : Packet");	//
		//OPERACIONES DE TST<PLANET>
		menu.add("clear()"); //
		menu.add("removePlanetByName(String name)"); //
		menu.add("getAll(): List<Planet>"); //
		menu.add("getAllPlanet(): TST<Planet>"); //
		menu.add("getPlanetByName(namep): Planet"); //
		menu.add("exist(g) : boolean"); //
		menu.add("existByName(String namep): boolean"); //
		menu.add("size() : int");
		menu.add("savePlanet()");
		menu.add("loadPlanet()");	
		print_menu();
	}
	
	
	private static PlanetController create_PlanetController() {
		try{
			return new PlanetController(); 
		}
		catch (Exception e){
			_msg_error(e.getMessage());
		}
		return null;
	}


	private static void create_Planet(PlanetController p, String namep, int x, int y) {
		try{
		 	p.createPlanet(namep,x,y); 
		}
		catch (Exception e){
			_msg_error(e.getMessage());
		}
	}

	//Setter
	//---------------------------------------------


	private static void set_Name(PlanetController p, String oldName, String newName){
		try{
			p.setName(oldName,newName); 
		}
		catch (Exception e){
			_msg_error(e.getMessage());
		}
	}

	private static void set_Position(PlanetController  p, String namep, int x, int y) {
		try{
			p.setPosition(namep,x,y); 
		}
		catch (Exception e){
			_msg_error(e.getMessage());
		}
	}

	private static void remove_Packet(PlanetController  p, String namep){
		try{
			p.removePacket(namep); 
		}
		catch (Exception e){
			_msg_error(e.getMessage());
		}
	}

	//private static void getNeededResources(){}

	private static void set_Packet(PlanetController  p, String namePlanet, String namePacket){
		try{
			p.setPacket(namePlanet, namePacket);
		}
		catch (Exception e){
			_msg_error(e.getMessage());
		}
	}

	/**
	 * 
	 * @param name
	 */
	private static boolean remove_PlanetByName(PlanetController  p, String namep){
		try{
			p.removePlanetByName(namep); 
		}
		catch (Exception e){
			_msg_error(e.getMessage());
		}
		return false;
	}
	
	private static PairInt get_Position(PlanetController  p, String namep){
		try{
			return p.getPosition(namep); 
		}
		catch(Exception e){
			_msg_error(e.getMessage());
		}
		return null;
	}

	private static Packet get_Packet(PlanetController  p, String namePlanet){
		try{
			return p.getPacket(namePlanet); 
		}
		catch(Exception e){
			_msg_error(e.getMessage());
		}
		return null;
	}

	private static void clear(PlanetController  p){
		try{
			p.clear();
		}
		catch(Exception e){
			_msg_error(e.getMessage());
		}
	}
 	
 	private static List<String> get_All(PlanetController p){
 		try{
 			return p.getAll();
 		}
 		catch(Exception e){
			_msg_error(e.getMessage());
		}
		return null;
 	}

 	private static TST<Planet> get_AllPlanet(PlanetController p){
 		return p.getAllPlanet();
 	}

 	private static Planet get_PlanetByName(PlanetController p, String namep){
 		try{
 			return p.getPlanetByName(namep);
 		}
 		catch(Exception e){
			_msg_error(e.getMessage());
		}
		return null;
 	}

 	private static boolean exists(PlanetController  p, Planet planet){
 		try{
 			return p.getAllPlanet().contains(planet.getName());
 		}
 		catch(Exception e){
			_msg_error(e.getMessage());
		}
		return false;
 	}

 	private static boolean exist_ByName(PlanetController p, String namep){
 		try{
 			return p.getAllPlanet().contains(namep);
 		}
 		catch(Exception e){
			_msg_error(e.getMessage());
		}
		return false;
 	}
	private static int size(PlanetController p){
 		try{
 			return p.size();
 		}
 		catch(Exception e){
			_msg_error(e.getMessage());
		}
		return 0;
 	}
 
	private static  void save(PlanetController p,String path, String file, int cacheSize ){
		try{
			p.save(path,file,cacheSize); 
		}
		catch (Exception e){
			_msg_error(e.getMessage());
		}
	}
	
	private static void load(PlanetController p){
		try{
			//TODO p.load(); 
		}
		catch (Exception e){
			_msg_error(e.getMessage());
		}
	}
}