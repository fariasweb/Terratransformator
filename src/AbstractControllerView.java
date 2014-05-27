
import java.awt.Container;
import javax.swing.JPanel;

/**
 * 
 * @author Admira
 *
 */
public abstract class AbstractControllerView {

	//Controllador
	protected AbstractController controller;
	
	//Vista
	protected AbstractViewer view;

	/**
	 * 
	 */
	public Container get_view() {
		return view.get_view();
	}
	
}
