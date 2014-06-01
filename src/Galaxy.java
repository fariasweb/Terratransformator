import java.util.*;

/**
 * 
 * @author farias
 *
 */
public class Galaxy extends Entity{

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

		planets = new TST<Planet>();
		
		setName(namep);
		setSize(xp, yp);

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
	 * Pre: xp > 0 y yp > 0
	 * 		La galaxia no debe de tener ningun planeta
	 * @param xp
	 * @param yp
	 * @throws Exception
	 */
	public void setSize(int xp, int yp) throws Exception {

		if (xp <= 0 || yp <= 0)
			throw new Exception("Size is not valid. Must be bigger than 0");

		if (planets.size() > 0)
			throw new Exception("The galaxy can not change the size if it have planets");
		
		x = xp;
		y = yp;
	}

	/**
	 * Pre: El planeta no debe estar en esta galaxia previamente
	 * 		La posicion del planeta debe de estar dentro de la galaxia
	 * 		No debe exisitir otro planeta en esa posicion
	 * @param p
	 * @throws Exception
	 */
	public void addPlanet(Planet p) throws Exception {
		
		if (p == null) throw new Exception("Planet is not defined");
		
		//Que no exista
		/*if (planets.contains(p.getName()))
			throw new Exception("This planet is in this galaxy");
		*/
		// Control de la posicion
		PairInt pi = p.getPosition();
		int px = pi.getX();
		int py = pi.getY();
		
		//Es una posicion valida para el tamano de la galaxia?
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
	
	/**
	 * Devuelve la matriz de distnacia entre planetas de una galaxi
	 * 
	 * @return double[][]
	 */
	/*public double[][] getDistanceMatrix(){
		
		//Creamos la matrix
		Iterable<Planet> l = new ArrayList<Planet>();
		l =	planets.values();
		int n = planets.size();
		double[][] d = new double[n][n];
		
		//Guardamos los planetas en un vector
		Planet[] vect = new Planet[n];
		int i = 0; 
		for(Planet p : l){						
			vect[i] = p;
			++i;
		}
		
		//Calculamos las distancias de cada planeta respecto
		//A los otros planteas
		for(i = 0; i < n; ++i){
			for(int j = i+1; j < n-1;++j){
				d[i][j] = getDistance(vect[i],vect[j]);
				d[j][i] = d[i][j];
			}
		}
		
		return d;
	}


	private double getDistance(Planet p1, Planet p2){
		PairInt pair1 = p1.getPosition();
		PairInt pair2 = p2.getPosition();
	    return Math.sqrt(((pair1.getX() - pair2.getX())*((pair1.getX() - pair2.getX()) + (( pair1.getY() - pair2.getY())*( pair1.getY() - pair2.getY())))));
	
	}*/

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
	
	// Deleters
	// -----------------------------------------------

	/**
	 * 
	 * @param namep
	 * @throws Exception
	 */
	public void removePlanet(String namep) throws Exception {
		
		//Comprobamos que tenga el planeta
		if (planets.contains(namep)) {
			//Selecionamos el planeta
			Planet p = planets.get(namep);
			//Eliminamos dle TST
			planets.remove(namep);
			//Eliminamos la galaxia
			p.removeGalaxy();
		}
	}
	
	/**
	 * @throws Exception 
	 * 
	 */
	public void removeAllPlanets() throws Exception {
		
		Iterator<Planet> iterator = planets.values().iterator();

		while (iterator.hasNext()) {
			Planet p = (Planet) iterator.next();
			planets.remove(p.getName());
			p.removeGalaxy();
		}
		
		
	}

	// toString
	// -----------------------------------------------

	/**
	 * 
	 */
	public String toString() {
		//Datos basicos
		String r = name+" "+x+" "+y;
		
		//Planetas asociados
		Iterator<Planet> iterator = planets.values().iterator();

		while (iterator.hasNext()) {
			//Cogemos el siguiente planeta
			Planet p = (Planet) iterator.next();
			r+= " "+p.getName();
		}
		
		return r;	
	}
}
