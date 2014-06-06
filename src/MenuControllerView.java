import java.util.Stack;

import javax.swing.JMenuBar;
import javax.swing.table.DefaultTableModel;

/**
 * 
 * @author farias
 * 
 */
public class MenuControllerView extends AbstractControllerView {

	private MenuView menu;
	private String help;
	
	/**
	 * 
	 * @param pc
	 */
	MenuControllerView(ViewTabbedPane vs,ViewNotification ve) {
		super(vs, ve);
		
		menu = new MenuView(this);
		
		help = "Terratransformator - Guia\n"
				+ "============================================\n"
				+ "1. Planetas\n"
				+ "2. Galaxia\n"
				+ "3. Recursos\n"
				+ "4. Paquetes\n"
				+ "5. QAPInput\n"
				+ "6. QAPOutput\n"
				+ "7. Tree\n"
				+ ""
				+ ""
				+ ""
				+ ""
				+ ""
				+ ""
				+ ""
				+ "";
	}

	/**
	 * 
	 */
	public void show_help() {
		vShared.add_once_tab("Help", new ViewText(help));
	}
	
	/**
	 * 
	 * @return
	 */
	public JMenuBar get_menu() {
		return menu.get_menu();
	}
	
}
