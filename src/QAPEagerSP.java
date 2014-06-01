
public class QAPEagerSP  extends QAPSolucionParcial{
	
	
	public int[] val;
	
	
	public void valor(int nivel, int[] vaaux, int[] valaux, double mini) {
		min = mini;
		va = Util.CopyVector(vaaux);
		val = Util.CopyVector(valaux);
		level = nivel;
	}
	
	public static QAPEagerSP SPcopy(QAPEagerSP sp) {
		QAPEagerSP s = new QAPEagerSP();
		s.valor(sp.level, sp.va, sp.val, sp.min);
		return s;
	}
	

	
	
}
