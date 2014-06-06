import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * 
 * @author farias
 * 
 */
public class TreeView extends View2Row {
	
	private JButton viewTree;
	private TreeForm fTree;
	
	/**
	 * 
	 * @param c
	 */
	TreeView(TreeControllerView c) { //He cambiado por esto en vez de AbstractControllerView
		super(c);
	}
	
	/**
	 * 
	 */
	protected void create_view() {
		// Boton de enviar
		viewTree = new JButton("See tree");
		add_top(viewTree);
		
		//Tree
		fTree = new TreeForm(((TreeControllerView)controller));
		add_bottom(fTree);
		
	}

	/**
	 * 
	 */
	protected void create_events() {
		
		viewTree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// display/center the jdialog when the button is pressed
				//viewTree.setVisible(false);
				try {
					fTree.submit_form();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					Console.print("Falla el Tree");
				}
			}
		});
	}
	
	// -------------------------------------------------------
	// PUBLIC UPDATE
	// -------------------------------------------------------
	
	/**
	 * 
	 * @param n
	 */
	public void setTree(QAPBaBTreeNode n){
		fTree.drawTree(n);
	}

	

}
