import java.util.*;
public class QAPSolution {
	private int numS;
	private int[] solution;
	private String QAPType;
	private Galaxy g;
	private TST<Packet> CltPacket;
	private QAPSend qapSend;
	
	/**
	 * 
	 * @param num
	 * @param sol
	 * @param namepl
	 * @param namepac
	 * @param CltP
	 * @param CltPl
	 */
	QAPSolution(int num,int[] sol, String qap, TST<Packet> CltP, Galaxy galaxy){
		numS = num;
		solution = sol;
		QAPType = qap;
		CltPacket = CltP;
		g = galaxy;
		qapSend = null;
	}
	
	/**
	 * 
	 * @return int
	 */
	public int getResult(){
		return numS;
	}
	
	/**
	 * 
	 * @return
	 */
	public int[] getSolution(){
		return solution;
	}
	
	/**
	 * 
	 * @return
	 */
	public Galaxy getGalaxy(){
		return g;
	}
	
	/**
	 * 
	 * @return
	 */
	public TST<Packet> getPackets(){
		return CltPacket;
	}
	
	public String getQAPType(){
		return QAPType;
	}
	
}
