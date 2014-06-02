import javax.swing.JButton;


public abstract class ViewPanel extends AbstractViewer {
	
	ViewPanel(AbstractControllerView c) {
		super(c);
		
		create_view();
		create_events();
	}
}
