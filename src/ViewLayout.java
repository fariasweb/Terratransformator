import javax.swing.JButton;


public abstract class ViewLayout extends AbstractViewer {
	/**
	 * 
	 */
	ViewLayout() {
		super();
		
		//Creacion de elementos y eventos -- Podrian estar vacias
		create_layout();
		create_view();
		create_events();
	}
	
	/**
	 * 
	 * @param c
	 */
	ViewLayout(AbstractControllerView c) {
		super(c);
		
		//Creacion de elementos y eventos -- Podrian estar vacias
		create_layout();
		create_view();
		create_events();
	}
	
	
	/**
	 * 
	 */
	protected abstract void create_layout();
	
	//-------------------------------------------------------
	// Funciones graficas
	//-------------------------------------------------------

	protected JButton create_button_submit() {
		JButton btn = new JButton("Submit");
		
		//TODO: Cambiar color;
		
		return btn;
	}
}
