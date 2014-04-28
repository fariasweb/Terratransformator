import java.util.Scanner;

public class ResourceControllerDriver extends AbstractDriver{
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Generico del driver
		ResourceController control = new ResourceController();
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

					case 0:
						break;

                    case 1:
						control = new ResourceController();
                        break;

                    case 2:
                    	try{
							control.add(argv[1], argv[2]);
						}
						catch (Exception e) {
							Console.print("Exception: ");
							e.printStackTrace();
						}
                        break;
                            
                    case 3:
                        try{
							Console.print(control.get(argv[1]));
						}
						catch (Exception e) {
							Console.print("Exception: ");
							e.printStackTrace();
						}
                        break;

                    case 4:
                   		try{
							Iterable<Resource> it = control.getMany(argv[1], Integer.parseInt(argv[2]));
							for(Resource i : it)
								Console.echo(i.toString()+" ");
							Console.print("");
						}
						catch (Exception e) {
							Console.print("Exception: ");
							e.printStackTrace();
						}
                        break;
                                
                    case 5:
                        Console.print(Integer.valueOf(control.size()).toString());
                        break;
                              
                    case 6:
                        try{
							control.remove(argv[1]);
						}
						catch (Exception e) {
							Console.print("Exception: ");
							e.printStackTrace();
						}
                        break;  
                     
                    case 7:
                     	//TODO
                     	break;

                    case 8:
                    	//TODO
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
		title = "Resource Controller Driver";

		menu.add("ResourceController() : ResourceController");
		menu.add("add(String name, String type) : void");
		menu.add("get(String name) : String");
		menu.add("getMany(String name, int qtt) : ArrayList<Resource>");
		menu.add("size() : int");
		menu.add("remove(String name) : void");
		menu.add("save() : void");
		menu.add("load() : void");
				
		print_menu();
	}

}
