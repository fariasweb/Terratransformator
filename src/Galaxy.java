import java.util.*;
import java.util.regex.*;

/**
 * 
 * @author farias
 *
 */
public class Galaxy {

	private String name;
	private int x;
	private int y;

	private TST<Planet> planets;

	// Contructs
	// ---------------------------------------------
	
	/**
	 * 
	 * @param namep
	 * @param xp
	 * @param yp
	 * @throws Exception
	 */
	public Galaxy(String namep, int xp, int yp) throws Exception {

		setName(namep);
		setSize(xp, yp);

		planets = new TST<Planet>();

	}

	/**
	 * 
	 */
	public Galaxy() {

		x = 0;
		y = 0;
		name = "";

		planets = new TST<Planet>();
		// this.packet_assigned = null;
	}

	// Setter
	// ---------------------------------------------

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
	 * 
	 * @param xp
	 * @param yp
	 * @throws Exception
	 */
	public void setSize(int xp, int yp) throws Exception {

		if (xp <= 0 || yp <= 0)
			throw new Exception("Size is not valid. Must be bigger than 0");

		x = xp;
		y = yp;
	}

	/**
	 * 
	 * @param p
	 * @throws Exception
	 */
	public void addPlanet(Planet p) throws Exception {
		
		if (p == null) throw new Exception("Planet is not defined");
		
		//Que no exista
		if (planets.contains(p.getName()))
			throw new Exception("This planet is in this galaxy");

		// Control de la posicion
		PairInt pi = p.getPosition();
		int px = pi.getX();
		int py = pi.getY();
		
		//Es una posicion valida para el tama–o de la galaxia?
		if ((px < 0 || px > x) ||
			(py < 0 || py > y )) {
				throw new Exception("The planet position is not correct for this galaxy");
			}
		
		//Existe algun planeta en esa posicion?
		if (existPlanetInPos(px, py))
			throw new Exception("Planet exists in this position");

		planets.put(p.getName(), p);
		p.setGalaxy(this);
	}

	// Getter
	// -----------------------------------------------
	
	/**
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @return
	 */
	public PairInt getSize() {
		return new PairInt(x, y);
	}

	/**
	 * 
	 * @return
	 */
	TST<Planet> getPlanets() {
		return planets;
	}
	

	/**
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public Planet getPlanetInPost(int x, int y) {
		Iterator<Planet> iterator = planets.values().iterator();

		while (iterator.hasNext()) {

			Planet p = (Planet) iterator.next();
			PairInt pos = p.getPosition();

			if (pos.getX() == x && pos.getY() == y) {
				return p;
			}

		}

		return null;
	}

	// Exists
	// -----------------------------------------------

	/**
	 * 
	 * @param x
	 * @param y
	 * @return
	 */

	public boolean existPlanetInPos(int x, int y) {

		return (getPlanetInPost(x,y) != null);

	}

}
