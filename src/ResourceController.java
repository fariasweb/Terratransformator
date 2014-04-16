/**
 * GalaxyController
 * 
 * 
 *
 */

import java.util.ArrayList;
import java.util.List;

public class ResourceController extends AbstractController{
	ResourceCollection resourceCtl;
	/**
	 * 
	 */
	public ResourceController() {
		resourceCtl = new ResourceCollection();
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
	public boolean createResource(String name, ResourceType type) throws Exception{
		//TODO Validaciones (o en recurso?)
				
		Resource r = new Resource(name, type);
		
		return resourceCtl.add(r);	
	}
	
	/**
	 * Devuelve un listado con el nombre de los recursos ordenado por creación
	 * TODO: Como lo hago para devolver mas campos????(el tipo)
	 * @return List<String>
	 */
	public List<String> getAll() {
		
		List<String> list = new ArrayList<String>();
		for(Resource i : resourceCtl.getAll()){
			list.add(i.getName());
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
        if(resourceCtl.size() > 0){
                //TODO: Depende de la implementación final (TreeMap, Hash, ...???)
        }
        return list;
    }
        
    /**
    * Devuelve un listado de los planetas en que se encuentra el recurso.
    * @param name
    * @return list<String>
    */

    //EN LAS SIGUIENTES DOS FUNCIONES HAY ERRORES POR UN TUBO
    /*public List<String> getPlanetsOfResource(String name){
        List<String> list = new ArrayList<String>();
        Resource r = resourceCtl.getByName(name);
        for(Planet i : planetCtl.getAll())
            if(i.getNameResourceHas() == name) list.add(i.getName());
            return list;
        }
    }   
    
   public List<String> getPacketsOfResource(String name){
        List<String> list = new ArrayList<String>();
        Resource r = resourceCtl.getResourceByName(name);
        for(Packet i : packetCtl.getAll()){
            if(i.getNameResourceHas() == name){ 
            	list.add(i.getName());
            }
            return list;
        }  
    }*/


	public void remove(Resource r){
		resourceCtl.remove(r);
	}
	
	/**
	 * 
	 * @param name
	 */
	public void removeResourceByName(String name){
		resourceCtl.removeResourceByName(name);	
	}
	
	public void add(Resource r){
		resourceCtl.add(r);
	}

	/**
	 * 
	 * @param g
	 * @return boolean
	 */
	public boolean addResourceByName(String name){
		return resourceCtl.addResourceByName(name);
	}

    public void guardarPlaneta(){
		
	}
	public void cargarPlaneta(){
		
	}
	
}
