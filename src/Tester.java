import java.util.*;
public class Tester {
	public static void main(String[] args){
		List<PairInt> p = new ArrayList<PairInt>();
		p.add(new PairInt(0,0));
		p.add(new PairInt(0,1));
		p.add(new PairInt(0,2));
		p.add(new PairInt(1,0));
		p.add(new PairInt(1,1));
		p.add(new PairInt(1,2));
		p.add(new PairInt(2,0));
		p.add(new PairInt(2,1));
		p.add(new PairInt(2,2));
	
		int sol[] = new int[3];
		
		Matching m = new Matching();
		int n = m.runMatching(3, 3, p);
		Console.print(n + "");
		sol = m.getMatchingList();
		Console.print(sol[0] + "");
		Console.print(sol[1] + "");
		Console.print(sol[2] + "");
		
	}
}
