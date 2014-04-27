import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * GalaxyController
 * 
 * @author farias
 *
 */
public class GalaxyController extends AbstractController{

	TST<Galaxy> Clt;
	//GalaxyControllerGD GGD;
	
	private final String _path_file = "";
	//PlanetController PlanetC;
	//Pasar por parametros en la funciones q lo necesite
	
	/**
	 * 
	 */
	public GalaxyController() {
		Clt = new TST<Galaxy>();
		//GGD = new GalaxyControllerGD;
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
		
		Galaxy g = new Galaxy(name, x, y);
		Clt.put(name, g);
	}

	// Read
	// ---------------------------------------------
	
	/**
	 * Devuelve un listado con el nombre de las galaxias ordenado por creaci—n
	 * TODO: Como lo hago para devolmes mas campos????
	 * @return String
	 */

	public String getAll() {
		
		String result = "";
		
		//Comprobamos que exista algo en el array
		if(Clt.size() > 0){
			for(Galaxy i : Clt.values()){
				result += i.toString()+"\n";
			}
		}
		return result;
	}
	
	/**
	 * Pre: El nombre no debe ser nulo y con longitud > 0
	 * 		La galaxia debe existir
	 * 
	 * @param name String
	 * @return
	 * @throws Exception
	 */
	public String getByNameToString(String name) throws Exception {
				
		Galaxy g = Clt.get(name);
		if (g == null) throw new Exception("This galaxy doesn't exist");
		
		return g.toString();
	}
	
	/**
	 * Pre: El nombre no debe ser nulo y con longitud > 0
	 * 		La galaxia debe existir
	 * 
	 * @param name String
	 * @return
	 * @throws Exception
	 */
	 public Galaxy getByName(String name) throws Exception {
				
		Galaxy g = Clt.get(name);
		if (g == null) throw new Exception("This galaxy doesn't exist");
		
		return g;
	 }
	
	/**
	 * Pre: El nombre no debe ser nulo y con longitud > 0
	 * 		La galaxia debe existir
	 * 
	 * @param name
	 * @return Boolean
	 */
	public boolean existGalaxy(String name) {		
		return Clt.contains(name);
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
	public void updateGalaxyName(String name, String new_name) throws Exception {
		
		//Cogemos la galxia
		Galaxy g = Clt.get(name);
		if (g == null) throw new Exception("This galaxy doesn't exist");

		//Actualizamos informacion
		//Si la galaxia tiene un ombre diferente se debe extraer del arbol y volver a meter
		if (g.getName() != new_name) {
			Clt.remove(g.getName());
			g.setName(new_name);
			Clt.put(new_name, g);	
		}
		
	}
	
	// Delete
	// ---------------------------------------------

	/**
	 * Pre: El nombre no debe ser nulo y con longitud > 0
	 * 		La galaxia debe existir
	 * Post: Eliminada la galaxia con nombre "name"
	 * @param name
	 * @throws Exception
	 */
	public void removeGalaxy(String name) throws Exception {
		Galaxy g = Clt.get(name);
		if (g == null) throw new Exception("This galaxy doesn't exist");
		
		//Eliminamos todos los planets
		g.removeAllPlanets();
		
		//Eliminos del conjunto
		Clt.remove(name);
	}
	
	/**
	 * Post: No existe ninguna galaxia
	 * @throws Exception 
	 */
	public void removeAllGalaxy() throws Exception {
		
		Iterator<Galaxy> iterator = Clt.values().iterator();

		while (iterator.hasNext()) {
			Galaxy g = (Galaxy) iterator.next();
			Clt.remove(g.getName());
			g.removeAllPlanets();
		}
		
		
	}
	
	
	// ---------------------------------------------
	// Planets
	// ---------------------------------------------
	
	// Create
	// ---------------------------------------------
	// TODO: Buscarlo en el otro controlador de planetas el planeta
	// EL otro controlador debe devolverme la referencia del planeta, no un string
	
	/**
	 * TODO: Pasar por paremtros la referencia al controlador de planetas
	 * @param GalaxyName
	 * @param PlanetName
	 */
	public void addPlanet (String GalaxyName, String PlanetName) {
		
		//1. Comprobar la existencia de galaxia
		
		//2. COmprobar la existencia de planeta en controlador de planetas
		//Pre: El planeta no debe tener otra galaxia asignaada o estar en esta ya
		
		//3. Asignar planeta a galaxia y viceversa
		
	}
	
	// Read
	// ---------------------------------------------
	
	/**
	 * Pre: La galaxia debe existir
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public String getPlanetsFromGalaxy(String name) throws Exception {		
		//Cogemos la galxia
		Galaxy g = Clt.get(name);
		if (g == null) throw new Exception("This galaxy doesn't exist");

		String result = "";
		//Comprobamos que exista algo en el array
		if(g.getPlanets().size() > 0){
			for(Planet i : g.getPlanets().values()){
				result += i.toString()+"\n";
			}
		}
		
		return result;
	}
	
	// Delete
	// ---------------------------------------------
	
	/**
	 * Pre: La galaxia y el planeta deben existir
	 * @param GalaxyName
	 * @param Planetname
	 * @throws Exception
	 */
	public void removePlanetFromGalaxy(String GalaxyName, String Planetname) throws Exception {
		//Cogemos la galxia
		Galaxy g = Clt.get(GalaxyName);
		if (g == null) throw new Exception("This galaxy "+GalaxyName+"doesn't exist");
		
		g.removePlanet(Planetname);

	}
	
	/**
	 * Pre: La galaxia debe existir
	 * Post: Eliminado todos los planetas de la galaxia indicada
	 * @param GalaxyName
	 * @throws Exception
	 */
	public void removePlanetsFromGalaxy(String GalaxyName) throws Exception {
		//Cogemos la galxia
		Galaxy g = Clt.get(GalaxyName);
		if (g == null) throw new Exception("This galaxy doesn't exist");
		
		g.removeAllPlanets();
	}
	
	// Save&Load
	// ---------------------------------------------
	
	protected void parseString(String l) {
		
		/*String[] s = l.split(" ");
		
		if (s.length != 3) throw new Exception();
		
		String name = s[0];
		int x = Integer.parseInt(s[1]);
		int y = Integer.parseInt(s[2]);
		
		addGalaxy(name, x, y);
		*/
	}
	
}
