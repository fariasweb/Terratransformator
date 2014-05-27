
import java.awt.Container;
import javax.swing.JPanel;

/**
 * 
 * @author Admira
 *
 */
public abstract class AbstractViewer extends JPanel {

	//Controlador & vista
	AbstractControllerView controller;
	
	/**
	 * 
	 * @param c
	 */
	AbstractViewer(AbstractControllerView c) {
		//Guargamos el controlador al que pertenecemos
		controller = c;
		
		//Creacion de elementos y eventos -- Podrian estar vacias
		create_view();
		create_events();
	}
	
	/**
	 * 
	 */
	protected abstract void create_view();
	
	/**
	 * 
	 */
	protected abstract void create_events();

}
