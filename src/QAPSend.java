/**
 * QAPSend
 *
 */
public class QAPSend {
	
	private Planet planet;
	private Packet packet;
	
	/**
	 * Constructor
	 * @param p
	 * @param pack
	 * @return 
	 */
	public QAPSend (Planet p , Packet pack){
		planet = p;
		packet = pack;
	}
	
	// Setters
	//---------------------------------------------
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
	
	// Getters
	//---------------------------------------------	
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
	
	// To Basic
	//---------------------------------------------

	public String ToString(){
		return planet.getName() + " " + packet.getName();
	}
	
	
}
