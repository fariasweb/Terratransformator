import javax.swing.JButton;


public class QAPInputDetail extends View3Col{
	QAPInputDetail(AbstractControllerView c, int size) {
		super((QAPInputControllerView)c);
	}

	
	protected void create_view() {
		QAPInputFormCreate matrixDistance = new QAPInputFormCreate(controller,80,"Distance Matrix:");
		add_left(matrixDistance);
		QAPInputFormCreate matrixFlow = new QAPInputFormCreate(controller,80, "Flow Matrix");
		add_center(matrixFlow);
		
		JButton jb = new JButton("Run Algorithm!");
		add_right(jb);
		
	}


	protected void create_events() {
		
	}

}
