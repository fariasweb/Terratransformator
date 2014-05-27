/**
 * 
 * @author farias
 *
 */
public class GalaxyControllerView extends AbstractControllerView {
	
	/**
	 * 
	 * @param pc
	 */
	GalaxyControllerView(PlanetController pc) {
		//Creamos el enlace a capa de dominio
		controller = new GalaxyController(pc);
		try {
			((GalaxyController) controller).addGalaxy("Fran", 1, 1);
			((GalaxyController) controller).addGalaxy("Fran2", 2, 1);
			((GalaxyController) controller).addGalaxy("Fran3", 3, 1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Creamos la vista
		view = new GalaxyView(this);
	}
	
	
	/**
	 * 
	 */
	public void getGalaxy() {
		Console.log(((GalaxyController) controller).getAll());
	}
}
