import java.awt.BorderLayout;
import javax.swing.*;

/**
 * 
 * @author farias
 *
 */
public class ViewPanel extends JPanel {

	//Elementos
	private JTable table;
	private JScrollPane scrollPane;
	
	/**
	 * 
	 * @param columnNames
	 */
	ViewPanel() {
		
		//Table
		table = new JTable();
		
		//Scroll
		scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		
		//Create in Panel
		setLayout(new BorderLayout());
		add(table.getTableHeader(), BorderLayout.PAGE_START);
		add(table, BorderLayout.CENTER);
	}
	
}
