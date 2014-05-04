import java.util.List;
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
	

	/**
	 * 
	 * @param p
	 */
	public void removePacketSolution(Packet p) throws Exception{
		Send i = getSendWithPacket(p);
		i.setPacket(null);
	}
	
	/**
	 * 
	 * @return
	 */
	public List<Send> getList(){
		return CltSend;
	}
	
	/**
	 * 
	 * @return
	 */
	public int size(){
		return CltSend.size();
	}
	
	
	public String toString() {
		String r = new String();
		for(Send i : CltSend){
			r += i.getPlanet().getName() + " " + i.getPacket().getName();
		}
		return r;	
	}
}

