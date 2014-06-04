import java.util.*;/*
public class QAPEagerDriver {

	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		double f[][] = Console.LectureMatrix(sc,n);
		double d[][] = Console.LectureMatrix(sc,n);
		
		int[] va = new int[f.length];
		int[] val = new int[f.length];
		
		int nb = sc.nextInt();
		QAPEager alg = new QAPEager();
		alg.NombredeBranch = nb;
		double aux1 = alg.run(d,f,va,val);
		
		long aux2 = alg.time;
		alg.tree. WriteBFS ();
		
		System.out.println(aux1);

		System.out.println(aux2);

		Console.WriteVector(va);
	}

}
*/