import java.util.ArrayList;
import java.util.Iterator;

/**
 * GalaxyController
 * 
 */
public class GalaxyController extends AbstractController {

	// protected attributes
	protected TST<Galaxy> Clt;
	private PlanetController pc;

	/**
	 * Constructor 
	 * Post: Inicializa el contructor padre y el TST
	 */
	public GalaxyController(PlanetController Planetc) {
		super();
		Clt = new TST<Galaxy>();
		pc = Planetc;
	}

	// Create
	// ---------------------------------------------

	/**
	 * Crea una galaxia en el sistema Pre: El nombre de la galaxia no debe
	 * existir en el sistema Post: Se crea una galaxia con el nombre indicado
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
	 * Devuelve un listado con el nombre de las galaxias ordenado por orden
	 * alfabetico
	 * 
	 * @return String
	 */

	public String getAll() {

		String result = "";

		// Comprobamos que exista algo en el array
		if (Clt.size() > 0) {
			for (Galaxy i : Clt.values()) {
				result += i.toString() + "\n";
			}
		}
		return result;
	}

	/**
	 * Pre: El nombre no debe ser nulo y con longitud > 0 La galaxia debe
	 * existir
	 * 
	 * @param name
	 *            String
	 * @return
	 * @throws Exception
	 */
	public String getByNameToString(String name) throws Exception {

		Galaxy g = Clt.get(name);
		if (g == null)
			throw new Exception("This galaxy doesn't exist");

		return g.toString();
	}

	/**
	 * Pre: El nombre no debe ser nulo y con longitud > 0 La galaxia debe
	 * existir
	 * 
	 * @param name
	 *            String
	 * @return
	 * @throws Exception
	 */
	public Galaxy getByName(String name) throws Exception {

		Galaxy g = Clt.get(name);
		if (g == null)
			throw new Exception("This galaxy doesn't exist");

		return g;
	}

	/**
	 * Pre: El nombre no debe ser nulo y con longitud > 0 La galaxia debe
	 * existir
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
	 * Pre: El nombre no debe ser nulo y con longitud > 0 La galaxia debe
	 * existir El nombre de a nueva galaxia no debe de existir Post: Modifica
	 * los datos de la galaxia con new_nam
	 * 
	 * @param name
	 * @param new_name
	 * @param x
	 * @param y
	 * @throws Exception
	 */
	public void updateGalaxyName(String name, String new_name) throws Exception {

		// Cogemos la galxia
		Galaxy g = Clt.get(name);
		if (g == null)
			throw new Exception("This galaxy doesn't exist");

		// Actualizamos informacion
		// Si la galaxia tiene un nombre diferente se debe
		// extraer del arbol y volver a meter
		if (g.getName() != new_name) {

			String oldName = g.getName();
			g.setName(new_name);

			Clt.remove(oldName);
			Clt.put(new_name, g);
		}

	}

	// Delete
	// ---------------------------------------------

	/**
	 * Pre: El nombre no debe ser nulo y con longitud > 0 La galaxia debe
	 * existir Post: Eliminada la galaxia con nombre "name"
	 * 
	 * @param name
	 * @throws Exception
	 */
	public void removeGalaxy(String name) throws Exception {
		Galaxy g = Clt.get(name);
		if (g == null)
			throw new Exception("This galaxy doesn't exist");

		// Eliminos del conjunto
		Clt.remove(name);
		
		// Eliminamos todos los planets
		g.removeAllPlanets();

		
	}

	/**
	 * Post: No existe ninguna galaxia
	 * 
	 * @throws Exception
	 */
	public void removeAllGalaxy() throws Exception {

		Iterator<Galaxy> iterator = Clt.values().iterator();

		// Recoremos todas las galaxias
		while (iterator.hasNext()) {
			Galaxy g = (Galaxy) iterator.next();
			// Eliminamos de la colecion
			Clt.remove(g.getName());
			// Eliminamos todos los planetnas de esa galaxia
			g.removeAllPlanets();
		}

	}

	// ---------------------------------------------
	// Planets
	// ---------------------------------------------

	// Create
	// ---------------------------------------------
	// EL otro controlador debe devolverme la referencia del planeta, no un
	// string

	/**
	 * Pre: La galaxia y el planeta deben existir El planeta no debe tener otra
	 * galaxia asignaada o estar en esta ya
	 * 
	 * @param GalaxyName
	 * @param PlanetName
	 * @throws Exception
	 */
	public void addPlanet(String GalaxyName, String PlanetName,
			PlanetController pc) throws Exception {

		// 1. Comprobar la existencia de galaxia
		Galaxy g = Clt.get(GalaxyName);
		if (g == null)
			throw new Exception("The galaxy " + GalaxyName + " does not exist");

		// 2. Comprobar la existencia de planeta en controlador de planetas
		// Pre: El planeta no debe tener otra galaxia asignaada o estar en esta
		// ya
		Planet p = pc.getByName(PlanetName);
		if (p == null)
			throw new Exception("The planet " + PlanetName + " does not exist");
		if (p.getGalaxy() != null)
			throw new Exception("The planet " + PlanetName + " is in a galaxy");

		// 3. Asignar planeta a galaxia y viceversa
		g.addPlanet(p);

	}

	// Read
	// ---------------------------------------------

	/**
	 * Pre: La galaxia debe existir
	 * 
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public String getPlanetsFromGalaxy(String name) throws Exception {
		// Cogemos la galxia
		Galaxy g = Clt.get(name);
		if (g == null)
			throw new Exception("This galaxy doesn't exist");

		String result = "";
		// Comprobamos que exista algo en el array
		if (g.getPlanets().size() > 0) {
			for (Planet i : g.getPlanets().values()) {
				result += i.toString() + "\n";
			}
		}

		return result;
	}

	// Delete
	// ---------------------------------------------

	/**
	 * Pre: La galaxia y el planeta deben existir
	 * 
	 * @param GalaxyName
	 * @param Planetname
	 * @throws Exception
	 */
	public void removePlanetFromGalaxy(String GalaxyName, String Planetname)
			throws Exception {
		// Cogemos la galxia
		Galaxy g = Clt.get(GalaxyName);
		if (g == null)
			throw new Exception("This galaxy " + GalaxyName + "doesn't exist");

		// Eliminamos el planeta de la galaxia
		g.removePlanet(Planetname);

	}

	/**
	 * Pre: La galaxia debe existir Post: Eliminado todos los planetas de la
	 * galaxia indicada
	 * 
	 * @param GalaxyName
	 * @throws Exception
	 */
	public void removePlanetsFromGalaxy(String GalaxyName) throws Exception {
		// Cogemos la galxia
		Galaxy g = Clt.get(GalaxyName);
		if (g == null)
			throw new Exception("This galaxy doesn't exist");

		// Eliminamos todas las galaxias
		g.removeAllPlanets();
	}

	// Save&Load
	// ---------------------------------------------

	/**
	 * Debe indicarse en cada controlador Post: Pasa el String a memoria como
	 * objetos
	 * 
	 * @param l
	 * @throws Exception
	 */
	protected void decodeString(String l) throws Exception {

		// Corta el string por el separador interno
		String[] s = l.split(" ");

		// Comprueba que sea correcto y tengo el numero de elemntos minimo
		if (s.length < 3)
			throw new Exception("The record is not correct");

		// Separaci—n especifica de galaxia
		String name = s[0];
		int x = Integer.parseInt(s[1]);
		int y = Integer.parseInt(s[2]);

		// A–ade a la colecci—n
		addGalaxy(name, x, y);
		
		//Relacion con planetas
		if (s.length > 3) {
			Galaxy g = getByName(name);
			Planet p;
			String error = "";
			int i = 3;
			
			//Recoremos todos los planetas
			while (i < s.length) {
				try {
					//Cogemos e planeta
					p = pc.getByName(s[i]);
					if (p == null) throw new Exception("The planet does not exist");
					
					//A–adimos a la galaxia
					g.addPlanet(p);
					
				} catch (Exception e) {
					error += "Relation with planet "+s[i]+" can not do: "+e.getMessage()+"\n";
				}
				
				//Aumentamos la posicion
				i += 1;
			}
			
			//En caso de error en alguna relacion lanzamos una excepcion
			if (error.length() > 0) 
				throw new Exception("Fail to relation planets whit galaxy "+name+"\n"+error);
		}

	}

	/**
	 * Debe indicarse en cada controlador Post: Pasa el String a memoria como
	 * objetos
	 * 
	 * @param l
	 * @throws Exception
	 */
	protected String encodeString() throws Exception {

		String encodeS = "";
		ArrayList<Galaxy> list;

		// Diferenciamos si es la primera vez
		if (_last_key == "") {
			// En caso de ser la primera vez como no tenemos indicado
			// el _last_key usamos el primer elemento
			encodeS = Clt.first().toString() + _SEPARATOR;
			list = Clt.valuesCache(Clt.firstKey(), _CACHE_NUM - 1);
		} else {
			// Como tenemos un _last_key partimos desde este
			list = Clt.valuesCache(_last_key, _CACHE_NUM);
		}

		// Pasamos objetos a cache
		for (Galaxy p : list) {
			encodeS += p.toString() + _SEPARATOR;
			_last_key = p.getName();
		}

		return encodeS;
	}

	/**
	 * Devuelvel numero de galaxias que contiene
	 * @return int
	 */
	public int size() {
		return Clt.size();
	}
	
	/**
	 * Compruba que esten todos los datos necesarios para hacer la carga de datos
	 * Pre: Deben existir planetas en el controlador de Planetas
	 * 
	 */
	protected void preConditionLoad() throws Exception {
		if (pc.size() == 0) throw new Exception("Planet Controler must have planets to load galaxis");
	}

}
