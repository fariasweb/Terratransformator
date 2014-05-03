public class Planet {

	private String name;
	private Integer x_pos;
	private Integer y_pos;
	private Galaxy galaxy;

	/**
	 * post:Comprueba que las posiciones son v‡lidas
	 * @param x_posp
	 * @param y_posp
	 * @throws Exception
	 */
	private static void checkPosition(int x_posp, int y_posp) throws Exception {
		if (x_posp < 0)
			throw new Exception(x_posp + " position not valid");
		if (y_posp < 0)
			throw new Exception(y_posp + " position not valid");
	}

	// Contructs
	// ---------------------------------------------
	
	/**
	 * 
	 * Crea un planeta en el sistema
	 * Pre: El nombre del planeta no debe existir en el sistema
	 * Post: Se crea un planeta con el nombre y posicion indicados
	 * 
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
	 * 
	 */
	public Planet() {
		name = null;
		x_pos = y_pos = null;
		galaxy = null;
	}

	// Setter
	// ---------------------------------------------

	/**
	 * Modifica el nombre de un planeta
	 * pre:El nombre a asignar no ha de existir en el sistema
	 * post:Se cambia el nombre del planeta 
	 * @param namep
	 * @throws Exception
	 */
	public void setName(String namep) throws Exception {
		if (!Util.checkName(namep))
			throw new Exception(namep + " is not valid");
		name = namep;
	}

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
		checkPosition(x_posp, y_posp);
		x_pos = x_posp;
		y_pos = y_posp;
	}


	/*public void setPacket(Packet packetp) {

		if (packetp != packet) {
			packet = packetp;
			packetp.setPlanet(this);
		}
	}*/
	
	/**
	 *post:Cambia la galaxia asignada a un planeta 
	 * @param g
	 * @throws Exception
	 */

	public void setGalaxy(Galaxy g) throws Exception {
		if (galaxy != g) {
			galaxy = g;
			//g.getPlanets().put(name,this);
		}
	}

	// Getter
	// -----------------------------------------------
	/**
	 * Devuelve el nombre del planeta
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * post: Devuelve la posicion del planeta 
	 * @return PairInt
	 */
	public PairInt getPosition() {
		return new PairInt(x_pos, y_pos);
	}

	
	/*public Packet getPacket() {
		return packet;
	}*/

	/**
	 * post: Devuelve la galaxia asignada al planeta
	 * @return Galaxy
	 */
	public Galaxy getGalaxy() {
		return galaxy;
	}

	// Deleter
	// -----------------------------------------------

	/*public void removePacket() {
		if (packet != null) {
			Packet p = packet;
			packet = null;
			p.removePlanet();
		}
	}*/

	
	/**
	 * post: Elimina la galaxia asignada al planeta 
	 * @throws Exception
	 */
	public void removeGalaxy() throws Exception {
		if (galaxy != null) {
			Galaxy g = galaxy;
			galaxy = null;
			g.removePlanet(g.getName());
		}
	}

	// toString
	// -----------------------------------------------

	/**
	 * post: Devuelve un string con los atributos de planeta
	 * @return String 
	 */
	public String toString() {
		return name + " " + x_pos + " " + y_pos;
	}

}
