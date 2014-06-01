import java.util.Stack;

import javax.swing.table.DefaultTableModel;

/**
 * 
 * @author farias
 * 
 */
public class QAPControllerView extends AbstractControllerView {

	/**
	 * 
	 * @param pcv
	 */
	QAPControllerView(PacketControllerView pcv, GalaxyControllerView gc,ViewTabbedPane vs,ViewNotification ve) {
		super(vs, ve);

		// -------------------------------------------------------
		// CONTROLADOR DE DOMINIO
		// -------------------------------------------------------
		controller = new QAPController(gc.getGalaxyController(),pcv.getPacketController());

		// -------------------------------------------------------
		// Vistas
		// -------------------------------------------------------
		view = new QAPView(this,gc.getGalaxyController());
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
