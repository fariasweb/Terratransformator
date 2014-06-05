import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;

public class QAPInputFormCreate extends ViewForm {

	private JTable tDistanceMatrix;
	private JScrollPane js;	
	private int sizeMatrix;
	private DefaultTableModel DistanceMatrix;
	private DefaultListModel lm;
	private JLabel label; 

	QAPInputFormCreate(AbstractControllerView c ,int size, String namep){
		super(c);
		crear_vista(size, namep);
	}

	private void crear_vista(int size, String namep){
		sizeMatrix = size;
		label = new JLabel(namep);
		DistanceMatrix = new DefaultTableModel(sizeMatrix,sizeMatrix);
		lm = new DefaultListModel();
		String[] header = new String[sizeMatrix];
		for(int i = 0; i < sizeMatrix; ++i){
			header[i] = i+1 + "";
			lm.addElement(header[i]);
		}

		DistanceMatrix.setColumnIdentifiers(header);
		tDistanceMatrix = new JTable(DistanceMatrix);
		tDistanceMatrix.setRowHeight(17);

		// Scroll
		js = new JScrollPane(tDistanceMatrix, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		tDistanceMatrix.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		js.setViewportView(tDistanceMatrix);

		JList rowHeader = new JList(lm);
		js.setRowHeaderView(rowHeader);
		// Create in Panel
		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING) //,javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALU

						.addComponent(label)
						.addComponent(js,javax.swing.GroupLayout.PREFERRED_SIZE,300, Short.MAX_VALUE)
		);
		layout.setVerticalGroup(layout.createSequentialGroup()
				.addComponent(label)
				.addComponent(js, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)

		);
	}


	protected void create_view() {}
	protected void create_events() {}


	@Override
	public void submit_form() throws Exception {
		// TODO Auto-generated method stub

	}
}