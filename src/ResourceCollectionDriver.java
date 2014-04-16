import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
		menu.add("add(Resource r) : void");
		menu.add("remove(Resource r) : void");
		menu.add("clear() : void");
		menu.add("getAll() : List<Resource> ");
        menu.add("existByName(String name) : boolean");
        menu.add("size() : int");
				
		print_menu();
		
		int opc = 0;
        String[] argv;
        Scanner in = new Scanner(System.in);
        List<Resource> list = new ArrayList<Resource>();
        ResourceCollection cjt = new ResourceCollection();
                
        do {
            //Cuidado con esta lectura, si le pongo saltos de
            //línea da errores
           //Lectura de datos
            argv = Console.read_line(in);
            
            if (argv == null) { //Terminaos el fichero
                opc = 0;
                
            } else if (argv.length > 0)
                //Recoger la opcion del usuario
                opc = Integer.parseInt(argv[0]);

            switch(opc){
                case 0:
                    break;
                case 1:
                    //if i+1 >= argv.size() throw exception
                    for (int i = 1; i < argv.length; i+=2)
                        list.add(new Resource(argv[i], argv[i+1]));
                    cjt = new ResourceCollection(list);
                    break;
				case 2:
                    cjt = new ResourceCollection();
                    break;
                case 3:
                    cjt.add(new Resource(argv[1], argv[2]));
                    break;
                case 4:
                    cjt.remove(new Resource(argv[1], argv[2]));
                    break;
                case 5:
                    cjt.clear();
                    break;
                case 6:
                    list = cjt.getAll();
                    for (int i = 0; i < list.size(); i++)
                        Console.print("Recurso "+i+": "+list.get(i).getName()+", "+list.get(i).getType());
                    break;
                case 7:
                    if(cjt.existsByName(argv[1])) Console.print("Present");
                    else Console.print("Not present");
                    break;
                case 8:
                    Console.print(""+cjt.size());
                    break;
                default:
                    Console.print("Opción no valida");
                    break;
			}
		} while (opc != 0);
	}
}
