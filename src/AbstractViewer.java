
import java.awt.Container;

/**
 * 
 * @author Admira
 *
 */
public abstract class AbstractViewer {

	AbstractControllerView controller;
	Container view;
	
	/**
	 * 
	 * @param c
	 */
	AbstractViewer(AbstractControllerView c) {
		//Guargamos el controlador al que pertenecemos
		controller = c;
		create_view();
	}
	
	/**
	 * 
	 * @return
	 */
	public Container get_view() {
		return view;
	}
	
	/**
	 * 
	 */
	protected abstract void create_view();

}
