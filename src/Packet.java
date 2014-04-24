/**
 * 
 * @author farias
 * TODO: El mapa debe ser ordenado
 */

public class Packet {

	String name;
	Planet planet;
	TST<RelationPacketResource> map; 
	//TST<String, RelationPacketResource> map;
	//TODO Relacion con recurso
	
	//Contructs
	//---------------------------------------------
	
	public Packet() {
		name = "";
		planet = null;
		map = new TST<RelationPacketResource>();
	}
	
	public Packet(String namep) throws Exception {
		setName(namep);
		map = new TST<RelationPacketResource>();
	}
	
	//Getters
	//---------------------------------------------

	/**
	 * 
	 * @return int
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return the planet
	 */
	public Planet getPlanet() {
		return planet;
	}
	
	/**
	 * @return the map
	 */
	public TST<RelationPacketResource> getResource() {
		return map;
	}
	
	//Setter
	//---------------------------------------------
		
	/**
	 * @param name the name to set
	 * @throws Exception 
	 */
	public void setName(String namep) throws Exception {
		if(!Util.checkName(namep)) throw new Exception(namep + " is not valid");
		name = namep;
	}

	/**
	 * @param planet the planet to set
	 */
	public void setPlanet(Planet planetp) {
		if (planet != planetp && planetp != null) {
			planet = planetp;
			planetp.setPacket(this);
		}
	}
	
	//Resource
	//---------------------------------------------
	/**
	 * 
	 * @param rp
	 * @param qp
	 * @throws Exception 
	 */
	public void addResource(Resource rp, int qp) throws Exception {
		
		if (rp == null) return;
		
		//Compruebas si existe ya en el packete
		if(map.contains(rp.getName())) throw new Exception ("This packet contains a "+rp.getName()+" resource");
		
		//Si no existe, creamos y a–adimos
		RelationPacketResource rpr = new RelationPacketResource(this, rp, qp);
		map.put(rp.getName(), rpr);
	}
	
	
	//Deleter
	//---------------------------------------------
	
	/**
	 * 
	 * @param rp
	 * @throws Exception
	 */
	public void removeResource(Resource rp) throws Exception {
		map.remove(rp.getName());
	}
	
	/**
	 * 
	 * @param namep
	 * @throws Exception 
	 */
	public void removeResourceByName(String namep) throws Exception {
		map.remove(namep);
	}
		
	/**
	 * 
	 */
	public void removeAllResource() {
		map.clear();
	}
	
	/**
	 * 
	 */
	public void removePlanet() {
		if (planet != null) {
			Planet p = planet;
			
			planet = null;
			p.removePacket();
			
		}
	}
}
