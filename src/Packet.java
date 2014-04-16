import java.util.Map;

/**
 * 
 * @author farias
 *
 */

public class Packet {

	String name;
	Planet planet;
	Map<String, int> map;
	//TODO Relacion con recurso
	
	//Contructs
	//---------------------------------------------
			
	public Packet(String namep) throws Exception {
		setName(namep);
	}
	
	//Getters
	//---------------------------------------------
	
	/**
	 * @return the map
	 */
	public getMap<String, int> getMap() {
		return map;
	}

	/**
	 * @param map the map to set
	 */
	public void setMap(Map<String, String> map) {
		this.map = map;
	}

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
	
	//Setter
	//---------------------------------------------
		
	/**
	 * @param name the name to set
	 * @throws Exception 
	 */
	public void setName(String namep) throws Exception {
		//TODO
		//if (idp <= 0) throw new Exception("The id must be bigger than 0");
		name = namep;
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
