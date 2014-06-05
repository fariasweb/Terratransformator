import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.JButton;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

public class PacketResourceForm extends ViewForm {

	private JComboBox tresource;
	private JSpinner quantity;
	private String[] list;
	private String originaName;

	/**
	 * 
	 * @param gcf
	 */
	PacketResourceForm(PacketControllerView gcf) {
		super(gcf);

	}

	/**
	 * 
	 * @param n
	 */
	public void setOriginalName(String n) {
		originaName = n;
	}

	/**
	 * 
	 */
	protected void create_view() {

		JLabel name = new JLabel("Resource: ");
		tresource = new JComboBox();
		
		JLabel quant = new JLabel("Quantity: ");
		SpinnerModel fx = new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1);
		quantity = new JSpinner(fx);

		// Creamos un Layout para colocar Labels y TextFields del formulario

		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);

		layout.setVerticalGroup(layout.createParallelGroup().addGroup(
				layout.createSequentialGroup().addComponent(name)
						.addComponent(tresource).addComponent(quant)
						.addComponent(quantity))

		);

		layout.setHorizontalGroup(layout.createParallelGroup()
				.addGroup(layout.createSequentialGroup().addComponent(name))
				.addGroup(layout.createSequentialGroup().addComponent(tresource))
				.addGroup(layout.createSequentialGroup().addComponent(quant))
				.addGroup(layout.createSequentialGroup().addComponent(quantity))
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

		// Creacion del objeto por parte del controlador
		((PacketControllerView) controller).addResource(originaName, list[tresource.getSelectedIndex()], (Integer) quantity.getValue());
	}

	// --------------------------------------------------------
	// INPUTS
	// --------------------------------------------------------

	/**
	 * 
	 * @param e
	 */
	public void append(String[] e) {
		// tfname.setText(e);
		list = e;

		for (int i = 0; i < e.length; i++)
			tresource.addItem(list[i]);

	}

}
