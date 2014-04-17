public class Resource extends Entity{
	
	String name;
	ResourceType type;
	
	private static void checkName(String namep) throws Exception{ //Funcion que comprueba la entrada 
		for(int i = 0; i < namep.length(); ++i){
			//Se realiza validacion de datos
			if(!((namep.charAt(i) >= 'a') && (namep.charAt(i) <= 'z'))){
				if(!((namep.charAt(i) >= 'A') && (namep.charAt(i) <= 'Z'))){
					if((namep.charAt(i) >= '0') && (namep.charAt(i) <= '9')){
						throw new Exception(namep + " is not valid");
					}
				}
			}
		}	
	}

	/*private static void checkType(ResourceType res) throws IllegalArgumentException{ //Enseñar
		if(!(typep.equals("H") || typep.equals("T")))  throw new IllegalArgumentException("type is not valid");
	}*/
	//Contructs
	//---------------------------------------------
		
	public Resource(String namep, String typep) throws Exception{
        checkName(namep);
        name = namep;
        //checkType(typep);
        type = ResourceType.valueOf(typep);
	}

		/*public static boolean contains(String test) {

		    for (Choice c : Choice.values()) {
		        if (c.name().equals(test)) {
		            return true;
		        }
		    }

		    return false;
		}*/

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
		checkName(namep);
        name = namep;
	}


	/**
	 * @param type the type to set
	 */
	public void setType(String typep) throws Exception {
		//checkType(typep);
        type = ResourceType.valueOf(typep);
	}

	public String getKey(){
		return name;
	}

}
