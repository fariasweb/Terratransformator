import java.awt.Color;
import javax.swing.JLabel;

public class ViewHelp extends ViewShared {

	private JLabel Message;

	/**
	 * 
	 */
	ViewHelp() {
		super();
	}

	/**
	 * 
	 */
	protected void create_view() {
		// Creamos un Label a rojo y add to este
		Message = new JLabel();

		// Add al Jpanel actual
		add(Message);

	}

	protected void create_view(String s) {
		// Creamos un Label a rojo y add to este
		Message = new JLabel();
		Message.setText(s);

		// Add al Jpanel actual
		removeAll();
		add(Message);

	}

	/**
	 * 
	 */
	protected void create_events() {
	}

	/**
	 * 
	 * @param e
	 */
	public void show(String e) {
		// Escribir en el label
		Message.setText(e);
	}
}
