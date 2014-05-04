import java.util.*;

public class QAPHungarianDriver {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		double d[][] = Console.LectureMatrix(sc);

		double n = QAPHungarian.Assigment(d);
		System.out.println(n);
	}
}
