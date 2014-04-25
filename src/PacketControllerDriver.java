import java.util.Scanner;

public class PacketControllerDriver extends AbstractDriver{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Generico del driver
		PacketController p = new PacketController();
		Planet planet = new Planet();
		TST<RelationPacketResource> rpr = new TST<RelationPacketResource>();
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
                        createPacket(p,argv[1])
                        break;
                    case 2:
                    	p = getPacketByName(argv[1]);
                    	break;
                    case 2:
                        getPlanet(argv[1]);
                        break;
                            
                    case 3:
                     	prp = getResource(argv[1]);
                        break;
                                
                    case 4:
                        setName(argv[1],argv[2]);
                        break;
                    case 5:
                      	setPlanet(argv[1], argv[2]) ;
                        break;
                    case 6:
                      	addResource(argv[1],argv[2], Integer.parseInt(argv[3]);
                        break;
                    case 8:
                      	removeResource(argv[1],argv[2]);
                        break;
                    case 9:
                      	removeAllResource(argv[1]);
                        break;
                    case 10:
                      	removePlanet(argv[1]);
                        break;
                    case 11:
                      	p = new PacketController(); 
                        break;
                    case 12:
                      	removePacketByName(argv[1]); 
                        break; 
                    case 13:
                      	clear();
                        break; 
                    case 14:
                      	p.getAll();
                        break;
                    case 15:
                      	boolean exist = existPacketByName(argv[1]);
                      	if(exist) Console.print("YES");
                      	else Console.print("NO");
                        break; 
                    case 16:
                      Console.print("" + size());
                      break;
				}
			}
		} 
		while (opc != 0);
	}

	private static void _menu(){
		title = "Planet Controller Driver";

		menu.add("createPacketController(String namep)");
		menu.add("getPacketByName(String namep):Packet");
		menu.add("getPlanet(String namep):Planet ");
		menu.add("getResource(String namep):TST<RelationPacketResource>");
		menu.add("setName(String oldName, String namep)");
		menu.add("setPlanet(String namePacket, String namePlanet) ");	//Nombre de paquete que se quiere asignar
		menu.add("void addResource(String namep,String namerp, int qp)");
		menu.add("removeResource(String namep,String namerp)");
		menu.add("removeAllResource(String namep)");
		menu.add("removePlanet(String namep)");
		menu.add("PacketController()");
		menu.add("add(Packet g)");
		menu.add("clear()");
		menu.add("getAll():TST<Packet");
		menu.add("existPacketByName(String namep) : boolean");
		menu.add("size() : int");	
		print_menu();
	}
	
	private static PacketController createPacketController() {
		try{
			return new PacketController(); 
		}
		catch (Exception e){
			_msg_error(e.getMessage());
		}
		return null;
	}


	private static boolean createPacket(PacketController p, String namep, int x, int y) {
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


	private static void setName(PacketController p, String oldName, String newName){
		try{
			p.setName(oldName,newName); 
		}
		catch (Exception e){
			_msg_error(e.getMessage());
		}
	}


	private static void removePacket(PacketController p, String namep){
		try{
			p.removePacket(namep); 
		}
		catch (Exception e){
			_msg_error(e.getMessage());
		}
	}

	//private static void getNeededResources(){}

	private static void setPacket(PacketController p, String namep){
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
	private static boolean removePlanetByName(PacketController p, String namep){
		try{
			p.removePacketByName(namep); 
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