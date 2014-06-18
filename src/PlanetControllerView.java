/**
 * 
 * @author farias
 * 
 */
public class PlanetControllerView extends AbstractControllerView {

	public PlanetDetails view_detail;

	/**
	 * 
	 * @param pc
	 */
	PlanetControllerView(ViewTabbedPane vs,
			ViewNotification ve) {
		super(vs, ve);

		// -------------------------------------------------------
		// CONTROLADOR DE DOMINIO
		// -------------------------------------------------------
		controller = new PlanetController();
		// -------------------------------------------------------
		// Vistas
		// -------------------------------------------------------
		view = new PlanetView(this);
		view_detail = null;
	}

	// -------------------------------------------------------
	// CREAR
	// -------------------------------------------------------

	/**
		 * 
		 */
	public void create_form_add() {
		vShared.add_once_tab("Create planet", new PlanetCreate(this));
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
			((PlanetController) controller).addPlanet(name, readXForm,
					readYForm);
			// Mensaje de notificacion
			//vError.success("The planet " + name + " has been created");

			// Add to table - TODO: CACHE

			Console.print("CREATING Planet!");
			refresh();
			((ViewController) view).show(getStringToShow());

		} else { // ACTUALIZACION

			// Comprobamos el nombre
			if (!originalName.equals(name)) {
				((PlanetController) controller).updatePlanetName(originalName,
						name);
			}

			// Actaulizamos los datos adjuntos
			((PlanetController) controller).updatePlanetPosition(name, readXForm,
					readYForm);

			// Mensaje de notificacion
			//vError.success("The planet " + name + " has been updated");

			// Table - TODO: Cache TODO: Eliminar esto
			Console.print("UPDATING Planet!");
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
		view_detail = new PlanetDetails(this, name);
		vShared.add_once_tab("Planet details", view_detail);
	}

	/**
	 * TODO: Cache
	 */
	public void get() {
		Console.log(((PlanetController) controller).getAll());
	}

	/**
	 * 
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public String getByName(String name) throws Exception {
		return ((PlanetController) controller).getByNameToString(name);
	}
	
	/**
	 * 
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public String getGalaxy(String name) throws Exception {
		return ((PlanetController) controller).getGalaxyFromPlanet(name);
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
		((PlanetController) controller).removePlanet(name);

		// Eliminar de la tabla - TODO
		Console.print("DELETING Planet!");
		refresh();
		((ViewController) view).show(getStringToShow());
		
		// Mensaje de notificacion
		//vError.success("The planet " + name + " has been deleted");

		vShared.remove_all_tabs();

	}
}
