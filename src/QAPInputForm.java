import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.LayoutStyle;
import javax.swing.JButton;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class QAPInputForm extends ViewForm {

	private JComboBox gcb;
	private JRadioButton rb1;
	private JRadioButton rb2;
	private JSpinner jp;
	private JLabel levelLabel;
	private JLabel galaxyLabel;
	private JButton refreshButton; 
	
	/**
	 * 
	 * @param gcf
	 */
	QAPInputForm(QAPInputControllerView gcf) {
		super(gcf);
	}

	/**
	 * 
	 */
	protected void create_view() {
		
		galaxyLabel = new JLabel("Select Galaxy for Algorithm:");
		String[] nulo = new String[1];
		nulo[0] = "None";
		gcb = new JComboBox(nulo);
		
		levelLabel = new JLabel("Set Level (Value -1: Infinite for Lazy and None for Eager)");
		refreshButton = new JButton("Refresh Galaxies");
		

		galaxyLabel = new JLabel("Select Galaxy for Algorithm:");
		rb1 = new JRadioButton("GilmoreLazy",true);
		rb2 = new JRadioButton("GilmoreEager",false);
		rb1.setName("GilmoreLazy");
		rb2.setName("GilmoreEager");


		SpinnerNumberModel jspin = new SpinnerNumberModel(-1, -1, Integer.MAX_VALUE, 1);
		jp = new JSpinner(jspin);

		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setVerticalGroup(
				layout.createParallelGroup()
					.addGroup(
							layout.createSequentialGroup()
								.addComponent(galaxyLabel,javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(
										layout.createSequentialGroup()
										.addComponent(refreshButton)
										.addComponent(gcb, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
								)
								.addComponent(rb1)
								.addGap(10)
								.addComponent(rb2) 
								.addGap(10)
								.addComponent(levelLabel) 
								.addGap(10)
								.addComponent(jp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE) 
					)

		);

		layout.setHorizontalGroup(
				layout.createParallelGroup()
						.addGroup(
								layout.createSequentialGroup()
								.addComponent(galaxyLabel,javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
						)
						.addGroup(
								layout.createSequentialGroup()
								.addComponent(refreshButton)

						)
						.addGroup(
								layout.createSequentialGroup()
								.addComponent(gcb,javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
						
						)
						.addGroup(
								layout.createSequentialGroup()
								.addComponent(rb1)
						)
						.addGroup(
								layout.createSequentialGroup()
								.addComponent(rb2)
						)
						.addGroup(
								layout.createSequentialGroup()
								.addComponent(levelLabel)
						)
						.addGroup(
								layout.createSequentialGroup()
								.addComponent(jp,javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
						)

		);
		
	}

	/**
	 * 
	 */
	protected void create_events() {
		
		refreshButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				refreshComboBox();
				
			}
		});

		rb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				
				rb1.setSelected(true);
				rb2.setSelected(false);

			}
		});

		//Boton de eliminar
		rb2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				rb1.setSelected(false);
				rb2.setSelected(true);
			}
		});
	}

	/**
	 * 
	 */
	public void submit_form() throws Exception {
		if((String)gcb.getSelectedItem() != "None" || 
				((QAPInputControllerView)controller).getEntityByName((String)gcb.getSelectedItem()).length() > 1){
			
			if(rb1.isSelected())
				((QAPInputControllerView)controller).create_form_view((String)gcb.getSelectedItem(), rb1.getName(), (Integer)jp.getValue());
			else 
				((QAPInputControllerView)controller).create_form_view((String)gcb.getSelectedItem(), rb2.getName(), (Integer)jp.getValue());
		
		} else {
			throw new Exception ("Select galaxy to continue");
		}
	}
	
	// -------------------------------------------------------
	// QAP FORM FUNCTION
	// -------------------------------------------------------
	
	public void refreshComboBox(){

		int sizeGalaxy = ((QAPInputControllerView)controller).getNumberGalaxies();
		
		if(sizeGalaxy > 0){
			String[][] ngMatrix = new String[sizeGalaxy][3];
			String[] nameGalaxies = new String[sizeGalaxy];

			ngMatrix = decode_list(((QAPInputControllerView)controller).getAllGalaxies());

			/*for(int i = 0; i < ngMatrix.length; ++i){
				for(int j =0 ; j < ngMatrix[0].length; ++j){
					Console.print(ngMatrix[i][j] + i+ " " + j);
				}
				
			}
			*/
			for(int i = 0; i < sizeGalaxy; ++i){
				nameGalaxies[i] = ngMatrix[i][0];
			}
			
			gcb.setModel(new DefaultComboBoxModel(nameGalaxies));
		}
		else{
			String[] nulo = new String[1];
			nulo[0] = "None";
			gcb.setModel(new DefaultComboBoxModel(nulo)); 
		}
	}

}
