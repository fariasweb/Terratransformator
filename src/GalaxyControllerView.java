import java.util.Stack;

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
	GalaxyControllerView(PlanetController pc, ViewOperation vs, ViewError ve) {
		super(vs, ve);
		
		//-------------------------------------------------------
		// CONTROLADOR DE DOMINIO
		//-------------------------------------------------------
		controller = new GalaxyController(pc);
		
		//TEST - TODO: Eliminar
		try {
			((GalaxyController) controller).addGalaxy("Fran", 1, 1);
			((GalaxyController) controller).addGalaxy("Fran2", 2, 1);
			((GalaxyController) controller).addGalaxy("Fran3", 3, 1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//-------------------------------------------------------
		// Vistas
		//-------------------------------------------------------
		view = new GalaxyView(this);

		//-------------------------------------------------------
		// CACHE - TODO revisar
		//-------------------------------------------------------
		firstCache = new String();
		secondCache = new String();
		references = new Stack<Entity>();
		//Tomamos los primeros de dominio y los mostramos
		Galaxy g = null;
		//firstCache = controller.encodeStringPresentation(g, CACHE_SIZE);

		//Chivato
		//Console.print(firstCache);
		//view.show(firstCache);
	}
	
	//-------------------------------------------------------
	// CREAR
	//-------------------------------------------------------
	
	public void create_form_add() {
		vShared.add_tab("Create galaxy", new GalaxyFormCreate());
	}
	
	//-------------------------------------------------------
	// LISTAR/EDITAR
	//-------------------------------------------------------
	//TODO
	
	//-------------------------------------------------------
	// ELIMINAR
	//-------------------------------------------------------
	//TODO	
	
	//-------------------------------------------------------
	// TEST - TODO: Revisar
	//-------------------------------------------------------
	public void getGalaxy() {
		Console.log(((GalaxyController) controller).getAll());
	}

	//Una vez tenido un formulario con textfields se cambia nombre atributos
	public void addGalaxy(String string, int readXForm, int readYForm) {
		try{
			((GalaxyController) controller).addGalaxy(string, readXForm, readYForm);
		}
		catch(Exception e){
			Console.print("Cannot add galaxy");
		}
	}
	public Galaxy getByName(String name){
		try{
			return ((GalaxyController) controller).getByName(name);
		}
		catch(Exception e){
			Console.print("Cannot add galaxy");
		}
		return null;
	}

}
