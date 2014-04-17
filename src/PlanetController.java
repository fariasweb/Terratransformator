/*import planet;
import planetCollection;
*/
import java.util.ArrayList;
import java.util.List;

public class PlanetController extends AbstractController{
// NO SE PONE TRY CATCH EN EL CONTROLADOR
	PlanetCollection planetCtl;
	
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
	
	/**
	 * 
	 * @param p
	 */
	public void remove(Planet p){
		planetCtl.remove(p);
	}
	
	/**
	 * 
	 * @param name
	 */
	public void removePlanetByName(String name){
		planetCtl.removePlanetByName(name);	
	}
	
	/**
	 * 
	 * @param g
	 * @return boolean
	 */
	public boolean add(Planet g){
		return planetCtl.add(g);
	}

	public boolean addPlanetByName(String name){
		return planetCtl.addPlanetByName(name);
	}
	/**
	 * 
	 */
	public void guardarPlaneta(){
		
	}
	
	public void cargarPlaneta(){
		
	}
	
}
