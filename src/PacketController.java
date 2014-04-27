import java.util.ArrayList;
import java.util.List;

public class PacketController extends AbstractController{

	private TST<Packet> packetCtl;


	public void createPacket(String namep) throws Exception{
		Packet p = new Packet(namep);

	}
	
	//Getters
	//---------------------------------------------

	public Packet getPacketByName(String namep){
		return packetCtl.get(namep);
	}

	/**
	 * @return the planet
	 */
	public Planet getPlanet(String namep) {
		Packet p = packetCtl.get(namep);
		return p.getPlanet();
	}
	
	/**
	 * @return the map
	 */
	public TST<RelationPacketResource> getResource(String namep) {
		return packetCtl.get(namep).getResource();
	}
	
	//Setter
	//---------------------------------------------
		
	/**
	 * @param name the name to set
	 * @throws Exception 
	 */
	public void setName(String oldName, String namep){
		if(!Util.checkName(oldName)) throw new Exception(oldName + " is not valid");
		if(!Util.checkName(namep)) throw new Exception(namep + " is not valid");
		Packet p = packetCtl.get(oldName);
		p.setName(namep);
	}

	/**
	 * @param planet the planet to set
	 */
	public void setPlanet(String namePacket, String namePlanet) {
		Packet paq = packetCtl.get(namePacket);
		Planet planet = getPlanetByName(namePlanet); //Error, relacion entre paquete planeta
		if (paq.getPlanet() != planet && paq.getPlanet() != null) {
			paq.setPlanet(planet);
			planet.setPacket(paq);
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
	public void addResource(String namep,String namerp, int qp){
		/*Packet paq = packetCtl.get(namePacket);
		//Resource res = getResource
		TST<RelationPacketResource> rpr = paq.getResource();
		RelationPacketResource rel = new RelationPacketResource();
		rel.setPacket(paq);
		rel.setResource();
		if (res == null) return;
		
		//Compruebas si existe ya en el packete
		if(rpr.contains(namerp)) throw new Exception ("This packet contains a "+namerp+" resource");
		
		//Si no existe, creamos y a–adimos
		rpr.put(rpr.get(namerp),qp);*/
	}
	
	
	//Deleter
	//---------------------------------------------
	
	/**
	 * 
	 * @param rp
	 * @throws Exception
	 */
	public void removeResource(String namep,String namerp) {
		Packet paq = packetCtl.get(namep);
		paq.removeResourceByName(namerp);
	}
	
	/**
	 * 
	 */
	public void removeAllResource(String namep) {
		Packet paq = packetCtl.get(namep);
		paq.removeAllResource();
	}
	
	/**
	 * 
	 */
	public void removePlanet(String namep) {
		Packet paq = packetCtl.get(namep);
		Planet planet = paq.getPlanet();
		if (planet != null) {
			paq.removePlanet();
			planet.removePacket();
			
		}
	}
	/**
	 * 
	 */
	public PacketController() {
		packetCtl = new TST<Packet>();
	}
	
	public void add(Packet g){
		 packetCtl.put(g.getName(),g);
	}
	
	/**
	 * @param namep
	 * @throws Exception
	 */
	public void removePacketByName(String namep) throws Exception {
		packetCtl.remove(namep);
	}
	    
	public void clear(){
		packetCtl.clear();
	}

	
	//Getter
	//-----------------------------------------------
	/**
	 * 
	 * @return TST<Packet>
	 */
	public TST<Packet> getAll(){
		return packetCtl;
	}
	
	// Exist
	//-----------------------------------------------
	
	/**
	 * @param namep
	 * @return boolean
	 */
	public boolean existPacketByName(String namep){
		return packetCtl.contains(namep);
	}
	// Utils
	//-----------------------------------------------
	
	public int size(){
		return packetCtl.size();
	}
}
