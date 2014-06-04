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

public class GalaxyPlanetsForm extends ViewForm {

	private JComboBox tplanets;
	private String[] list;
	private String originaName;


	/**
	 * 
	 * @param gcf
	 */
	GalaxyPlanetsForm(GalaxyControllerView gcf) {
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

		JLabel name = new JLabel("Planets: ");
		tplanets = new JComboBox();

		// Creamos un Layout para colocar Labels y TextFields del formulario

		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);

		layout.setVerticalGroup(layout.createParallelGroup().addGroup(
				layout.createSequentialGroup().addComponent(name)
						.addComponent(tplanets))

		);

		layout.setHorizontalGroup(layout.createParallelGroup()
				.addGroup(layout.createSequentialGroup().addComponent(name))
				.addGroup(layout.createSequentialGroup().addComponent(tplanets))
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
		((GalaxyControllerView) controller).addPlanet(originaName, list[tplanets.getSelectedIndex()]);
	}

	// --------------------------------------------------------
	// INPUTS
	// --------------------------------------------------------

	/**
	 * 
	 * @param e
	 */
	public void append(String[] e) {
		//tfname.setText(e);
		list = e;
		
		for (int i = 0; i < e.length; i++) 
			tplanets.addItem(list[i]);
		
	}

}
