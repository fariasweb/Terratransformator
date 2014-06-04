import java.util.*;/*
public class QAPlazyDriver {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		double f[][] = Console.LectureMatrix(sc,n);
		double d[][] = Console.LectureMatrix(sc,n);
		
		int[] va = new int[f.length];
		int[] val = new int[f.length];
		int nivel = sc.nextInt();
		
		QAPLazyGLB alg = new QAPLazyGLB(nivel,f,d);
		alg.run();
		
		
		//alg.tree.WriteBFS();

		if(va.length > 1)System.out.println(alg.costs[n-2]); //el resultado final
		else System.out.println(alg.costs[0]);
		Console.WriteVector(alg.asignacionP);
		System.out.println(alg.time); //el resultado final
		
		
	}
}*/
