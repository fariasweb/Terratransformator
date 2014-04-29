/*import planet;
import planetCollection;
*/
import java.util.ArrayList;
import java.util.List;

public class PlanetController extends AbstractController{

	private TST<Planet> planetCtl;
	
	private final String path_file = "";

	public PlanetController() {
		planetCtl = new TST<Planet>();
	}
	/**
	 * Crea una galaxia en el sistema
	 * Pre: El nombre del planeta no debe existir en el sistema
	 * 		Las posiciones del planeta no deben de estar ocupadas
	 * Post: Se crea un planeta con el nombre y pos indicado
	 * 
	 * @param name
	 * @param x
	 * @param y
	 * @return boolean
	 */
	public void createPlanet(String name, int x, int y) throws Exception {
			Planet g = new Planet(name, x, y);
			if(planetCtl.get(g.getName()) != null) throw new Exception("This planet already exists!");
			planetCtl.put(g.getName(),g);	
	}
	
	//Setter
	//---------------------------------------------

	public void removePacket(String namep) throws Exception{
		Planet g = planetCtl.get(namep);
		if(g.getPacket() != null) g.removePacket();
	}
	
	public void setPacket(String namep, String namePacket) throws Exception{
		Planet p = planetCtl.get(namep);
		if (p == null) throw new Exception("This planet doesn't exist");
		if(p.getPacket() != null) throw new Exception("There is a packet already assigned!");
		Packet paq = p.getPacket();
		p.setPacket(paq);
	}


	public void setName(String oldName, String newName) throws Exception{
		Planet p = planetCtl.get(oldName);
		if (p == null) throw new Exception("This planet doesn't exist");
		if (p.getName() != newName) {
			if (!Util.checkName(newName)) throw new Exception(newName + " is not valid");
			planetCtl.remove(p.getName());
			p.setName(newName);
			planetCtl.put(newName, p);	
		}
	}

	public void setPosition(String namep, int x, int y) throws Exception {
		//TODO: Comprobar solapamiento
		Planet p = planetCtl.get(namep);
		if (p == null) throw new Exception("This planet doesn't exist");
		if (!(p.getPosition().getX() == x && p.getPosition().getY() == y)){
			p.setPosition(x,y);
			planetCtl.remove(p.getName());
			planetCtl.put(namep,p);
		}
	}

	
	//Getter
	//---------------------------------------------

	public PairInt getPosition(String namep) throws Exception{
		Planet p = planetCtl.get(namep);
		if (p == null) throw new Exception("This planet doesn't exist");
		return p.getPosition();
		
	}
	public Packet getPacket(String namep) throws Exception {
		Planet p = planetCtl.get(namep);
		if (p == null) throw new Exception("This planet doesn't exist");
		return p.getPacket();
		
	}
 	
	/////////////////////////////////FUNCIONES TST<PLANET>

	/**
	 * @param namep
	 * @return
	 */
	
	public void clear(){
		planetCtl.clear();
	}

	//Setter
	
	/** 
	 * @param namep
	 * @return
	 */
	public void removePlanetByName(String namep) throws Exception {
		Planet g = planetCtl.get(namep);
		if (g == null) throw new Exception("This planet doesn't exist");
		planetCtl.remove(namep);
	}



	//Getter
	//-----------------------------------------------
	
	public List<String> getAll() {
		List<String> list = new ArrayList<String>();
		for(Planet i : planetCtl.values()){
			list.add(i.getName());
		}
		return list;
	}

	/**
	 * @return TST<Planet>
	 */
	public TST<Planet> getAllPlanet(){
		return planetCtl;
	}
	
	/**
	 * @param namep
	 * @return
	 */
	public Planet getPlanetByName(String namep) throws Exception{
		if (!existByName(namep)) throw new Exception("This planet doesn't exist!"); 
		return planetCtl.get(namep);
	}
	// Exist
	//-----------------------------------------------
	/**
	 * @param g
	 * @return
	 */
	public boolean exist(Planet g){
		return planetCtl.contains(g.getName());
	}
	
	/**
	 * @param name
	 * @return
	 */
	public boolean existByName(String namep) {
		return planetCtl.contains(namep);
	}

	// Utils
	//-----------------------------------------------
	public int size(){
		return planetCtl.size();
	}

	public void save() throws Exception {

		String cache = PlanetCtl.first().toString();
		ArrayList<Planet> list = planetCtl.getMany(planetCtl.firstKey(), 5);
		for(Planet r : list) cache += r.toString();
		while(list.size() > 0){
			list = planetCtl.getMany(list.get(list.size()-1).getName(),5);
			cache = "";
			for(Planet r : list)
				cache += r.toString();
		}
	} 
}
