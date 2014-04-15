
import java.util.*;

public class ResourceCollection {
	List<Resource> cjtResource;
	
	//Contructs
	//---------------------------------------------
		
	public ResourceCollection(List<Resource> cjt){
		cjtResource = cjt;
	}
		
	public ResourceCollection(){
		cjtResource = new ArrayList<Resource>();
	}
	
	//Setter
	//---------------------------------------------
	
	public boolean add(Resource r){
            //No haría falta comprobar si hacemos un map
            if(!cjtResource.exists(r)) return cjtResource.add(r);
            return false;
	}
		
	public boolean remove(Resource r){
		return cjtResource.remove(r);
	}
	    
	public void clear(){
		cjtResource.clear();
	}

	
	//Getter
	//-----------------------------------------------
		
	public List<Resource> getAll(){
		return cjtResource;
	}
	
	// Exist
	//-----------------------------------------------

	public boolean exists(Resource r){
		return cjtResource.contains(r);
	}
	
	public boolean existByName(String name) {
		//TODO
		return false;
	}
	
	// Utils
	//-----------------------------------------------
	
	public int size(){
		return cjtResource.size();
	}
}
