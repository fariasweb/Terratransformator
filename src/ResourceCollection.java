
import java.util.*;

public class ResourceCollection {
	private List<Resource> cjtResource;
	
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
            return cjtResource.remove(r);
	}
		
	public boolean remove(Resource r){
		return cjtResource.remove(r);
	}
	
	public boolean removeResourceByName(String name){
		for(int i = 0; i < size(); ++i){
			if(name == cjtResource.get(i).getName()){
    			return cjtResource.remove(cjtResource.get(i));
    		}
    	}
    	return false;
    }

	public void clear(){
		cjtResource.clear();
	}

	
	//Getter
	//-----------------------------------------------
		
	public List<Resource> getAll(){
		return cjtResource;
	}
	
	public Resource getResourceByName(String namep){
		for(int i = 0; i < size(); ++i){
			if(namep == cjtResource.get(i).getName()){
				return cjtResource.get(i);
			}
		}
		return null;
	}

	// Exist
	//-----------------------------------------------

	public boolean exists(Resource r){
		return cjtResource.contains(r);
	}
	
	public boolean existByName(String name) {
		for(int i = 0; i < size(); ++i){
			if(name == cjtResource.get(i).getName()){
				return true;
			}
		}
		return false;
	}
	
	// Utils
	//-----------------------------------------------
	
	public int size(){
		return cjtResource.size();
	}
}
