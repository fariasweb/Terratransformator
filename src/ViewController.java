import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Adjustable;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

/**
 * 
 * @author farias
 * 
 */
public abstract class ViewController extends ViewPanel {

	// Elementos
	protected DefaultTableModel tmodel;
	protected JTable table;
	protected JScrollPane scrollPane;

	protected JButton bCreate, bDelete, bImport, bExport;

	/**
	 * 
	 * @param columnNames
	 */
	ViewController(AbstractControllerView c) {
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
		
		table.setCellSelectionEnabled(true);
		table.removeAll();

    	ListSelectionModel cellSelectionModel = table.getSelectionModel();
    	cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// Scroll
		scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);

		// Listen for value changes in the scroll pane's scrollbars
    	AdjustmentListener listener = new MyAdjustmentListener();
    	scrollPane.getHorizontalScrollBar().addAdjustmentListener(listener);
    	scrollPane.getVerticalScrollBar().addAdjustmentListener(listener);

		// Buttons
		bCreate = new JButton("Create");
		bDelete = new JButton("Delete");
		bDelete.setBackground(Color.RED);
		bDelete.setForeground(Color.WHITE);

		bImport = new JButton("Save");
		bExport = new JButton("Load");

		// Create in Panel
		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		
		layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
		
		
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

		//show(controller.getStringToShow());
	}
	
	/**
	 * 
	 * @param s
	 */
	public void show(String s){

		if(s.equals(" ") || s.equals("")){
			Console.print("s es vacio");
			tmodel.setRowCount(0);
			return;
		}

		String[] ss = decode(s);
		
		tmodel.setRowCount(0);
		for (String aux : ss)
			tmodel.addRow(new String[] {aux});
	}
	
	/**
	 * 
	 */
	public void clear() {
		tmodel.setRowCount(0);
	}

	//Private stuff

	private class MyAdjustmentListener implements AdjustmentListener {
		public void adjustmentValueChanged(AdjustmentEvent evt) {

    	Adjustable source = evt.getAdjustable();
    	int minAdj = (int) Math.floor(0.25 * (source.getMaximum() - source.getMinimum()) + source.getMinimum());
    	int maxAdj = (int) Math.floor(0.75 * (source.getMaximum() - source.getMinimum()) + source.getMinimum());
	    int value = evt.getValue();

	    //WARNING!!!!!
	    //NO DESCOMENTAR PQ PETA!!!
	    //MANISH, TE HE DICHO QUE NOOOO!!!!

    	/*if (evt.getValueIsAdjusting()) return;

    	if(value < minAdj){
    		controller.backwards();
    		show(controller.getStringToShow());
    	}
    	else if(value < minAdj){
    		controller.forwards();
    		show(controller.getStringToShow());
    	}*/

	   /*int orient = source.getOrientation();
	    if (orient == Adjustable.HORIZONTAL) {
	      System.out.println("from horizontal scrollbar"); 
	    } else {
	      System.out.println("from vertical scrollbar");
	    }
	    int type = evt.getAdjustmentType();
	    switch (type) {
	    case AdjustmentEvent.UNIT_INCREMENT:
	      System.out.println("Scrollbar was increased by one unit");
	      break;
	    case AdjustmentEvent.UNIT_DECREMENT:
	      System.out.println("Scrollbar was decreased by one unit");
	      break;
	    case AdjustmentEvent.BLOCK_INCREMENT:
	      System.out.println("Scrollbar was increased by one block");
	      break;
	    case AdjustmentEvent.BLOCK_DECREMENT:
	      System.out.println("Scrollbar was decreased by one block");
	      break;
	    case AdjustmentEvent.TRACK:
	      System.out.println("The knob on the scrollbar was dragged");
	      break;
	    }*/
	  }
	}

}
