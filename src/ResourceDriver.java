import java.util.ArrayList;
import java.util.List;

/**
 * 
 */


//import AbstractDriver;

/**
 * 
 *
 */
public class ResourceDriver extends AbstractDriver{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		title = "Resource Driver";
		
		menu.add("Resource(String namep, ResourceType typep) : Resource");
		menu.add("getName() : String");
		menu.add("getType() : String");
		menu.add("setName(String namep) : void");
		menu.add("setType(ResourceType typep) : String");
				
		print_menu();
		
		int opc = 0;
		String par1, par2;
                Resource r = new Resource();
                
		do {
			
                    opc = Console.read_int();
			switch(opc) {
                            case 1:
                                par1 = Console.read_string();
                                par2 = Console.read_string();
                                Resource(par1, par2);
                                break;
				
                            case 2:
                                Console.print(r.getName());
                                break;
                            
                            case 3:
                                Console.print(getType());
                                break;
                            
                            case 4:
                                par1 = Console.read_string();
                                r.setName(par1);
                                break;
                                
                            case 5:
                                par1 = Console.read_string();
                                r.setType(par1);
                                break;
                                
                            default:
                                Console.print("Opción no valida");
                                break;
			}
			
			
		} while (opc != 0);
	}

}
