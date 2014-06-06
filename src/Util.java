/**
 * Util Contiene funciones genericas de ayuda en el software
 */
public class Util {
	/**
	 * Comprueba que el strin namep sea valido Pre: name no puede ser nulo ni
	 * vacio name debe estar formado por letras y numeros
	 * 
	 * @param namep
	 * @return
	 */
	public static boolean checkName(String namep) {

		// Que no sea nulo
		if (namep == null)
			return false;

		// Que no este vacio
		if (namep.length() <= 1)
			return false;

		// La primera debe de ser una letra
		if (!((namep.charAt(0) >= 'a') && (namep.charAt(0) <= 'z'))) {
			if (!((namep.charAt(0) >= 'A') && (namep.charAt(0) <= 'Z'))) {
				return false;
			}
		}

		// Miramos el resto de la cadena
		boolean is_correct = true;
		int i = 1;

		while (is_correct && i < namep.length()) {
			if (!((namep.charAt(i) >= 'a') && (namep.charAt(i) <= 'z'))) {
				if (!((namep.charAt(i) >= 'A') && (namep.charAt(i) <= 'Z'))) {
					if (!((namep.charAt(i) >= '0') && (namep.charAt(i) <= '9'))) {
						is_correct = false;
					}
				}
			}

			++i;
		}

		return is_correct;
	}

	public static double vectorialDistance(PairInt pair1, PairInt pair2) {
		return Math.sqrt(
						((pair1.getX() - pair2.getX()) * (pair1.getX() - pair2.getX())) 
						+ 
						((pair1.getY() - pair2.getY()) * (pair1.getY() - pair2.getY()))
				);
	}

	/**
	 * Comprueba que los entereso x_posp y y_posp sean validos para ser
	 * atributos de posicion Pre: x_posp, y_psop mayores que 0
	 * 
	 * @param x_posp
	 * @param y_posp
	 * @throws Exception
	 */

	public static void checkPosition(int x_posp, int y_posp) throws Exception {
		if (x_posp < 0)
			throw new Exception(x_posp + " position not valid");
		if (y_posp < 0)
			throw new Exception(y_posp + " position not valid");
	}

	public static double[][] CopyMatrix(double[][] m1) {
		int n = m1.length;
		double[][] m2 = new double[n][n];
		for (int x = 0; x < n; x++) {
			for (int y = 0; y < m1[x].length; y++) {
				m2[x][y] = m1[x][y];
			}
		}
		return m2;
	}

	public static int[] CopyVector(int[] m1) {
		int n = m1.length;
		int[] m2 = new int[n];

		for (int y = 0; y < m1.length; y++) {
			m2[y] = m1[y];
		}
		return m2;
	}
	
	public static void CopyVector(int[] m1,int[] m2) {
		int n = m1.length;

		for (int y = 0; y < m1.length; y++) {
			m2[y] = m1[y];
		}
	}
	public static void CopyVector(double[] m1,double[] m2) {
		int n = m1.length;

		for (int y = 0; y < m1.length; y++) {
			m2[y] = m1[y];
		}
	}
	public static void CopyVectors(int[] m1,int[] n1,int[] n2,int[] m2) {
		int n = m1.length;

		for (int y = 0; y < m1.length; y++) {
			m2[y] = m1[y];
			n2[y] = n1[y];
		}
	}
	
	public static void CopyVectors(double[] m1,int[] n1,int[] n2,double[] m2) {
		int n = m1.length;

		for (int y = 0; y < m1.length; y++) {
			m2[y] = m1[y];
			n2[y] = n1[y];
		}
	}
	public static int getMaxElement(double Matrix[][]){
		double aux = 0; 
		for(int i = 0; i < Matrix.length; ++i){
			for(int j = 0; j < Matrix.length; ++j){
				if( Matrix[i][j] > aux) aux = Matrix[i][j];
			}
		}
		return (int)aux;
	}
}
