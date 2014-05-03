import java.util.List;;
public class QAPSend {
	
	private List<Send> CltSend;
	
	public QAPSend(){
		CltSend = null;
	}
	
	public void addSend(Send s){
		CltSend.add(s);
	}
	
	/**
	 * 
	 * @param p
	 * @return
	 * @throws Exception
	 */
	public Send getSendWithPlanet(Planet p) throws Exception{  // Devuelve Send que tenga paquete = p;
		for(Send i :CltSend){
			if(p == i.getPlanet()) return i;
		}
		throw new Exception("Planet not found");
	}
	
	/**
	 * 
	 * @param p
	 * @return
	 * @throws Exception
	 */
	public Send getSendWithPacket(Packet p) throws Exception{ // Devuelve Send que tenga paquete = p;
		for(Send i :CltSend){
			if(p == i.getPacket()) return i;
		}
		throw new Exception("Packet not found");
	}
	
	/**
	 * 
	 * @param packet
	 * @param planet
	 * @return
	 * @throws Exception
	 */
	public Send getSendWithPacketAndPlanet(Packet packet, Planet planet) throws Exception{
		for(Send i :CltSend){
			if(packet == i.getPacket() && planet== i.getPlanet()) return i;
		}
		throw new Exception("Packet or Planet not found");
	}
	
	/**
	 * 
	 * @param s1
	 * @param s2
	 */
	public void swapSends (Send s1, Send s2){
		Packet r = s1.getPacket();
		s1.setPacket(s2.getPacket());
		s2.setPacket(r);
	}
	
	/*Quizas sea util
	 * private void swapPlanets (Planet planet1, Planet planet2) throws Exception {
		Send s1 = getSendWithPlanet(planet1);
		Send s2 = getSendWithPlanet(planet2);
		Planet r = s1.getPlanet();
		s1.setPlanet(s2.getPlanet());
		s2.setPlanet(r);
	}*/
	
	/*public void setPacketToPlanet(Planet planet, Packet packet) throws Exception{
		if(planet == null ) throw new Exception("Planet not defined");
		Send i = getSendWithPlanet(planet);
		if(i.getPacket() == null ) i.setPacket(packet);
		else swapPackets(packet, i.getPacket());
	}*/
	
	/*public void setPlanetToPacket(Planet planet, Packet packet) throws Exception{
		if(planet == null ) throw new Exception("Planet not defined");
		if(packet == null ) throw new Exception("Packet not defined");
		Send i = getSendWithPacket(packet);
		if(i.getPlanet() == null ) i.setPlanet(planet);
		else swapPlanets(planet, i.getPlanet());	
	}*/
	
	/**
	 * 
	 * @param p
	 */
	/*public void removePacketFromPlanet(Planet p){
		Send i = getSendWithPlanet(p);
		Packet r = i.getPacket();
		i.setPacket(null);
		Send j = getSendWithPacketAndPlanet(null,null); //Buscame un Send Vacio
		j.setPacket(r);
		
	}*/
	
	/**
	 * 
	 * @param p
	 */
	public void removePacketSolution(Packet p){
		Send i = getSendWithPacket(p);
		i.setPacket(null);
	}
	
	public List<Send> getList(){
		return CltSend;
	}
	
	public int size(){
		return CltSend.size();
	}
	
	
	public void save(){
		
	}
}

