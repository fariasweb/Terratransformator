/**
 * 
 */

/**
 * @author farias
 *
 */
public class ViewController {
	
	//Controladores de vista
	private GalaxyControllerView gcv;
	private PlanetControllerView pcv;
	private PacketControllerView kcv;
	
	private ViewMain view;
	
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
		
		kcv = new PacketControllerView();
		
		//Anadimos a la ventana principal los controladores
		view.add_left_tab(gcv.get_view(), "Galaxys");
		view.add_left_tab(pcv.get_view(), "Planets");
		
		view.add_right_tab(kcv.get_view(), "Packets");

	}
	
}
