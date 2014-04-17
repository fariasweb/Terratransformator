import java.util.Scanner;

public class ResourceDriver extends AbstractDriver{
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
                        p = create_resource(argv[1], argv[2]);
                        break;
                    case 2:
                        p = new Resource();
                        break;
                            
                    case 3:
                        set_name(p,argv[1]);
                        break;
                            
                    case 4:
                      	//p.setType(argv[1]);
                        break;
                                
                    case 5:
                        Console.print(p.getName());
                        break;
                                
                    default:
                        Console.print(p.getType());
                        break;
				}
			}
		} 
		while (opc != 0);
	}

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

	public static Resource create_resource(String namep, String typep) {
		try{
			return new Resource(namep,typep); //El parametro 0 es el nombre del planeta
		}
		catch (Exception e){
			_msg_error(e.getMessage());
		}
		return null;
	}

	public static void set_name(Resource p, String namep){
		try{
			p.setName(namep);
		}
		catch(Exception e){
			_msg_error(e.getMessage());
		}
	}
}
