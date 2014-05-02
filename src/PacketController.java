import java.util.ArrayList;
import java.util.List;

public class PacketController extends AbstractController{

	private TST<Packet> Clt;
	private DataController dCont;


	/**************************************************************
	 * Contructs
	 **************************************************************/
	public PacketController() {
		Clt = new TST<Packet>();
		dCont = new DataController();
	}

	public void assignDataController(DataController dc)throws Exception{
		if(dc == null) throw new Exception("DataController needed");
		dCont = dc;
	}

	public void createPacket(String name) throws Exception {
		Packet p = new Packet(name);
		Clt.put(name, p);
	}

	/**************************************************************
	 * Setters
	 **************************************************************/
	/**
	 * Crea un recurso en el sistema y lo agrega a la ED
	 * Pre: el formato del nombre es correcto; el tipo está en la enum
	 * Post: Se crea un recurso con el nombre y tipo indicado; se 
	 * agrega a la ED
	 * 
	 * @param name
	 * @param type ResourceType
	 * @return 
	 */
	public void add(String name) throws Exception{
		Packet p = new Packet(name);
		Clt.put(name, p);	
	}

	public void add(Packet p) throws Exception{
		if(p == null) throw new Exception("Bad input");
		Clt.put(p.getName(), p);	
	}

	/**
	 * @param rp
	 * @param qp
	 * @throws Exception 
	 */
	public void addResource(String p, String r, String t, int qtt) throws Exception{
		Packet pack = Clt.get(p);
		if(pack == null) throw new Exception ("No such packet");
		Resource res = new Resource(r, t);
		pack.addResource(res, qtt);
	}

	/**
	 * @param planet the planet to set
	 */
	public void setPlanet(String namePacket, String namePlanet, PlanetController pCont) throws Exception {
		Packet p = Clt.get(namePacket);
		if(p == null) throw new Exception ("Debugging");
		Planet planet = pCont.getPlanetByName(namePlanet);
		p.setPlanet(planet);
	}

	/**
	 * @param name the name to set
	 * @throws Exception 
	 */
	public void renamePacket(String oldName, String name) throws Exception{
		Packet p = Clt.get(oldName);
		if(p == null) throw new Exception("No packet called " + oldName);
		Packet paux = p;
		Clt.remove(p.getName());
		paux.setName(name);
		Clt.put(paux.getName(), paux);
	}


	/**************************************************************
	 * Getters
	 **************************************************************/
	public Packet getPacket(String name) throws Exception{
		return Clt.get(name);
	}

	/**
	 * @return the planet
	 */
	public Planet getPlanet(String name) throws Exception{
		Packet p = Clt.get(name);
		return p.getPlanet();
	}
	
	/**
	 * @return the map
	 */
	public TST<RelationPacketResource> getResources(String namep) throws Exception{
		return Clt.get(namep).getResources();
	}
	
/*	public ArrayList<Resource> getMany(String name, int qtt) throws Exception {

        if(Clt.size() == 0) throw new Exception("No resources!");
		
		ArrayList<Resource> ar = Clt.valuesCache(name, qtt);
		return ar;

	}

	public String getManyAsString(String name, int qtt) throws Exception {

        if(Clt.size() == 0) throw new Exception("No resources!");
		
		ArrayList<Resource> ar = Clt.valuesCache(name, qtt);
		String s = "";
		for (Resource r : ar) {
			s+=r.toString();
		}

	}*/
	
	public boolean containsResource(String name){
		Iterable<Packet> ps = Clt.values();
		for(Packet p : ps){
			Iterable<RelationPacketResource> rps = p.getResources().values();
			for(RelationPacketResource r : rps)
				if(r.getResource().getName() == name) return true;
		}
		return false;
	}
	
	/**
	 * @param namep
	 * @return boolean
	 */
	public boolean exists(String p){
		return Clt.contains(p);
	}

	public int size(){
		return Clt.size();
	}
	
	/**************************************************************
	 * Delete
	 **************************************************************/
	
	/**
	 * @param namep
	 * @throws Exception
	 */
	public void removePacket(String p) throws Exception {
		Clt.remove(p);
	}
	    
	public void removeAllPackets(){
		Clt.clear();
	}

	/**
	 * 
	 * @param rp
	 * @throws Exception
	 */
	public void removeResource(String p,String r) throws Exception{
		Packet pack = Clt.get(p);
		pack.removeResource(r);
	}
	
	/**
	 * 
	 */
	public void removeAllResources(String p) throws Exception{
		Packet paq = Clt.get(p);
		paq.removeAllResources();
	}
	
	/**
	 * 
	 */
	public void removePlanet(String p) throws Exception{
		Packet paq = Clt.get(p);
		//paq.removePlanet();
	}

	/**************************************************************
	 * Save & Load
	 **************************************************************/

	public void save(String path, String file) throws Exception{

		/*String cache = Clt.first().toString()+";";
		ArrayList<Packet> list = Clt.valuesCache(Clt.firstKey(), _CACHE_NUM-1);
		
		for(Packet p : list)
			cache += (p.toString()+";");

		dCont.write(path, file, cache, true);

		while(list.size() > 0){

			list = Clt.valuesCache(list.get(list.size()-1).getName(),_CACHE_NUM);
			cache = "";
			for(Packet p : list)
				cache += (p.toString()+";");

			if(cache != "") dCont.write(path, file, cache, true);

		}*/
	}

	public void load(String path, PlanetController pltCont, ResourceController resCont) throws Exception{
		
		/*String s = dCont.read(path);

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

}
