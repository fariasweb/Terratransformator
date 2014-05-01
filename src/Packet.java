public class Packet {

	private String name;
	private TST<RelationPacketResource> rel; 
	
	// Constructors
		// ---------------------------------------------
	/**
	 * 
	 */
	public Packet() {
		name = "";
		rel = new TST<RelationPacketResource>();
	}
	/**
	 * Crea un paquete en el sistema
	 * Pre: El nombre del paquete no debe existir en el sistema
	 * Post: Se crea una galaxia con el nombre indicado
	 * 
	 * @param name
	 * @throws Exception
	 */
	public Packet(String name) throws Exception {
		new Packet();
		setName(name);
	}
	

	// Setter
		// ---------------------------------------------
	/**
	 * Modifica el nombre de un paquete
	 * pre:El nombre a asignar no ha de existir en el sistema
	 * post:Se cambia el nombre del paquete 
	 * 
	 * @param namep
	 * @throws Exception
	 */
	public void setName(String namep) throws Exception {
		if(!Util.checkName(namep)) throw new Exception(namep + " is not valid");
		name = namep;
	}

	
	/*public void setPlanet(Planet planetp) {
		if (planet != planetp && planetp != null) {
			planet = planetp;
			planetp.setPacket(this); //Está en planeta?
		}
	}*/

	/**
	 * pre:El nombre no debe ser nulo y qtt > 0 
	 * post:Se a–ade el recurso y la cantidad en el paquete
	 * 
	 * @param r
	 * @param qtt
	 * @throws Exception
	 */
	public void addResource(Resource r, int qtt) throws Exception {
		if (r == null) return;
		
		RelationPacketResource rpr = new RelationPacketResource(this, r, qtt);
		rel.put(r.getName(), rpr);
	}


	// Getters
			//---------------------------------------------
	/**
	 * pre:El paquete debe existir
	 * @return String
	 */
	public String getName() {
		return name;
	}
	
	/*public Planet getPlanet() {
		return planet;
	}*/
	
	/**
	 * Post: Devuelve los recursos dentro de un paquete
	 * @return TST<RelationPacketResource> 
	 */
	public TST<RelationPacketResource> getResources() {
		return rel;
	}
	
	
	// Delete
		// ---------------------------------------------
	
	/*public void removePlanet() {
		if (planet != null) {
			planet.removePacket();
			planet = null;
		}
	}*/

	/*public void removeResource(Resource rp) throws Exception {
		rel.remove(rp.getName());
	}*/
	
	/**
	 * pre:El recurso debe existir en el paquete
	 * post: Se elimina el recurso del paquete
	 * 
	 * @param name
	 * @throws Exception 
	 */
	public void removeResource(String name) throws Exception {
		rel.remove(name);
	}
		
	/**
	 *post: Eliminamos todos los recursos de un paquete
	 */
	public void removeAllResources() {
		rel.clear();
	}
	
	// Basic Types
		// ---------------------------------------------
	/**
	 * post: Convierte a String los atributos de un paquete
	 * @return String 
	 */
	public String toString(){
		return name + " " + rel.toString();
	}
	
	
}
