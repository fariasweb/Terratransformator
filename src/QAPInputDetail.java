import javax.swing.JButton;


public class QAPInputDetail extends View3Col{
	
	QAPInputDetail(AbstractControllerView c, int size) {
		super(c);
	}

	
	protected void create_view() {
		QAPInputFormCreate matrixDistance = new QAPInputFormCreate(controller,80);
		add_left(matrixDistance);
		QAPInputFormCreate matrixFlow = new QAPInputFormCreate(controller,80);
		add_center(matrixFlow);
		
		JButton jb = new JButton("Run Algorithm!");
		add_right(jb);
	}


	protected void create_events() {
		
	}

}
