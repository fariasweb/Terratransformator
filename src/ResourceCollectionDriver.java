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
<<<<<<< HEAD
		menu.add("add(Resource r) : void");
		menu.add("remove(Resource r) : void");
		menu.add("clear() : void");
		menu.add("getAll() : List<Resource> ");
        menu.add("existByName(String name) : boolean");
        menu.add("size() : int");
=======
		menu.add("add(Resource r) : boolean");
		menu.add("remove(Resource r) : boolean");
		menu.add("clear() : void");
		menu.add("getAll() : List<Resource> ");
        menu.add("exists(Resource r) : boolean);
        menu.add("existByName(String name) : boolean);
        menu.add("size() : int);
>>>>>>> 4ecfd0d95eb7574fdc2986ef957c336ae487c323
				
		print_menu();
		
		int opc = 0;
        String[] argv;
        Scanner in = new Scanner(System.in);
        List<Resource> list = new ArrayList<Resource>();
        ResourceCollection cjt = new ResourceCollection();
                
<<<<<<< HEAD
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
=======
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
>>>>>>> 4ecfd0d95eb7574fdc2986ef957c336ae487c323
			}
		} while (opc != 0);
	}
}
