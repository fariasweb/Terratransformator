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
	ViewController(){
		
		//Creamos la ventana principal - Crear el FRAME
		view = new ViewMain(this);
		//Elementos compartidos
		ViewOperation operationTab = view.get_operation_tab();
		ViewError vError = view.get_error_panel();
		
		//Controladores de dominios temporales
		PlanetController pc = new PlanetController();
		
		try{
			//Creamos los controladores de vista
			gcv = new GalaxyControllerView(pc, operationTab, vError);
			pcv = new PlanetControllerView(pc, operationTab, vError);
			
			kcv = new PacketControllerView(operationTab, vError);
		}
		catch(Exception e){
			Console.print(e.getMessage());
		}
		//Anadimos a la ventana principal los controladores
		view.add_left_tab(gcv.get_view(), "Galaxys");
		view.add_left_tab(pcv.get_view(), "Planets");
		
		view.add_right_tab(kcv.get_view(), "Packets");

	}
	
}
