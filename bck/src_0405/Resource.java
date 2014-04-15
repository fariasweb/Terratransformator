/**
 * 
 * @author farias
 *
 */

public class Resource {
	
	String name;
	ResourceType type;
	
	
	//Contructs
	//---------------------------------------------
		
	public Resource(String namep, ResourceType typep) {
		
	}

	//Getter
	//-----------------------------------------------
		
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @return the type
	 */
	public ResourceType getType() {
		return type;
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
	 * @param type the type to set
	 */
	public void setType(ResourceType typep) {
		type = typep;
	}

}
