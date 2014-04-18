
import java.util.*;

public class GalaxyCollection {

	private TST<Galaxy> cjtGalaxy;
	
	//Contructs
	//---------------------------------------------
		
	public GalaxyCollection(){
		cjtGalaxy = new TST<Galaxy>();
	}
	
	//Setter
	//---------------------------------------------
	
	public void add(Galaxy g){
		cjtGalaxy.put(g.getName(),g);
	}
		
	public void removeGalaxyByName(String namep) throws Exception {
		cjtGalaxy.remove(namep);
	}
	  
	public void clear(){
		cjtGalaxy.clear();
	}

	
	//Getter
	//-----------------------------------------------
		
	public TST<Galaxy> getAll(){
		return cjtGalaxy;
	}
	
	public Galaxy getGalaxyByName(String namep){
		return cjtGalaxy.get(namep);
	}
	
	// Exist
	//-----------------------------------------------

	public boolean exist(Galaxy g){
		return cjtGalaxy.contains(g.getName());
	}
	
	public boolean existByName(String namep) {
		return cjtGalaxy.contains(namep);
	}
	
	// Utils
	//-----------------------------------------------
	
	public int size(){
		return cjtGalaxy.size();
	}
}
