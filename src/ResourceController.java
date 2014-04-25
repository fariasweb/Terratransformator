import java.util.ArrayList;
import java.util.List;

public class ResourceController extends AbstractController{

	private TST<Resource> resourceClt;

	//Contructs
	//---------------------------------------------

	/**
	 * Crea un resourceClt
	 * Pre: cierto
	 * Post: Existe un nuevo resourceClt
	 */
	public ResourceController() {
		resourceClt = new TST<Resource>();
	}


	//Getters
	//-----------------------------------------------

	/**
	 * Devuelve un listado con los campos del recurso en forma de String.
	 * El primer elemento es el nombre, el segundo el tipo
	 * Pre: existe un recurso con este nombre
	 * Post: Devuelve un listado con los campos del recurso en forma de String
	 * @return ArrayList<String>
	 * @param name String
	 * @throws Exception
	 */
 	public ArrayList<String> get(String name) throws Exception {

		if(!Util.checkName(name)) throw new Exception(name + " is not valid");

        if(resourceClt.size() == 0) throw new Exception("No resources!");
		
		if (name == null || name.length() == 0) throw new Exception("Parameter name is not correct");
		Resource r = resourceClt.get(name);
		if (r == null) throw new Exception("This resource doesn't exist");
		return r.toStringArray();

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
    public ArrayList<ArrayList<String>> getAll() throws Exception{   
        ArrayList<ArrayList<String>> listOfLists = new ArrayList<ArrayList<String>> ();
        List<String> list = new ArrayList<String>();

       	if(resourceClt.size() == 0) throw new Exception("No resources!");

        for(Resource i: resourceClt.values())
   	    	listOfLists.add(i.toStringArray());

        return listOfLists;
    }


	//Setter
	//---------------------------------------------

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
	public void addResource(String name, String type) throws Exception{

		if(!Util.checkName(name)) throw new Exception(name + " is not valid");

		Resource r = new Resource(name, type);
		resourceClt.put(name, r);	
	}


	//Delete
	//---------------------------------------------

	public void remove(String name) throws Exception{

		if(!Util.checkName(name)) throw new Exception(name + " is not valid");

		resourceClt.remove(name);
	}


	//Save/load
	//---------------------------------------------

	public void guardarRecurso(){

	}

	public void cargarRecurso(){

	}

}



			// Iterator<List<String>> iter = listOlist.iterator();
			// while(iter.hasNext()){
			//     Iterator<String> siter = iter.next().iterator();
			//     while(siter.hasNext()){
			//          String s = siter.next();
			//          System.out.println(s);
			//      }
			// }
			// 