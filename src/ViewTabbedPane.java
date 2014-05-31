import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 * 
 * @author farias
 *
 */
public class ViewTabbedPane extends ViewShared {

	private JTabbedPane tabbedOpe;
	
	/**
	 * 
	 */
	protected void create_view() {
		tabbedOpe = new JTabbedPane();
		//tabbedOpe.setSize(500, 300);
		//tabbedOpe.setMinimumSize(new Dimension(500,300));
		
		this.setBorder(BorderFactory.createTitledBorder(""));
		
        GroupLayout layout = new GroupLayout(this);          
        this.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        
        layout.setHorizontalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                .addComponent(tabbedOpe))
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(tabbedOpe))
        );
		
        //add(tabbedOpe);
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
		
		//Creamos la nueva
		tabbedOpe.add(name, p);
	}
	
	/**
	 * 
	 * @param name
	 * @param p
	 */
	public void add_once_tab(String name, JPanel p) {
		//Eliminaos las anteriores Tabs
		tabbedOpe.removeAll();
		add_tab(name, p);
	}

}