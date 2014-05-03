import java.util.ArrayList;


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
		setFlowMatrix(packets);
	}
	
	/**
	 * 
	 * @param g
	 */
	public void  setDistanceMatrix(Galaxy g){
		Iterable<Planet> l = new ArrayList<Planet>();
		l =	g.getPlanets().values();
		int n = g.getPlanets().size();
		double[][] d = new double[n][n];
		
		Planet[] vect = new Planet[n];
		int i = 0; 
		for(Planet p : l){						
			vect[i] = p;
			++i;
		}
		for(i = 0; i < n; ++i){
			for(int j = i+1; j < n-1;++j){
				d[i][j] = Util.vectorialDistance(vect[i].getPosition(),vect[j].getPosition());
				d[j][i] = d[i][j];
			}
		}
		distanceMatrix = d;
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
