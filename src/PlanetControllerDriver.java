import java.util.Scanner;

public class PlanetControllerDriver extends AbstractDriver{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Generico del driver
		PlanetController p = new PlanetController();
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
                        p = createPlanetController();
                        break;
                    case 2:
                    	p = createPlanet(argv[0], Integer.parseInt(argv[1]), Integer.parseInt(argv[2]));
                    	break;
                    case 2:
                        setName(p,argv[1], argv[2]);
                        break;
                            
                    case 3:
                      	setPosition(p,argv[1], Integer.parseInt(argv[2]),Integer.parseInt(argv[3]));
                        break;
                                
                    case 4:
                        removePacket(p,argv[1]);
                        break;
                    case 5:
                      	setPacket(p,argv[1]);
                        break;
                    case 6:
                      	removePlanetByName(p,argv[1]);
                        break;
                    case 8:
                      	//list = p.getAll();
                        break;
                    case 9:
                      	Console.print(p.getPosition(argv[1]).getX() + " " + p.getPosition(argv[1]).getY());
                        break;
                    case 10:
                      	Packet pack = p.getPacket(argv[1]);
                        break;
                    case 11:
                      	//savePlanet(p);
                        break;
                    case 12:
                      	//loadPlanet(p);
                        break;   
				}
			}
		} 
		while (opc != 0);
	}

	private static void _menu(){
		title = "Planet Controller Driver";

		menu.add("PlanetController() : PlanetController");
		menu.add("Planet(String name,int x, int y):");
		menu.add("setName(String oldName, String newName) ");
		menu.add("setPosition(String namep, int x, int y) ");
		menu.add("removePacket(String namep)");
		menu.add("setPacket(String namep)");	//Nombre de paquete que se quiere asignar
		menu.add("removePlanetByName(String namep)");
		add 
		remove
		menu.add("getNeededResource()");
		menu.add("getAll(): List<Planet>");
		menu.add("getPosition(String namep) : Parint");
		menu.add("getPacket(String namep)");
		menu.add("savePlanet()");
		menu.add("loadPlanet()");	
		print_menu();
	}
	
	private static PlanetController createPlanetController() {
		try{
			return new PlanetController(); 
		}
		catch (Exception e){
			_msg_error(e.getMessage());
		}
		return null;
	}


	private static boolean createPlanet(PlanetController p, String namep, int x, int y) {
		try{
			p.createPlanet(namep,x,y); 
		}
		catch (Exception e){
			_msg_error(e.getMessage());
		}
		return false;
	}

	//Setter
	//---------------------------------------------


	private static void setName(PlanetController p, String oldName, String newName){
		try{
			p.setName(oldName,newName); 
		}
		catch (Exception e){
			_msg_error(e.getMessage());
		}
	}

	private static void setPosition(PlanetController p, String namep, int x, int y) {
		try{
			p.setPosition(namep,x,y); 
		}
		catch (Exception e){
			_msg_error(e.getMessage());
		}
	}

	private static void removePacket(PlanetController p, String namep){
		try{
			p.removePacket(namep); 
		}
		catch (Exception e){
			_msg_error(e.getMessage());
		}
	}

	//private static void getNeededResources(){}

	private static void setPacket(PlanetController p, String namep){
		try{
			//Packet packet = getPacketByName(namep);
			//p.setPacket(packet); 
		}
		catch (Exception e){
			_msg_error(e.getMessage());
		}
	}

	/**
	 * 
	 * @param name
	 */
	private static boolean removePlanetByName(PlanetController p, String namep){
		try{
			p.removePlanetByName(namep); 
		}
		catch (Exception e){
			_msg_error(e.getMessage());
		}
		return false;
	}
	
 /*
	private static  void savePlanet(PlanetController p ){
		try{
			p.getPlanetCtl().savePlanet(); 
		}
		catch (Exception e){
			_msg_error(e.getMessage());
		}
	}
	
	private static void loadPlanet(PlanetController p){
		try{
			p.getPlanetCtl().loadPlanet(); 
		}
		catch (Exception e){
			_msg_error(e.getMessage());
		}
	}*/
}