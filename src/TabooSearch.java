import java.util.*;

public class TabooSearch{
	
	private static long m = 2147483647; private static long m2 = 2145483479; 
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
 }

	public static void main (String[] args){

		int[] v = int[10];
		for(int i = 0; i < 10; ++i) v[i] = 0;

		for(int i = 0; i < 1000000; ++i)
			++v[Math.floor(rand()*10)];

		for(int j = 0; j < 10; ++j)
			Console.print(Double.valueOf(v[i]*10000));

	}
}
