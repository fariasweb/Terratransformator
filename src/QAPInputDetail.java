import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class QAPInputDetail extends View3Col{
	private JButton jb; 
	private QAPInput input;
	private int sizeMatrix;
	private String[][] distanceM;
	private String[][] flowM;
	

	QAPInputDetail(QAPInputControllerView c) {
		super((QAPInputControllerView)c);
		
		distanceM = transformMatrix(c.getDistanceMatrix());
		flowM = transformMatrix(c.getFlowMatrix());
		crear_vista();
	}

	private String[][] transformMatrix(double[][] distanceMatrix){
		String[][] aux = new String[distanceMatrix.length][distanceMatrix[0].length];
		for(int i = 0; i < distanceMatrix.length; ++i){
			for(int j = 0; j < distanceMatrix[0].length; ++j){
				aux[i][j] = distanceMatrix + "";
			}
		}
		return aux;
	}
	
	private void crear_vista(){

		
		QAPInputFormCreate matrixDistance = new QAPInputFormCreate(controller,"Distance Matrix:", distanceM);
		add_left(matrixDistance);
		QAPInputFormCreate matrixFlow = new QAPInputFormCreate(controller, "Flow Matrix", flowM);
		add_center(matrixFlow);

		jb = new JButton("Run Algorithm!");
		add_right(jb);

	}

	protected void create_view() {}

	protected void create_events() {
		/*jb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				
			}
		});*/

	}

}