import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PacketResourceView extends ViewController {

	PacketResourceView(AbstractControllerView c) {
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
				((PacketControllerView) controller).create_form_resource();
			}
		});
		
	}
	
	

}
