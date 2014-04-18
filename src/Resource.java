
public class Resource //extends Entity{
{
	String name;
	ResourceType type;

	private static void checkType(ResourceType res) throws IllegalArgumentException{ //Enseñar
		if(!(res.equals("H") || res.equals("T")))  throw new IllegalArgumentException("type is not valid");
	}
	//Contructs
	//---------------------------------------------
		
	public Resource(String namep, ResourceType typep) throws Exception{
        setName(namep);
        setType(typep);
	}

    public Resource(){
        name = null;
        type = null;
    }
	//Getter
	//-----------------------------------------------
		
	/**
	 * @return the name
	 */
	public String getName() {
        return name;
	}

	public String getKey(){
		return name;
	}

	/**
	 * @return the type as a String
	 */
	public String getType() {
        return type.name();
	}

	//Setter
	//---------------------------------------------
	
	/**
	 * @param name the name to set
	 */
	public void setName(String namep) throws Exception {
		if(!Util.checkName(namep)) throw new Exception();
        name = namep;
	}


	/**
	 * @param type the type to set
	 */
	public void setType(ResourceType typep) throws Exception {
		checkType(typep);
        type = typep;
	}
}
