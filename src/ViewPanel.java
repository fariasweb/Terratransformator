import javax.swing.JButton;


public abstract class ViewPanel extends AbstractViewer {
	
	ViewPanel(AbstractControllerView c) {
		super(c);
		
		//Creacion de elementos y eventos -- Podrian estar vacias
		create_view();
		create_events();
	}
}
