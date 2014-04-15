
import java.util.*;

public class ResourceCollection {
	List<Resource> cjtResource;
	
	//Contructs
	//---------------------------------------------
		
	public ResourceCollection(List<Resource> g){
		cjtResource = g;
	}
		
	public ResourceCollection(){
		cjtResource = new ArrayList<Resource>();
	}
	
	//Setter
	//---------------------------------------------
	
	public boolean add(Resource g){
		return cjtResource.add(g);
	}
		
	public boolean remove(Resource g){
		return cjtResource.remove(g);
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

	public boolean exist(Resource g){
		return cjtResource.contains(g);
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
