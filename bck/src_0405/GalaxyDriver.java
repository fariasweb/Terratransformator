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
public class GalaxyDriver extends AbstractDriver{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		title = "Galaxy Driver";
		
		menu.add("Create(String name, int x, int y) : Planet");
		menu.add("Create() : Planet");
		menu.add("SetName(String name)");
		menu.add("SetSize(int x, int y)");
		menu.add("SetSize(int x, int y)");
		menu.add("SetPlanet(Planet p, int x, int y)");
		menu.add("GetName() : String");
		menu.add("GetSize() : PairInt");
		menu.add("GetPlanets(): List<Planet>");
		
		print_menu();
		
		int opc = 0;
		
		do {
			
			opc = Console.read_int();
			switch(opc) {
				case 1:
					//Funciones...
					break;
					
				default:
					break;
			}
			
			
		} while (opc != 0);
	}

}
