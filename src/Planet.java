public class Planet {

	private String name;
	private Integer x_pos;
	private Integer y_pos;	
	private Packet packet;
	private Galaxy galaxy;

	
	private static void checkPosition(int x_posp, int y_posp) throws Exception {
		if(x_posp < 0 ) throw new Exception(x_posp + " position not valid");
		if(y_posp < 0 ) throw new Exception(y_posp + " position not valid");
	}

	//Contructs
	//---------------------------------------------
	public Planet(String namep,int x_posp, int y_posp) throws Exception{
		setPosition(x_posp,y_posp); // Se chequea aqui
		setName(namep);				// Se chequea aqui
		packet = null;
		galaxy = null;
	}
	
	//Constructora por defecto
	public Planet(){
		name = null;
		x_pos = y_pos = null;
		
		packet = null;
		galaxy = null;
	}
	
	//Setter
	//---------------------------------------------
	
	/**
	 * @param namep the name to set
	 */
	public void setName(String namep) throws Exception {
		if(!Util.checkName(namep)) throw new Exception(namep + " is not valid");
		name = namep;
	}

	/**
	 * @param Integer x_pos
	 * @param Integer y_pos
	 */
	public void setPosition(Integer x_posp, Integer y_posp) throws Exception{
		checkPosition(x_posp,y_posp);
		x_pos = x_posp;
		y_pos = y_posp;
	}

	/**
	 * @param packet the packet to set
	 */
	public void setPacket(Packet packetp) {

		if(packetp != packet){
			packet = packetp;
			packetp.setPlanet(this);
		}
	}
	
	public void setGalaxy(Galaxy g) throws Exception {
		if (galaxy != g) {
			galaxy = g;
			//g.addPlanet(this);
		}
	}
	
	//Getter
	//-----------------------------------------------
	/**
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return PairInt pos
	 */
	public PairInt getPosition() {
		return new PairInt(x_pos, y_pos);
	}

	/**
	 * @return the packet
	 */
	public Packet getPacket() {
		return packet;
	}
	
	/**
	 * 
	 * @return
	 */
	public Galaxy getGalaxy() {
		return galaxy;
	}
	
	//Deleter
	//-----------------------------------------------
	
	/**
	 * 
	 */
	public void removePacket(){
		if (packet != null) {
 			Packet p = packet;
 			packet = null;
 			p.removePlanet();
 		} 
	}
	
	
}
