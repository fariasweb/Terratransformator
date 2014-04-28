public class Packet {

	private String name;
	private Planet planet;
	private TST<RelationPacketResource> rel; 
	//TST<String, RelationPacketResource> rel;
	//TODO Relacion con recurso
	
	
	/**************************************************************
	 * Contructs
	 **************************************************************/
	public Packet() {
		name = "";
		planet = null;
		rel = new TST<RelationPacketResource>();
	}
	
	public Packet(String namep) throws Exception {
		new Packet();
		setName(namep);
	}
	

	/**************************************************************
	 * Setters
	 **************************************************************/
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
			planetp.setPacket(this); //Está en planeta?
		}
	}

	/**
	 * 
	 * @param rp
	 * @param qp
	 * @throws Exception 
	 */
	public void addResource(Resource r, int qtt) throws Exception {
		
		if (r == null) return;
		
		RelationPacketResource rpr = new RelationPacketResource(this, r, qtt);
		rel.put(r.getName(), rpr);
	}


	/**************************************************************
	 * Getters
	 **************************************************************/
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
	 * @return the rel
	 */
	public TST<RelationPacketResource> getResources() {
		return rel;
	}
	
	
	/**************************************************************
	 * Delete
	 **************************************************************/
	
	/**
	 * 
	 */
	public void removePlanet() {
		if (planet != null) {
			planet.removePacket();
			planet = null;
		}
	}

	/**
	 * 
	 * @param rp
	 * @throws Exception
	 */
	/*public void removeResource(Resource rp) throws Exception {
		rel.remove(rp.getName());
	}*/
	
	/**
	 * 
	 * @param namep
	 * @throws Exception 
	 */
	public void removeResource(String name) throws Exception {
		rel.remove(name);
	}
		
	/**
	 * 
	 */
	public void removeAllResources() {
		rel.clear();
	}
	
	/**************************************************************
	 * To Basic Types
	 **************************************************************/
	public String toString(){
		return name + " " + planet.getName() + " " + rel.toString();
	}
	
	
}
