/**
 * GalaxyController
 * 
 * @author farias
 *
 */

import java.util.ArrayList;
import java.util.List;

public class PacketController extends AbstractController{

	private TST<Packet> cjtPacket;
	private Packet packet;
	
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
	/**
	 * 
	 */
	public PacketController() {
		cjtPacket = new TST<Packet>();
	}
	
	public void add(Packet g){
		 cjtPacket.put(g.getName(),g);
	}
	
	/**
	 * @param namep
	 * @throws Exception
	 */
	public void removePacketByName(String namep) throws Exception {
		cjtPacket.remove(namep);
	}
	    
	public void clear(){
		cjtPacket.clear();
	}

	
	//Getter
	//-----------------------------------------------
	/**
	 * 
	 * @return TST<Packet>
	 */
	public TST<Packet> getAll(){
		return cjtPacket;
	}
	
	/**
	 * @param namep
	 * @return Packet
	 */
	public Packet getPacketByName(String namep){
		return cjtPacket.get(namep);
	}

	// Exist
	//-----------------------------------------------
	
	/**
	 * @param namep
	 * @return boolean
	 */
	public boolean existPacketByName(String namep){
		return cjtPacket.contains(namep);
	}
	// Utils
	//-----------------------------------------------
	
	public int size(){
		return cjtPacket.size();
	}
}
