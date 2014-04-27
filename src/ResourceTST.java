import java.util.ArrayList;


public class ResourceTST{
	
	private TST<Resource> resourceClt;

	//Contructs
	//---------------------------------------------

	public ResourceTST(){
		resourceClt = new TST<Resource>();
	}


	//Setters
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
	public void add(String name, String type) throws Exception{

		if(!Util.checkName(name)) throw new Exception(name + " is not valid");

		Resource r = new Resource(name, type);
		resourceClt.put(name, r);	
	}

	//Getters
	//-----------------------------------------------

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
		
		if (name == null || name.length() == 0) throw new Exception("Parameter name is not correct");

		if(!Util.checkName(name)) throw new Exception(name + " is not valid");

        if(resourceClt.size() == 0) throw new Exception("No resources!");
		
		Resource r = resourceClt.get(name);
		if (r == null) throw new Exception("This resource doesn't exist");
		return r.toString();

	}

	public ArrayList<Resource> getMany(String name, int qtt) throws Exception {

		if (name == null || name.length() == 0) throw new Exception("Parameter name is not correct");
		
		if(!Util.checkName(name)) throw new Exception(name + " is not valid");

        if(resourceClt.size() == 0) throw new Exception("No resources!");
		
		ArrayList<Resource> ar = resourceClt.valuesCache(name, qtt);
		return ar;
	}

	public Resource first(){
		return first();
	}

	public String firstKey(){
		return firstKey();
	}

	public int size(){
		return resourceClt.size();
	}

	//Delete
	//---------------------------------------------

	public void remove(String name) throws Exception{

		if(!Util.checkName(name)) throw new Exception(name + " is not valid");

		resourceClt.remove(name);
	}
}
