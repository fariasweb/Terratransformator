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

public class PlanetForm extends ViewForm {

	private JTextField tfname;
	private JSpinner tfposx;
	private JSpinner tfposy;
	private String originaName;

	/**
	 * 
	 * @param gcf
	 */
	PlanetForm(PlanetControllerView gcf) {
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
		JLabel posx = new JLabel("X: ");
		JLabel posy = new JLabel("Y:");

		tfname = new JTextField(10);
		SpinnerModel fx = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
		SpinnerModel fy = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);

		tfposx = new JSpinner(fx);
		tfposy = new JSpinner(fy);

		// Creamos un Layout para colocar Labels y TextFields del formulario

		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);

		layout.setVerticalGroup(layout.createParallelGroup().addGroup(
				layout.createSequentialGroup().addComponent(name)
						.addComponent(tfname).addComponent(posx)
						.addComponent(tfposx).addComponent(posy)
						.addComponent(tfposy))

		);

		layout.setHorizontalGroup(layout.createParallelGroup()
				.addGroup(layout.createSequentialGroup().addComponent(name))
				.addGroup(layout.createSequentialGroup().addComponent(tfname))
				.addGroup(layout.createSequentialGroup().addComponent(posx))
				.addGroup(layout.createSequentialGroup().addComponent(tfposx))
				.addGroup(layout.createSequentialGroup().addComponent(posy))
				.addGroup(layout.createSequentialGroup().addComponent(tfposy))

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
			throw new Exception("The planet name can not be empty");

		// Creaci—n del objeto por parte del controlador
		((PlanetControllerView) controller).save(originaName, tfname.getText(),
				(Integer) tfposx.getValue(), (Integer) tfposy.getValue());

		// Add to table - TODO: Orden alfabetico??
		// jt.addRow(new Object[] { tfname.getText() });

		// Reinicio campos
		tfname.setText("");
		tfposx.setValue(0);
		tfposy.setValue(0);
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

	/**
	 * 
	 * @param e
	 */
	public void setXValue(String e) {
		tfposx.setValue(Integer.parseInt(e));
	}

	/**
	 * 
	 * @param e
	 */
	public void setYValue(String e) {
		tfposy.setValue(Integer.parseInt(e));
	}

}
