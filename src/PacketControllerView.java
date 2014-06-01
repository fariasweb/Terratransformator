/**
 * 
 * @author farias
 *
 */
public class PacketControllerView extends AbstractControllerView {

	
	/**
	 * 
	 * @param pc
	 */
	PacketControllerView(ViewTabbedPane vs, ViewNotification ve) {
		
		super(vs, ve);
		
		//Creamos el enlace a capa de dominio
		controller = new PacketController();
		//Creamos la vista
		view = new PacketView(this);
	}

	public PacketController getPacketController(){
		return (PacketController) controller;
	}
	
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
