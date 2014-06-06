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
	
	public void drawTree(QAPBaBTreeNode n){
		
		node = n;
		drawAuxTree(model, root, node);
		scrollPane.repaint();
	}

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
