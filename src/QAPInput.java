import java.util.*;

public class QAPInput {

	private double distanceMatrix[][];
	private double flowMatrix[][];
	private String[] CltPlanet;
	private String[] CltPacket;
	
	/**
	 * 
	 */
	public QAPInput() {
		distanceMatrix = null;
		flowMatrix = null;
	}

	/**
	 * 
	 * @param galaxy
	 * @param packets
	 */
	public QAPInput(Galaxy galaxy, TST<Packet> packets) {
		setGalaxy(galaxy);
		setDistanceMatrix(galaxy);
		setFlowMatrix(packets);
		setVectorPlanets(galaxy);
		setVectorPackets(packets);
	}
	
	/**
	 * 
	 * @param g
	 */
	public void setDistanceMatrix(Galaxy g) {
		Iterable<Planet> l = new ArrayList<Planet>();
		l = g.getPlanets().values();
		int n = g.getPlanets().size();
		double[][] d = new double[n][n];

		Planet[] vect = new Planet[n];
		int i = 0;
		for (Planet p : l) {
			vect[i] = p;
			++i;
		}
		for (i = 0; i < n; ++i) {
			for (int j = i + 1; j < n - 1; ++j) {
				d[i][j] = Util.vectorialDistance(vect[i].getPosition(),
						vect[j].getPosition());
				d[j][i] = d[i][j];
			}
		}
		distanceMatrix = d;
	}

	public void setPackets(TST<Packet> packets){
		p = packets;
	}
	
	/**
	 * 
	 * @param packets
	 */
	public void setFlowMatrix(TST<Packet> packets) {
		int n = packets.size();
		double[] packetResource = new double[n];
		double flow[][] = new double[n][n];

		Iterable<Packet> p = packets.values();
		int j = 0;
		for (Packet i : p) {
			packetResource[j] = (double) i.getQuantity();
			++j;
		}

		for (int i = 0; i < n; ++i) {
			for (j = i + 1; j < n - 1; ++j) {
				flow[i][j] = packetResource[i] + packetResource[j];
				flow[j][i] = flow[i][j];
			}
		}

		flowMatrix = flow;
	}
	
	public void setVectorPackets(TST<Packet> p){
		CltPacket = new String[p.size()];
		int j = 0;
		for (Packet i : p.values()){
			CltPacket[j] = i.getName();
			++j;
		}
	}
	public void setVectorPlanets(Galaxy g){
		CltPlanet = new String[g.getPlanets().size()];
		int j = 0;
		for (Planet i : g.getPlanets().values()){
			CltPlanet[j] = i.getName();
			++j;
		}
	}
	
	public void setGalaxy(Galaxy galaxy){
		g = galaxy;
	}
	/**
	 * 
	 * @return
	 */
	public double[][] getDistanceMatrix() {
		return distanceMatrix;
	}

	public int getSizePlanets() {
		return CltPlanet.length;
	}
	
	public int getSizePackets() {
		return CltPacket.length;
	}
	
	public String[] getPlanets(){
		return CltPlanet;
	}
	
	public String[] getPackets(){
		return CltPacket;
	}
	
	public Galaxy getGalaxy(){
		return g;
	}
	
	public TST<Packet> getPacket(){
		return p;
	}
	/**
	 * 
	 * @return
	 */
	public double[][] getFlowMatrix() {
		return flowMatrix;
	}

}
