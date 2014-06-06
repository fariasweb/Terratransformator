import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;


public class QAPOutputView extends ViewForm {
	private JButton viewSolution;
	private JLabel labelCost;
	private JLabel writeCost;
	private JLabel labelSolution;
	private JLabel writeSolution;
	
	private JLabel labelTime;
	private JLabel writeTime;
	
	
	private JLabel labelSend;
	private JLabel writeLabelPacket;
	private JLabel writeLabelPlanet;
	
	
	QAPOutputView(AbstractControllerView c) {
		super(c);	
	}
	
	/**
	 * 
	 */
	public void showQAPInputForm(){
		/*qapinput = new QAPInputDetail((QAPInputControllerView)controller);
		qapinput.setVisible(true);
		((QAPInputControllerView)controller).create_form_add();	*/
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
		// TODO Auto-generated method stub
		double result = ((QAPOutputControllerView)controller).getResult();
		int[] n  = ((QAPOutputControllerView)controller).getSolution();
		long time = ((QAPOutputControllerView)controller).getTime();
		String text = ""; 
		for(int i = 0; i < n.length; ++i ){
			Console.print(n[i] + " ");
			text += n[i] + " ";
		}
		
		writeCost.setText(result + "");
		writeSolution.setText(text);
		writeTime.setText(time + "");
	}


	/**
	 * 
	 */
	protected void create_view() {
		JButton viewSolution = new JButton("View Generated Solution");
		
		labelCost= new JLabel("Cost of Solution:");
		writeCost = new JLabel();
		
		labelSolution = new JLabel("Vector of Solution:");
		writeSolution = new JLabel();
		
		labelTime = new JLabel("Time:");
		writeTime = new JLabel();
		
		labelSend = new JLabel("Vector of QAPSend:");
		
		writeLabelPacket = new JLabel("Packets: ");
		
		writeLabelPlanet = new JLabel("Planets: ");
		

		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		
		layout.setVerticalGroup(
				layout.createParallelGroup()
					.addGroup(
							layout.createSequentialGroup()
								.addComponent(viewSolution)
								.addGap(15)
								.addComponent(labelCost,javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(15)
								.addComponent(writeCost)
								.addGap(15)
								.addComponent(labelSolution) 
								.addGap(15)
								.addComponent(writeSolution) 
								.addGap(15)
								
								.addComponent(labelTime) 
								.addGap(15)
								
								.addComponent(writeTime) 
								.addGap(15)
								
								.addComponent(labelSend) 
								.addGap(15)
								.addComponent(writeLabelPacket)
								.addGap(15)
								.addComponent(writeLabelPlanet)
					)
		);

		layout.setHorizontalGroup(
				layout.createParallelGroup()
						.addGroup(
								layout.createSequentialGroup()
								.addComponent(viewSolution)
						)
						.addGroup(
								layout.createSequentialGroup()
								.addComponent(labelCost)
						)
						.addGroup(
								layout.createSequentialGroup()
								.addComponent(writeCost)

						)
						.addGroup(
								layout.createSequentialGroup()
								.addComponent(labelSolution)
						
						)
						.addGroup(
								layout.createSequentialGroup()
								.addComponent(writeSolution)
						)
						.addGroup(
								layout.createSequentialGroup()
								.addComponent(labelTime)
						)
						.addGroup(
								layout.createSequentialGroup()
								.addComponent(writeTime)
						)
						.addGroup(
								layout.createSequentialGroup()
								.addComponent(labelSend)
						)
						.addGroup(
								layout.createSequentialGroup()
								.addComponent(writeLabelPacket)
						)
						.addGroup(
								layout.createSequentialGroup()
								.addComponent(writeLabelPlanet)
						)
		);
		viewSolution.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				try{
					submit_form();
				}
				catch(Exception t){
					((QAPOutputControllerView)controller).getResult();
				}
			}
		});
	}
	
	

}
