import java.util.*;

public class TabooSearch{
	

	/*Lo ejecuté 100 iteraciones y devolvia numeros entre
	0 y 1, asi que lo sustitui por random()*/

		/*	private static long m = 2147483647; private static long m2 = 2145483479; 
			private static long a12= 63308; private static long q12=33921; private static long r12=12979; 
			private static long a13=-183326; private static long q13=11714; private static long r13=2883; 
			private static long a21= 86098; private static long q21=24919; private static long r21= 7417; 
			private static long a23=-539608; private static long q23= 3976; private static long r23=2071;
			private static double invm = 4.656612873077393e-10;

			private static long x10 = 12345;
			private static long x11 = 67890;
			private static long x12 = 13579;
			private static long x20 = 24680;
			private static long x21 = 98765;
			private static long x22 = 43210;

			private static double rando()
		 {long h, p12, p13, p21, p23;
		  h = x10/q13; p13 = -a13*(x10-h*q13)-h*r13;
		  h = x11/q12; p12 = a12*(x11-h*q12)-h*r12;
		  if (p13 < 0) p13 = p13 + m; if (p12 < 0) p12 = p12 + m;
		  x10 = x11; x11 = x12; x12 = p12-p13; if (x12 < 0) x12 = x12 + m;
		  h = x20/q23; p23 = -a23*(x20-h*q23)-h*r23;
		  h = x22/q21; p21 = a21*(x22-h*q21)-h*r21;
		  if (p23 < 0) p23 = p23 + m2; if (p21 < 0) p21 = p21 + m2;
		  x20 = x21; x21 = x22; x22 = p21-p23; if(x22 < 0) x22 = x22 + m2;
		  if (x12 < x22) h = x12 - x22 + m; else h = x12 - x22;
		  if (h == 0) return(1.0); else return(h*invm);
		 }*/

	private static long unif(long low, long high){
		double d = high - low + 1;
		long l = (long)(d*Math.random());
 		return low + l;
 		}

 	//No funciona, lo apañe rollo inline

	/*private static void transpose(Integer a, Integer b){
		Integer temp = a; 
		a.valueOf((int)b);
		b.valueOf((int)temp);
	}
*/
	private static long min(long a, long b)
		{if (a < b) return(a); else return(b);}


	/*--------------------------------------------------------------*/
	/*       compute the cost difference if elements i and j        */
	/*         are transposed in permutation (solution) p           */
	/*--------------------------------------------------------------*/
	private static long compute_delta(int n, ArrayList<ArrayList<Integer>> a, ArrayList<ArrayList<Integer>> b,
                ArrayList<Integer>  p, int i, int j){
 		
  			long d = (a.get(i).get(i)-a.get(j).get(j))*(b.get(p.get(j)).get(p.get(j))-b.get(p.get(i)).get(p.get(i))) +
      		(a.get(i).get(j)-a.get(j).get(i))*(b.get(p.get(j)).get(p.get(i))-b.get(p.get(i)).get(p.get(j)));
  			for (int k = 1; k <= n; ++k) if (k!=i && k!=j)
    		d += (a.get(k).get(i)-a.get(k).get(j))*(b.get(p.get(k)).get(p.get(j))-b.get(p.get(k)).get(p.get(i))) +
            (a.get(i).get(k)-a.get(j).get(k))*(b.get(p.get(j)).get(p.get(k))-b.get(p.get(i)).get(p.get(k)));
			  return(d);
 		}	

 	/*--------------------------------------------------------------*/
	/*      Idem, but the value of delta[i][j] is supposed to       */
	/*    be known before the transposition of elements r and s     */
	/*--------------------------------------------------------------*/
	private static long compute_delta_part(ArrayList<ArrayList<Integer>> a, ArrayList<ArrayList<Integer>> b,
                ArrayList<Integer>  p, ArrayList<ArrayList<Integer>> delta, 
                        int i, int j, int r, int s)
  		{return(delta.get(i).get(j)+(a.get(r).get(i)-a.get(r).get(j)+a.get(s).get(j)-a.get(s).get(i))*
     		(b.get(p.get(s)).get(p.get(i))-b.get(p.get(s)).get(p.get(j))+b.get(p.get(r)).get(p.get(j))-b.get(p.get(r)).get(p.get(i)))+
     		(a.get(i).get(r)-a.get(j).get(r)+a.get(j).get(s)-a.get(i).get(s))*
     		(b.get(p.get(i)).get(p.get(s))-b.get(p.get(j)).get(p.get(s))+b.get(p.get(j)).get(p.get(r))-b.get(p.get(i)).get(p.get(r))) );
  		}

  	private static long tabu_search(long n,                  
                ArrayList<ArrayList<Integer>> a,        
                ArrayList<ArrayList<Integer>> b,       
                ArrayList<Integer> best_sol, 
                long best_cost,	        
                long min_size,     	     
                long max_size,         	 
                long aspiration,	         
                long nr_iterations){     
 
 	ArrayList<Integer> p;                        // current solution
  	ArrayList<ArrayList<Integer>> delta;                    // store move costs
  	ArrayList<ArrayList<Integer>> tabu_list;                // tabu status
  	long current_iteration;               // current iteration
  	long current_cost;                    // current sol. value
  	int i, j, k, i_retained, j_retained = 0;  // indices

  	  /***************** dynamic memory allocation *******************/
  	p = new ArrayList<Integer>((int)n+1);
  	delta = new ArrayList<ArrayList<Integer>>((int)n+1);
  	for (i = 1; i <= n; ++i) delta.set(i, new ArrayList<Integer>((int)n+1));
  	tabu_list = new ArrayList<ArrayList<Integer>>((int)n+1);
	for (i = 1; i <= n; ++i) tabu_list.set(i, new ArrayList<Integer>((int)n+1));;

  	/************** current solution initialization ****************/
  	for (i = 1; i <= n; ++i) p.set(i, best_sol.get(i));

  /********** initialization of current solution value ***********/
  /**************** and matrix of cost of moves  *****************/
	current_cost = 0;
	for (i = 1; i <= n; ++i)
		for (j = 1; j <= n; ++j){
	   		current_cost = current_cost + a.get(i).get(j) * b.get(p.get(i)).get(p.get(j));
	    	if (i < j) {delta.get(i).set(j, (int)compute_delta((int)n, a, b, p, i, j));};
	   	};
	
	best_cost = current_cost;

	 /****************** tabu list initialization *******************/
  for (i = 1; i <= n; ++i)
  	for (j = 1; j <= n; ++j)
    	tabu_list.get(i).set(j,  (int)-(n*i + j));

  /******************** main tabu search loop ********************/
  for (current_iteration = 1; current_iteration <= nr_iterations; ++current_iteration)
   {/** find best move (i_retained, j_retained) **/

    i_retained = Integer.MAX_VALUE;       // in case all moves are tabu
    long min_delta = (long)Double.POSITIVE_INFINITY;   // retained move cost
    boolean autorized;               // move not tabu?
    boolean aspired;                 // move forced?
    boolean already_aspired = false; // in case many moves forced

    for (i = 1; i < n; ++i) 
      for (j = i+1; j <= n; ++j)
       {autorized = (tabu_list.get(i).get(p.get(j)) < current_iteration) || 
                    (tabu_list.get(j).get(p.get(i)) < current_iteration);

        aspired =
         (tabu_list.get(i).get(p.get(j)) < current_iteration-aspiration)||
         (tabu_list.get(j).get(p.get(i)) < current_iteration-aspiration)||
         (current_cost + delta.get(i).get(j) < best_cost);                

        if ((aspired && !already_aspired) || // first move aspired
           (aspired && already_aspired &&    // many move aspired
            (delta.get(i).get(j) < min_delta)   ) || // => take best one
           (!aspired && !already_aspired &&  // no move aspired yet
            (delta.get(i).get(j) < min_delta) && autorized))
          {i_retained = i; j_retained = j;
           min_delta = delta.get(i).get(j);
           if (aspired) {already_aspired = true;};
          };
       };

	if (i_retained == Integer.MAX_VALUE) Console.print("All moves are tabu! \n"); 
    else 
     {/** transpose elements in pos. i_retained and j_retained **/
      Integer aux = p.get(i_retained);
      p.set(i_retained, p.get(j_retained));
      p.set(j_retained, aux);
      // update solution value
      current_cost += delta.get(i_retained).get(j_retained);
      // forbid reverse move for a random number of iterations
      tabu_list.get(i_retained).set((int)p.get(j_retained), (int)current_iteration + (int)unif(min_size,max_size));
      tabu_list.get(j_retained).set((int)p.get(i_retained), (int)current_iteration + (int)unif(min_size,max_size));

      // best solution improved ?
      if (current_cost < best_cost)
       {best_cost = current_cost;
        for (k = 1; k <= n; ++k) best_sol.set(k, p.get(k));
        Console.print("Solution of value " + Integer.valueOf((int)best_cost).toString() + " found at iter. " + Integer.valueOf((int)current_iteration).toString());
       };

      // update matrix of the move costs
      for (i = 1; i < n; ++i)
      	for (j = i+1; j <= n; ++j)
        if (i != i_retained && i != j_retained && 
            j != i_retained && j != j_retained)
         {delta.get(i).set(j, (int)compute_delta_part(a, b, p, delta, 
                               i, j, i_retained, j_retained));}
        else
         {delta.get(i).set(j, (int)compute_delta((int)n, a, b, p, i, j));};
     };
      
   }; 
   return best_cost;
}

	private static void generate_random_solution(long n, ArrayList<Integer> p)
 	{
  		for (int i = 0; i <= n; ++i) p.set(i, i);
  		for (int i = 1; i <  n; ++i){
  			Integer aux = p.get(i);
  			p.set(i, p.get((int)unif(i, n)));
  			p.set(((int)unif(i, n)), aux);
  		}
 	}

 	private static int n;                    // problem size
	private static ArrayList<ArrayList<Integer>> a, b;         // flows and distances matrices
	private static ArrayList<Integer> solution;      /*solution (permutation) */
	private static long cost;                // solution cost

	int i, j;
	
	public static void main (String[] args){

		generate_random_solution(n, solution);
		cost = tabu_search(n, a, b,                     // problem data
		              solution, cost,              // tabu search results
		              9*n/10, 11*n/10, n*n*2,      // parameters
		              1000000);                    // number of iterations 

		Console.print("Solution found by tabu search: ");
		for (int i = 1; i <= n; ++i) Console.echo(solution.get(i).toString()+" "); 
		Console.print(" ");


	}
}
