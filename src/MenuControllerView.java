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
	
	/**
	 * 
	 * @param pc
	 */
	MenuControllerView(ViewTabbedPane vs,ViewNotification ve) {
		super(vs, ve);
		
		menu = new MenuView(this);
	}

	/**
	 * 
	 */
	public void show_help() {
		vShared.add_once_tab("Help", new ViewHelp());
	}
	
	/**
	 * 
	 * @return
	 */
	public JMenuBar get_menu() {
		return menu.get_menu();
	}
	
}
