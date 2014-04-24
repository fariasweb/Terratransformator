
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
	
	/**
	 * @param g
	 */
	public void add(Galaxy g){
		cjtGalaxy.put(g.getName(),g);
	}
	
	/**
	 * @param namep
	 * @throws Exception
	 */
	public void removeGalaxyByName(String namep) throws Exception {
		cjtGalaxy.remove(namep);
	}
	  

	public void clear(){
		cjtGalaxy.clear();
	}

	
	//Getter
	//-----------------------------------------------
	/**
	 * 	
	 * @return TST<Galaxy>
	 */
	public TST<Galaxy> getAll(){
		return cjtGalaxy;
	}
	
	/**
	 * 
	 * @param namep
	 * @return Galaxy
	 */
	public Galaxy getGalaxyByName(String namep){
		return cjtGalaxy.get(namep);
	}
	
	// Exist
	//-----------------------------------------------
	
	/**
	 * @param g
	 * @return boolean
	 */
	public boolean exist(Galaxy g){
		return cjtGalaxy.contains(g.getName());
	}
	
	/**
	 * @param namep
	 * @return
	 */
	public boolean existByName(String namep) {
		return cjtGalaxy.contains(namep);
	}
	
	// Utils
	//-----------------------------------------------
	
	public int size(){
		return cjtGalaxy.size();
	}
}
