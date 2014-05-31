import javax.swing.JButton;

/**
 * 
 * @author farias
 *
 */
public abstract class ViewShared extends AbstractViewer {

	/**
	 * 
	 */
	ViewShared() {
		super();
		
		//Creacion de elementos y eventos -- Podrian estar vacias
		create_view();
		create_events();
	}
	
	/**
	 * 
	 * @param c
	 */
	ViewShared(AbstractControllerView c) {
		super(c);
		
		//Creacion de elementos y eventos -- Podrian estar vacias
		create_view();
		create_events();
	}
}
