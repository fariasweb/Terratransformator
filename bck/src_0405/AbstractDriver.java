
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDriver {
	
	protected static String title;
	protected static List<String> menu = new ArrayList<String>();
	
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
	
}
