import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JTree;
import javax.swing.JScrollPane;

/**
 * 
 * @author farias
 * 
 */
public class TreeView extends ViewForm {
	
	JTree tree;
	JButton viewTree;
	QAPBaBTreeNode node = new QAPBaBTreeNode();
	JScrollPane scrollPane;
	/**
	 * 
	 * @param c
	 */
	TreeView(TreeControllerView c) { //He cambiado por esto en vez de AbstractControllerView
		super(c);
		viewTree = new JButton("VIEW TREE");
		viewTree.setVisible(true);
	}


	/**
	 * 
	 */
	protected void create_events() {}

	public void setTree(QAPBaBTreeNode n){
		node = n;
	}
	
	public void pintameElArbol(){
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("B&B Tree");
		DefaultTreeModel model = new DefaultTreeModel(root);
		tree = new JTree(model);
		scrollPane = new JScrollPane(tree);
		pintameElArbolAuxiliar(model, root, node);
		scrollPane.repaint();
	}

	private void pintameElArbolAuxiliar(DefaultTreeModel model, DefaultMutableTreeNode act, QAPBaBTreeNode node){
		for(int i = 0; i < node.getSons().size(); ++i){
			QAPBaBTreeNode next = node.getSons().get(i);
			String s = next.toString();
			DefaultMutableTreeNode n = new DefaultMutableTreeNode(s);
			model.insertNodeInto(n, act, i);
			pintameElArbolAuxiliar(model, n, next);
		}
	}
	/*protected void create_events(){
		

	}*/


	@Override
	public void submit_form() throws Exception {
		// TODO Auto-generated method stub
		
	}


	@Override
	protected void create_view() {
		// TODO Auto-generated method stub
		viewTree = new JButton("VIEW TREE");
		viewTree.setVisible(true);
		
		viewTree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// display/center the jdialog when the button is pressed
				viewTree.setVisible(false);
				try {
					((TreeControllerView)controller).pintameElArbol();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					Console.print("Falla el Tree");
				}
			}
		});
	}

}
