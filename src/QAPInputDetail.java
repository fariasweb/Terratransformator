import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class QAPInputDetail extends View3Col{
	private JButton jb; 
	private QAPInput input;
	private int sizeMatrix;
	private double[][] distanceM;
	private double[][] flowM;
	private QAPInputFormCreate formDistance;
	private QAPInputFormCreate formFlow;
	private boolean control = false;
	
	QAPInputDetail(AbstractControllerView c) {
		super((QAPInputControllerView)c);
	
		distanceM = ((QAPInputControllerView)c).getDistanceMatrix();
		flowM = ((QAPInputControllerView)c).getFlowMatrix();
		crear_vista();
	
	}

	/*private String[][] transformMatrix(double[][] distanceMatrix){
		String[][] aux = new String[distanceMatrix.length][distanceMatrix[0].length];
		for(int i = 0; i < distanceMatrix.length; ++i){
			for(int j = 0; j < distanceMatrix[0].length; ++j){
				aux[i][j] = distanceMatrix + "";
			}
		}
		return aux;
	}*/
	
	
	
	private void crear_vista(){
		
		formDistance = new QAPInputFormCreate(controller,"Distance Matrix:", distanceM);
		add_left(formDistance);
		formFlow = new QAPInputFormCreate(controller, "Flow Matrix", flowM);
		add_center(formFlow);
		jb = new JButton("Run Algorithm!");
		add_right(jb);
		
		jb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				try{
					if(!((QAPInputControllerView)controller).is_running()){

						//Activamos el control de thread
						((QAPInputControllerView)controller).set_run();
						
						//Generamot el thread
						formDistance.checkSetMatrix();
						formFlow.checkSetMatrix();
						AlgorithmThread tAlg = new AlgorithmThread((QAPInputControllerView)controller);
						Thread t1 = new Thread(tAlg,"Algorithm THREAD1");
						t1.start();
						
					} else {
						controller.vError.error("The algorithm is running. Wait a moment!");
					}
				}
				catch(Exception ee){
					controller.vError.error("Introduce Numbers in the Tables!");
				}
				
				
			}
		});

	}

	protected void create_view() {}

	protected void create_events() {}

}