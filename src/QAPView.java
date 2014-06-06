import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;


public class QAPView extends ViewForm {
	private JButton inputButton;
	private JComboBox gcb;
	private JRadioButton rb1;
	private JRadioButton rb2;
	private JSpinner jp;
	private JLabel levelLabel;
	private JLabel galaxyLabel;

	private QAPInput input;
	private QAPInputDetail qapinput;
	private JButton refreshButton; 
	private PacketController pc; 
	private QAPController qc;

	QAPView(AbstractControllerView c , QAPController qcp) {
		super(c);	
		qc = qcp;
		// Button of QAPInputForm
		crear_vista();
	}
	protected void crear_vista(){
		// Button of QAPInputForm
	
		galaxyLabel = new JLabel("Select Galaxy for Algorithm:");
		String[] nulo = new String[1];
		nulo[0] = "None";
		gcb = new JComboBox(nulo);
		inputButton = new JButton("Create Input Form");
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
								.addGap(10)
								.addComponent(inputButton)
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
						.addGroup(
								layout.createSequentialGroup()
								.addComponent(inputButton)
						)

		);

	
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

	inputButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e){
			try{
				
				if(rb1.isSelected())showQAPInputForm((String)gcb.getSelectedItem(), rb1.getName(), (Integer)jp.getValue());
				else showQAPInputForm((String)gcb.getSelectedItem(), rb2.getName(), (Integer)jp.getValue());
			}
			catch(Exception mm){
				mm.printStackTrace();
			}
		}
	});
	}
	public void refreshComboBox(){

		int sizeGalaxy = qc.getNumberGalaxies();
		if(sizeGalaxy > 0){
			String[][] ngMatrix = new String[sizeGalaxy][3];
			String[] nameGalaxies = new String[sizeGalaxy];

			ngMatrix = decode_list(qc.getAllGalaxies());

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
	
	public void showQAPInputForm(String nameGalaxy, String QAPType, int nivel){
		try{
			qc.generateQAPInput(nameGalaxy, QAPType, nivel);
		}
		catch(Exception e) {
			Console.print(e.getMessage());
		}

		qapinput = new QAPInputDetail((QAPInputControllerView)controller);
		Console.print("QAPINPUT DETAIL GENERADO!"); 
		qapinput.setVisible(true);
		((QAPInputControllerView)controller).create_form_add();
	}

	protected void create_events() {
		// TODO Auto-generated method stub

	}


	public void submit_form() throws Exception {
		// TODO Auto-generated method stub

	}


	protected void create_view() {

	}

}
