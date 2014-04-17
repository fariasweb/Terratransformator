import java.util.*;

public class Planet {

	private String name;
	private Integer x_pos;	//Don't need this attribute
	private Integer y_pos;	//This one neither
	
	//TODO Relacion con recurso
	//private List<Resource> neededResources;
	private Packet packet;

	
	private static void checkPosition(int x_posp, int y_posp) throws Exception {
		if(x_posp < 0 ) throw new Exception(x_posp + " position not valid");
		if(y_posp < 0 ) throw new Exception(y_posp + " position not valid");
	}
	//Contructs
	//---------------------------------------------
	public Planet(String namep,int x_posp, int y_posp) throws Exception{
		setPosition(x_posp,y_posp); // Se chequea aqui
		setName(namep);				// Se chequea aqui
		//neededResources = new ArrayList<Resource> ();
		packet = null;
	}
	
	//Constructora por defecto
	public Planet(){
		name = null;
		x_pos = y_pos = null;
		
		//neededResources = new ArrayList<Resource>();
		packet = null;
	}
	
	//Setter
	//---------------------------------------------
	
	/**
	 * @param name the name to set
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
	 * @param neededResources the neededResources to set
	 */
	/*public void setNeededResources(List<Resource> neededResourcesp) {
		neededResources = neededResourcesp;
	}*/

	/**
	 * @param packet the packet to set
	 */
	public void setPacket(Packet packetp) {
		if (packet != packetp) {
			packet = packetp;
			packetp.setPlanet(this);
		}
	}
	
	/**
	 * 
	 */
	public void removePacket() {
		if (packet != null) {
			Packet p = packet;
			
			packet = null;
			p.removePlanet();
			
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
	 * @return the neededResources
	 */
	/*public List<Resource> getNeededResources() {
		return neededResources;
	}*/

	/**
	 * @return the packet
	 */
	public Packet getPacket() {
		return packet;
	}
	
}
