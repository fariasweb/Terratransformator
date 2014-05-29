import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 * 
 * @author farias
 *
 */
public class ViewOperation extends ViewShared {

	private JTabbedPane tabbedOpe;
	
	/**
	 * 
	 */
	protected void create_view() {
		tabbedOpe = new JTabbedPane();
		//tabbedOpe.setSize(500, 300);
		//tabbedOpe.setMinimumSize(new Dimension(500,300));
		add(tabbedOpe);
	}
	
	/**
	 * 
	 */
	protected void create_events() {
	}
	
	/**
	 * 
	 * @param name
	 * @param p
	 */
	public void add_tab(String name, JPanel p) {
		//Eliminaos las anteriores Tabs
		tabbedOpe.removeAll();
		//Creamos la nueva
		tabbedOpe.add(name, p);
	}

}
