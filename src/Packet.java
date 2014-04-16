/**
 * 
 * @author farias
 *
 */

public class Packet {

	int id;
	Planet planet;
	//TODO Relacion con recurso
	
	//Contructs
	//---------------------------------------------
			
	public Packet(int idp) {
		setId();
	}
	
	//Getters
	//---------------------------------------------
	
	/**
	 * 
	 * @return int
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * @return the planet
	 */
	public Planet getPlanet() {
		return planet;
	}
	
	//Setter
	//---------------------------------------------
		
	/**
	 * @param name the name to set
	 * @throws Exception 
	 */
	public void setId(int idp) throws Exception {
		if (idp <= 0) throw new Exception("The id must be bigger than 0");
		id = idp;
	}

	/**
	 * @param planet the planet to set
	 */
	public void setPlanet(Planet planetp) {
		if (planet != planetp) {
			planet = planetp;
			planetp.setPacket(this);
		}
	}
	
	//TODO A–adir y gestionar recursos del paquete
}
