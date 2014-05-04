
public class QAPSolution{
	private int numS;
	private int[] solution;
	private String QAPType;
	private Galaxy g;
	private String[] CltPlanet;
	private String[] CltPacket;
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
	QAPSolution(int num,int[] sol, String qap, String[] CltP, Galaxy galaxy){
		numS = num;
		solution = sol;
		QAPType = qap;
		CltPacket = CltP;
		g = galaxy;
		qapSend = null;
		
	}
	
	public void setResult(int num){
		numS = num;
	}
	
	public void setSolution(int[] sol){
		solution = sol;
	}
	
	public void setGalaxy(Galaxy galaxy){
		g = galaxy;
	}
	
	
	public void setQAPType(String name){
		QAPType = name;
	}

	public void setPackets(String[] p){
		CltPacket = p;
	}
	
	public void setPlanets(String[] p){
		CltPlanet = p;
	}
	public void setQAPSend(QAPSend s){
		qapSend = s;
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
	public String[] getPackets(){
		return CltPacket;
	}
	
	public String getQAPType(){
		return QAPType;
	}
}
