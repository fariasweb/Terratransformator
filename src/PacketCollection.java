
import java.util.*;

public class PacketCollection {
	private TST<Packet> cjtPacket;
	
	//Contructs
	//---------------------------------------------
			
	public PacketCollection(){
		cjtPacket = new TST<Packet>();
	}
	
	//Setter
	//---------------------------------------------
	/**
	 * @param g
	 */
	public void add(Packet g){
		 cjtPacket.put(g.getName(),g);
	}
	
	/**
	 * @param namep
	 * @throws Exception
	 */
	public void removePacketByName(String namep) throws Exception {
		cjtPacket.remove(namep);
	}
	    
	public void clear(){
		cjtPacket.clear();
	}

	
	//Getter
	//-----------------------------------------------
	/**
	 * 
	 * @return TST<Packet>
	 */
	public TST<Packet> getAll(){
		return cjtPacket;
	}
	
	/**
	 * @param namep
	 * @return Packet
	 */
	public Packet getPacketByName(String namep){
		return cjtPacket.get(namep);
	}

	// Exist
	//-----------------------------------------------
	/**
	 * @param g
	 * @return boolean
	 */
	public boolean exist(Packet g){
		return cjtPacket.contains(g.getName());
	}
	
	/**
	 * @param namep
	 * @return boolean
	 */
	public boolean existPacketByName(String namep){
		return cjtPacket.contains(namep);
	}
	// Utils
	//-----------------------------------------------
	
	public int size(){
		return cjtPacket.size();
	}
}
