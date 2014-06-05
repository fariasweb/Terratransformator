import java.util.ArrayList;
import java.util.Iterator;

/**
 * ResourceController
 * 
 */

public class ResourceController extends AbstractController {

	// protected attributes
	private TST<Resource> Clt;
	private PacketController pc;

	/**
	 * Constructora Post: Inicializa el contructor padre y el TST
	 */
	public ResourceController(PacketController PacketC) {
		super();
		Clt = new TST<Resource>();
		pc = PacketC;
	}

	// Create
	// ---------------------------------------------

	/**
	 * Crea un recurso en el sistema 
	 * Pre: El nombre del recurso no debe existir en el sistema 
	 * Post: Se crea un recurso con el nombre indicado
	 * 
	 * @param name
	 */
	public void addResource(String name, String type) throws Exception {
		Resource g = new Resource(name, type);

		// Anadimos el Resourcea al TST
		Clt.put(g.getName(), g);
	}

	// Read
	// ---------------------------------------------
	/**
	 * Devuelve un listado con el nombre de los recursos ordenado por orden
	 * alfabetico
	 * 
	 * @return String
	 */

	public String getAll() {

		String result = "";

		// Comprobamos que exista algo en el array
		if (Clt.size() > 0) {
			for (Resource i : Clt.values()) {
				result += i.toString() + _SEPARATOR;
			}
		}
		return result;
	}

	/**
	 * Pre: El nombre no debe ser nulo y con longitud > 0
	 * El recurso debe existir
	 * 
	 * @param name
	 *            String
	 * @return
	 * @throws Exception
	 */
	public String getByNameToString(String name) throws Exception {

		Resource g = Clt.get(name);
		//if (g == null) throw new Exception("This resource does not exist");

		return g.toString();
	}

	/**
	 * Pre: El nombre no debe ser nulo y con longitud > 0
	 * El recurso debe existir
	 * 
	 * @param name
	 *            String
	 * @return
	 * @throws Exception
	 */
	public Resource getByName(String name) throws Exception {

		Resource g = Clt.get(name);
		//if (g == null) throw new Exception("This resource does not exist");

		return g;
	}

	/**
	 * Pre: El nombre no debe ser nulo y con longitud > 0. El recurso debe
	 * existir
	 * 
	 * @param name
	 * @return Boolean
	 */
	public boolean existResource(String name) {
		return Clt.contains(name);
	}

	// Update
	// ---------------------------------------------
	/**
	 * Pre: El nombre no debe ser nulo
	 * El recurso debe existir 
	 * El nombre de a nuevo recurso no debe de existir 
	 * Post: Modifica los datos del recurso con newName
	 * 
	 * @param oldName
	 * @param newName
	 * @throws Exception
	 */
	public void updateResourceName(String oldName, String newName)
			throws Exception {
		// Cogemos el recurso
		Resource p = Clt.get(oldName);
		//if (p == null) throw new Exception("This resource does not exist");

		// Cimprobamos qu eno sea las misma galaxi
		if (p.getName() != newName) {
			if (!Util.checkName(newName))
				throw new Exception(newName + " is not valid");

			if (Clt.contains(newName))
				throw new Exception(newName + " is using in other resource");
			
			Clt.remove(p.getName());
			p.setName(newName);
			Clt.put(newName, p);
			
			//Cambiamos el nombre en los paquetes
			pc.updateResourceName(oldName, newName);
		}
	}

	/**
	 * Actualiza la posicon de un recurso Pre: El recurso debe exisitr Las
	 * cordenadas deben ser validas En caso de estar en una galaxia, las
	 * cordenadas deben estar dentro de la galaxia y que no exista otro recurso
	 * en su interior Post: El recurso tiene nuevas cordenadas
	 * 
	 * @param namep
	 * @param x
	 * @param y
	 * @throws Exception
	 */
	public void updateResourceType(String namep, String type)
			throws Exception {

		// Cogemos el recurso
		Resource p = Clt.get(namep);
		//if (p == null) throw new Exception("This resource does not exist");

		// Cambiamos el typo
		p.setType(type);

	}

	// Delete
	// ---------------------------------------------

	/**
	 * Elimina todos los recursos de la coleccion Post: No existe ningun recurso
	 * 
	 * @throws Exception
	 */

	public void removeAllResources() throws Exception {
		
		//Eliminamos todos los recuros
		Clt.clear();
		//Eliminimos todos los recuroso de todos los paquetes
		pc.removeResourcesFromAllPacket();
	}

	/**
	 * Pre: El nombre no debe ser nulo y con longitud > 0 El recurso debe
	 * existir Post: Eliminada el recurso con nombre "name"
	 * 
	 * @param name
	 * @throws Exception
	 */
	public void removeResource(String name) throws Exception {
		Resource p = Clt.get(name);
		//if (p == null) throw new Exception("This planet doesn't exist");

		// Eliminos del conjunto
		Clt.remove(name);

		//Eliminar las referencias de los paquetes
		pc.removeResourceFromAllPacket(name);

	}


	// Save&Load
	// ---------------------------------------------

	/**
	 * Post: Devuelve el tamano de la colecion
	 * 
	 * @return int
	 */
	public int size() {
		return Clt.size();
	}
	
	/**
	 * 
	 */
	protected Iterator getIterator() {
		return Clt.iterator();
	}

	/**
	 * Debe indicarse en cada controlador 
	 * Post: Pasa el String a memoria como objetos
	 * 
	 * @param l
	 * @throws Exception
	 */
	protected void decodeString(String l) throws Exception {

		// Corta el string por el separador interno
		String[] s = l.split(" ");

		// Comprueba que sea correcto y tengo el numero de elemntos minimo
		if (s.length != 2)
			throw new Exception("The record is not correct");

		// Separacion especifica del recurso
		String name = s[0];
		String type = s[1];
		
		// Anade a la coleccin
		addResource(name, type);

	}

	/**
	 * Debe indicarse en cada controlador 
	 * Post: Pasa el String a memoria como objetos
	 * 
	 * @param l
	 * @throws Exception
	 */
	protected String encodeString() throws Exception {

		String encodeS = "";
		ArrayList<Resource> list;

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
		for (Resource p : list) {
			encodeS += p.toString() + _SEPARATOR;
			_last_key = p.getName();
		}

		return encodeS;
	}

}
