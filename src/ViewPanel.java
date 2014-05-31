<<<<<<< HEAD
import javax.swing.JButton;
=======
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Adjustable;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
>>>>>>> f5355a3dae6f796adcb1e46d8752e1fd1d8ec730


public abstract class ViewPanel extends AbstractViewer {
	
	ViewPanel(AbstractControllerView c) {
		super(c);
<<<<<<< HEAD
		
		//Creacion de elementos y eventos -- Podrian estar vacias
		create_view();
		create_events();
=======
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
		if (ss.length > 0) {
			Console.print(ss[0]);
			tmodel.addRow(new String[] {ss[0]});
		}
>>>>>>> f5355a3dae6f796adcb1e46d8752e1fd1d8ec730
	}



	//Private stuff

	private class MyAdjustmentListener implements AdjustmentListener {
		public void adjustmentValueChanged(AdjustmentEvent evt) {

    	Adjustable source = evt.getAdjustable();
    	int minAdj = (int) Math.floor(0.25 * (source.getMaximum() - source.getMinimum()) + source.getMinimum());
    	int maxAdj = (int) Math.floor(0.75 * (source.getMaximum() - source.getMinimum()) + source.getMinimum());
	    int value = evt.getValue();

    	if (evt.getValueIsAdjusting()) return;

    	if(value < minAdj){
    		controller.backwards();
    		show(controller.getStringToShow());
    	}
    	else if(value < minAdj){
    		controller.forwards();
    		show(controller.getStringToShow());
    	}

	    int orient = source.getOrientation();
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
	    }
	  }
	}
}
