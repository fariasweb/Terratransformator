import java.awt.Component;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Adjustable;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import javax.swing.BoundedRangeModel;
import javax.swing.ScrollPaneConstants;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.filechooser.FileNameExtensionFilter;

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
	
	protected JFrame jframe;
	protected JFileChooser jfile;
	protected String path; 
	protected boolean is_init = false;

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
		tmodel = new DefaultTableModel(new Object[][] {}, new String[] { "Name" })
		{
		    public boolean isCellEditable(int row, int column)
		    {
		      return false;//This causes all cells to be not editable
		    }
		};
		 
		table = new JTable(tmodel);
		
		table.setCellSelectionEnabled(true);
		table.removeAll();

    	ListSelectionModel cellSelectionModel = table.getSelectionModel();
    	cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// Scroll
		scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.getVerticalScrollBar().setMaximum(50);

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
	 * @param s
	 */
	public void show(String[][] ss){

		if(ss == null || ss.length == 0){
			tmodel.setRowCount(0);
			return;
		}

		tmodel.setRowCount(0);
		String[] aux = null;
		
		for (String[] s : ss)
			tmodel.addRow(new String[] {s[0]});
	}
	
	/**
	 * 
	 */
	public void clear() {
		tmodel.setRowCount(0);
	}
	
	/**
	 * 
	 * @param name
	 */
	public void createFrame(String name){
		
		FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
		jfile = new JFileChooser();
		jfile.setFileFilter(filter);
		jfile.setDialogTitle(name);
		JPanel jpanel1 = new JPanel();
		jpanel1.add(jfile);
		jfile.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int result = jfile.showSaveDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {
		    System.out.println("Accept was selected");
		    path = jfile.getSelectedFile().getAbsolutePath();
		    if(name == "Load")controller.load(path);
		    else controller.save(path,false);
		} else if (result == JFileChooser.CANCEL_OPTION) {
		    System.out.println("Cancel was selected");
		}
		
	}

	public void set_scroll(){
		
		// Listen for value changes in the scroll pane's scrollbars
    	scrollPane.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener(){

    		public void adjustmentValueChanged(AdjustmentEvent evt) {

	    	Adjustable source = evt.getAdjustable();

	    	int extent = scrollPane.getVerticalScrollBar().getModel().getExtent();
	    	int min = scrollPane.getVerticalScrollBar().getMinimum(); 
	    	int max = scrollPane.getVerticalScrollBar().getMaximum();
	    	int value = scrollPane.getVerticalScrollBar().getValue()+extent;


	    	if(evt.getValueIsAdjusting()) return;
	    	if(extent == 145){ controller.reloadTable(); is_init = true; }
	    	if(!is_init) return;
	    	if(extent != 141) return;


	    	if(value == extent){
	    		controller.backwards();
	    		show(controller.getStringToShow());
	    	}
	    	else if(value == max){
	    		controller.forwards();
	    		show(controller.getStringToShow());
	    	}

		   int orient = source.getOrientation();
		    if (orient == Adjustable.VERTICAL) {
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
		    }
		  }
    	});
	}

}
