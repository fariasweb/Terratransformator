

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.*;


public class Console {
	
	private static String table_format = "%1$12s";
	
	//Lineas
	//---------------------------------------------

	public static void print_line() {
		System.out.println("=================================");
	}
	
	public static void print_line_light() {
		System.out.println("---------------------------------");
	}
	
	//TITULOS
	//---------------------------------------------

	public static void print_h1(String x) {
		print_line();
		System.out.println(x);
		print_line();
	}
	
	public static void print_h2(String x) {
		print_line_light();
		System.out.println(x);
		print_line_light();
	}
	
	
	//Espacios
	//---------------------------------------------
	
	public static void ln() {
		print_ln(1);
	}
	
	public static void print_ln(int n) {
		if (n <= 1) {
			System.out.println("");
		} else {
			for (int i = 0; i < n; i++) {
				System.out.println("");
			}
		}
	}
	
	public static void clear()
	{
	    try
	    {
	        String os = System.getProperty("os.name");

	        if (os.contains("Windows"))
	        {
	            Runtime.getRuntime().exec("cls");
	        }
	        else
	        {
	            Runtime.getRuntime().exec("clear");
	        }
	    }
	    catch (Exception exception)
	    {
	        //  Handle exception.
	    }
	}
	
	// Impresiones
	//---------------------------------------------
	
	public static void print(String x) {
		System.out.println(x);
	}
	
	public static void echo(String x) {
		System.out.print(x);
	}
	
	public static void log(String x) {
	    Date dNow = new Date( );
	    SimpleDateFormat ft = new SimpleDateFormat ("hh:mm:ss");
		System.out.println(ft.format(dNow)+"> "+x);
	}
	
	public static void table(String[] head, List<String[]> content) {
		
		// HEAD
		for(int i = 0; i < head.length; i++) System.out.print("===============");
		Console.ln();
		 
        for(int i = 0; i < head.length; i++) {
            //Console.echo(head[i]);
        	System.out.format(table_format, head[i]);
        }	
        
        Console.ln();
        for(int i = 0; i < head.length; i++) System.out.print("===============");
		Console.ln();
        
        //BODY
        if (content.size() > 0) {
	        for(int i = 0; i < content.size(); i++) {
	            String[] s = content.get(i);
	            
	            for(int j = 0; j < s.length; j++) {
	                System.out.format(table_format, s[j]);
	            }	
	            Console.ln();
	            //Console.print_line_light();
	        }
        } else {
        	System.out.format(table_format, "Any row");
        	Console.ln();
        	//Console.print_line_light();
        }
        
        for(int i = 0; i < head.length; i++) System.out.print("===============");
		Console.ln();
	}
	
	public static void simplyTable(String head, List<String> content) {
		print_line();
		System.out.format(table_format, head);
		
		Console.ln();
		print_line();
		
		 if (content.size() > 0) {
		        for(int i = 0; i < content.size(); i++) {
		        	System.out.format(table_format, content.get(i));	
		            Console.ln();
		        }
	        } else {
	        	System.out.format(table_format, "Any row");
	        	Console.ln();
	        }
		 
		 print_line();
		
	}
	
	public static void tableDouble(double[][] m) {
		
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				Console.print(m[i][j]+" ");
			}
			Console.ln();
		}
		
	}
	
	
	// ENTRADAS	
	//---------------------------------------------

	public static int read_int() {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int opc = Integer.parseInt(br.readLine());
			
			return opc;
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public static String read_string() {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
			return br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return "";
	}
	
	public static String[] read_line(Scanner in) {
		
		String[] argv = null;
		//Pattern pat = Pattern.compile("\"(\"|[^\"])*?\"|[^ ]+");

		if (in.hasNext()) {
		    //Matcher mat = pat.matcher(in.nextLine());
			argv = in.nextLine().split(" ");
		    //while(mat.find()) {
		    //   argv.add(mat.group());
		    //}
		}
		
	    return argv;
		
	}

}
