import java.util.*;

class ResourceDriver extends AbstractDriver{
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Generico del driver
		Resource r = new Resource();
		ResourceController rc = new ResourceController();
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
            	catch (Exception e) {opc = -1;}

				switch(opc) {
                    case 1:
                        rc = new ResourceController();
                        break;

                    case 2:
                        ArrayList<String> list = new ArrayList<String>();

                        try{
                        	list = rc.get(argv[1]);
                        }
                        catch (Exception e){_msg_error(e.getMessage()); }
                        Iterator<String> itera = list.iterator();

                        while(itera.hasNext())
                        	Console.echo(itera.next()+" ");

                        Console.print("");
                        break;

                    case 3:
                     	ArrayList<ArrayList<String>> listOfLists = new ArrayList<ArrayList<String>>();
                        try{
                        	listOfLists = rc.getAll();
                        }
                        catch (Exception e){_msg_error(e.getMessage()); }
                        Iterator<ArrayList<String>> iter = listOfLists.iterator();
                        while(iter.hasNext()){
                        	Iterator<String> siter = iter.next().iterator();
                        	while(siter.hasNext())
                        		Console.echo(siter.next()+" ");
                        	Console.print("");
                        }
                        Console.print("");
                        break;
                        /*set_name(r,argv[1]);
                        break;*/
                            
                    case 4:
                      	//p.setType(argv[1]);
                    	try{ rc.addResource(argv[1], argv[2]);}
                        catch (Exception e){_msg_error(e.getMessage()); }
                        break;
                                
                    case 5:
                    	try{ rc.remove(argv[1]);}
                        catch (Exception e){_msg_error(e.getMessage()); }
                        break;
                    
                    case 6:
                    	//TODO
                        break;

                    case 7:
                    	//TODO
                        break;

                    case 8:
                    	try{ r = new Resource(argv[1], argv[2]); }
						catch (Exception e){ _msg_error(e.getMessage()); }
						break;

                    case 9:
                    	r = new Resource();
                        break;
                            
                    case 10:
                    	try{ r.setName(argv[1]); }
						catch (Exception e){ _msg_error(e.getMessage()); }
						break;

                    case 11:
                    	try{ r.setType(argv[1]); }
						catch (Exception e){ _msg_error(e.getMessage()); }
						break;

                    case 12:     
                    	Console.print(r.getName()); 
                    	break;

                    case 13:
                    	Console.print(r.getType()); 
                    	break;    

                    case 14:     
 						ArrayList<String> lista = r.toStringArray();
                        Iterator<String> iterat = lista.iterator();

                        while(iterat.hasNext())
                        	Console.echo(iterat.next());

                        Console.print("");
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

		menu.add("ResourceController() : ResourceController");
		menu.add("get(String name) : ArrayList<String>");
		menu.add("getAll() : ArrayList<ArrayList<String>>");
		menu.add("addResource(String name, String type) : void");
		menu.add("remove(String name) : void");
		menu.add("guardarRecurso() : void [TODO]");
		menu.add("cargarRecurso() : void [TODO]");
		menu.add("Resource(String namep, ResourceType typep) : Resource");
		menu.add("Resource() : Resource");
		menu.add("setName(String namep)");
		menu.add("setType(String typep)");
		menu.add("getName() : String");
		menu.add("getType() : String");
		menu.add("toStringArray() : ArrayList<String>");

		print_menu();
	}

	public static Resource create_resource(String namep, String typep) {
		try{
			return new Resource(namep, typep); 
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
