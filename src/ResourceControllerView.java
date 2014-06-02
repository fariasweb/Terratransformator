/**
 * 
 * @author farias
 * 
 */
public class ResourceControllerView extends AbstractControllerView {

	public ResourceDetails view_detail;

	/**
	 * 
	 * @param pc
	 */
	ResourceControllerView(AbstractController pc, ViewTabbedPane vs,
			ViewNotification ve) {
		super(vs, ve);

		// -------------------------------------------------------
		// CONTROLADOR DE DOMINIO
		// -------------------------------------------------------
		controller = new ResourceController((PacketController) pc);
		// -------------------------------------------------------
		// Vistas
		// -------------------------------------------------------
		view = new ResourceView(this);
		view_detail = null;
	}

	// -------------------------------------------------------
	// CREAR
	// -------------------------------------------------------

	/**
		 * 
		 */
	public void create_form_add() {
		vShared.add_once_tab("Create recourse", new ResourceCreate(this));
	}

	/**
	 * 
	 * @param string
	 * @param readXForm
	 * @param readYForm
	 * @throws Exception
	 */
	public void save(String originalName, String name, String type) throws Exception {

		if (originalName == null) { // CREACION
			// Creamos en el objeto en la capa de dominio
			((ResourceController) controller).addResource(name, type);
			// Mensaje de notificacion
			vError.success("The recourse " + name + " has been created");

			// Add to table - TODO: CACHE

			Console.print("CREATING Resource!");
			refresh();
			((ViewController) view).show(getStringToShow());

		} else { // ACTUALIZACION

			// Comprobamos el nombre
			if (!originalName.equals(name)) {
				((ResourceController) controller).updateResourceName(originalName,
						name);
			}

			//Actualizar tipo
			((ResourceController) controller).updateResourceType(name, type);
			
			// Mensaje de notificacion
			vError.success("The recourse " + name + " has been updated");

			// Table - TODO: Cache TODO: Eliminar esto
			Console.print("UPDATING Resource!");
			refresh();
			((ViewController) view).show(getStringToShow());
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
		view_detail = new ResourceDetails(this, name);
		vShared.add_once_tab("Resource details", view_detail);
	}

	/**
	 * TODO: Cache
	 */
	public void get() {
		Console.log(((ResourceController) controller).getAll());
	}

	/**
	 * 
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public String getByName(String name) throws Exception {
		return ((ResourceController) controller).getByNameToString(name);
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
		// Eliminar galaxia
		((ResourceController) controller).removeResource(name);

		// Eliminar de la tabla - TODO
		Console.print("DELETING Resource!");
		refresh();
		((ViewController) view).show(getStringToShow());
		
		// Mensaje de notificacion
		vError.success("The recourse " + name + " has been deleted");

		vShared.remove_all_tabs();

	}
}
