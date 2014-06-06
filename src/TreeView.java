import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
public class TreeView extends ViewController {
	
	JTree tree;
	QAPBaBTreeNode node = new QAPBaBTreeNode();

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
	protected void create_events() {
		// Eventos
		//Boton de crear
		bCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// display/center the jdialog when the button is pressed
				// ((TreeControllerView)controller).create_form_add();
			}
		});
		
		// Boton de guardar
		bImport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				createFrame("Save");
			}
		});
		
		
		//Boton de cargar
		bExport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				createFrame("Load");
			}
		});
		
		//Help hereda de ViewForm
		
		//Boton de eliminar
		bDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				
				int selectedRow = table.getSelectedRow();
				if (selectedRow < 0) controller.show_error("You must select a galaxy before delete");
				else {
        			String selectedData = (String) table.getValueAt(selectedRow, 0);
        			try {
						// ((TreeControllerView) controller).delete(selectedData);
					} catch (Exception e1) {
						controller.show_error(e1.getMessage());
					}

				}
			}
		});
		
		//Tabla
		final ListSelectionModel cellSelectionModel = table.getSelectionModel();
    	cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
      		public void valueChanged(ListSelectionEvent e) {

      			//Sin este if se activan dos eventos (al clickar y soltar click)
      			if (!e.getValueIsAdjusting() && !cellSelectionModel.isSelectionEmpty()){
	        		int selectedRow = table.getSelectedRow();
        			String selectedData = (String) table.getValueAt(selectedRow, 0);
        			//String info = controller.getEntityByName(selectedData);
        			//controller.showOp(info);
        			
        			//Llamada al controlador
        			System.out.println("Selected: " + selectedData);
        			// ((TreeControllerView) controller).create_form_view(selectedData);
        		}
      		}
      	});
		
	}

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

}
