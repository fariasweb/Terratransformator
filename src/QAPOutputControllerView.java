import java.util.Stack;

import javax.swing.table.DefaultTableModel;

/**
 * 
 * @author farias
 * 
 */
public class QAPOutputControllerView extends AbstractControllerView {

	/**
	 * 
	 * @param pcv
	 */
	QAPOutputControllerView(QAPController qap, ViewTabbedPane vs,ViewNotification ve) {
		super(vs, ve);

		// -------------------------------------------------------
		// CONTROLADOR DE DOMINIO
		// -------------------------------------------------------
		controller = qap;

		// -------------------------------------------------------
		// Vistas
		// -------------------------------------------------------

		view = new QAPOutputView(this);
	}

	public void create_form_add() {
		vShared.add_once_tab("Create QAPInput Detail", new QAPInputDetail(this,controller.size()));
	}

	// -------------------------------------------------------
	// TODO
	// -------------------------------------------------------
}