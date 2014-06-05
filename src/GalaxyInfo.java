import java.awt.Font;
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

public class GalaxyInfo extends ViewForm {

	private JLabel tfname;
	private JLabel tfposx;
	private JLabel tfposy;
	private String originaName;

	/**
	 * 
	 * @param gcf
	 */
	GalaxyInfo(AbstractControllerView gcf) {
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

		
		JLabel name = new JLabel("Galaxy: ");
		JLabel posx = new JLabel("Width: ");
		JLabel posy = new JLabel("Heigth:");
	

		tfname = new JLabel("");
		tfposx = new JLabel("");
		tfposy = new JLabel("");

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
		tfposx.setText(e);
	}

	/**
	 * 
	 * @param e
	 */
	public void setYValue(String e) {
		tfposy.setText(e);
	}

}
