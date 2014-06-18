import java.util.*;

/**
 * QAPInput
 *
 */
public class QAPInput {
	
	//Matrices de entrada
	private double distanceMatrix[][];
	private double flowMatrix[][];

	//Listado con los planetas y paquetes
	private String[] CltPlanet;
	private String[] CltPacket;
	
	private Galaxy galaxy;
	private TST<Packet> packets;
	
	private int nivelparametro;

	/**
	 * 
	 * @param galaxy
	 * @param packets
	 */
	public QAPInput(Galaxy gal, TST<Packet> pack, int parametro) {
		galaxy = gal;
		packets = pack;
		nivelparametro = parametro;
		setDistanceMatrix(galaxy);
		setFlowMatrix(packets);
		setEqualMatrix();
		setVectorPlanets(galaxy);
		setVectorPackets(packets);
		
	}

	private void setEqualMatrix(){
		double auxd[][];
		int nflow = flowMatrix.length;
		int dflow = distanceMatrix.length;

		if(nflow > dflow){
			auxd = new double[nflow][nflow];
			double maxElement = Util.getMaxElement(distanceMatrix);

			for(int i = 0; i < nflow; ++i){
				for(int j = 0; j < nflow; ++j){
					if(i < dflow && j < dflow) auxd[i][j] = distanceMatrix[i][j];
					else {
						if(i == j) auxd[i][j] = 0;
						else auxd[i][j] = maxElement;
					}
				}
			}
			distanceMatrix = auxd;
		}
		else if(nflow < dflow){
			auxd = new double[dflow][dflow];
			double maxElement = Util.getMaxElement(flowMatrix);

			for(int i = 0; i < dflow; ++i){
				for(int j = 0; j < dflow; ++j){
					if(i < nflow && j < nflow) auxd[i][j] = flowMatrix[i][j];
					else {
						if(i == j) auxd[i][j] = 0;
						else auxd[i][j] = maxElement;
					}
				}
			}
			flowMatrix = auxd;
			
		}
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
			for (int j = i; j < n; ++j) {
				d[i][j] = Util.vectorialDistance(vect[i].getPosition(),
						vect[j].getPosition());
				d[j][i] = d[i][j];
			}
		}

		distanceMatrix = d;
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
			for (j = i + 1; j < n; ++j) {
				flow[i][j] = packetResource[i] + packetResource[j];
				flow[j][i] = flow[i][j];
				
			}
		}

		//Console.WriteMatrix(flow);
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

	public void setElementDistanceMatrix(double value, int i , int j){
		distanceMatrix[i][j] = value;
	}

	public void setElementFlowMatrix(double value, int i , int j){
		flowMatrix[i][j] = value;
	}
	
	
	public double[][] getDistanceMatrix() {
		return distanceMatrix;
	}

	public double[][] getFlowMatrix() {
		return flowMatrix;
	}
	public int getMatrixSize() {
		return flowMatrix.length;
	}
	

	public double getElementDistanceMatrixAtIndex(int i, int j ){
		return distanceMatrix[i][j];
	}
	public double getElementFlowMatrixAtIndex(int i , int j){
		return flowMatrix[i][j];
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
	
	public Galaxy getgalaxy() {
		return galaxy;
	}
	
	public TST<Packet> getpackets() {
		return packets;
	}
	
	public int getnivelparametro() {
		return nivelparametro;
	}
}