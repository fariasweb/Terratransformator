import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PacketResourceView extends ViewController {

	private String Name;

	PacketResourceView(AbstractControllerView c) {
		super(c);

		bCreate.setText("Add");
		bImport.setVisible(false);
		bExport.setVisible(false);
		
		//Add column to table
		tmodel.addColumn("Quantity");
		
		
	}

	@Override
	protected void create_events() {

		// Add
		bCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				// Crear el formulario de add planetaa galaxia
				((PacketControllerView) controller).create_form_resource(Name);
			}
		});

		// Remove
		bDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				// Crear el formulario de add planetaa galaxia
				int selectedRow = table.getSelectedRow();
				if (selectedRow < 0)
					controller
							.show_error("You must select a resource before delete");
				else {
					String selectedData = (String) table.getValueAt(
							selectedRow, 0);
					try {
						((PacketControllerView) controller).delete_resource(Name,
								selectedData);
					} catch (Exception e1) {
						controller.show_error(e1.getMessage());
					}

				}
			}
		});

	}

	/**
	 * Asigna el nombre del paquete que gestiona
	 * 
	 * @param e
	 */
	public void setName(String e) {
		Name = e;
	}
	
	
	/**
	 * 
	 * @param s
	 */
	@Override
	public void show(String[][] ss){

		if(ss == null || ss.length == 0){
			tmodel.setRowCount(0);
			return;
		}

		tmodel.setRowCount(0);
		String[] aux = null;
		
		for (String[] s : ss) {
			if (s.length >= 3)
				tmodel.addRow(new String[] {s[1], s[2]});
		}
	}

}
