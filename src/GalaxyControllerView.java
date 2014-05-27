/**
 * 
 * @author farias
 *
 */
public class GalaxyControllerView extends AbstractControllerView {

	
	/**
	 * 
	 * @param pc
	 */
	GalaxyControllerView(PlanetController pc) {
		//Creamos el enlace a capa de dominio
		controller = new GalaxyController(pc);
		//Creamos la vista
		view = new GalaxyView(this);
	}
}
