
import java.util.*;

public class GalaxyCollection {
	List<Galaxy> cjtGalaxy;
	
	//Contructs
	//---------------------------------------------
		
	public GalaxyCollection(List<Galaxy> g){
		cjtGalaxy = g;
	}
		
	public GalaxyCollection(){
		cjtGalaxy = new ArrayList<Galaxy>();
	}
	
	//Setter
	//---------------------------------------------
	
	public boolean add(Galaxy g){
		return cjtGalaxy.add(g);
	}
		
	public boolean remove(Galaxy g){
		return cjtGalaxy.remove(g);
	}
	    
	public void clear(){
		cjtGalaxy.clear();
	}

	
	//Getter
	//-----------------------------------------------
		
	public List<Galaxy> getAll(){
		return cjtGalaxy;
	}
	
	// Exist
	//-----------------------------------------------

	public boolean exist(Galaxy g){
		return cjtGalaxy.contains(g);
	}
	
	public boolean existByName(String name) {
		//TODO
		return false;
	}
	
	// Utils
	//-----------------------------------------------
	
	public int size(){
		return cjtGalaxy.size();
	}
}
