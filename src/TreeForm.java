import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.LayoutStyle;
import javax.swing.JButton;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class TreeForm extends ViewForm {

	JTree tree;
	QAPBaBTreeNode node = new QAPBaBTreeNode();
	DefaultTreeModel model;
	DefaultMutableTreeNode root;
	JScrollPane scrollPane;
	
	/**
	 * 
	 * @param gcf
	 */
	TreeForm(TreeControllerView gcf) {
		super(gcf);
	}

	/**
	 * 
	 */
	protected void create_view() {
		
		root = new DefaultMutableTreeNode("B&B Tree");
		model = new DefaultTreeModel(root);
		tree = new JTree(model);
		scrollPane = new JScrollPane(tree);
		
		//Layout
		GroupLayout layout = new GroupLayout(this);
		setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);

		layout.setHorizontalGroup(layout.createSequentialGroup().addGroup(
				layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
						.addComponent(scrollPane)));
		layout.setVerticalGroup(layout.createSequentialGroup().addGroup(
				layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(scrollPane)));
		
	}

	/**
	 * 
	 */
	protected void create_events() {
	}

	/**
	 * 
	 */
	public void submit_form() throws Exception {
		((TreeControllerView)controller).drawTree();
	}
	
	// -------------------------------------------------------
	// TREE FORM FUNCTION
	// -------------------------------------------------------
	
	/**
	 * 
	 * @param n
	 */
	public void drawTree(QAPBaBTreeNode n){
		
		node = n;
		
		//RESET
		root.removeAllChildren(); //this removes all nodes
	    model.reload();
	    
		drawAuxTree(model, root, node);
		scrollPane.repaint();
	}

	/**
	 * 
	 * @param model
	 * @param act
	 * @param node
	 */
	private void drawAuxTree(DefaultTreeModel model, DefaultMutableTreeNode act, QAPBaBTreeNode node){
		
		for(int i = 0; i < node.getSons().size(); ++i){
			QAPBaBTreeNode next = node.getSons().get(i);
			String s = next.toString();
			
			DefaultMutableTreeNode n = new DefaultMutableTreeNode(s);
			model.insertNodeInto(n, act, i);
			drawAuxTree(model, n, next);
		}
	}

}
