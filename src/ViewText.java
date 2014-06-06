import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class ViewText extends ViewShared {

	private JTextArea Message;

	/**
	 * 
	 */
	ViewText() {

		super();
		create_view();
	}

	/**
	 * 
	 * @param s
	 */
	ViewText(String s) {
		super();
		// Mostrar text
		create_view();
		show(s);
	}

	/**
	 * 
	 */
	protected void create_view() {
		// Creamos un Label a rojo y add to este
		Message = new JTextArea();

		// Layout
		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);

		// Horizontal
		layout.setHorizontalGroup(layout.createParallelGroup().addGroup(
				layout.createSequentialGroup()
						.addGroup(
								layout.createParallelGroup(
										GroupLayout.Alignment.LEADING)
										.addComponent(Message))));

		// Vertical
		layout.setVerticalGroup(layout.createSequentialGroup().addGroup(
				layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(Message)));

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
