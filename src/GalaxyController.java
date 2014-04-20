

/*import Galaxy;
import GalaxyCollection;
*/
import java.util.ArrayList;
import java.util.List;

/**
 * GalaxyController
 * 
 * @author farias
 *
 */
public class GalaxyController extends AbstractController{

	TST<Galaxy> galaxyClt;
	
	/**
	 * 
	 */
	public GalaxyController() {
		galaxyClt = new TST<Galaxy>();
	}
	
	/**
	 * Crea una galaxia en el sistema
	 * Pre: El nombre de la galaxia no debe existir en el sistema
	 * Post: Se crea una galaxia con el nombre indicado
	 * 
	 * @param name
	 * @param x
	 * @param y
	 * @return boolean
	 * @throws Exception 
	 */
	public void create(String name, int x, int y) throws Exception {
		//if (this.galaxyClt.existByName(name)) throw new Exception(1, "Fran");
		Galaxy g = new Galaxy(name, x, y);
		galaxyClt.put(name, g);	
	}
	
	/**
	 * Devuelve un listado con el nombre de las galaxias ordenado por creaci—n
	 * TODO: Como lo hago para devolmes mas campos????
	 * @return List<String>
	 */
	public List<String> getAll() {
		
		List<String> list = new ArrayList<String>();
		
		//Comprobamos que exista algo en el array
		if(this.galaxyClt.size() > 0){
			for(Galaxy i : this.galaxyClt.values()){
				list.add(i.getName());
			}
		}
		return list;
	}
	
}
