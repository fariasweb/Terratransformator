import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
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
	private JTextField tf;
	private JLabel levelLabel;
	private JLabel galaxyLabel;
	private GalaxyController gc;
	private String[] nameGalaxies;
	private String[][] ngMatrix;
	
	QAPView(AbstractControllerView c, GalaxyController gcp) {
		super(c);
		gc = gcp;
	}

	
	protected void create_events() {
		// TODO Auto-generated method stub
		
	}

	
	public void submit_form() throws Exception {
		// TODO Auto-generated method stub
		
	}

	
	protected void create_view() {
		// Button of QAPInputForm
		inputButton = new JButton("Create Input Form");
		levelLabel = new JLabel("Set Level (Value -1: Infinite for Lazy and None for Eager)");
		if(gc.size() > 0){
			/*ngMatrix = new String[gc.size()][3];
			ngMatrix = decode_list(gc.getAll());
			
			nameGalaxies = new String[gc.size()];
			for(int i = 0; i < gc.size() ; ++i){
				nameGalaxies[i] = ngMatrix[i][0];
			}*/
		}
		/*
		galaxyLabel = new JLabel("Select Galaxy for Algorithm");
		
		gcb = new JComboBox(nameGalaxies);
		rb1 = new JRadioButton("QAP Lazy Branch and Bound");
		rb2 = new JRadioButton("QAP Eager Branch and Bound");
		SpinnerNumberModel jspin = new SpinnerNumberModel(-1, -1, Integer.MAX_VALUE, 1);
		jp = new JSpinner(jspin);
		
		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setVerticalGroup(
				layout.createParallelGroup()
					.addGroup(
							layout.createSequentialGroup()
								.addComponent(galaxyLabel)
								.addComponent(gcb) 
								.addComponent(rb1)
								.addComponent(rb2) 
								.addComponent(levelLabel) 
								.addComponent(jp) 
								.addComponent(inputButton)
					)
					
		);
		
		layout.setHorizontalGroup(
				layout.createParallelGroup()
						.addGroup(
								layout.createSequentialGroup()
								.addComponent(galaxyLabel)
						)
						.addGroup(
								layout.createSequentialGroup()
								.addComponent(gcb)
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
								.addComponent(jp)
						)
						.addGroup(
								layout.createSequentialGroup()
								.addComponent(inputButton)
						)
						
		);*/
	}

}
