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


public class QAPOutputView extends ViewForm {
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

	QAPOutputView(AbstractControllerView c) {
		super(c);	
	}
	
	/**
	 * 
	 */
	public void showQAPInputForm(){
		qapinput = new QAPInputDetail((QAPInputControllerView)controller);
		qapinput.setVisible(true);
		((QAPInputControllerView)controller).create_form_add();	
	}

	/**
	 * 
	 */
	protected void create_events() {
		refreshButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				//refreshComboBox();
			}
		});

		rb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				Console.print("LAA 1!");
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
				showQAPInputForm();
			}
		});

	}

	/**
	 * 
	 */
	public void submit_form() throws Exception {
		// TODO Auto-generated method stub

	}


	/**
	 * 
	 */
	protected void create_view() {
		galaxyLabel = new JLabel("SOY LA VISTA DE OUTPUT :D");
		String[] nulo = new String[1];
		nulo[0] = "None";
		gcb = new JComboBox(nulo);
		inputButton = new JButton("Create Input Form");
		levelLabel = new JLabel("Set Level (Value -1: Infinite for Lazy and None for Eager)");
		refreshButton = new JButton("Refresh Galaxies");
		

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
	}

}
