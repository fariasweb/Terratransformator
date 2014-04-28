import java.util.ArrayList;
import java.util.List;

public class PacketController extends AbstractController{

	private TST<Packet> Clt;


	/**************************************************************
	 * Contructs
	 **************************************************************/
	public PacketController() {
		Clt = new TST<Packet>();
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
	public void setPlanet(String namePacket, String namePlanet) throws Exception {
		Packet p = Clt.get(namePacket);
		if(p.getPlanet() == null) throw new Exception ("No such packet");
		Planet planet = getPlanet(namePlanet);
		if (p.getPlanet() != planet && p.getPlanet() != null) {
			p.setPlanet(planet);
			planet.setPacket(p);
		}
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
		paq.removePlanet();
	}

	/**************************************************************
	 * Save & Load
	 **************************************************************/

	public void save() throws Exception{

		String cache = Clt.first().toString();
		ArrayList<Packet> list = Clt.valuesCache(Clt.firstKey(), 5);
		for(Packet p : list)
			cache += p.toString();
		//ResourceGD.save(cache);

		while(list.size() > 0){

			list = Clt.valuesCache(list.get(list.size()-1).getName(),5);
			cache = "";
			for(Packet p : list)
				cache += p.toString();
			//ResourceGD.save(cache);
		}
	}

	public void load(){

		/*String s = new String(); // = ResourceControllerGD.load(N);
		String name = null;
		String type = null;
		for (int i = 0; i < s.length(); ++i) {
			if(s.charAt(i) == ' '){
				if(type == null) type = "";
				else{ 
					try{
						add(name, type);
						name = type = null; 
					}
					catch (Exception e) {
						Console.print("Exception: ");
						e.printStackTrace();
					}
				}
			}
			else{
				if(type == null) name+=s.charAt(i);
				else type+=s.charAt(i);
			}
		}*/
	}

}
