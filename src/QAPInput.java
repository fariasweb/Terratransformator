
public class QAPInput {
	
	private double distanceMatrix[][];
	private double flowMatrix[][];
			
	/**
	 * 
	 */
	public QAPInput(){
		distanceMatrix = null;
		flowMatrix = null;
	}
	
	/**
	 * 
	 * @param galaxy
	 * @param packets
	 */
	public QAPInput(Galaxy galaxy, TST<Packet> packets){
		setDistanceMatrix(galaxy);
		//flowMatrix = packets.getFlowMatrix();
	}
	
	/**
	 * 
	 * @param g
	 */
	public void  setDistanceMatrix(Galaxy g){
		distanceMatrix = g.getDistanceMatrix();
	}
	
	/**
	 * 
	 * @param packets
	 */
	public void setFlowMatrix(TST<Packet> packets){
		int n = packets.size();
		double[] packetResource = new double[n];
		double flow[][] = new double[n][n];
		
		Iterable<Packet> p = packets.values();
		int j = 0;
		for(Packet i : p){
			packetResource[j] = (double) i.getQuantity();
			++j;
		}
		
		for(int i = 0; i < n; ++i){
			for(j = i+1; j < n-1;++j){
				flow[i][j] = packetResource[i] + packetResource[j];
				flow[j][i] = flow[i][j];
			}
		}
		
		flowMatrix = flow;
	}
	
	/**
	 * 
	 * @return
	 */
	public double[][] getDistanceMatrix(){
		return distanceMatrix;
	}
	
	/**
	 * 
	 * @return
	 */
	public double[][] getFlowMatrix(){
		return flowMatrix;
	}
	

	
}
