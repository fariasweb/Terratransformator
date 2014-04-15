
import java.util.*;

public class PacketCollection {
	List<Packet> cjtPacket;
	
	//Contructs
	//---------------------------------------------
		
	public PacketCollection(List<Packet> g){
		cjtPacket = g;
	}
		
	public PacketCollection(){
		cjtPacket = new ArrayList<Packet>();
	}
	
	//Setter
	//---------------------------------------------
	
	public boolean add(Packet g){
		return cjtPacket.add(g);
	}
		
	public boolean remove(Packet g){
		return cjtPacket.remove(g);
	}
	    
	public void clear(){
		cjtPacket.clear();
	}

	
	//Getter
	//-----------------------------------------------
		
	public List<Packet> getAll(){
		return cjtPacket;
	}
	
	// Exist
	//-----------------------------------------------

	public boolean exist(Packet g){
		return cjtPacket.contains(g);
	}
	
	// Utils
	//-----------------------------------------------
	
	public int size(){
		return cjtPacket.size();
	}
}
