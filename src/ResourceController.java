import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;


public class ResourceController extends AbstractController{

	private TST<Resource> Clt;
	private PacketController pClt;

	/**************************************************************
	 * Contructs
	 **************************************************************/

	/**
	 * Crea un Clt
	 * Pre: cierto
	 * Post: Existe un nuevo Clt
	 */
	public ResourceController() {
		Clt = new TST<Resource>();
		pClt = new PacketController();
	}

	public void passPackCont(PacketController pc)throws Exception{
		if(pc == null) throw new Exception("PacketController needed");
		pClt = pc;
	}
	
	/**************************************************************
	 * Setters
	 **************************************************************/
	/**
	 * Crea un recurso en el sistema y lo agrega a la ED
	 * Pre: el formato del nombre es correcto; el tipo está en la enum
	 * Post: Se crea un recurso con el nombre y tipo indicado; se 
	 * agrega a la ED
	 * 
	 * @param name
	 * @param type ResourceType
	 * @return 
	 */
	public void add(String name, String type) throws Exception{
		Resource r = new Resource(name, type);
		Clt.put(name, r);	
	}

	public void rename(String oldName, String name) throws Exception{
		Resource r= Clt.get(oldName);
		if(r == null) throw new Exception("No packet called " + oldName);
		Resource raux = r;
		Clt.remove(r.getName());
		raux.setName(name);
		Clt.put(raux.getName(), raux);
	}


	/**************************************************************
	 * Getters
	 **************************************************************/
	/**
	 * Devuelve un String con los campos del recurso.
	 * El primer elemento es el nombre, el segundo el tipo, separados por " "
	 * Pre: existe un recurso con este nombre
	 * Post: Devuelve un String con los campos del recurso
	 * @return String
	 * @param name String
	 * @throws Exception
	 */
 	public String get(String name) throws Exception {
		
        if(Clt.size() == 0) throw new Exception("No resources!");
		
		Resource r = Clt.get(name);
		if (r == null) throw new Exception("This resource doesn't exist");
		return r.toString();

	}

	public ArrayList<Resource> getMany(String name, int qtt) throws Exception {

        if(Clt.size() == 0) throw new Exception("No resources!");
		
		ArrayList<Resource> ar = Clt.valuesCache(name, qtt);
		return ar;

	}

	public String getManyAsString(String name, int qtt) throws Exception {

        if(Clt.size() == 0) throw new Exception("No resources!");
		
		ArrayList<Resource> ar = Clt.valuesCache(name, qtt);
		String s = "";
		for (Resource r : ar) {
			s+=r.toString();
		}
		return s;
	}

	/**
	 * @param namep
	 * @return boolean
	 */
	public boolean exists(String r){
		return Clt.contains(r);
	}

	public int size(){
		return Clt.size();
	}


	/**************************************************************
	 * Delete
	 **************************************************************/
	public void remove(String name) throws Exception{
		if(pClt.containsResource(name)) throw new Exception ("Resource in use! Please delete all instances and retry.");
		Clt.remove(name);
	}

     /**
	 * Devuelve un listado de todos los recursos ordenados por nombre. Cada elemento es
	 * un recurso, y de cada elemento, el primer elemento es el nombre, el segundo el tipo
	 * en forma de String
	 * Pre: cierto
	 * Post: Devuelve un listado con los campos recursos ordenados por nombre
	 * @return List<String>
	 * @throws Exception
	 */
   /* public ArrayList<ArrayList<String>> getAll() throws Exception{   
        ArrayList<ArrayList<String>> listOfLists = new ArrayList<ArrayList<String>> ();
        List<String> list = new ArrayList<String>();

       	if(resourceTST.size() == 0) throw new Exception("No resources!");

        for(Resource i: resourceTST.values())
   	    	listOfLists.add(i.toString());

        return listOfLists;
    }*/


	/**************************************************************
	 * Save & Load
	 **************************************************************/

	public void save() throws Exception{

		String cache = Clt.first().toString();
		ArrayList<Resource> list = Clt.valuesCache(Clt.firstKey(), 5);
		for(Resource r : list)
			cache += r.toString();
		//ResourceGD.save(cache);

		while(list.size() > 0){

			list = Clt.valuesCache(list.get(list.size()-1).getName(),5);
			cache = "";
			for(Resource r : list)
				cache += r.toString();
			//ResourceGD.save(cache);
		}
	}

	public void load(){

		String s = new String(); // = ResourceControllerGD.load(N);
		String name = null;
		String type = null;
		for (int i = 0; i < s.length(); ++i) {
			if(s.charAt(i) == ' '){
				if(type == null) type = "";
				else{ 
					try{
						add(name, type);
						name = type = null; 
					}
					catch (Exception e) {
						Console.print("Exception: ");
						e.printStackTrace();
					}
				}
			}
			else{
				if(type == null) name+=s.charAt(i);
				else type+=s.charAt(i);
			}
		}
	}

}
