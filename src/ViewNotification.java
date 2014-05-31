import java.awt.Color;
import javax.swing.JLabel;

public class ViewNotification extends ViewShared {

	private JLabel errorMessage;
	
	/**
	 * 
	 */
	protected void create_view() {
		//Creamos un Label a rojo y add to este
		errorMessage = new JLabel();
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
	public void error(String e) {
		//Escribir en el label
		errorMessage.setForeground(Color.red);
		errorMessage.setText(e);
		errorMessage.setVisible(true);
	}
	
	/**
	 * 
	 * @param e
	 */
	public void success(String e) {
		//Escribir en el label
		errorMessage.setForeground(Color.green);
		errorMessage.setText(e);
		errorMessage.setVisible(true);
	}
	
	/**
	 * 
	 * @param e
	 */
	public void warning(String e) {
		//Escribir en el label
		errorMessage.setForeground(Color.yellow);
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
