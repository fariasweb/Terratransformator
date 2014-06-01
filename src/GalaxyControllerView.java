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
	GalaxyControllerView(PlanetController pc, ViewTabbedPane vs,
			ViewNotification ve) {
		super(vs, ve);

		// -------------------------------------------------------
		// CONTROLADOR DE DOMINIO
		// -------------------------------------------------------
		controller = new GalaxyController(pc);

		// -------------------------------------------------------
		// Vistas
		// -------------------------------------------------------
		view = new GalaxyView(this);

		// -------------------------------------------------------
		// CACHE - TODO revisar
		// -------------------------------------------------------
		firstCache = new String();
		secondCache = new String();

		try {
			// Tomamos los primeros de dominio y los mostramos
			Galaxy g = null;
			firstCache = controller.encodeStringPresentation(g, CACHE_SIZE);
		} catch (Exception e) {
			Console.print(e.getMessage());
		}

		// Chivato
		Console.print(firstCache);
		// view.show(firstCache);
	}

	// -------------------------------------------------------
	// CREAR
	// -------------------------------------------------------

	/**
	 * 
	 */
	public void create_form_add() {
		vShared.add_once_tab("Create galaxy", new GalaxyCreate(this));
	}

	/**
	 * 
	 * @param string
	 * @param readXForm
	 * @param readYForm
	 * @throws Exception
	 */
	public void save(String originalName, String name, int readXForm,
			int readYForm) throws Exception {

		if (originalName == null) { // CREACION
			// Creamos en el objeto en la capa de dominio
			((GalaxyController) controller).addGalaxy(name, readXForm,
					readYForm);
			// Mensaje de notificacion
			vError.success("The galaxy " + name + " has been created");

			// Add to table - TODO: CACHE
			((ViewController) view).show(name);

		} else { // ACTUALIZACION

			// Comprobamos el nombre
			if (!originalName.equals(name)) {
				((GalaxyController) controller).updateGalaxyName(originalName,
						name);
			}

			// Actaulizamos los datos adjuntos
			((GalaxyController) controller).updateGalaxy(name, readXForm,
					readYForm);

			// Mensaje de notificacion
			vError.success("The galaxy " + name + " has been updated");

			// Table - TODO: Cache TODO: Eliminar esto
			((ViewController) view).show(name);
		}
	}

	// -------------------------------------------------------
	// LISTAR/EDITAR
	// -------------------------------------------------------

	/**
	 * 
	 * @param name
	 */
	public void create_form_view(String name) {
		vShared.add_once_tab("Galaxy details", new GalaxyDetails(this, name));
	}

	/**
	 * 
	 */
	public void get() {
		Console.log(((GalaxyController) controller).getAll());
	}

	/**
	 * 
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public String getByName(String name) throws Exception {
		return ((GalaxyController) controller).getByNameToString(name);
	}

	// -------------------------------------------------------
	// ELIMINAR
	// -------------------------------------------------------
	/**
	 * 
	 * @param name
	 * @throws Exception 
	 */
	public void delete(String name) throws Exception {
		//Eliminar galaxia
		((GalaxyController) controller).removeGalaxy(name);
		
		//Eliminar de la tabla - TODO
		
		
	}

	// -------------------------------------------------------
	// TEST - TODO: Revisar
	// -------------------------------------------------------

	// ESTO ESTA PROHIBIDO!!! ENTRE CAPAS NO COMPARTES OBJETOS - SOLO DATOS
	// BASICOS
	/*
	 * public Galaxy getByName(String name){ try{ return ((GalaxyController)
	 * controller).getByName(name); } catch(Exception e){
	 * Console.print("Cannot add galaxy"); } return null; }
	 */

	public String getEntityByName(String name) {
		try {
			return controller.getByNameToString(name);
		} catch (Exception e) {
			Console.print("Cannot find galaxy");
		}
		return null;
	}

	public void updateEntityNameByName(String oldName, String newName) {
		try {
			controller.updateEntityNameByName(oldName, newName);
		} catch (Exception e) {
			Console.print("Cannot find galaxy");
		}
	}

}
