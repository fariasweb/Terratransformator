import java.util.Scanner;

public class PlanetDriver extends AbstractDriver{ 

	public static void main(String args[]){
		
		//Generico del driver
		Planet p = new Planet();
		
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
					set_needed_resources(p);
					break;
				case 6:
					//set_packet(p,packet)
					break;
				case 7:
					Console.print(p.getName());
					break;
				case 8:
					Console.print(p.getPosition().getX() + " " + p.getPosition().getY());
					break;
				case 9:
					for(int i = 0; i < p.getNeededResources().size(); ++i){
						Console.print(p.getNeededResources().get(i).getName());
					}
					break;
				case 10:
					Console.print(p.getPacket().getId() + "");
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
		menu.add("SetNeededResources(List<Resource> neededResources)");
		menu.add("SetPacket(Packet p)");
		menu.add("GetName() : String"); //7
		menu.add("GetPosition() : PairInt");
		menu.add("GetNeededResources() : PairInt");
		menu.add("GetPacket(): Packet");
		print_menu();
	}
	
	private static Planet create_planet(String namep, int x, int y) {
		try{
			return new Planet(namep,x,y); //El parametro 0 es el nombre del planeta
		}
		catch (Exception e){
			_msg_error(e.getMessage());
		}
		return null;
	}
	
	private static void set_name(Planet p,String param){
		try{
			p.setName(param);
		}
		catch(Exception e){
			_msg_error(e.getMessage());
		}
	}
	private static void set_position(Planet p,int x, int y){
		try{
			p.setPosition(x, y);
		}
		catch(Exception e){
			_msg_error(e.getMessage());
		}
	}
	private static void set_needed_resources(Planet p){
		try{
			//int number = Console.read_int();
			//Read list of resources -> Change Data Structure to Maps.
		}
		catch(Exception e){
			_msg_error(e.getMessage());
		}
	}
	private static void set_packet(Planet p, Packet packet){
		try{
			p.setPacket(packet);
		}
		catch(Exception e){
			_msg_error(e.getMessage());
		}
	}
}
