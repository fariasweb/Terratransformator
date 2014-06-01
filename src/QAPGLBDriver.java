import java.util.*;

public class QAPGLBDriver {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		double f[][] = Console.LectureMatrix(sc,N);
		double d[][] = Console.LectureMatrix(sc,N);

		int[] va = Console.LectureVector(sc);
		int[] val = new int[va.length];
		for (int i = 0; i < va.length; i++) {
			if (va[i] != 0) {
				val[va[i] - 1] = i + 1;
			}
		}
		QAPGilmoreLawerBound GLB = new QAPGilmoreLawerBound(va.length);
		double n = GLB.QAPGLB(d, f, va, val);
		System.out.println("coste total");
		System.out.println(n);

	}

}
