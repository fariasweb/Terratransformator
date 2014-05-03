import java.util.ArrayList;
import java.util.Iterator;

/**
 * PlanetController
 * 
 */

public class PlanetController extends AbstractController {

	// protected attributes
	protected TST<Planet> Clt;

	/**
	 * Constructora 
	 * Post: Inicializa el contructor padre y el TST
	 */
	public PlanetController() {
		super();
		Clt = new TST<Planet>();
	}

	// Create
	// ---------------------------------------------

	/**
	 * Crea un planeta en el sistema 
	 * Pre: El nombre del planeta no debe existir
	 * en el sistema Las posiciones del planeta no deben de estar ocupadas +
	 * Post: Se crea un planeta con el nombre y pos indicado
	 * 
	 * @param name
	 * @param x
	 * @param y
	 * @return boolean
	 */
	public void addPlanet(String name, int x, int y) throws Exception {
		
		Planet g = new Planet(name, x, y);

		// A–adimos el planeta al TST
		Clt.put(g.getName(), g);
	}

	// Read
	// ---------------------------------------------
	/**
	 * Devuelve un listado con el nombre de los planetas ordenado por orden
	 * alfabetico
	 * 
	 * @return String
	 */

	public String getAll() {

		String result = "";

		// Comprobamos que exista algo en el array
		if (Clt.size() > 0) {
			for (Planet i : Clt.values()) {
				result += i.toString() + "\n";
			}
		}
		return result;
	}

	
	/**
	 * Pre: El nombre no debe ser nulo y con longitud > 0 
	 * El planeta debe existir
	 * 
	 * @param name String
	 * @return
	 * @throws Exception
	 */
	public String getByNameToString(String name) throws Exception {

		Planet g = Clt.get(name);
		if (g == null)
			throw new Exception("This planet doesn't exist");

		return g.toString();
	}

	/**
	 * Pre: El nombre no debe ser nulo y con longitud > 0 
	 * El planeta debe existir
	 * 
	 * @param name String
	 * @return
	 * @throws Exception
	 */
	public Planet getByName(String name) throws Exception {

		Planet g = Clt.get(name);
		if (g == null)
			throw new Exception("This planet doesn't exist");

		return g;
	}

	/**
	 * Pre: El nombre no debe ser nulo y con longitud > 0. El planeta debe
	 * existir
	 * 
	 * @param name
	 * @return Boolean
	 */
	public boolean existPlanet(String name) {
		return Clt.contains(name);
	}

	// Update
	// ---------------------------------------------
	/**
	 * Pre: El nombre no debe ser nulo y con longitud > 0 El planeta debe
	 * existir El nombre de a nuevo planeta no debe de existir 
	 * Post: Modifica los datos del planeta con newName
	 * 
	 * @param oldName
	 * @param newName
	 * @throws Exception
	 */
	public void updatePlanetName(String oldName, String newName) throws Exception {
		// Cogemos el planeta
		Planet p = Clt.get(oldName);
		if (p == null)
			throw new Exception("This planet doesn't exist");

		// Cimprobamos qu eno sea las misma galaxi
		if (p.getName() != newName) {
			if (!Util.checkName(newName))
				throw new Exception(newName + " is not valid");

			if (Clt.contains(newName))
				throw new Exception(newName + " is using in other planet");
			
			Clt.remove(oldName);
			p.setName(newName);
			Clt.put(newName, p);
			
			//En caso de estar en una galaxia
			//Cambier en el conjunto de la galaxia
			Galaxy g = p.getGalaxy();
			if (g != null) {
				//Eliminamos el antiguo
				g.getPlanets().remove(oldName);
				//A–adimos el nuevo
				g.getPlanets().put(newName, p);
			}
		}
	}

	/**
	 * Actualiza la posicon de un planeta
	 * Pre: El planeta debe exisitr
	 * 		Las cordenadas deben ser validas
	 * 		En caso de estar en una galaxia, las cordenadas deben estar
	 * 		dentro de la galaxia y que no exista otro planeta en su interior
	 * Post: El planeta tiene nuevas cordenadas
	 * @param namep
	 * @param x
	 * @param y
	 * @throws Exception
	 */
	public void updatePlanetPosition(String namep, int x, int y) throws Exception {

		// Cogemos el planeta
		Planet p = Clt.get(namep);
		if (p == null)
			throw new Exception("This planet doesn't exist");

		// Cambiamos la posicoon
		p.setPosition(x, y);

		
	}

	// Delete
	// ---------------------------------------------

	/**
	 * Elimina todos los planetas de la colecci—n
	 * Post: No existe ningun planeta
	 * 
	 * @throws Exception
	 */

	public void removeAllPlanets() throws Exception {
		Iterator<Planet> iterator = Clt.values().iterator();

		// Recoremos todas los planetas
		while (iterator.hasNext()) {
			Planet p = (Planet) iterator.next();
			// Eliminamos de la colecion
			Clt.remove(p.getName());
			// Eliminamos la referencia a galaxia
			p.removeGalaxy();
		}
	}

	/**
	 * Pre: El nombre no debe ser nulo y con longitud > 0
	 * 		El planeta debe existir 
	 * Post: Eliminada el planeta con nombre "name"
	 * 
	 * @param name
	 * @throws Exception
	 */
	public void removePlanet(String name) throws Exception {
		Planet p = Clt.get(name);
		if (p == null)
			throw new Exception("This planet doesn't exist");

		// Eliminos del conjunto
		Clt.remove(name);

		// Eliminamos la refenrecia a galaxia
		p.removeGalaxy();

	}

	// Save&Load
	// ---------------------------------------------

	/**
	 * Post: Devuelve el tama–o de la coleci—n
	 * 
	 * @return int
	 */
	public int size() {
		return Clt.size();
	}

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
		if (s.length != 3)
			throw new Exception("The record is not correct");

		// Separaci—n especifica del planeta
		String name = s[0];
		int x = Integer.parseInt(s[1]);
		int y = Integer.parseInt(s[2]);

		// A–ade a la colecci—n
		addPlanet(name, x, y);

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
		ArrayList<Planet> list;

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
		for (Planet p : list) {
			encodeS += p.toString() + _SEPARATOR;
			_last_key = p.getName();
		}

		return encodeS;
	} 
}

