

import java.util.*;

public class Planet {

	private String name;
	private Integer x_pos;	
	private Integer y_pos;
	
	//TODO Relacion con recurso
	private List<Resource> neededResources;
	private Packet packet;

	//Contructs
	//---------------------------------------------
	public Planet(String nombrep,int x_posp, int y_posp){
		name = nombrep;
		x_pos = x_posp;
		y_pos = y_posp;
		
		neededResources = new ArrayList<Resource> ();
		packet = null;
	}
	
	//Constructora por defecto
	public Planet(){
		name = null;
		x_pos = y_pos = null;
		
		neededResources = new ArrayList<Resource>();
		packet = null;
	}
	
	//Setter
	//---------------------------------------------
	
	/**
	 * @param name the name to set
	 */
	public void setName(String namep) {
		name = namep;
	}

	/**
	 * @param Integer x_pos
	 * @param Integer y_pos
	 */
	public void setPosition(Integer x_posp, Integer y_posp) {
		x_pos = x_posp;
		y_pos = y_posp;
	}

	/**
	 * @param neededResources the neededResources to set
	 */
	public void setNeededResources(List<Resource> neededResourcesp) {
		neededResources = neededResourcesp;
	}

	/**
	 * @param packet the packet to set
	 */
	public void setPacket(Packet packetp) {
		packet = packetp;
	}
	
	//Getter
	//-----------------------------------------------
	
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
	public List<Resource> getNeededResources() {
		return neededResources;
	}

	/**
	 * @return the packet
	 */
	public Packet getPacket() {
		return packet;
	}
	
}
