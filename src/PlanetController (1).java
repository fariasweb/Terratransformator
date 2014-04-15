/*import planet;
import planetCollection;
*/
import java.util.ArrayList;
import java.util.List;

public class PlanetController extends AbstractController{
// NO SE PONE TRY CATCH EN EL CONTROLADOR
	PlanetCollection planetClt;
	
	public PlanetController() {
		planetClt = new PlanetCollection();
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
			return this.planetClt.add(g);	
	}
	
	/**
	 * Devuelve un listado con el nombre de las planeta ordenado por creaci—n
	 * TODO: Como lo hago para devolmes mas campos????
	 * @return List<String>
	 */
	public List<String> getAll() {
		List<String> list = new ArrayList<String>();
		if(this.planetClt.size() > 0){
			for(Planet i : this.planetClt.getAll()){
				list.add(i.getName());
			}
		}
		return list;
	}
	
	/**
	 * 
	 * @param p
	 */
	public void remove(Planet p){
		planetClt.remove(p);
	}
	
	/**
	 * 
	 * @param name
	 */
	public void removePlanetByName(String name){
		planetClt.removePlanetByName(name);	
	}
	
	/**
	 * 
	 * @param g
	 * @return boolean
	 */
	public boolean add(Planet g){
		return planetClt.add(g);
	}
	/**
	 * 
	 */
	public void guardarPlaneta(){
		
	}
	
	public void cargarPlaneta(){
		
	}
	
}
