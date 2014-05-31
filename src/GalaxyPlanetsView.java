
public class GalaxyPlanetsView extends ViewController {

	GalaxyPlanetsView(AbstractControllerView c) {
		super(c);
		
		bCreate.setText("Add");
		bImport.setVisible(false);
		bExport.setVisible(false);
	}

	@Override
	protected void create_events() {
		// TODO Auto-generated method stub
		
	}

}
