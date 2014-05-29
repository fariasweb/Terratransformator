import java.awt.Color;
import javax.swing.JLabel;

public class ViewTest extends AbstractViewer {

	private JLabel errorMessage;
	
	/**
	 * 
	 */
	protected void create_view() {
		//Creamos un Label a rojo y add to este
		errorMessage = new JLabel();
		errorMessage.setForeground(Color.blue);
		errorMessage.setText("This is a test");
		
		//Add al Jpanel actual
		add(errorMessage);
		
	}

	/**
	 * 
	 */
	protected void create_events() {}
	
	/**
	 * 
	 * @param e
	 */
	public void show(String e) {
		//Escribir en el label
		errorMessage.setText(e);
	}
}
