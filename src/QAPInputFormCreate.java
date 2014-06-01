import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
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
	QAPInputFormCreate(AbstractControllerView c ,int size){
		super(c);
		sizeMatrix = size;
	}
	
	
	protected void create_view() {
		
		//Le pasas el tama–o de la matriz
		sizeMatrix = 200;
		
		
		DistanceMatrix = new DefaultTableModel(sizeMatrix,sizeMatrix);
		
		//genera vectores que enumeran las cabeceras
		DefaultListModel lm = new DefaultListModel();
		String[] header = new String[sizeMatrix];
		for(int i = 0; i < sizeMatrix; ++i){
			header[i] = i+1 + "";
			lm.addElement(header[i]);
		}
		
		DistanceMatrix.setColumnIdentifiers(header);
		tDistanceMatrix = new JTable(DistanceMatrix);
		
		//No cambiar el valor de setRowHeight
		tDistanceMatrix.setRowHeight(17);
		
		js = new JScrollPane(tDistanceMatrix, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		tDistanceMatrix.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		js.setViewportView(tDistanceMatrix);
		
		JList rowHeader = new JList(lm);
		js.setRowHeaderView(rowHeader);

		// Ajusta tama–o de la tabla cambiando el numerito al lado del PREFERRED_SIZE
		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(GroupLayout.Alignment.LEADING) 
				.addComponent(js,javax.swing.GroupLayout.PREFERRED_SIZE,300, Short.MAX_VALUE));

		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
						.addComponent(js, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
				)
		);
	}
	protected void create_events() {
		
		//FORMULARIO: Guardar
		/*bcommit.addActionListener(new ActionListener() 
			public void actionPerformed(ActionEvent event){
				
				try {
					
					//Comprobacion basica de campos
					if(tfposx.getValue() == null || tfposy.getValue() == null || tfname.getText() == null)
						throw new Exception("The values can not be empty");
					
					//Creaci—n del objeto por parte del controlador
					((GalaxyControllerView)controller).addGalaxy(tfname.getText(), (Integer)tfposx.getValue(), (Integer)tfposy.getValue());

					//Add to table - TODO: Orden alfabetico??
					//jt.addRow(new Object[] { tfname.getText() });
					
					//Reinicio campos
					tfname.setText("");
					tfposx.setValue(0);
					tfposy.setValue(0);
					
				} catch (Exception e) {
					controller.show_error(e.getMessage());
				}
			}
		});*/
	}


	@Override
	public void submit_form() throws Exception {
		// TODO Auto-generated method stub
		
	}
}

