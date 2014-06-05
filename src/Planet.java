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
	 * Post: Inicializa planeta con todos los atributos nulos
	 */
	public Planet() {
		name = "";
		x_pos = y_pos = 0;
		galaxy = null;
	}

	// Setter
	// ---------------------------------------------


	/**
	 * Modifica la posicion de un planeta
	 * pre:La coordenadas han de ser positivas
	 * post:Se cambia la posicion del planeta
	 * 
	 * @param x_posp
	 * @param y_posp
	 * @throws Exception
	 */
	public void setPosition(Integer x_posp, Integer y_posp) throws Exception {
		//Control basico de datos
		Util.checkPosition(x_posp, y_posp);
		
		//Solo cambiamos si son diferentes
		if (!(x_posp == x_pos && y_posp == y_pos)) {

			// Comprobamos si esta en una galaxia
			
			if (galaxy != null) {
				// La posicion esta dentro de la galaxia
				PairInt pi = galaxy.getSize();
				if (x_posp > pi.getX() || y_posp > pi.getY()) {
					throw new Exception("Position is not valid for galaxy "
							+ galaxy.getName());
				}

				// Existe otro planeta en esta posicion
				if (galaxy.existPlanetInPos(x_posp, y_posp))
					throw new Exception("Exit other planet in this position");
			}

			// En caso de no estar en galaxi y ser diferentes
			x_pos = x_posp;
			y_pos = y_posp;
		}
	}

	/**
	 * Post: Asigna al planetea una galaxia
	 * @param g
	 * @throws Exception
	 */
	public void setGalaxy(Galaxy g) throws Exception {
		if (g != null && galaxy != g) {
			galaxy = g;
		}
	}

	// Getter
	// -----------------------------------------------


	/**
	 * post: Devuelve la posicion del planeta 
	 * @return PairInt
	 */
	public PairInt getPosition() {
		return new PairInt(x_pos, y_pos);
	}

	/**
	 * post: Devuelve la galaxia asignada al planeta
	 * @return Galaxy
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
	
	// Exist
	// -----------------------------------------------

	/**
	 * 
	 * @return
	 */
	public boolean haveGalaxy() {
		return galaxy != null;
	}

	// toString
	// -----------------------------------------------

	/**
	 * Post: Devuelve un string con los atributos de planeta
	 * @return String 
	 */
	public String toString() {
		return name + " " + x_pos + " " + y_pos;
	}
}
