import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ResourceView extends ViewController {
	private JFrame jframe;
	private JFileChooser jfile;
	private String path; 
	
	/**
	 * 
	 * @param c
	 */
	ResourceView(AbstractControllerView c) {
		super(c);
	}
	
	public void createFrame(String name){
		FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
		jfile = new JFileChooser();
		jfile.setFileFilter(filter);
		
		JPanel jpanel1 = new JPanel();
		jpanel1.add(jfile);
		jfile.setDialogTitle(name);
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
	
	/**
	 * 
	 */
	protected void create_events() {
		// Eventos
		//Boton de crear
		bCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// display/center the jdialog when the button is pressed
				((ResourceControllerView)controller).create_form_add();
			}
		});
		
		// Boton de guardar
		bImport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				createFrame("Save");
			}
		});
		
		//Boton de cargar
		bExport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				createFrame("Load");
			}
		});
		
		//Boton de eliminar
		bDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				
				int selectedRow = table.getSelectedRow();
				if (selectedRow < 0) controller.show_error("You must select a resource before delete");
				else {
        			String selectedData = (String) table.getValueAt(selectedRow, 0);
        			try {
						((ResourceControllerView) controller).delete(selectedData);
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
        			((ResourceControllerView) controller).create_form_view(selectedData);
        		}
      		}
      	});
		
	}
}
