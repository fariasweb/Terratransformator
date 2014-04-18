import java.util.*;
import java.util.regex.*;

public class Galaxy {

	private String name;
	private int x;
	private int y;
	
	private TST<Planet> planets;

	//Contructs
	//---------------------------------------------
	public Galaxy(String namep, int xp, int yp) throws Exception {
		
		setName(namep);	
		setSize(xp, yp);
		
		planets = new TST<Planet> ();
	
	}
	
	public Galaxy() {
		
		x = 0;
		y = 0;
		name = "";
		
		planets = new TST<Planet> ();
		//this.packet_assigned = null;
	}
	
	//Setter
	//---------------------------------------------
	
	public void setName(String namep) throws Exception{
		
		Pattern pat = Pattern.compile("^[A-Za-z]+[0-9]*");
	    Matcher mat = pat.matcher(namep);
		
	    if (!mat.matches()) throw new Exception("Name error");
	    
		name = namep;
		
	}
	
	public void setSize(int xp, int yp) throws Exception{
		
		if (xp <= 0 || yp <= 0) throw new Exception("Size error");
		
		x = xp;
		y = yp;
	}
	
	public void setPlanet(Planet p, int x, int y) {
		//TODO: Asignar posicion al planeta
		planets.put(p.getName(), p);
		p.setPlanet(this);
	}
	
	//Getter
	//-----------------------------------------------
	
	public String getName() {
		return name;
	}
	
	public PairInt getSize (){ 
		return new PairInt(x, y);
	}
	
	TST<Planet> getPlanets(){
		return planets;
	}
	
	//Deleter
	//-----------------------------------------------
	
	public void removePlanet() {
		
	}
	
}
