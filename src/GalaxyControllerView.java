import java.util.Stack;

import javax.swing.table.DefaultTableModel;

/**
 * 
 * @author farias
 * 
 */
public class GalaxyControllerView extends AbstractControllerView {

	public GalaxyDetails view_detail;
	
	/**
	 * 
	 * @param pc
	 */
	GalaxyControllerView(AbstractController pc, ViewTabbedPane vs,ViewNotification ve) {
		super(vs, ve);

		// -------------------------------------------------------
		// CONTROLADOR DE DOMINIO
		// -------------------------------------------------------
		controller = new GalaxyController((PlanetController) pc);

		// -------------------------------------------------------
		// Vistas
		// -------------------------------------------------------
		view = new GalaxyView(this);
		view_detail = null;

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
			//vError.success("The galaxy " + name + " has been created");

			// Add to table - TODO: CACHE


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
			//vError.success("The galaxy " + name + " has been updated");

			// Table - TODO: Cache TODO: Eliminar esto
			if(needsRefreshing(name)) refresh();
		}
		reloadTable();
	}
	
	/**
	 * 
	 * @param num
	 * @throws Exception 
	 */
	public void addPlanet(String galaxy, String planet) throws Exception {
		//Asignamos el planeta a la galxia
		((GalaxyController) controller).addPlanet(galaxy,planet);
		
		//Refrescamos tabla
		view_detail.update_planet_list(galaxy);
		
		//Cerramos pestana
		vShared.remove_tab(1);
		
	}

	// -------------------------------------------------------
	// LISTAR/EDITAR
	// -------------------------------------------------------

	/**
	 * 
	 * @param name
	 */
	public void create_form_view(String name) {
		view_detail = new GalaxyDetails(this, name);
		vShared.add_once_tab("Galaxy details", view_detail);
	}
	
	/**
	 * 
	 */
	public void create_form_planet(String name) {
		vShared.add_tab_pos("Add planet", new GalaxyPlanetsDetails(this, name), 1);
		vShared.change_tab(1);
	}

	/**
	 * TODO: Cache
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
	
	/**
	 * 
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public String getPlanets(String name) throws Exception {
		return ((GalaxyController) controller).getPlanetsFromGalaxy(name);

	}
	
	/**
	 * 
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public String getPlanetWithoutGalaxy(String name) throws Exception {
		return ((GalaxyController) controller).getPlanetsToGalaxy(name);
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
		reloadTable();
		
		// Mensaje de notificacion
		//vError.success("The galaxy " + name + " has been deleted");


		vShared.remove_all_tabs();
	}
	
	/**
	 * 
	 * @param galaxy
	 * @param planet
	 * @throws Exception 
	 */
	public void delete_planet(String galaxy, String planet) throws Exception {
		
		//Eliminar el planeta
		((GalaxyController) controller).removePlanetFromGalaxy(galaxy, planet);
	
		//Refrescamos tabla
		view_detail.update_planet_list(galaxy);
				
		//Cerramos pestana
		vShared.remove_tab(1);
	}

	/**
	 * 
	 * @return
	 */
	public GalaxyController getGalaxyController(){
		return (GalaxyController) controller;
	}
}
