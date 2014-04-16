public class Resource {
	private String name;
	private ResourceType type;
	
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

	private static void checkType(ResourceType res) throws Exception{ //Enseñar
		if(res != ResourceType.HUMAN && res != ResourceType.TECHNOLOGICAL) throw new Exception(res + "is not valid");
	}
	//Contructs
	//---------------------------------------------
		
	public Resource(String namep, ResourceType typep) throws Exception{
			checkName(namep);
			checkType(typep);
            name = namep;
            type = typep;
	}

    public Resource(){
        name = null;
        type = null;
    }
	//Getter
	//-----------------------------------------------
		
	/*
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
	public void setName(String namep) throws Exception{
			checkName(namep);
            name = namep;
	}


	/**
	 * @param type the type to set
	 */
	public void setType(ResourceType typep) throws Exception{
			checkType(typep);
            type = typep;
	}

}
