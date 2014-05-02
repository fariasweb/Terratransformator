/**
 * Entity
 *
 */
abstract class Entity implements EntityInterface {

	//Atributos basicos
	protected String name;
	
	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 
	 * @param namep
	 * @throws Exception
	 */
	public void setName(String namep) throws Exception {
		if(!Util.checkName(namep)) throw new Exception(namep + " is not valid");
		name = namep;
	}
	
	/**
	 * Transforam la clase Entity en un string
	 * @return String
	 */
	public abstract String toString();
	
}
