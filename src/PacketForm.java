import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.JButton;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

public class PacketForm extends ViewForm {

	private JTextField tfname;
	private String originaName;

	/**
	 * 
	 * @param gcf
	 */
	PacketForm(PacketControllerView gcf) {
		super(gcf);

		originaName = null;
	}

	public void setOriginalName(String n) {
		originaName = n;
	}

	/**
	 * 
	 */
	protected void create_view() {

		JLabel name = new JLabel("Name: ");
		tfname = new JTextField(10);

		// Creamos un Layout para colocar Labels y TextFields del formulario

		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);

		layout.setVerticalGroup(layout.createParallelGroup().addGroup(
				layout.createSequentialGroup().addComponent(name)
						.addComponent(tfname))

		);

		layout.setHorizontalGroup(layout.createParallelGroup()
				.addGroup(layout.createSequentialGroup().addComponent(name))
				.addGroup(layout.createSequentialGroup().addComponent(tfname))

		);
	}

	/**
	 * 
	 */
	protected void create_events() {
	}

	/**
	 * 
	 */
	public void submit_form() throws Exception {

		// Comprobacion basica
		if (!validString(tfname.getText()))
			throw new Exception("The Packet name can not be empty");

		// Creacion del objeto por parte del controlador
		((PacketControllerView) controller).save(originaName, tfname.getText());

		// Add to table - TODO: Orden alfabetico??
		// jt.addRow(new Object[] { tfname.getText() });

		// Reinicio campos
		tfname.setText("");
	}

	// --------------------------------------------------------
	// INPUTS
	// --------------------------------------------------------

	/**
	 * 
	 * @param e
	 */
	public void setNameValue(String e) {
		tfname.setText(e);
	}

}
