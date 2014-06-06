import java.util.Stack;

import javax.swing.table.DefaultTableModel;

/**
 * 
 * @author farias
 * 
 */
public class QAPInputControllerView extends AbstractControllerView {

	private QAPInputDetail view_detail;
	
	/**
	 * 
	 * @param pcv
	 */
	QAPInputControllerView(PacketControllerView pcv, GalaxyControllerView gc,
			ViewTabbedPane vs, ViewNotification ve) {
		super(vs, ve);

		// -------------------------------------------------------
		// CONTROLADOR DE DOMINIO
		// -------------------------------------------------------
		controller = new QAPController(gc.getGalaxyController(),
				pcv.getPacketController());

		// -------------------------------------------------------
		// Vistas
		// -------------------------------------------------------

		view = new QAPView(this);
	}

	

	// -------------------------------------------------------
	// CREAR
	// -------------------------------------------------------

	public void updateEntityNameByName(String oldName, String newName) {
		/*
		 * try{ return controller.updateEntityNameByName(oldName, newName);}
		 * catch(Exception e){ Console.print("Cannot find galaxy"); }
		 */
	}
	
	public void create_form_add() {
		vShared.add_once_tab("Create QAPInput Detail", new QAPInputDetail(this));
	}

	// -------------------------------------------------------
	// LISTAR
	// -------------------------------------------------------

	/**
	 * 
	 * @param name
	 */
	public void create_form_view(String nameGalaxy, String QAPType, int nivel) throws Exception{
		//Generar el QAPINput
		((QAPController)controller).generateQAPInput(nameGalaxy, QAPType, nivel);
		Console.log("CREATE FORM VIEW");
		view_detail = new QAPInputDetail(this);
		vShared.add_once_tab("QAP input details", view_detail);
	}
	
	public double[][] getDistanceMatrix() {
		return ((QAPController) controller).getDistanceMatrix();
	}

	public double[][] getFlowMatrix() {
		return ((QAPController) controller).getFlowMatrix();
	}
	
	public String getEntityByName(String name) throws Exception {
		return controller.getByNameToString(name);
	}
	
	/**
	 * 
	 * @return
	 */
	public int getNumberGalaxies() {
		return ((QAPController)controller).getNumberGalaxies();
	}
	
	/**
	 * 
	 * @return
	 */
	public String getAllGalaxies() {
		return ((QAPController)controller).getAllGalaxies();
	}
	
}