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
				+ ""
				+ ""
				+ ""
				+ ""
				+ ""
				+ ""
				+ ""
				+ "2. Galaxia\n"
				+ "Las galaxias son el principal elemente del sistema y se definen por un nombre que debe ser unico\n"
				+ "Ademas cada galaxia tiene asignado una anchura y altura para poder contener planetas."
				+ ""
				+ ""
				+ ""
				+ ""
				+ ""
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
