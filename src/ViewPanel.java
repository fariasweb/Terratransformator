import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

/**
 * 
 * @author farias
 * 
 */
public abstract class ViewPanel extends AbstractViewer {

	// Elementos
	protected DefaultTableModel tmodel;
	protected JTable table;
	protected JScrollPane scrollPane;
	//Para testear; luego cambiamos por el panel de operaciones
	protected ViewTest vtest;

	protected JButton bCreate, bDelete, bImport, bExport;

	/**
	 * 
	 * @param columnNames
	 */
	ViewPanel(AbstractControllerView c) {
		super(c);
	}

	/**
	 * 
	 */
	protected void create_view() {
		// Table
		tmodel = new DefaultTableModel(new Object[][] {},
				new String[] { "Name" });
		table = new JTable(tmodel);
		vtest = new ViewTest();
		vtest.create_view();

		table.setCellSelectionEnabled(true);
    	ListSelectionModel cellSelectionModel = table.getSelectionModel();
    	cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    	cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
      		public void valueChanged(ListSelectionEvent e) {

      			//Sin este if se activan dos eventos (al clickar y soltar click)
      			if (!e.getValueIsAdjusting() && !cellSelectionModel.isSelectionEmpty()){
	        		int selectedRow = table.getSelectedRow();
        			String selectedData = (String) table.getValueAt(selectedRow, 0);
        			String info = controller.getEntityByName(selectedData);
        			controller.showOp(info);
        			System.out.println("Selected: " + selectedData);
        		}
      		}
      	});

		// Scroll
		scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);

		// Buttons
		bCreate = new JButton("Crear");
		bDelete = new JButton("Eliminar");
		// bDelete.setBackground(Color.BLUE);
		// bDelete.setForeground(Color.GRAY);

		bImport = new JButton("Guardar");
		bExport = new JButton("Cargar");

		// Create in Panel
		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGroup(
										layout.createSequentialGroup()
												.addComponent(bCreate))
								.addGroup(
										layout.createSequentialGroup()
												.addComponent(bImport)
												.addComponent(bExport))
								.addGroup(
										layout.createSequentialGroup()
												.addComponent(bDelete)))
				.addComponent(scrollPane));

		layout.setVerticalGroup(layout.createParallelGroup(
				GroupLayout.Alignment.LEADING)
				.addGroup(
						GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										layout.createParallelGroup(
												GroupLayout.Alignment.BASELINE)
												.addComponent(bCreate)
												.addComponent(bImport)
												.addComponent(bExport)
												.addComponent(bDelete))
								.addPreferredGap(
										LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(scrollPane
										//,GroupLayout.DEFAULT_SIZE, 690,
										//Short.MAX_VALUE
										)));

	}
	
	/**
	 * 
	 * @param s
	 */
	public void show(String s){

		String[] ss = s.split(" ");
		//Chivato
		for (int i = 0; i < ss.length; ++i) {
			Console.print(ss[i]);
			tmodel.addRow(new String[] {ss[i]});
		}
		//tmodel.addRow(ss);
	}
}
