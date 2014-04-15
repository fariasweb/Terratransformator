

import java.util.*;

public class Galaxy {

	private String name;
	private int x;
	private int y;
	
	private List<Planet> planets;
	//private Packet packet_assigned;

	//Contructs
	//---------------------------------------------
	public Galaxy(String namep, int xp, int yp) {
		x = xp;
		y = yp;
		name = namep;
	}
	
	public Galaxy() {
		x = 0;
		y = 0;
		name = "";
		
		planets = new ArrayList<Planet> ();
		//this.packet_assigned = null;
	}
	
	//Setter
	//---------------------------------------------
	
	public void setName(String namep) {
		name = namep;
	}
	
	public void setSize(int xp, int yp) {
		x = xp;
		y = yp;
	}
	
	public void setPlanet(Planet p, int x, int y) {
		//TODO: Asignar posicion al planeta
		planets.add(p);
	}
	
	//Getter
	//-----------------------------------------------
	
	public String getName() {
		return name;
	}
	
	public PairInt getSize (){ 
		return new PairInt(x, y);
	}
	
	List<Planet> getPlanets(){
		return planets;
	}
	
}
