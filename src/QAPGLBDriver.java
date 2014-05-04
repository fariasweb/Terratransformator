import java.util.*;

public class QAPGLBDriver {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		double f[][] = Console.LectureMatrix(sc);
		double d[][] = Console.LectureMatrix(sc);

		int[] va = Console.LectureVector(sc);
		int[] val = new int[va.length];
		for (int i = 0; i < va.length; i++) {
			if (va[i] != 0) {
				val[va[i] - 1] = i + 1;
			}
		}
		double n = QAPGilmoreLawerBound.QAPGLB(d, f, va, val);

		System.out.println("coste total");
		System.out.println(n);

	}

}
