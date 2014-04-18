import java.util.*;

public class PlanetCollection {
	TST<Planet> cjtPlanet;
	
	//Contructs
	//---------------------------------------------
	
	public PlanetCollection(){
		cjtPlanet = new TST<Planet>();
	}
	
	//Setter
	//---------------------------------------------
	
	/**
	 * 
	 * @param namep
	 * @return
	 */
	public void removePlanetByName(String namep) throws Exception{
		cjtPlanet.remove(namep);
    }
	  
	public void clear(){
		cjtPlanet.clear();
	}

	
	//Getter
	//-----------------------------------------------
	/**
	 * 
	 * @return TST<Planet>
	 */
	public TST<Planet> getAll(){
		return cjtPlanet;
	}
	
	/**
	 * 
	 * @param namep
	 * @return
	 */
	public Planet getPlanetByName(String namep){
		return cjtPlanet.get(namep);
	}
	// Exist
	//-----------------------------------------------
	/**
	 * @param g
	 * @return
	 */
	public boolean exist(Planet g){
		return cjtPlanet.contains(g.getName());
	}
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public boolean existByName(String namep) {
		return cjtPlanet.contains(namep);
	}

	// Utils
	//-----------------------------------------------
	
	public int size(){
		return cjtPlanet.size();
	}
}
