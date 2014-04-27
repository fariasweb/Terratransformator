/*import planet;
import planetCollection;
*/
import java.util.ArrayList;
import java.util.List;

public class PlanetController extends AbstractController{

	private TST<Planet> planetCtl;
	
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
			planetCtl.put(g.getName(),g);	
	}
	
	//Setter
	//---------------------------------------------

	public void removePacket(String namep){
		Planet g = planetCtl.get(namep);
		g.removePacket();
	}
	
	public void setPacket(String namep, String p) throws Exception{
		Planet g = planetCtl.get(namep);
		Packet paq = getPacketByName(p);
		g.setPacket(paq);
	}


	public void setName(String oldName, String newName) throws Exception{
		Planet g = planetCtl.get(oldName);
		g.setName(newName);
	}

	public void setPosition(String namep, int x, int y) throws Exception {
		Planet g = planetCtl.get(namep);
		g.setPosition(x,y);
	}


	/**
	 * 
	 * @param name
	 */
	public void removePlanetByName(String namep) throws Exception {
		planetCtl.remove(namep);	
	}
	


	//Getter
	//---------------------------------------------
	
	/**
	 * Devuelve un listado con el nombre de las planeta ordenado por creaci—n
	 * TODO: Como lo hago para devolmes mas campos????
	 * @return List<String>
	 */
	public List<String> getAll() {
		List<String> list = new ArrayList<String>();
		for(Planet i : planetCtl.values()){
			list.add(i.getName());
		}
		return list;
	}
	
	public PairInt getPosition(String namep){
		return planetCtl.get(namep).getPosition();
		
	}
	public Packet getPacket(String namep){
		return planetCtl.get(namep).getPacket();
		
	}
 	
 	public TST<Planet> getPlanetCtl(){
 		return planetCtl;
 	}
	/**
	 * 
	 */
	public void savePlanet(){}
	
	public void loadPlanet(){}

	//FUNCIONES COLECCION DE PLANETAS

	/**
	 * 
	 * @param namep
	 * @return
	 */
	
	public void clear(){
		planetCtl.clear();
	}

	
	//Getter
	//-----------------------------------------------
	
	/**
	 * 
	 * @return TST<Planet>
	 */
	public TST<Planet> getAllPlanet(){
		return planetCtl;
	}
	
	/**
	 * 
	 * @param namep
	 * @return
	 */
	public Planet getPlanetByName(String namep){
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
	 * 
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

}
