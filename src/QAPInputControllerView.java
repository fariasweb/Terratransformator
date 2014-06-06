import java.util.Stack;

import javax.swing.table.DefaultTableModel;

/**
 * 
 * @author farias
 * 
 */
public class QAPInputControllerView extends AbstractControllerView {

	/**
	 * 
	 * @param pcv
	 */
	QAPInputControllerView(PacketControllerView pcv, GalaxyControllerView gc,ViewTabbedPane vs,ViewNotification ve) {
		super(vs, ve);

		// -------------------------------------------------------
		// CONTROLADOR DE DOMINIO
		// -------------------------------------------------------
		controller = new QAPController(gc.getGalaxyController(),pcv.getPacketController());

		// -------------------------------------------------------
		// Vistas
		// -------------------------------------------------------

		view = new QAPView(this);
	}

	public void create_form_add() {
		vShared.add_once_tab("Create QAPInput Detail", new QAPInputDetail(this));
	}


	public double[][] getDistanceMatrix(){
		return ((QAPController) controller).getDistanceMatrix();
	}
	
	public double[][] getFlowMatrix(){
		return ((QAPController) controller).getFlowMatrix();
	}
	// -------------------------------------------------------
	// CREAR
	// -------------------------------------------------------
	public String getEntityByName(String name){
		try{ return controller.getByNameToString(name);}
		catch(Exception e){ Console.print("Cannot find packet"); }
		return null;
	}

	public void updateEntityNameByName(String oldName, String newName){
		/*try{ return controller.updateEntityNameByName(oldName, newName);}
		catch(Exception e){ Console.print("Cannot find galaxy"); }*/
	}

}