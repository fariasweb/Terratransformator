/**
 * GalaxyController
 * 
 * 
 *
 */

import java.util.ArrayList;
import java.util.List;

public class ResourceController extends AbstractController{

	ResourceCollection resourceCjt;
		
	/**
	 * 
	 */
	public ResourceController() {
		resourceCjt = new ResourceCollection();
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
	public boolean createResource(String name, ResourceType type) {
		//TODO Validaciones (o en recurso?)
				
		Resource r = new Resource(name, type);
		
		return resourceCjt.add(r);	
	}
	
	/**
	 * Devuelve un listado con el nombre de los recursos ordenado por creación
	 * TODO: Como lo hago para devolver mas campos????(el tipo)
	 * @return List<String>
	 */
	public List<String> getAll() {
		
		List<String> list = new ArrayList<String>();
		
		//Comprobamos que exista algo en el array
		if(resourceCjt.size() > 0){
			for(Resource i : resourceCjt.getAll()){
				list.add(i.getName());
			}
		}
		return list;
	}
	
        /**
	 * Devuelve un listado con el nombre de los recursos ordenado por nombre
	 * (Hace falta lo mismo por tipo??)
	 * @return List<String>
	 */
        public List<String> getAllByName(){
            
            List<String> list = new ArrayList<String>();
            
            if(resourceCjt.size() > 0){
                //TODO: Depende de la implementación final (TreeMap, Hash, ...???)
            }
            return list;
        }
        
        /**
         * Devuelve un listado de los planetas en que se encuentra el recurso.
         * @param name
         * @return list<String>
         */
        public List<String> getPlanetsOfResource(String name){
            
            List<String> list = new ArrayList<String>();
            
            Reseource r = resourceCjt.getByName(name);
            
            for(Planet i : planetCtl.getAll())
                if(i.getNameResourceHas() == name)
                    list.add(i.getName());
            
            return list;
        }
        
         /**
         * Devuelve un listado de los paquetes en que se encuentra el recurso.
         * @param name
         * @return list<String>
         */
         public List<String> getPacketsOfResource(String name){
            
            List<String> list = new ArrayList<String>();
            
            Reseource r = resourceCjt.getByName(name);
            
            for(Packet i : packetCtl.getAll())
                if(i.getNameResourceHas() == name)
                    list.add(i.getName());
            
            return list;
        }
}
