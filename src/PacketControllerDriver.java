import java.util.Scanner;

public class PacketControllerDriver extends AbstractDriver{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Generico del driver
		PacketController p = new PacketController();
		ResourceController resCont = new ResourceController();
		PlanetController plaCont = new PlanetController();
		DataController dc = new DataController();
		Planet planet = new Planet();
		Packet packet = new Packet();
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
                        p = createPacketController();
                        break;
                    case 2:
                    	add(p,argv[1]);
                    	break;
                    case 3: 
                    	getPacket(p,argv[1]);
                    	add(p,packet);
                        break;
                            
                    case 4:
                     	rpr = getResources(p,argv[1]);
                     	addResource(p,argv[1], argv[2], argv[3], Integer.parseInt(argv[4]));
                        break;        
                    case 5:
                    	setPlanet(p,argv[1], argv[2], plaCont);
                        break;
                    case 6:
                    	renamePacket(p,argv[1],argv[2]);
                        break;
                    case 7:
                    	getPacket(p,argv[1]);
                        break;
                    case 8:
                    	planet = getPlanet(p,argv[1]);
                        break;
                    case 9:
                    	rpr = getResources(p,argv[1]);
                        break;
                    case 10:
                		if(containsResource(p,argv[1])) Console.print("YES");
                		else Console.print("NO"); 
                        break;
                    case 11:
                		exists(p,argv[1]);
                    	break;
                    case 12:
                    	Console.print("" + p.size());
                        break;
                    case 13:
                    	removeResource(p,argv[1],argv[2]);
                        break; 
                    case 14:
                    	removePacket(p,argv[1]);
                        break; 
                    case 15:
                    	removeAllPackets(p);
                        break;
                    case 16:
                      	removePlanet(p,argv[1]);
                      	break;
                    case 17:
                      	save(p,argv[1],argv[2]);
                      	break;
                    case 18:
                    	load(p,argv[1],plaCont,resCont);
                        break;
                    case 19:
						try{resCont.add(argv[1],argv[2]);}
						catch (Exception e){_msg_error(e.getMessage());}
						break;
					case 20:
						try{plaCont.createPlanet(argv[1],Integer.parseInt(argv[2]), Integer.parseInt(argv[3]));}
						catch (Exception e){_msg_error(e.getMessage());}
						break;


				}
			}
		} 
		while (opc != 0);
	}

	private static void _menu(){
		title = "Planet Controller Driver";

		menu.add("PacketController(String namep)"); //
		menu.add("add(String name)"); //
		menu.add("add(Packet p)  "); //
		menu.add("addResource(String p, String r, String t, int qtt)"); //
		menu.add("setPlanet(String namePacket, String namePlanet)");// 
		menu.add("renamePacket(String oldName, String newName)"); //
		menu.add("getPacket(String name) : Packet");
		menu.add("getPlanet(String name) : Planet");
		menu.add("getResources(String namep) : TST<RelationPacketResource>"); //
		menu.add("containsResource(String name) : boolean");
		menu.add("exists(String p) : boolean");
		menu.add("size() : int"); //
		menu.add("removeResource(String namePacket,String nameResource)");
		menu.add("removePacket(String p)");
		menu.add("removeAllPackets()");
		menu.add("removePlanetByName(String namep)");
		menu.add("save(String path, String file, int cacheSize)");
		menu.add("load()");
		menu.add("[AUX]ResourceControllerDriver.add(String namep, ResourceType typep) : void");
		menu.add("[AUX]PlanetControllerDriver.createPlanet(String namep, int x_posp, int y_posp) : void");

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


	private static boolean createPacket(PacketController p, String namep) {
		try{
			p.createPacket(namep); 
		}
		catch (Exception e){
			_msg_error(e.getMessage());
		}
		return false;
	}

	private static void assignDataController(PacketController p, DataController dc){
		try{
			p.assignDataController(dc);
		}
		catch (Exception e){
			_msg_error(e.getMessage());
		}
	}

	//Setter
	//---------------------------------------------


	private static void renamePacket(PacketController p, String oldName, String newName){
		try{
			p.renamePacket(oldName,newName); 
		}
		catch (Exception e){
			_msg_error(e.getMessage());
		}
	}

	private static void add(PacketController p, String namep){
		try{
			p.add(namep); 
		}
		catch (Exception e){
			_msg_error(e.getMessage());
		}
	}

	private static void add(PacketController p, Packet packet){
		try{
			p.add(packet); 
		}
		catch (Exception e){
			_msg_error(e.getMessage());
		}
	}

	private static void addResource(PacketController p, String namep, String namer, String namet, int qtt){
		try{
			p.addResource(namep,namer,namet,qtt); 
		}
		catch (Exception e){
			_msg_error(e.getMessage());
		}
	}

	private static void setPlanet(PacketController p, String namePacket, String namePlanet, PlanetController plaCont){
		try{
			p.setPlanet(namePacket,namePlanet, plaCont);
		}
		catch (Exception e){
			_msg_error(e.getMessage());
			e.printStackTrace();
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

	private static void removeAllPackets(PacketController p){
		try{
			p.removeAllPackets(); 
		}
		catch (Exception e){
			_msg_error(e.getMessage());
		}
	}
	/**
	 * 
	 * @param name
	 */
	private static void removePlanet(PacketController p, String namep){
		try{
			p.removePacket(namep); 
		}
		catch (Exception e){
			_msg_error(e.getMessage());
		}
	}
	
	private static void removeResource(PacketController p,String namePacket, String nameResource){
		try{
			p.removeResource(namePacket, nameResource); 
		}
		catch (Exception e){
			_msg_error(e.getMessage());
		}
	}

		//Getter
	//---------------------------------------------
	private static void getPacket(PacketController p, String namep){
		try{
			Packet paux = p.getPacket(namep);
			if(paux == null) Console.print("No such packet");
			else Console.print(paux.toString()); 
		}
		catch (Exception e){
			_msg_error(e.getMessage());
			e.printStackTrace();
		}
	}

	private static Planet getPlanet(PacketController p, String namep){
		try{
			return p.getPlanet(namep); 
		}
		catch (Exception e){
			_msg_error(e.getMessage());
		}
		return null;
	}

	private static TST<RelationPacketResource> getResources(PacketController p, String namep){
		try{
			return p.getResources(namep); 
		}
		catch (Exception e){
			_msg_error(e.getMessage());
		}
		return null;
	}

		//Exists
	//---------------------------------------------

	private static boolean containsResource(PacketController p, String namep){
		try{
			return p.containsResource(namep); 
		}
		catch (Exception e){
			_msg_error(e.getMessage());
		}
		return false;
	}

	private static boolean exists(PacketController p, String namep){
		try{
			return p.exists(namep); 
		}
		catch (Exception e){
			_msg_error(e.getMessage());
		}
		return false;
	}

 
	private static void save(PacketController p, String path, String file){
		try{
			p.save(path, file); 
		}
		catch (Exception e){
			_msg_error(e.getMessage());
		}
	}
	
	private static void load(PacketController p, String path, PlanetController pltCont, ResourceController resCont){
		try{
			p.load(path, pltCont,resCont); 
		}
		catch (Exception e){
			_msg_error(e.getMessage());
		}
	}
}