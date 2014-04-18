
import java.util.*;

public class ResourceCollection {
	private TST<Resource> cjtResource;
	
	//Contructs
	//---------------------------------------------
	public ResourceCollection(){
		cjtResource = new TST<Resource>();
	}
	
	//Setter
	//---------------------------------------------
	
	public void add(Resource r){
            //No haría falta comprobar si hacemos un map
            cjtResource.put(r.getName(),r);
	}
	
	public void removeResourceByName(String namep) throws Exception{
    	cjtResource.remove(namep);
    }

	public void clear(){
		cjtResource.clear();
	}

	
	//Getter
	//-----------------------------------------------

	public TST<Resource> getAll(){
		return cjtResource;
	}
	
	public Resource getResourceByName(String namep){
		return cjtResource.get(namep);
	}

	// Exist
	//-----------------------------------------------

	public boolean exists(Resource r){
		return cjtResource.contains(r.getName());
	}
	
	public boolean existByName(String namep) {
		return cjtResource.contains(namep);
	}
	
	// Utils
	//-----------------------------------------------
	
	public int size(){
		return cjtResource.size();
	}
}
