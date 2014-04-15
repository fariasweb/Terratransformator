import java.util.ArrayList;
import java.util.List;

/**
 * 
 */


//import AbstractDriver;

/**
 * @author farias
 *
 */
public class GalaxyCollectionDriver extends AbstractDriver{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		title = "Galaxy Collection Driver";
		
		menu.add("Create(String name, int x, int y) : Planet"); //1
		menu.add("Create() : Planet");
		menu.add("SetName(String name)"); //3
		menu.add("SetSize(int x, int y)");
		menu.add("SetSize(int x, int y)");
		menu.add("SetPlanet(Planet p, int x, int y)");
		menu.add("GetName() : String"); //7
		menu.add("GetSize() : PairInt");
		menu.add("GetPlanets(): List<Planet>");
		
		print_menu();
		
		int opc = 0;
		//Galaxy g = new Galaxy();
		
		do {
			
			opc = Console.read_int();
			
			switch(opc) {
				case 1:
					g = create_galaxy_full();
					break;
					
				case 2:
					g = new Galaxy();
					break;
					
				case 3:	
					set_galaxy_name(g);
					Galaxy g = GalaxyDriver.create_galaxy_full();
					break;
					
				case 4:	
					
					break;
					
				case 5:	
	
					break;
					
				case 6:	//TODO
					
					break;
					
				case 7:
					Console.print(g.getName());
					
					break;
					
				case 8:	
					
					break;
					
				case 9:	
	
					break;
					
				default:
					Console.print("Opcio no valida");
					
					break;
			}
			
			
		} while (opc != 0);
	}
	
	
	public static Galaxy create_galaxy_full() {
		
		try {
		
			String name;
			int x, y;
			
			//Conseguir parametros
			name = Console.read_string();
			x = Console.read_int();
			y = Console.read_int();
			
			//Crear
			return new Galaxy(name, x, y);

		} catch (Exception e) {
			Console.print("Error "+e.getMessage());
		}
		
		return null;
	}
	
	public static void set_galaxy_name(Galaxy g) {
		try {
			
			String name;
			
			//Conseguir paraemtros
			name = Console.read_string();
			
			g.setName(name);
			
		} catch (Exception e) {
			Console.print("Error "+e.getMessage());
		}
	}

}
