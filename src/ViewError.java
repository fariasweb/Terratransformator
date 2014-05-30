import java.awt.Color;
import javax.swing.JLabel;

public class ViewError extends ViewShared {

	private JLabel errorMessage;
	
	/**
	 * 
	 */
	protected void create_view() {
		//Creamos un Label a rojo y add to este
		errorMessage = new JLabel();
		errorMessage.setForeground(Color.red);
		errorMessage.setVisible(false);
		
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
		errorMessage.setVisible(true);
	}
	
	/**
	 * 
	 */
	public void hide() {
		errorMessage.setText("");
		errorMessage.setVisible(false);
	}
}
