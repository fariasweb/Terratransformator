/**
 * Resource
 * 
 */
public class Resource extends Entity {

	//Atributos espeficicos
	String type;

	//Private methods
	private static void checkType(String res) throws Exception {
		if (!(res.equals("HUMAN") || res.equals("TECHNOLOGICAL")))
			throw new Exception("Type is not valid");
	}

	// Contructs
	// ---------------------------------------------

	/**
	 * Constructor 
	 * @param namep
	 * @param typep
	 * @throws Exception
	 */
	public Resource(String namep, String typep) throws Exception {
		setName(namep);
		setType(typep);
	}

	/**
	 * Constructor basico, todos los atributos nulos
	 */
	public Resource() {
		name = "";
		type = null;
	}

	// Setter
	// ---------------------------------------------

	/**
	 * @param type
	 */
	public void setType(String typep) throws Exception {
		checkType(typep);
		type = typep;
	}

	// Getter
	// -----------------------------------------------

	/**
	 * @return the type as a String
	 */
	public String getType() {
		return type;
	}

	// toString
	// -----------------------------------------------

	/**
	 * @return String
	 */
	public String toString() {
		// Datos basicos
		return name + " " + type;
	}
}