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
		//view.show(firstCache);
	}
	
	//-------------------------------------------------------
	// CREAR
	//-------------------------------------------------------
	
	/**
	 * 
	 * @param jt
	 */
	public void create_form_add(DefaultTableModel jt) {
		vShared.add_tab("Create galaxy", new  GalaxyFormCreate(this));
	}
	
	/**
	 * 
	 * @param string
	 * @param readXForm
	 * @param readYForm
	 * @throws Exception
	 */
	public void addGalaxy(String name, int readXForm, int readYForm) throws Exception {
		//Creamos en el objeto en la capa de dominio
		((GalaxyController) controller).addGalaxy(name, readXForm, readYForm);
		
		//Add to table
		((ViewPanel) view).show(name);
	}
	
	//-------------------------------------------------------
	// LISTAR/EDITAR
	//-------------------------------------------------------
	public void getGalaxy() {
		Console.log(((GalaxyController) controller).getAll());
	}
	
	public void getGalaxyByName(String name) {
		try {
			Console.log(((GalaxyController) controller).getByNameToString(name));
			
			//TODO: Coger los planetas de esta galaxia
			
			//TODO: Llamar al formuario pasando los datos
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			vError.show(e.getMessage());
		}
	}
	
	//-------------------------------------------------------
	// ELIMINAR
	//-------------------------------------------------------
	//TODO	
	
	//-------------------------------------------------------
	// TEST - TODO: Revisar
	//-------------------------------------------------------

	
	//ESTO ESTA PROHIBIDO!!! ENTRE CAPAS NO COMPARTES OBJETOS - SOLO DATOS BASICOS
	/*
	public Galaxy getByName(String name){
		try{
			return ((GalaxyController) controller).getByName(name);
		}
		catch(Exception e){
			Console.print("Cannot add galaxy");
		}
		return null;
	}*/

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
