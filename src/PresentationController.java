/**
 * 
 */

/**
 * @author farias
 *
 */
public class PresentationController {
	
	//Controladores de vista
	private GalaxyControllerView gcv;
	private PlanetControllerView pcv;
	private PacketControllerView kcv;
	private QAPControllerView qcv;
	private PresentationView view;
	
	/**
	 * 
	 */
	PresentationController(){
		
		//Creamos la ventana principal - Crear el FRAME
		view = new PresentationView(this);
		//Elementos compartidos
		ViewTabbedPane operationTab = view.get_operation_tab();
		ViewNotification vError = view.get_error_panel();
		
		//Controladores de dominios temporales
		PlanetController pc = new PlanetController(); //Pasar a GCV
		
		try{
			//Creamos los controladores de vista
			gcv = new GalaxyControllerView(pc, operationTab, vError);
			pcv = new PlanetControllerView(pc, operationTab, vError);
			kcv = new PacketControllerView(operationTab, vError);
			
			qcv = new QAPControllerView(kcv,gcv,operationTab,vError);
		}
		catch(Exception e){
			Console.print(e.getMessage());
		}
		//Anadimos a la ventana principal los controladores
		view.add_left_tab(gcv.get_view(), "Galaxys");
		view.add_left_tab(pcv.get_view(), "Planets");
		view.add_left_tab(qcv.get_view(), "QAP");
		view.add_right_tab(kcv.get_view(), "Packets");

	}
	
}
