/**
 * 
 */

/**
 * @author farias
 *
 */
public class ViewController extends AbstractControllerView {
	
	//Controladores de vista
	private GalaxyControllerView gcv;
	private PlanetControllerView pcv;
	
	/**
	 * 
	 */
	ViewController() {
		
		//Creamos la ventana principal - Crear el FRAME
		view = new ViewMain(this);
		
		//Controladores de dominios temporales
		PlanetController pc = new PlanetController();
		
		//Creamos los controladores de vista
		gcv = new GalaxyControllerView(pc);
		pcv = new PlanetControllerView(pc);
		
		//Anadimos a la ventana principal los controladores
		((ViewMain) view).add_left_tab(gcv.get_view(), "Galaxys");
		((ViewMain) view).add_left_tab(pcv.get_view(), "Planets");

	}
	
}
