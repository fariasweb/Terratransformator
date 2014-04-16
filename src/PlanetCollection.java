import java.util.*;

public class PlanetCollection {
	List<Planet> cjtPlanet;
	
	//Contructs
	//---------------------------------------------
		
	public PlanetCollection(List<Planet> g){
		cjtPlanet = g;
	}
		
	public PlanetCollection(){
		cjtPlanet = new ArrayList<Planet>();
	}
	
	//Setter
	//---------------------------------------------
	/**
	 * 
	 * @param g
	 * @return
	 */
	public boolean add(Planet g){
		return cjtPlanet.add(g);
	}
	
	public boolean addPlanetByName(String name){
		for(int i = 0; i < size(); ++i){
			if(name == cjtPlanet.get(i).getName()){
    			return cjtPlanet.add(cjtPlanet.get(i));
    		}
    	}
    	return false;
	}

	/**
	 * 
	 * @param g
	 * @return
	 */
	public boolean remove(Planet g){
		return cjtPlanet.remove(g);
	}
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public boolean removePlanetByName(String name){
		for(int i = 0; i < size(); ++i){
			if(name == cjtPlanet.get(i).getName()){
    			return cjtPlanet.remove(cjtPlanet.get(i));
    		}
    	}
    	return false;
    }
	  
	public void clear(){
		cjtPlanet.clear();
	}

	
	//Getter
	//-----------------------------------------------
	/**
	 * 
	 * @return the cjtPlanet
	 */
	public List<Planet> getAll(){
		return cjtPlanet;
	}
	
	/**
	 * 
	 * @param planet
	 * @return
	 */
	public Planet getPlanetByName(String name){
		for(int i = 0; i < size(); ++i){
			if(name == cjtPlanet.get(i).getName()){
				return cjtPlanet.get(i);
			}
		}
		return null;
	}
	// Exist
	//-----------------------------------------------
	/**
	 * 
	 * @param g
	 * @return
	 */
	public boolean exist(Planet g){
		return cjtPlanet.contains(g);
	}
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public boolean existByName(String name) {
		for(int i = 0; i < size(); ++i){
			if(name == cjtPlanet.get(i).getName()) return true;
		}	
		return false;
	}

	// Utils
	//-----------------------------------------------
	
	public int size(){
		return cjtPlanet.size();
	}
}
