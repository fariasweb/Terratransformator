
public class Send {
	private Planet planet;
	private Packet packet;
	
	public Send(){
		planet = null;
		packet = null;
	}
	/**
	 * 
	 * @param p
	 * @param pack
	 */
	public Send (Planet p , Packet pack){
		planet = p;
		packet = pack;
	}
	//SETTERS
	/**
	 * 
	 * @param p
	 */
	public void setPlanet(Planet p){
		planet = p;
	}
	/**
	 * 
	 * @param p
	 */
	public void setPacket(Packet p){
		packet = p;
	}
	
	///GETTERS
	/**
	 * 
	 * @return
	 */
	public Planet getPlanet(){
		return planet;
	}
	/**
	 * 
	 * @return
	 */
	public Packet getPacket(){
		return packet;
	}
	
	public String ToString(){
		return planet.getName() + " " + packet.getName();
	}
	
	
}
