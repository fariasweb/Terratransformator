import java.util.*;

public class ResourceCollectionDriver extends AbstractDriver{

    /**
     * @param args
     */
    public static void main(String[] args) {
        //Generico del driver
        ResourceCollection p  = new ResourceCollection(); 
        Resource rec = new Resource();
        List<Resource> list = new ArrayList<Resource>(); // List<Resource> ??    
        //Generico del menu
        Scanner in = new Scanner(System.in);
        int opc = 0;
        String argv[];      
        //Menu
        _menu();        
        do {    
            argv = Console.read_line(in);
            opc = Integer.parseInt(argv[0]);
            if (argv == null) opc = 0;
            else if (argv.length > 0){
                switch(opc) { 
                    case 1:
                        p = new ResourceCollection();
                        break;       
                    case 2:
                        //p = new Resource(argv[0], argv[1]);
                        add_resource(p,rec);
                        break;           
                    case 3:
                        //p = new Resource(argv[1], argv[2]);
                        remove(p,rec);
                        break; 
                    case 4:
                        removeResourceByName(p,argv[1]);
                        break;                              
                    case 5:
                        p.clear();
                        break;
                    case 6:
                        List<Resource> recursos = p.getAll();
                        for(Resource i : recursos){
                            Console.print(i.getName());
                        }
                        break;   
                    case 7:
                        Resource aux = p.getResourceByName(argv[1]);
                        Console.print(aux.getName());
                        break;
                    case 8:
                        p.exists(rec);
                        break;
                    case 9:
                        p.existByName(argv[1]);
                        break;
                    case 10:
                        Console.print("" + p.size());
                }
            }
        }
        while (opc != 0);
    }
    private static void _menu(){
        title = "ResourceCollection Driver";
        
        menu.add("ResourceCollection() : ResourceCollection");
        menu.add("add(Resource r) : boolean");
        menu.add("remove(Resource r) : boolean");
        menu.add("removeResourceByName(String name) : boolean");
        menu.add("clear() : void");
        menu.add("getAll() : List<Resource> ");
        menu.add("getResourceByName(String namep) : Resource");
        menu.add("exists(Resource r) : boolean");
        menu.add("existByName(String name) : boolean");
        menu.add("size() : int");
                
        print_menu();
    }

    private static boolean add_resource(ResourceCollection p,Resource r){
        try{
            return p.add(r);
        }
        catch(Exception e){
            _msg_error(e.getMessage());
       }
       return false;
    }

    private static boolean remove(ResourceCollection p , Resource r){
        try{
            return p.remove(r);
        }
        catch(Exception e){
            _msg_error(e.getMessage());
       }
       return false;
    }

    private static boolean removeResourceByName(ResourceCollection p , String namep){
        try{
            return p.removeResourceByName(namep);
        }
        catch(Exception e){
            _msg_error(e.getMessage());
       }
       return false;
    }
    
    private static void clear(ResourceCollection p){
        try{
            p.clear();
        }
        catch(Exception e){
            _msg_error(e.getMessage());
        }
    }
}