import java.util.*;
public class QAPEagerDriver {

	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
		
		double f[][] = Console.LectureMatrix(sc);
		double d[][] = Console.LectureMatrix(sc);
		
		int[] va = new int[f.length];
		int[] val = new int[f.length];
		
		System.out.println(QAPEager.BranchAndBound(d,f,va,val));

		 Console.WriteVector(va);
		
		
	}

}
