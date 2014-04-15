

/*import planet;
import planetCollection;
*/
import java.util.ArrayList;
import java.util.List;

/**
 * planetController
 * 
 * @author farias
 *
 */
public class PlanetController extends AbstractController{

	PlanetCollection planetClt;
	
	/**
	 * 
	 */
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
	public boolean create(String name, int x, int y) {
		//if (this.planetClt.existByName(name)) throw new Exception(1, "Fran");
		
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
		
		//Comprobamos que exista algo en el array
		if(this.planetClt.size() > 0){
			for(Planet i : this.planetClt.getAll()){
				list.add(i.getName());
			}
		}
		return list;
	}
	
}
