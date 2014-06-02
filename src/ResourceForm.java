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

public class ResourceForm extends ViewForm {

	private JTextField tfname;
	private JComboBox tselect;
	private String originaName;
	
	//private String[] ltype = {"HUMAN", "TECHNOLOGICAL"};

	/**
	 * 
	 * @param gcf
	 */
	ResourceForm(ResourceControllerView gcf) {
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
		JLabel type = new JLabel("Type: ");

		String[] ltype = {"HUMAN", "TECHNOLOGICAL"};
		
		tfname = new JTextField(10);
		tselect = new JComboBox(ltype);
		tselect.setSelectedIndex(0);


		// Creamos un Layout para colocar Labels y TextFields del formulario

		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);

		layout.setVerticalGroup(layout.createParallelGroup().addGroup(
				layout.createSequentialGroup().addComponent(name)
						.addComponent(tfname).addComponent(type)
						.addComponent(tselect))

		);

		layout.setHorizontalGroup(layout.createParallelGroup()
				.addGroup(layout.createSequentialGroup().addComponent(name))
				.addGroup(layout.createSequentialGroup().addComponent(tfname))
				.addGroup(layout.createSequentialGroup().addComponent(type))
				.addGroup(layout.createSequentialGroup().addComponent(tselect))

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
			throw new Exception("The resource name can not be empty");

		// Creacion del objeto por parte del controlador
		String[] ltype = {"HUMAN", "TECHNOLOGICAL"};
		((ResourceControllerView) controller).save(originaName, tfname.getText(), ltype[tselect.getSelectedIndex()]);

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

	/**
	 * 
	 * @param e
	 */
	public void setTypeValue(String e) {
		
		int anIndex = 1;
		if (e.equals("HUMAN")) anIndex = 0;
		
		tselect.setSelectedIndex(anIndex);
	}

}
