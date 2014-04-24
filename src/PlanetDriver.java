import java.util.Scanner;

class PlanetDriver extends AbstractDriver{ 

	public static void main(String args[]){
		
		//Generico del driver
		Planet p = new Planet();
		Packet packet = new Packet();
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
					p = create_planet(argv[1], Integer.parseInt(argv[2]), Integer.parseInt(argv[3]));
					break;
				case 2:
					p = new Planet();
					break;
				case 3:
					set_name(p,argv[1]);
					break;
				case 4:
					set_position(p,Integer.parseInt(argv[1]) , Integer.parseInt(argv[2]));
					break;
				case 5:
					set_packet(p,PacketDriver.create_packet_full(argv[1]));
					break;
				case 6:
					remove_packet(p,packet);
					break;
				case 7:
					Console.print(p.getName());
					break;
				case 8:
					Console.print(p.getPosition().getX() + " " + p.getPosition().getY());
					break;
				case 9:
					Console.print(p.getPacket().getName() + "");
				}
			}
		}
		while(opc != 0);
	}
	
	private static void _menu(){
		title = "Planet Collection Driver";
		
		menu.add("Planet(String name,int x_pos, int y_pos) : Planet"); 
		menu.add("Planet() : Planet");
		menu.add("SetName(String namePlanet)"); //3
		menu.add("SetPosition(int x_pos, int y_pos)");
		menu.add("SetPacket(Packet p)");
		menu.add("removePacket(Packet packetp)");
		menu.add("GetName() : String"); //7
		menu.add("GetPosition() : PairInt");
		menu.add("GetPacket(): Packet");
		print_menu();
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
	
	/**
	 * @param p
	 * @param packet
	 */
	public static void set_packet(Planet p, Packet packet){
		try{
			p.setPacket(packet);
		}
		catch(Exception e){
			_msg_error(e.getMessage());
		}
	}
	/**
	*@param p
	*@param packet
	*/
	public static void remove_packet(Planet p, Packet packet){
		try{
			p.setPacket(packet);
		}
		catch(Exception e){
			_msg_error(e.getMessage());
		}
	}
}
