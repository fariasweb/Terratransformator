/**
 * 
 */

/**
 * @author farias
 * 
 */
public class PresentationController {

	// Controladores de vista
	private GalaxyControllerView gcv;
	private PlanetControllerView pcv;
	private PacketControllerView kcv;
	private ResourceControllerView rcv;
	private QAPInputControllerView qcv;
	private QAPOutputControllerView ocv;
	private TreeControllerView tcv;
	private PresentationView view;
	private MenuControllerView menu;

	/**
	 * 
	 */
	PresentationController() {

		// Creamos la ventana principal - Crear el FRAME
		view = new PresentationView(this);
		// Elementos compartidos
		ViewTabbedPane operationTab = view.get_operation_tab();
		ViewNotification vError = view.get_error_panel();

		// Creamos los controladores de vista
		pcv = new PlanetControllerView(operationTab, vError);
		gcv = new GalaxyControllerView(pcv.get_controller(), operationTab, vError);
		kcv = new PacketControllerView(operationTab, vError);
		rcv = new ResourceControllerView(kcv.get_controller(), operationTab,vError);
		kcv.setResourceController((ResourceController) rcv.get_controller());
		
		// Controladores de QAP
		qcv = new QAPInputControllerView(kcv, gcv, operationTab, vError);
		ocv = new QAPOutputControllerView(((QAPController)qcv.get_controller()), operationTab, vError);
		tcv = new TreeControllerView(((QAPController)qcv.get_controller()), operationTab, vError);
		
		//MENU
		menu = new MenuControllerView(operationTab, vError);
		// Anadimos a la ventana principal los controladores
		view.setMenu(menu.get_menu());
		
		view.add_left_tab(gcv.get_view(), "Galaxies");
		view.add_left_tab(pcv.get_view(), "Planets");
		view.add_left_tab(qcv.get_view(), "QAPInput");

		view.add_right_tab(kcv.get_view(), "Packets");
		view.add_right_tab(rcv.get_view(), "Resource");
		view.add_right_tab(ocv.get_view(), "QAPOutput");
		view.add_right_tab(tcv.get_view(), "Tree");

		gcv.set_scroll();
		pcv.set_scroll();
		kcv.set_scroll();
		rcv.set_scroll();
		qcv.set_scroll();
		ocv.set_scroll();
		tcv.set_scroll();

	}

}
