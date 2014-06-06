import java.util.Stack;

import javax.swing.table.DefaultTableModel;

/**
 * 
 * @author farias
 * 
 */
public class TreeControllerView extends AbstractControllerView {

	/**
	 * 
	 * @param pc
	 */
	TreeControllerView(QAPController qapsol, ViewTabbedPane vs,ViewNotification ve) {
		super(vs, ve);

		// -------------------------------------------------------
		// CONTROLADOR DE DOMINIO
		// -------------------------------------------------------
		
		controller = qapsol;

		// -------------------------------------------------------
		// Vistas
		// -------------------------------------------------------
		view = new TreeView(this);

	}
	
	public void pintameElArbol() throws Exception{
		try{
			Console.print("Pintando el arbol");
			((TreeView)view).setTree(((QAPController)controller).getTree());
			((TreeView)view).pintameElArbol();
		}
		catch(Exception e){ Console.print(e.getMessage()); }

	}


}
