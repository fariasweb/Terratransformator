
import java.util.*;

public class GalaxyCollection {

	private List<Galaxy> cjtGalaxy;
	
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
	
	public void add(Galaxy g){
		cjtGalaxy.add(g);
	}
		
	public void remove(Galaxy g){
		cjtGalaxy.remove(g);
	}
	    
	public void clear(){
		cjtGalaxy.clear();
	}

	
	//Getter
	//-----------------------------------------------
		
	public List<Galaxy> getAll(){
		return cjtGalaxy;
	}
	
	//TODO: Selecionar solamente 1
	
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
