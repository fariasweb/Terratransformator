import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GalaxyPlanetsView extends ViewController {

	private String GalaxyName;
	
	GalaxyPlanetsView(AbstractControllerView c) {
		super(c);
		
		bCreate.setText("Add");
		bImport.setVisible(false);
		bExport.setVisible(false);
	}

	@Override
	protected void create_events() {
		
		//Add
		bCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event){
				//Crear el formulario de add planetaa galaxia
				((GalaxyControllerView) controller).create_form_planet(GalaxyName);
			}
		});
		
		//remove
		bDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event){
				//Crear el formulario de add planetaa galaxia
				int selectedRow = table.getSelectedRow();
				if (selectedRow < 0) controller.show_error("You must select a planet before delete");
				else {
        			String selectedData = (String) table.getValueAt(selectedRow, 0);
        			try {
						((GalaxyControllerView) controller).delete_planet(GalaxyName, selectedData);
					} catch (Exception e1) {
						controller.show_error(e1.getMessage());
					}

				}
			}
		});
		
	}
	
	/**
	 * Asigna el nombre de la galaxia que gestionra los planetas
	 * @param e
	 */
	public void setGalaxyName(String e) {
		GalaxyName = e;
	}
	
	

}
