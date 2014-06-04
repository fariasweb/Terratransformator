import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class QAPInputDetail extends View3Col{
	private JButton jb; 
	private QAPInput input;
	private int sizeMatrix;
	
	QAPInputDetail(AbstractControllerView c, int size) {
		super((QAPInputControllerView)c);
		crear_vista(size);
	}

	private void crear_vista(int size){
		
		sizeMatrix = size;
		QAPInputFormCreate matrixDistance = new QAPInputFormCreate(controller,sizeMatrix,"Distance Matrix:");
		add_left(matrixDistance);
		QAPInputFormCreate matrixFlow = new QAPInputFormCreate(controller,sizeMatrix, "Flow Matrix");
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
