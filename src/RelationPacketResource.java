/**
 * 
 */

/**
 * @author farias
 *
 */
public class RelationPacketResource {

	Packet p;
	Resource s;
	int quantity;
	
	
	//Contructs
	//---------------------------------------------
	public RelationPacketResource(Packet pp, Resource ss, int qp) throws Exception {
		
		setPacket(pp);
		setResource(ss);
		setQuantity(qp);
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
		return s;
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
	public void setResource(Resource ss) {
		s = ss;
	}
	/**
	 * @param quantity the quantity to set
	 * @throws Exception 
	 */
	public void setQuantity(int qp) throws Exception {
		if (qp <= 0) throw new Exception("Quantity must be bigger than 0");
		
		quantity = qp;
	}
	
	
	
}
