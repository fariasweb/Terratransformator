import java.util.*;
public class QAPSolution {
	private int numS;
	private int[] solution;
	private String[] namePackets;
	private String[] namePlanets;
	private TST<Packet> CltPacket;
	private TST<Planet> CltPlanet;
	
	/**
	 * 
	 * @param num
	 * @param sol
	 * @param namepl
	 * @param namepac
	 * @param CltP
	 * @param CltPl
	 */
	QAPSolution(int num,int[] sol, String[] namepl , String[] namepac, TST<Packet> CltP, TST<Planet> CltPl){
		numS = num;
		solution = sol;
		namePackets = namepac;
		namePlanets = namepl;
		CltPacket = CltP;
		CltPlanet = CltPl;
	}
	
	/**
	 * 
	 * @return int
	 */
	public int getResult(){
		return numS;
	}
	
	/**
	 * 
	 * @return
	 */
	public int[] getSolution(){
		return solution;
	}
	
	/**
	 * 
	 * @return
	 */
	public String[] getPlanets(){
		return namePlanets;
	}
	
	/**
	 * 
	 * @return
	 */
	public String[] getPackets(){
		return namePackets;
	}
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public int findIndexPacket(String name){
		for(int i = 0; i < CltPacket.size(); ++i){
			if(namePackets[i] == name) return i;
		}
		return -1;
	}
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public int findIndexPlanet(String name){
		for(int i = 0; i < CltPacket.size(); ++i){
			if(namePlanets[i] == name) return i;
		}
		return -1;
	}
	
	/**
	 * 
	 * @param i1
	 * @param i2
	 */
	public void changePacket(int i1, int i2){
		int r = solution[i1];
		solution[i1] = solution[i2];
		solution[i2] = r;
	}
	
	/**
	 * 
	 * @param p
	 * @return
	 */
	public List<String> getResources(Packet p){
		Iterable<RelationPacketResource> t = p.getResources().values();
		List<String> res = new ArrayList<String>();
		for(RelationPacketResource i : t){
			res.add(i.getResource().getName());
		}
		return res;
	}
	/**
	 * 
	 * @param p
	 * @return
	 * @throws Exception
	 */
	public Planet getPlanetFromPacket(String p) throws Exception{
		int res = findIndexPlanet(p);
		if (res == -1) throw new Exception("Planet name not valid");
		else return CltPlanet.get(namePlanets[res]);
	}
	
	/**
	 * 
	 * @param p
	 * @return
	 * @throws Exception
	 */
	public Packet getPacketFromPlanet(String p) throws Exception{
		int res = findIndexPacket(p);
		if (res == -1) throw new Exception("Planet name not valid");
		else return CltPacket.get(namePackets[res]);
	}
	
	/**
	 * 
	 * @param namep
	 */
	public void removePacketFromPlanet(String namep){
		int n = findIndexPacket(namep);
		namePackets[n] = "";
	}
	
	/*public saveSolution(){
		
	
	}*/
}
