/**
 * Planet
 * 
 */

public class Planet extends Entity {

	private Integer x_pos;
	private Integer y_pos;
	private Galaxy galaxy;

	

	// Contructs
	// ---------------------------------------------
	/**
	 * Planet
	 * Pre: namep no puede ser nulo ni vacio
	 * 		namep debe estar formado por letras y numeros
	 * 		x_posp, y_psop mayores que 0
	 * Post: Inicializa planeta con el nombre y la posicion indicada
	 * @param namep
	 * @param x_posp
	 * @param y_posp
	 * @throws Exception
	 */
	public Planet(String namep, int x_posp, int y_posp) throws Exception {
		setPosition(x_posp, y_posp); // Se chequea aqui
		setName(namep); // Se chequea aqui
		galaxy = null;
	}

	/**
	 * Planet
	 * Post: Inicializa planeta con todos los atriubutos nulos
	 */
	public Planet() {
		name = "";
		x_pos = y_pos = 0;
		galaxy = null;
	}

	// Setter
	// ---------------------------------------------

	/**
	 * Asigna al planeta una posicion
	 * Pre: x_posp, y_psop mayores que 0
	 * @param Integer x_pos
	 * @param Integer y_pos
	 */
	public void setPosition(Integer x_posp, Integer y_posp) throws Exception {
		Util.checkPosition(x_posp, y_posp);
		x_pos = x_posp;
		y_pos = y_posp;
	}

	/**
	 * Post: Asigna al planetea una galaxia
	 * @param g
	 * @throws Exception
	 */
	public void setGalaxy(Galaxy g) throws Exception {
		if (galaxy != g) {
			galaxy = g;
		}
	}

	// Getter
	// -----------------------------------------------

	/**
	 * @return PairInt pos
	 */
	public PairInt getPosition() {
		return new PairInt(x_pos, y_pos);
	}

	/**
	 * 
	 * @return
	 */
	public Galaxy getGalaxy() {
		return galaxy;
	}

	// Deleter
	// -----------------------------------------------

	/**
	 * Post: Elimina la galaxia del planeta
	 * @throws Exception
	 */
	public void removeGalaxy() throws Exception {
		//Comprobamos que tenga una galaxia previamente
		if (galaxy != null) {
			Galaxy g = galaxy;
			galaxy = null;
			//Eliminamos de la galaxia el planeta
			g.removePlanet(g.getName());
		}
	}

	// toString
	// -----------------------------------------------

	/**
	 * @return String
	 */
	public String toString() {
		return name + " " + x_pos + " " + y_pos;
	}

}
