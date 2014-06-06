import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class QAPInputDetail extends View3Col{
	private JButton jb; 
	private QAPInput input;
	private int sizeMatrix;
	private double[][] distanceM;
	private double[][] flowM;
	

	QAPInputDetail(QAPInputControllerView c) {
		super((QAPInputControllerView)c);
		Console.print("PASO 1");
		distanceM = c.getDistanceMatrix();
		flowM = c.getFlowMatrix();
		crear_vista();
		Console.print("PASO Final");
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
		
		Console.print("PASO 2");
		QAPInputFormCreate matrixDistance = new QAPInputFormCreate(controller,"Distance Matrix:", distanceM);
		add_left(matrixDistance);
		Console.print("PASO 3");
		QAPInputFormCreate matrixFlow = new QAPInputFormCreate(controller, "Flow Matrix", flowM);
		add_center(matrixFlow);
		Console.print("PASO 4");
		jb = new JButton("Run Algorithm!");
		add_right(jb);
		
		jb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				try{
					AlgorithmThread tAlg = new AlgorithmThread((QAPInputControllerView)controller);
					Thread t1 = new Thread(tAlg,"Algorithm THREAD1");
					t1.start();
				}
				catch(Exception ee){
					Console.print("E: Running QAP");
				}
				
				
			}
		});

	}

	protected void create_view() {}

	protected void create_events() {

	}

}