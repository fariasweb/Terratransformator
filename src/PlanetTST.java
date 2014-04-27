import java.*;

public class PlanetTST extends TST{
	TST<Planet> cjtPlanet;
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
	public String getPlanetByName(String name) throws Exception {	
		if (name == null || name.length() == 0) throw new Exception("Parameter name is not correct");
		if(!Util.checkName(name)) throw new Exception(name + " is not valid");
        if(planetClt.size() == 0) throw new Exception("No resources!");		
		Planet r = planetClt.get(name);
		if (r == null) throw new Exception("This resource doesn't exist");
		return r.toString();
	}

	public ArrayList<Planet> getMany(String name, int qtt) throws Exception {
		if (name == null || name.length() == 0) throw new Exception("Parameter name is not correct");
		if(!Util.checkName(name)) throw new Exception(name + " is not valid");
        if(planetClt.size() == 0) throw new Exception("No resources!");
		ArrayList<Planet> ar = planetClt.valuesCache(name, qtt);
		return ar;
	}

	public Planet first(){
		return first();
	}

	public String firstKey(){
		return firstKey();
	}

	public int size(){
		return resourceClt.size();
	}

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

	public void save(){
		int i = 0;
		String last;
		ArrayList<Planet> planets; 
		while (i < cjtPlanet.size()){
			planets = valuesCache(planets.firstKey(),100);
			while(j < 100){
				//cjtPlanet.send(Array<List> hskfs)
				++j;
			}
			i += 100;
		}

	}

	public void load(){

	}

	public ArrayList toString(String name, int x, int y){
		ArrayList list = new ArrayList();
		list.add(name);
		list.add(Integer.toString(x));
		list.add(Integer.toString(y));
		return list;
	}
}