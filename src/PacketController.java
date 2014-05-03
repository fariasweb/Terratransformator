import java.util.ArrayList;
import java.util.Iterator;

public class PacketController extends AbstractController {

	// protected attributes
	protected TST<Packet> Clt;
	private ResourceController rc;

	/**
	 * Constructor Post: Inicializa el contructor padre y el TST
	 */
	public PacketController(ResourceController rcp) {
		super();
		Clt = new TST<Packet>();
		rc = rcp;

	}

	// Create
	// ---------------------------------------------

	/**
	 * Crea una paquete en el sistema Pre: El nombre de la paquete no debe
	 * existir en el sistema Post: Se crea una paquete con el nombre indicado
	 * 
	 * @param name
	 * @param x
	 * @param y
	 * @return boolean
	 * @throws Exception
	 */
	public void addPacket(String name) throws Exception {

		Packet p = new Packet(name);
		Clt.put(name, p);
	}

	// Read
	// ---------------------------------------------

	/**
	 * Devuelve un listado con el nombre de los paquetes ordenado por orden
	 * alfabetico
	 * 
	 * @return String
	 */

	public String getAll() {

		String result = "";

		// Comprobamos que exista algo en el array
		if (Clt.size() > 0) {
			for (Packet i : Clt.values()) {
				result += i.toString() + "\n";
			}
		}
		return result;
	}

	/**
	 * Pre: El nombre no debe ser nulo y con longitud > 0 La paquete debe
	 * existir
	 * 
	 * @param name
	 *            String
	 * @return
	 * @throws Exception
	 */
	public String getByNameToString(String name) throws Exception {

		Packet p = Clt.get(name);
		if (p == null)
			throw new Exception("This packet doesn't exist");

		return p.toString();
	}

	/**
	 * Pre: El nombre no debe ser nulo y con longitud > 0 La paquete debe
	 * existir
	 * 
	 * @param name
	 *            String
	 * @return
	 * @throws Exception
	 */
	public Packet getByName(String name) throws Exception {

		Packet g = Clt.get(name);
		if (g == null)
			throw new Exception("This galaxy doesn't exist");

		return g;
	}

	/**
	 * Pre: El nombre no debe ser nulo y con longitud > 0 La paquete debe
	 * existir
	 * 
	 * @param name
	 * @return Boolean
	 */
	public boolean existPacket(String name) {
		return Clt.contains(name);
	}

	/**
	 * Indica si un paquete contiene de un recurso
	 * 
	 * @param name
	 * @return
	 */
	public boolean containsResource(String name) {
		Iterable<Packet> ps = Clt.values();
		for (Packet p : ps) {
			Iterable<RelationPacketResource> rps = p.getResources().values();
			for (RelationPacketResource r : rps)
				if (r.getResource().getName() == name)
					return true;
		}
		return false;
	}

	// Update
	// ---------------------------------------------

	/**
	 * Pre: El nombre no debe ser nulo y con longitud > 0 
	 * EL paquete debe exisitr
	 * El nombre del nuevo paquete no debe de existir 
	 * Post: Modifica los datos del paquete con new_nam
	 * 
	 * @param name
	 * @param new_name
	 * @param x
	 * @param y
	 * @throws Exception
	 */
	public void updatePacketName(String name, String newName) throws Exception {

		// Cogemos el paquete
		Packet g = Clt.get(name);
		if (g == null)
			throw new Exception("This packet doesn't exist");

		// Actualizamos informacion
		// Si el pacquete tiene un nombre diferente se debe
		// extraer del arbol y volver a meter
		if (g.getName() != newName) {

			if (!Util.checkName(newName))
				throw new Exception(newName + " is not valid");

			if (Clt.contains(newName))
				throw new Exception(newName + " is using in other packet");

			Clt.remove(g.getName());
			g.setName(newName);
			Clt.put(newName, g);
		}

	}

	// Delete
	// ---------------------------------------------

	/**
	 * Pre: El nombre no debe ser nulo 
	 * El paquete debe exisitir
	 * Post: Eliminada el paquete con nombre "name"
	 * 
	 * @param name
	 * @throws Exception
	 */
	public void removePacket(String name) throws Exception {
		Packet g = Clt.get(name);
		if (g == null)
			throw new Exception("This packet doesn't exist");

		// Eliminos del conjunto
		Clt.remove(name);

		// Eliminamos todos los recursos
		g.removeAllResources();

	}

	/**
	 * Post: No existe ningun paquete
	 * 
	 * @throws Exception
	 */
	public void removeAllPacket() throws Exception {

		Iterator<Packet> iterator = Clt.values().iterator();

		// Recoremos todas los paquetes
		while (iterator.hasNext()) {
			Packet g = (Packet) iterator.next();
			// Eliminamos de la colecion
			Clt.remove(g.getName());
			// Eliminamos todos los recursos del paquete
			g.removeAllResources();
		}

	}

	// ---------------------------------------------
	// Resource
	// ---------------------------------------------

	// Create
	// ---------------------------------------------
	// EL otro controlador debe devolverme la referencia del recuros, no un
	// string

	/**
	 * Pre: La paquete y el recurso deben existir El recurso no debe tener otra
	 * paquete asignaada o estar en esta ya
	 * 
	 * @param PacketName
	 * @param ResourceName
	 * @param Quantity
	 * @throws Exception
	 */
	public void addResource(String PacketName, String ResourceName, int q) throws Exception {

		// 1. Comprobar la existencia de paquete
		Packet g = Clt.get(PacketName);
		if (g == null)
			throw new Exception("The packet " + PacketName + " does not exist");

		// 2. Comprobar la existencia de recurso en controlador de recursos
		Resource p = rc.getByName(ResourceName);
		if (p == null)
			throw new Exception("The resource " + ResourceName + " does not exist");

		// 3. Asignar recurso a paquete y viceversa
		g.addResource(p, q);

	}

	// Read
	// ---------------------------------------------

	/**
	 * Pre: La paquete debe existir
	 * 
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public String getResourcesFromPacket(String name) throws Exception {
		// Cogemos el paquete
		Packet g = Clt.get(name);
		if (g == null)
			throw new Exception("This packet doesn't exist");

		String result = "";
		// Comprobamos que exista algo en el array
		if (g.getResources().size() > 0) {
			for (RelationPacketResource i : g.getResources().values()) {
				result += i.toString() + "\n";
			}
		}

		return result;
	}

	// Update
	// ---------------------------------------------

	public void updateResourceQuantity(String Pname, String Rname, int q) throws Exception {
		// Cogemos el paquete
		Packet g = Clt.get(Pname);
		if (g == null)
			throw new Exception("This packet doesn't exist");

		//Actualizamos el recurpo del paquete
		g.updateResource(Rname, q);
	}
	
	// Delete
	// ---------------------------------------------

	/**
	 * Pre: La paquete y el recurso deben existir
	 * 
	 * @param PacketName
	 * @param Resourcename
	 * @throws Exception
	 */
	public void removeResourceFromPacket(String PacketName, String Resourcename)
			throws Exception {
		// Cogemos la galxia
		Packet g = Clt.get(PacketName);
		if (g == null)
			throw new Exception("This packet " + PacketName + "doesn't exist");

		// Eliminamos el recurso de la paquete
		g.removeResource(Resourcename);

	}

	/**
	 * Pre: La paquete debe existir Post: Eliminado todos los recursos de la
	 * paquete indicada
	 * 
	 * @param PacketName
	 * @throws Exception
	 */
	public void removeResourcesFromPacket(String PacketName) throws Exception {
		// Cogemos la galxia
		Packet g = Clt.get(PacketName);
		if (g == null)
			throw new Exception("This packet doesn't exist");

		// Eliminamos todas las paquetes
		g.removeAllResources();
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
		if (s.length < 2)
			throw new Exception("The record is not correct");

		// Separaci—n especifica de paquete
		String name = s[0];

		// A–ade a la colecci—n
		addPacket(name);

		// TODO: Relacion con recursos
		if (s.length > 2) {
			Packet g = getByName(name);
			Resource p;
			String error = "";
			
			int pos = 2;
			int i = 0;
			int loops = (s.length - 2) / 2;

			// Recoremos todos los recursos
			while (i < loops) {
				try {
					// Cogemos e recurso
					p = rc.getByName(s[pos]);
					if (p == null)
						throw new Exception("The planet does not exist");

					// A–adimos a la paquete
					g.addResource(p, Integer.parseInt(s[pos + 1]));
					
					//Aumentamos la posicion
					pos += 2;

				} catch (Exception e) {
					error += "Relation with resource " + s[i] + " can not do: "
							+ e.getMessage() + "\n";
				}

				// Aumentamos la posicion
				i += 1;
			} 

			// En caso de error en alguna relacion lanzamos una excepcion
			if (error.length() > 0)
				throw new Exception("Fail to relation resources whit packet "
						+ name + "\n" + error);
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
		ArrayList<Packet> list;

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
		for (Packet p : list) {
			encodeS += p.toString() + _SEPARATOR;
			_last_key = p.getName();
		}

		return encodeS;
	}

	/**
	 * Devuelvel numero de paquetes que contiene
	 * 
	 * @return int
	 */
	public int size() {
		return Clt.size();
	}

	/**
	 * Compruba que esten todos los datos necesarios para hacer la carga de
	 * datos Pre: Deben existir recursos en el controlador de Resourceas
	 * 
	 */
	protected void preConditionLoad() throws Exception {
		if (rc.size() == 0)
			throw new Exception(
					"Resource Controler must have resource to load packets");
	}

}
