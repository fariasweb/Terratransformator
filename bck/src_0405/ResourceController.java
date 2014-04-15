/**
 * GalaxyController
 * 
 * @author farias
 *
 */

import java.util.ArrayList;
import java.util.List;

public class ResourceController extends AbstractController{

	ResourceCollection resourceClt;
		
	/**
	 * 
	 */
	public ResourceController() {
		resourceClt = new ResourceCollection();
	}
	
	/**
	 * Crea una recurso en el sistema
	 * Pre: El nombre del recursos no debe existir en el sistema
	 * Post: Se crea un recurso con el nombre y tipo indicado
	 * 
	 * @param name
	 * @param type ResourceType
	 * @return boolean
	 */
	public boolean create(String name, ResourceType type) {
		//TODO Validaciones
		//if (resourceClt.existByName(name)) throw new Exception(1, "Fran");
		
		Resource g = new Resource(name, type);
		
		return resourceClt.add(g);	
	}
	
	/**
	 * Devuelve un listado con el nombre de los recursos ordenado por creaci—n
	 * TODO: Como lo hago para devolmes mas campos????
	 * @return List<String>
	 */
	public List<String> getAll() {
		
		List<String> list = new ArrayList<String>();
		
		//Comprobamos que exista algo en el array
		if(resourceClt.size() > 0){
			for(Resource i : resourceClt.getAll()){
				list.add(i.getName());
			}
		}
		return list;
	}
	
}
