
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
		set_controller(c);
		
		//Creacion de elementos y eventos -- Podrian estar vacias
		create_view();
		create_events();
	}
	
	/**
	 * 
	 */
	AbstractViewer() {
		//Creacion de elementos y eventos -- Podrian estar vacias
		create_view();
		create_events();
	}
	
	/**
	 * 
	 * @param c
	 */
	public void set_controller(AbstractControllerView c) {
		controller = c;
	}
	
	/**
	 * 
	 * @return
	 */
	protected boolean have_controller() {
		return controller != null;
	}
	
	/**
	 * 
	 */
	protected abstract void create_view();
	
	/**
	 * 
	 */
	protected abstract void create_events();

	public abstract void show(String s);

}
