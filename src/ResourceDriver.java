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

	private static void _menu(){
		title = "Resource Driver";
		
		menu.add("Resource(String namep, ResourceType typep) : Resource");
		menu.add("Resource() : Resource");
		menu.add("setName(String namep)");
		menu.add("setType(ResourceType typep)");
		menu.add("getName() : String");
		menu.add("getType() : ResourceType");
				
		print_menu();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Generico del driver
		Resource p = new Resource();
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
                        p = Resource(argv[1], argv[2]);
                        break;
	
                    case 2:
                        p = Console.print(r.getName());
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
