import java.util.Scanner;

class ResourceDriver extends AbstractDriver{
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Generico del driver
		Resource r = new Resource();
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
            	try{ opc = Integer.parseInt(argv[0]);}
            	catch (Exception e) {Console.print("ERROR"); opc = -1;}

				switch(opc) {

					case 0:
						break;

                    case 1:
                    	create_resource(r,argv[1], argv[2]);
						break;

                    case 2:
                    	r = new Resource();
                        break;
                            
                    case 3:
                    	try{ r.setName(argv[1]); }
						catch (Exception e){ _msg_error(e.getMessage()); }
						break;

                    case 4:
                    	try{ r.setType(argv[1]); }
						catch (Exception e){ _msg_error(e.getMessage()); }
						break;

                    case 5:     
                    	Console.print(r.getName()); 
                    	break;

                    case 6:
                    	Console.print(r.getType()); 
                    	break;    

                    case 7:     
                       	Console.print(r.toString());
                        break;

                    default:
						_msg_opc_invalid();
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
		menu.add("setName(String namep) : void");
		menu.add("setType(String typep) : void");
		menu.add("getName() : String");
		menu.add("getType() : String");
		menu.add("toString() : String");

		print_menu();
	}
	public static void create_resource(Resource r , String namep1, String namep2){
		try{ 
			r = new Resource(argv[1], argv[2]); 
		}
		catch (Exception e){ 
			_msg_error(e.getMessage()); 
		}
	}
}