import java.util.*;

public class QAPHungarianDriver {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		double d[][] = Console.LectureMatrix(sc,N);
		 
		QAPHungarian h = new  QAPHungarian(d.length);
		double n = h.Assigment(d);
		System.out.println(n);
	}
}
