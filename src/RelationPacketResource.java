/**
 * @author farias
 *
 */
public class RelationPacketResource {

	Packet p;
	Resource r;
	int quantity;
	
	
	//Contructs
	//---------------------------------------------
	public RelationPacketResource(Packet pp, Resource rr, int qtt) throws Exception {
		setPacket(pp);
		setResource(rr);
		setQuantity(qtt);
	}
	
	
	//Getter
	//-----------------------------------------------
	
	/**
	 * @return the p
	 */
	public Packet getPacket() {
		return p;
	}
	/**
	 * @return the s
	 */
	public Resource getResource() {
		return r;
	}
	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	
	//Setter
	//---------------------------------------------
		
	/**
	 * @param p the p to set
	 */
	public void setPacket(Packet pp) {
		p = pp;
	}
	/**
	 * @param s the s to set
	 */
	public void setResource(Resource rr) {
		r = rr;
	}
	/**
	 * @param quantity the quantity to set
	 * @throws Exception 
	 */
	public void setQuantity(int qtt) throws Exception {
		if (qtt <= 0) throw new Exception("Quantity must be bigger than 0");
		
		quantity = qtt;
	}
	
	/**************************************************************
	 * To Basic Types
	 **************************************************************/
	public String toString(){
		return p.getName() + " " + r.getName() + " " + quantity;
	}
	
}
