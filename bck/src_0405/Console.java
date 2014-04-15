

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Console {
	
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
	
	// ENTRADAS	
	//---------------------------------------------

	public static int read_int() {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int opc = Integer.parseInt(br.readLine());
			System.out.println("Opc " + opc);
			
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
	
	//TODO: Esperar un enter
}
