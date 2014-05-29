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
	PacketControllerView(ViewOperation vs, ViewError ve) {
		
		super(vs, ve);
		
		//Creamos el enlace a capa de dominio
		controller = new PacketController();
		//Creamos la vista
		view = new PacketView(this);
	}
}
