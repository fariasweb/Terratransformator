/*import planet;
import planetCollection;
*/
import java.util.ArrayList;
import java.util.List;

public class PlanetController extends AbstractController{

	private PlanetCollection planetCtl;
	
	public PlanetController() {
		planetCtl = new PlanetCollection();
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
	public boolean createPlanet(String name, int x, int y) throws Exception {
			Planet g = new Planet(name, x, y);
			return planetCtl.add(g);	
	}
	
	//Setter
	//---------------------------------------------

	public void removePacket(String namep){
		Planet g = planetCtl.getPlanetByName(namep);
		g.removePacket();
	}
	
	public void setPacket(String namep, String p) throws Exception{
		Planet g = planetCtl.getPlanetByName(namep);
		g.setPacket(p);
	}


	public void setName(String oldName, String newName) throws Exception{
		Planet g = planetCtl.getPlanetByName(oldName);
		g.setName(newName);
	}

	public void setPosition(String namep, int x, int y) throws Exception {
		Planet g = planetCtl.getPlanetByName(namep);
		g.setPosition(x,y);
	}


	/**
	 * 
	 * @param name
	 */
	public boolean removePlanetByName(String namep) throws Exception {
		return planetCtl.removePlanetByName(namep);	
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
		for(Planet i : planetCtl.getAll()){
			list.add(i.getName());
		}
		return list;
	}
	
	public PairInt getPosition(String namep){
		return planetCtl.getPlanetByName(namep).getPosition();
		
	}
	public Packet getPacket(String namep){
		return planetCtl.getPlanetByName(namep).getPacket();
		
	}
 	
 	public PlanetCollection getPlanetCtl(){
 		return planetCtl;
 	}
	/**
	 * 
	 */
	public void savePlanet(){
		
	}
	
	public void loadPlanet(){
		
	}
}
