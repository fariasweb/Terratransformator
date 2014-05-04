/**
 * Packet
 *
 */
public class Packet extends Entity{

	private TST<RelationPacketResource> rel; 
	private int qttResources;
	
	// Constructors
	// ---------------------------------------------
	/**
	 * 
	 */
	public Packet() {
		name = "";
		rel = new TST<RelationPacketResource>();
		qttResources = 0;
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
		rel = new TST<RelationPacketResource>();
		setName(name);
		qttResources = 0;
	}
	

	// Setter
	// ---------------------------------------------

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
		qttResources += qtt;
	}
	
	/**
	 * Pre: EL recurso debe exisitir
	 * @param name
	 * @param qtt
	 * @throws Exception
	 */
	public void updateResource(String name, int qtt) throws Exception {
		// Cogemos el recuros dentro del paquete
		RelationPacketResource rpr = rel.get(name);
		if (rpr == null)
			throw new Exception("The resource does not exist in the packet");

		//Calculamos la difernecia entre la cantidad antigua y la nueva
		int diff_q = qtt - rpr.getQuantity();
		
		// Actualizamso la cantidad
		rpr.setQuantity(qtt);
		
		//Una vez es correcto la actualizacion de la cantiad
		//lo reflejamos en el general
		qttResources += diff_q;
	}


	// Getters
	//---------------------------------------------
	
	/**
	 * Post: Devuelve los recursos dentro de un paquete
	 * @return TST<RelationPacketResource> 
	 */
	public TST<RelationPacketResource> getResources() {
		return rel;
	}
	
	public int getQuantity(){
		return qttResources;
	}
	
	
	// Delete
	// ---------------------------------------------
	
	/**
	 * pre:El recurso debe existir en el paquete
	 * post: Se elimina el recurso del paquete
	 * 
	 * @param names
	 * @throws Exception 
	 */
	public void removeResource(String name) throws Exception {
		RelationPacketResource res = rel.get(name);
		if (res == null)
			throw new Exception("The resource "+name+" does not exist in this packet");
		
		qttResources -= res.getQuantity();
		rel.remove(name);
	}
		
	/**
	 *post: Eliminamos todos los recursos de un paquete
	 */
	public void removeAllResources() {
		rel.clear();
		qttResources = 0;
	}
	
	// Basic Types
	// ---------------------------------------------
	/**
	 * post: Convierte a String los atributos de un paquete
	 * @return String 
	 */
	public String toString(){
		return name + " " +qttResources;
	}
	
	
}
