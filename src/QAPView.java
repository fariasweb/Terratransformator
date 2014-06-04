import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	private GalaxyController gc;
	private String[] nameGalaxies;
	private String[][] ngMatrix;
	private QAPInputDetail qapinput;
	private PacketController pc; 
	private String nameMatrix;

	QAPView(AbstractControllerView c, GalaxyController gcp, PacketController pcp) {
		super(c);	
		gc = gcp;
		pc = pcp;
		// Button of QAPInputForm
		crear_vista();
	}
	protected void crear_vista(){
		// Button of QAPInputForm

		inputButton = new JButton("Create Input Form");
		levelLabel = new JLabel("Set Level (Value -1: Infinite for Lazy and None for Eager)");

		if(gc.size() > 0){
			ngMatrix = new String[gc.size()][3];
			ngMatrix = decode_list(gc.getAll());

			nameGalaxies = new String[gc.size()];
			for(int i = 0; i < gc.size() ; ++i){
				nameGalaxies[i] = ngMatrix[i][0];
			}
		}
		galaxyLabel = new JLabel("Select Galaxy for Algorithm:");
		String[] nulo = new String[1];
		nulo[0] = "None";
		if(gc.size() > 0) gcb = new JComboBox(nameGalaxies);
		else gcb = new JComboBox(nulo);

		galaxyLabel = new JLabel("Select Galaxy for Algorithm:");
		rb1 = new JRadioButton("QAP Lazy Branch and Bound",true);
		rb2 = new JRadioButton("QAP Eager Branch and Bound",false);



		SpinnerNumberModel jspin = new SpinnerNumberModel(-1, -1, Integer.MAX_VALUE, 1);
		jp = new JSpinner(jspin);

		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setVerticalGroup(
				layout.createParallelGroup()
					.addGroup(
							layout.createSequentialGroup()
								.addComponent(galaxyLabel,javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(gcb, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE) 
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


	rb1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e){
			rb2.setSelected(false);

		}
	});

	//Boton de eliminar
	rb2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e){
			rb1.setSelected(false);;
		}
	});

	inputButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e){
			showQAPInputForm();
		}
	});
	}

	public void showQAPInputForm(){

		qapinput = new QAPInputDetail((QAPInputControllerView)controller,10);
		qapinput.setVisible(true);
		((QAPInputControllerView)controller).create_form_add();	

	}


	/*public void refreshComboBox(){
		if(gc.size() > 0){
			ngMatrix = new String[gc.size()][3];
			ngMatrix = decode_list(gc.getAll());
			
			nameGalaxies = new String[gc.size()];
			for(int i = 0; i < gc.size() ; ++i){
				nameGalaxies[i] = ngMatrix[i][0];
			}
		}
		String[] nulo = new String[1];
		nulo[0] = "None";
		if(gc.size() > 0) gcb.setModel(new DefaultComboBoxModel(nameGalaxies));
		else {
			gcb = new JComboBox(nulo);
			gcb.setModel(new DefaultComboBoxModel(nulo)); 
		}
	}*/

	protected void create_events() {
		// TODO Auto-generated method stub

	}


	public void submit_form() throws Exception {
		// TODO Auto-generated method stub

	}


	protected void create_view() {

	}

}
