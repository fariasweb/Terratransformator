/**
 * 
 * @author farias
 *
 */
public class PlanetControllerView extends AbstractControllerView {

	
	/**
	 * 
	 * @param pc
	 */
	PlanetControllerView(PlanetController pc, ViewOperation vs, ViewError ve) {
		super(vs, ve);
		
		//Creamos el enlace a capa de dominio
		controller = pc;
		//Creamos la vista
		view = new PlanetView(this);
	}

	public String getEntityByName(String name){
		try{ return controller.getByNameToString(name);}
		catch(Exception e){ Console.print("Cannot find planet"); }
		return null;
	}
}
