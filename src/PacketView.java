import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * 
 * @author farias
 * 
 */
public class PacketView extends ViewController {

	/**
	 * 
	 * @param c
	 */
	PacketView(PacketControllerView c) { //He cambiado por esto en vez de AbstractControllerView
		super(c);
	}

	/**
	 * 
	 */
	protected void create_events() {
		// Eventos
		//Boton de crear
		bCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// display/center the jdialog when the button is pressed
				((PacketControllerView)controller).create_form_add();
			}
		});
		
		// Boton de guardar
		bImport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				Console.log("you have pressed the SAVE button!");
				controller.save("./save/PacketControler.txt", false);
			}
		});
		
		//Boton de cargar
		bExport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				Console.log("you have pressed the LOAD button!");
				controller.load("./save/PacketControler.txt");
			}
		});
		
		//Boton de eliminar
		bDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				
				int selectedRow = table.getSelectedRow();
				if (selectedRow < 0) controller.show_error("You must select a Packet before delete");
				else {
        			String selectedData = (String) table.getValueAt(selectedRow, 0);
        			try {
						((PacketControllerView) controller).delete(selectedData);
					} catch (Exception e1) {
						controller.show_error(e1.getMessage());
					}

				}
			}
		});
		
		//Tabla
		final ListSelectionModel cellSelectionModel = table.getSelectionModel();
    	cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
      		public void valueChanged(ListSelectionEvent e) {

      			//Sin este if se activan dos eventos (al clickar y soltar click)
      			if (!e.getValueIsAdjusting() && !cellSelectionModel.isSelectionEmpty()){
	        		int selectedRow = table.getSelectedRow();
        			String selectedData = (String) table.getValueAt(selectedRow, 0);
        			//String info = controller.getEntityByName(selectedData);
        			//controller.showOp(info);
        			
        			//Llamada al controlador
        			System.out.println("Selected: " + selectedData);
        			((PacketControllerView) controller).create_form_view(selectedData);
        		}
      		}
      	});
		
	}

	/*protected void create_events(){
		

	}*/

}
