public class QAPEagerSP {
	public int level;
	public int[] va;
	public int[] val;
	public double min;

	public void valor(int nivel, int[] vaaux, int[] valaux, double mini) {
		min = mini;
		va = Util.CopyVector(vaaux);
		val = Util.CopyVector(valaux);
		level = nivel;
	}
}
