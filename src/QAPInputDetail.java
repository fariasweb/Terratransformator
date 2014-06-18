import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;


public class QAPInputDetail extends View3Col{
	private JButton jb; 
	private JButton stopButton;
	private double[][] distanceM;
	private double[][] flowM;
	private static Thread t1;
	private QAPInputFormCreate formDistance;
	private QAPInputFormCreate formFlow;
	private AlgorithmThread tAlg = null;

	QAPInputDetail(AbstractControllerView c) {
		super((QAPInputControllerView)c);
	
		distanceM = ((QAPInputControllerView)c).getDistanceMatrix();
		flowM = ((QAPInputControllerView)c).getFlowMatrix();
		crear_vista();
	
	}


	public void check(){
		try{
			formDistance.checkSetMatrix();
			formFlow.checkSetMatrix();
		}
		catch(Exception e){
			controller.vError.error("Introduce Numbers in the Tables!");
		}
	}
	
	
	private void crear_vista(){
		
		formDistance = new QAPInputFormCreate(controller,"Distance Matrix:", distanceM);
		add_left(formDistance);
		formFlow = new QAPInputFormCreate(controller, "Flow Matrix", flowM);
		add_center(formFlow);
		jb = new JButton("Run Algorithm!");
		stopButton = new JButton("Stop Execution!");
		JPanel jp = new JPanel(new GridLayout(0,1));
		jp.add(jb);
		jp.add(stopButton);
		add_right(jp);

		
		stopButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				t1.stop();
				((QAPInputControllerView)controller).set_stop();
			}
		});
		
		jb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				try{
					if(!((QAPInputControllerView)controller).is_running()){
							tAlg = new AlgorithmThread((QAPInputControllerView)controller);
							t1 = new Thread(tAlg,"Algorithm");
							check();
							//Activamos el control de thread
							((QAPInputControllerView)controller).set_run();
							
							//Generamos el thread
							t1.start();
						}
						else {
							controller.vError.error("The algorithm is running. Wait a moment!");
						}
				
				}
				catch(Exception ee){
					Console.print("SIGNAL RECEIVED");
				}
			}
			
		});

	}

	protected void create_view() {}

	protected void create_events() {}

}