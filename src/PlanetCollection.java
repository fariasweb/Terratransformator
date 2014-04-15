
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
	
	public boolean add(Planet g){
		return cjtPlanet.add(g);
	}
		
	public boolean remove(Planet g){
		return cjtPlanet.remove(g);
	}
	    
	public void clear(){
		cjtPlanet.clear();
	}

	
	//Getter
	//-----------------------------------------------
		
	public List<Planet> getAll(){
		return cjtPlanet;
	}
	
	// Exist
	//-----------------------------------------------

	public boolean exist(Planet g){
		return cjtPlanet.contains(g);
	}
	
	public boolean existByName(String name) {
		//TODO
		return false;
	}
	
	// Utils
	//-----------------------------------------------
	
	public int size(){
		return cjtPlanet.size();
	}
}
