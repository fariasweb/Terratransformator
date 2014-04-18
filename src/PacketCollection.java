
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
	
	public void add(Packet g){
		 cjtPacket.put(g.getName(),g);
	}
		
	public void removePacketByName(String namep) throws Exception {
		cjtPacket.remove(namep);
	}
	    
	public void clear(){
		cjtPacket.clear();
	}

	
	//Getter
	//-----------------------------------------------
		
	public TST<Packet> getAll(){
		return cjtPacket;
	}
	
	public Packet getPacketByName(String namep){
		return cjtPacket.get(namep);
	}

	// Exist
	//-----------------------------------------------

	public boolean exist(Packet g){
		return cjtPacket.contains(g.getName());
	}
	
	public boolean existPacketByName(String namep){
		return cjtPacket.contains(namep);
	}
	// Utils
	//-----------------------------------------------
	
	public int size(){
		return cjtPacket.size();
	}
}
