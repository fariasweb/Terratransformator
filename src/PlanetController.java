/*import planet;
import planetCollection;
*/
import java.util.ArrayList;
import java.util.List;

public class PlanetController extends AbstractController{

	private TST<Planet> planetCtl;
	private DataController dCont;

	private final String path_file = "";

	public PlanetController() {
		planetCtl = new TST<Planet>();
		dCont = new DataController();
	}
	/**
	 * Crea una galaxia en el sistema
	 * Pre: El nombre del planeta no debe existir en el sistema
	 * 		Las posiciones del planeta no deben de estar ocupadas
	 * Post: Se crea un planeta con el nombre y pos indicado
	 * 
	 * @param name
	 * @param x
	 * @param y
	 * @return boolean
	 */
	public void createPlanet(String name, int x, int y) throws Exception {
			Planet g = new Planet(name, x, y);
			if(planetCtl.get(g.getName()) != null) throw new Exception("This planet already exists!");
			planetCtl.put(g.getName(),g);	
	}
	
	//Setter
	//---------------------------------------------
	/**
	 * @param namep
	 * @throws Exception
	 */
	/*public void removePacket(String namep) throws Exception{
		Planet g = planetCtl.get(namep);
<<<<<<< HEAD
		if(g.getPacket() != null) g.removePacket();
	}*/
	
	/**
	 * 
	 * @param namep
	 * @param namePacket
	 * @throws Exception
	 */
=======
		//if(g.getPacket() != null) g.removePacket();
	}
	
>>>>>>> 81ea9cbe4d2b7d02f69d2cf7ebcbaa4553343c80
	/*public void setPacket(String namep, String namePacket) throws Exception{
		Planet p = planetCtl.get(namep);
		if (p == null) throw new Exception("This planet doesn't exist");
		//if(p.getPacket() != null) throw new Exception("There is a packet already assigned!");
		Packet paq = p.getPacket();
		p.setPacket(paq);
<<<<<<< HEAD
	}
    */
	/**
	 * 
	 * @param oldName
	 * @param newName
	 * @throws Exception
	 */
=======
	}*/


>>>>>>> 81ea9cbe4d2b7d02f69d2cf7ebcbaa4553343c80
	public void setName(String oldName, String newName) throws Exception{
		Planet p = planetCtl.get(oldName);
		if (p == null) throw new Exception("This planet doesn't exist");
		if (p.getName() != newName) {
			if (!Util.checkName(newName)) throw new Exception(newName + " is not valid");
			planetCtl.remove(p.getName());
			p.setName(newName);
			planetCtl.put(newName, p);	
		}
	}

	/**
	 * 
	 * @param namep
	 * @param x
	 * @param y
	 * @throws Exception
	 */
	public void setPosition(String namep, int x, int y) throws Exception {
		//TODO: Comprobar solapamiento
		Planet p = planetCtl.get(namep);
		if (p == null) throw new Exception("This planet doesn't exist");
		if (!(p.getPosition().getX() == x && p.getPosition().getY() == y)){
			p.setPosition(x,y);
			planetCtl.remove(p.getName());
			planetCtl.put(namep,p);
		}
	}

	
	//Getter
	//---------------------------------------------
	/**
	 * 
	 * @param namep
	 * @return
	 * @throws Exception
	 */
	public PairInt getPosition(String namep) throws Exception{
		Planet p = planetCtl.get(namep);
		if (p == null) throw new Exception("This planet doesn't exist");
		return p.getPosition();
		
	}
	
<<<<<<< HEAD
	/**
	 * 
	 * @param namep
	 * @return
	 * @throws Exception
	 */
=======
>>>>>>> 81ea9cbe4d2b7d02f69d2cf7ebcbaa4553343c80
	/*public Packet getPacket(String namep) throws Exception {
		Planet p = planetCtl.get(namep);
		if (p == null) throw new Exception("This planet doesn't exist");
		return p.getPacket();
		
	}*/
 	
	/////////////////////////////////FUNCIONES TST<PLANET>

	/**
	 * @param namep
	 * @return
	 */
	
	public void clear(){
		planetCtl.clear();
	}

	//Setter
	
	/** 
	 * @param namep
	 * @return
	 */
	public void removePlanetByName(String namep) throws Exception {
		Planet g = planetCtl.get(namep);
		if (g == null) throw new Exception("This planet doesn't exist");
		planetCtl.remove(namep);
	}



	//Getter
	//-----------------------------------------------
	/**
	 * 
	 * @return
	 */
	public List<String> getAll() {
		List<String> list = new ArrayList<String>();
		for(Planet i : planetCtl.values()){
			list.add(i.getName());
		}
		return list;
	}

	/**
	 * @return TST<Planet>
	 */
	public TST<Planet> getAllPlanet(){
		return planetCtl;
	}
	
	/**
	 * @param namep
	 * @return
	 */
	public Planet getPlanetByName(String namep) throws Exception{
		if (!existByName(namep)) throw new Exception("This planet doesn't exist!"); 
		return planetCtl.get(namep);
	}
	// Exist
	//-----------------------------------------------
	/**
	 * @param g
	 * @return
	 */
	public boolean exist(Planet g){
		return planetCtl.contains(g.getName());
	}
	
	/**
	 * @param name
	 * @return
	 */
	public boolean existByName(String namep) {
		return planetCtl.contains(namep);
	}

	// Utils
	//-----------------------------------------------
	/**
	 * 
	 * @return
	 */
	public int size(){
		return planetCtl.size();
	}
	


	/*public void save(String path, String file, int cacheSize) throws Exception {


		String cache = planetCtl.first().toString();
		ArrayList<Planet> list = planetCtl.valuesCache(planetCtl.firstKey(), 5);
		for(Planet p : list)
			cache += (p.toString()+";");
		dCont.write(path, file, cache, false);

		while(list.size() > 0){

			list = planetCtl.valuesCache(list.get(list.size()-1).getName(),5);
			cache = "";
			for(Planet p : list)
				cache += p.toString();
			dCont.write(path, file, cache, true);

		}

	} 

	public void load(String path, PlanetController pltCont, ResourceController resCont) throws Exception{
	/*
		String s = dCont.read(path);

		String name = new String();
		String planet = new String();
		String packRel = new String();
		String resRel = new String();
		String qttRel = new String();
		String aux = new String();

		Packet pk = new Packet();
		Planet pl;

		for (int i = 0; i < s.length(); ++i) {
			if(s.charAt(i) == ';'){
				name = planet = null; 
				aux = "";
			}
			else if (s.charAt(i) == ' '){
				if (name == null){
					name = aux;
					aux = "";
				}
				else if (planet == null){
					planet = aux;
					aux = "";
					try{
						pk = new Packet(name);
						pl = pltCont.getPlanetByName(planet);
						pk.setPlanet(pl);
						add(pk);
					}
					catch (Exception e) {
						Console.print("Exception: ");
						e.printStackTrace();
					}
				}
				else if (packRel == null){
					packRel = aux;
					aux = "";
				}
				else if (resRel == null){
					resRel = aux;
					aux = "";
				}
				else if (qttRel == null){
					qttRel = aux;
					aux = "";
					pk.addResource(resCont.get(resRel), Integer.parseInt(qttRel));
					packRel = resRel = qttRel = null;
				}
			}
			else aux+=s.charAt(i);
		}*/
	}

