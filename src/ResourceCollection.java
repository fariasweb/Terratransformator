
import java.util.*;

public class ResourceCollection {
	private TST<Resource> cjtResource;
	
	//Contructs
	//---------------------------------------------
	/**
	*@return new ResourceCollection 
	*/
	public ResourceCollection(){
		cjtResource = new TST<Resource>();
	}
	
	//Setter
	//---------------------------------------------
	
	/**
	*@param Resource r
	*/
	public void add(Resource r){
            //No haría falta comprobar si hacemos un map
            cjtResource.put(r.getName(),r);
	}
	
	/**
	*@param String namep
	*/
	public void removeResourceByName(String namep) throws Exception{
    	cjtResource.remove(namep);
    }

	public void clear(){
		cjtResource.clear();
	}

	
	//Getter
	//-----------------------------------------------
	
	/**
	*@return Resource 
	*/
	public TST<Resource> getAll(){
		return cjtResource;
	}

    /**
	*@param String namep
	*@return Resource 
	*/
	public Resource getResourceByName(String namep){
		return cjtResource.get(namep);
	}

	// Exist
	//-----------------------------------------------

	/**
	*@param Resource r
	*@return boolean 
	*/
	public boolean exists(Resource r){
		return cjtResource.contains(r.getName());
	}

	/**
	*@param String namep
	*@return boolean 
	*/
	public boolean existByName(String namep) {
		return cjtResource.contains(namep);
	}
	
	// Utils
	//-----------------------------------------------
	
	public int size(){
		return cjtResource.size();
	}
}
