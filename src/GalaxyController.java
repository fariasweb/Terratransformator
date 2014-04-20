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
	
	// Create
	// ---------------------------------------------
	
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
	public void addGalaxy(String name, int x, int y) throws Exception {
		if (galaxyClt.contains(name)) throw new Exception("This galaxy name exist");
		
		Galaxy g = new Galaxy(name, x, y);
		galaxyClt.put(name, g);	
	}

	// Read
	// ---------------------------------------------
	
	/**
	 * Devuelve un listado con el nombre de las galaxias ordenado por creaci—n
	 * TODO: Como lo hago para devolmes mas campos????
	 * @return List<String>
	 */
	public List<String> getAll() {
		
		List<String> list = new ArrayList<String>();
		
		//Comprobamos que exista algo en el array
		if(galaxyClt.size() > 0){
			for(Galaxy i : galaxyClt.values()){
				list.add(i.getName());
			}
		}
		return list;
	}
	
	/**
	 * Pre: El nombre no debe ser nulo y con longitud > 0
	 * 		La galaxia debe existir
	 * Post:
	 * 
	 * @param name String
	 * @return
	 * @throws Exception
	 */
	public List<String> getByName(String name) throws Exception {
		
		if (name == null || name.length() == 0) throw new Exception("Parameter name is not correct");
		Galaxy g = galaxyClt.get(name);
		
		if (g == null) throw new Exception("This galaxy doesn't exist");
		
		//TODO: Array con los datos
		
		return null;
	}
	
	/**
	 * Pre: El nombre no debe ser nulo y con longitud > 0
	 * 		La galaxia debe existir
	 * 
	 * @param name
	 * @return Boolean
	 */
	private boolean existGalaxy(String name) {
		
		if (name == null || name.length() == 0) return false;
		
		return galaxyClt.contains(name);
	}
	
	// Update
	// ---------------------------------------------
	
	/**
	 * Pre: El nombre no debe ser nulo y con longitud > 0
	 * 		La galaxia debe existir
	 * 		Si la galaxia modifica su tama–o no deben haber planetas en esas cordenados
	 * Post: Modifica los datos de la galaxia con new_name, x e y
	 * 
	 * @param name
	 * @param new_name
	 * @param x
	 * @param y
	 * @throws Exception
	 */
	public void updateGalaxy(String name, String new_name, int x, int y) throws Exception {
		if (name == null || name.length() == 0) throw new Exception("Parameter name is not correct");
		
		//Cogemos la galxia
		Galaxy g = galaxyClt.get(name);
		if (g == null) throw new Exception("This galaxy doesn't exist");

		//Actualizamos informacion
		//Si la galaxia tiene un ombre diferente se debe extraer del arbol y volver a meter
		if (g.getName() != new_name) {
			galaxyClt.remove(g.getName());
			g.setName(new_name);
			galaxyClt.put(new_name, g);	
		}
		
		
		//TODO: Comprobar que, en caso de ser menor que el actual no 
		//existan planetas en ella
		PairInt pi = g.getSize();
		if (pi.getX() > x || pi.getY() > y) {
			
		}
		
		g.setSize(x, y);
		
	}
	
	// Delete
	// ---------------------------------------------

	/**
	 * Pre: El nombre no debe ser nulo y con longitud > 0
	 * 		La galaxia debe existir
	 * @param name
	 * @throws Exception
	 */
	public void removeGalaxy(String name) throws Exception {
		
		galaxyClt.remove(name);
		
	}
	
	/**
	 * 
	 */
	public void removeAllGalaxy() {
		galaxyClt.clear();
	}
	
	
	// ---------------------------------------------
	// Planets
	// ---------------------------------------------
	
	// Create
	// ---------------------------------------------
	
	public void addPlanet (String name) {
		
	}
	
	// Read
	// ---------------------------------------------
	
	public List<String> getPlanetsFromGalaxy(String name) {
		
		return null;
	}
	
	public List<String> getPlanets() {
		
		return null;
	}
	
	// Delete
	// ---------------------------------------------
	
	public void removePlanetFromGalaxy(String GalaxyName, String Planetname) {
		
	}
	
	public void removePlanetsFromGalaxy(String GalaxyName) {
		
	}
	
}
