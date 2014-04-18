
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDriver {
	
	protected static String title;
	protected static List<String> menu = new ArrayList<String>();
	
	protected static String _msg_error_pre = "Error: ";
	
	protected static int opc = 0;
	protected static String[] argv;
	
	public static void print_menu(){
		
		//Print title
		Console.print_h2(title);
		
		//MENU
		Console.print("0. Exit");
		
		for(int i = 0; i < menu.size(); i++) {
			Console.print((i + 1) + ". " + menu.get(i));
		}

		Console.print_line_light();
	}
	
	//Error message
	//---------------------------------------------
	
	protected static void _msg_error(String msg) {
		Console.print(_msg_error_pre + msg);
	}
	
	protected static void _msg_opc_invalid() {
		Console.print("Opcion is not correct");
	}
	
	protected static void _msg_error_param_insuf() {
		Console.print("Parameter number is not correct");
	}
	
}
