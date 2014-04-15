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
public class ResourceCollectionDriver extends AbstractDriver{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		title = "ResourceCollection Driver";
		
		menu.add("ResourceCollection()(List<Resource> cjt) : ResourceCollection");
                menu.add("ResourceCollection() : ResourceCollection");
		menu.add("add(Resource r) : boolean");
		menu.add("remove(Resource r) : boolean");
		menu.add("clear() : void");
		menu.add("getAll() : List<Resource> ");
                menu.add("exists(Resource r) : boolean);
                menu.add("existByName(String name) : boolean);
                menu.add("size() : int);
				
		print_menu();
		
		int opc = 0;
		String par1, par2;
                List<String> list = new ArrayList<String>();
                ResourceColection cjt = new ResourceCollection();
                
		do {
			
                    opc = Console.read_int();
			switch(opc) {
                            
                            case 1:
                                par1 = Console.read_string();
                                list.add(par1);
                                //No sé cómo leer una lista de tamaño indefinido
                                Resource(list);
                                break;
				
                            case 2:
                                cjt = new ResourceCollection();
                                break;
                            
                            case 3:
                                par1 = Console.read_string();
                                par2 = Console.read_string();
                                Resource r = new Resource(par1, par2);
                                boolean b = cjt.add(r);
                                Console.print(b.toString());
                                //Esto imprime bien?
                                break;
                            
                            case 4:
                                par1 = Console.read_string();
                                par2 = Console.read_string();
                                Resource r = new Resource(par1, par2);
                                boolean b = cjt.remove(r);
                                Console.print(b.toString());
                                break;
                                
                            case 5:
                                cjt.clear();
                                break;
                            
                            case 6:
                                list = getAll();
                                Console.print_list(list);
                                //No creo que una lista se pueda imprmir así...
                                break;
                            
                            case 7:
                                par1 = Console.read_string();
                                par2 = Console.read_string();
                                Resource r = new Resource(par1, par2);
                                boolean b = cjt.exists(r);
                                Console.print(b.toString());
                                break;
                                
                            case 8:
                                par1 = Console.read_string();
                                boolean b = cjt.existsByName(par1);
                                Console.print(b.toString());
                                break;
                            
                            case 9:
                                int s = cjt.size();
                                Console.print(s.toString());
                                //Escribe bien?
                                break;
                                
                            default:
                                Console.print("Opción no valida");
                                break;
			}
			
			
		} while (opc != 0);
	}

}
