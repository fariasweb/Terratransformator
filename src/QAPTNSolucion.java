

public class QAPTNSolucion extends QAPSolucionParcial{

	public long executionTime;
	
	public void valor(int nivel, int[] vaaux, long time, double mini) {
		min = mini;
		va = Util.CopyVector(vaaux);
		executionTime = time;
		level = nivel;
	}
	public void show() {

		System.out.println("Cost = " + min);
		System.out.println("Time = " + executionTime);
		System.out.println("level = " + level);
		System.out.println("Paquets goes");
		Console.WriteVector(va);
		System.out.println();
		
	}
	
	public String toString() {
		String r;
		r = min + " " + executionTime + " "+ level;
		for(int i = 0; i < va.length; ++i){
			r += " " + va[i];
		}
		return r;
		
	}
}
