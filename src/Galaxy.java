import java.util.*;
import java.util.regex.*;

public class Galaxy {

	private String name;
	private int x;
	private int y;

	private TST<Planet> planets;

	// Contructs
	// ---------------------------------------------
	public Galaxy(String namep, int xp, int yp) throws Exception {

		setName(namep);
		setSize(xp, yp);

		planets = new TST<Planet>();

	}

	public Galaxy() {

		x = 0;
		y = 0;
		name = "";

		planets = new TST<Planet>();
		// this.packet_assigned = null;
	}

	// Setter
	// ---------------------------------------------

	public void setName(String namep) throws Exception {

		Pattern pat = Pattern.compile("^[A-Za-z]+[0-9]*");
		Matcher mat = pat.matcher(namep);

		if (!mat.matches())
			throw new Exception("Name error");

		name = namep;

	}

	public void setSize(int xp, int yp) throws Exception {

		if (xp <= 0 || yp <= 0)
			throw new Exception("Size error");

		x = xp;
		y = yp;
	}

	public void setPlanet(Planet p, int x, int y) throws Exception {

		if (planets.contains(p.getName()))
			throw new Exception("This planet is in this galaxy");

		// Control de la posicion
		if (existPlanetInPos(x, y))
			throw new Exception("Planet exists in this position");

		planets.put(p.getName(), p);
		p.setPosition(x, y);
		p.setGalaxy(this);
	}

	// Getter
	// -----------------------------------------------

	public String getName() {
		return name;
	}

	public PairInt getSize() {
		return new PairInt(x, y);
	}

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
		Iterator iterator = planets.values().iterator();

		while (iterator.hasNext()) {

			Planet p = (Planet) iterator.next();
			PairInt pos = p.getPosition();

			if (pos.getX() == x && pos.getY() == y) {
				return p;
			}

		}

		return null;
	}

	// Deleter
	// -----------------------------------------------

	/**
	 * 
	 * @param name
	 * @throws Exception
	 */
	public void removePlanet(String name) throws Exception {
		planets.remove(name);
	}

	/**
	 * 
	 */
	public void removeAllPlanet() {
		planets.clear();
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

		Iterator iterator = planets.values().iterator();
		boolean _exist = false;

		while (!_exist && iterator.hasNext()) {

			Planet p = (Planet) iterator.next();
			PairInt pos = p.getPosition();

			_exist = (pos.getX() == x && pos.getY() == y);

		}

		return _exist;

	}

}
