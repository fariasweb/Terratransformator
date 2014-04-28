
public class Resource{

	String name;
	ResourceType type;

	/**************************************************************
	 * Private Methods
	 **************************************************************/
	private static void checkType(String res) throws IllegalArgumentException{ //Enseñar
		if(!(res.equals("HUMAN") || res.equals("TECHNOLOGICAL")))  throw new IllegalArgumentException("type is not valid");
	}


	/**************************************************************
	 * Contructs
	 **************************************************************/	
	public Resource(String namep, String typep) throws Exception{
        setName(namep);
        setType(typep);
	}

    public Resource(){
        name = "";
        type = null;
    }


	/**************************************************************
	 * Setter
	 **************************************************************/
	/**
	 * @param namep
	 * @throws Exception
	 */
	public void setName(String namep) throws Exception {
		if(!Util.checkName(namep)) throw new Exception(namep + " is not valid");
        name = namep;
	}


	/**
	 * @param type the type to set
	 */
	public void setType(String typep) throws Exception {
		checkType(typep);
        type = ResourceType.valueOf(typep);
	}


	/**************************************************************
	 * Getters
	 **************************************************************/	
	/**
	 * @return the name
	 */
	public String getName() {
        return name;
	}

	/**
	 * @return the type as a String
	 */
	public String getType() {
        if(type == null) return "";
        return type.name();
	}

	/**************************************************************
	 * Delete
	 **************************************************************/

	/**************************************************************
	 * To Basic Types
	 **************************************************************/
	public String toString(){
		return getName() + " " + getType();
	}
}