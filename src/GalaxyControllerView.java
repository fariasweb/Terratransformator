import java.util.Stack;

import javax.swing.table.DefaultTableModel;

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

		try{
		//Tomamos los primeros de dominio y los mostramos
		Galaxy g = null;
		firstCache = controller.encodeStringPresentation(g, CACHE_SIZE);
		}
		catch(Exception e){Console.print(e.getMessage());}

		//Chivato
		Console.print(firstCache);
		view.show(firstCache);
	}
	
	//-------------------------------------------------------
	// CREAR
	//-------------------------------------------------------
	
	public void create_form_add(DefaultTableModel jt) {
		vShared.add_tab("Create galaxy", new  GalaxyFormCreate(jt,this));
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

	public String getEntityByName(String name){
		try{ return controller.getByNameToString(name);}
		catch(Exception e){ Console.print("Cannot find galaxy"); }
		return null;
	}

	public void updateEntityNameByName(String oldName, String newName){
		try{ controller.updateEntityNameByName(oldName, newName);}
		catch(Exception e){ Console.print("Cannot find galaxy"); }
	}

}
