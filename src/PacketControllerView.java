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
	PacketControllerView() {
		//Creamos el enlace a capa de dominio
		controller = new PacketController();
		//Creamos la vista
		view = new PacketView(this);
	}
}
