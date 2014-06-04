import java.util.Stack;

import javax.swing.table.DefaultTableModel;

/**
 * 
 * @author farias
 * 
 */
public class PacketControllerView extends AbstractControllerView {

	public PacketDetails view_detail;
	
	/**
	 * 
	 * @param pc
	 */
	PacketControllerView(ViewTabbedPane vs,ViewNotification ve) {
		super(vs, ve);

		// -------------------------------------------------------
		// CONTROLADOR DE DOMINIO
		// -------------------------------------------------------
		controller = new PacketController();

		// -------------------------------------------------------
		// Vistas
		// -------------------------------------------------------
		view = new PacketView(this);
		view_detail = null;

		// -------------------------------------------------------
		// CACHE - TODO revisar
		// -------------------------------------------------------
		firstCache = new String();
		secondCache = new String();

		try {
			// Tomamos los primeros de dominio y los mostramos
			Packet g = null;
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
		vShared.add_once_tab("Create packet", new PacketCreate(this));
	}

	/**
	 * 
	 * @param string
	 * @param readXForm
	 * @param readYForm
	 * @throws Exception
	 */
	public void save(String originalName, String name) throws Exception {

		if (originalName == null) { // CREACION
			// Creamos en el objeto en la capa de dominio
			((PacketController) controller).addPacket(name);
			// Mensaje de notificacion
			vError.success("The packet " + name + " has been created");

			// Add to table - TODO: CACHE
			refresh();
			((ViewController) view).show(getStringToShow());

		} else { // ACTUALIZACION

			// Comprobamos el nombre
			if (!originalName.equals(name)) {
				((PacketController) controller).updatePacketName(originalName,
						name);
			}

			// Actaulizamos los datos adjuntos
			//((PacketController) controller).updatePacket(name, readXForm,
			//		readYForm);

			// Mensaje de notificacion
			vError.success("The packet " + name + " has been updated");

			// Table - TODO: Cache TODO: Eliminar esto
			Console.print("UPDATING Packet!");
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
		view_detail = new PacketDetails(this, name);
		vShared.add_once_tab("Packet details", view_detail);
	}
	
	/**
	 * 
	 */
	public void create_form_resource() {
		vShared.add_tab_pos("Add resource", new ViewTest(), 1);
		vShared.change_tab(1);
	}

	/**
	 * TODO: Cache
	 */
	public void get() {
		Console.log(((PacketController) controller).getAll());
	}

	/**
	 * 
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public String getByName(String name) throws Exception {
		return ((PacketController) controller).getByNameToString(name);
	}
	
	/**
	 * 
	 * @param name
	 * @return
	 * @throws Exception
	 */
	/*public String getPlanets(String name) throws Exception {
		return ((PacketController) controller).getPlanetsFromPacket(name);

	}*/

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
		((PacketController) controller).removePacket(name);
		
		//Eliminar de la tabla - TODO
		refresh();
		((ViewController) view).show(getStringToShow());
		
		// Mensaje de notificacion
		vError.success("The packet " + name + " has been deleted");


		vShared.remove_all_tabs();
	}

	public PacketController getPacketController(){
		return (PacketController) controller;
	}
	// -------------------------------------------------------
	// TEST - TODO: Revisar
	// -------------------------------------------------------

	// ESTO ESTA PROHIBIDO!!! ENTRE CAPAS NO COMPARTES OBJETOS - SOLO DATOS
	// BASICOS
	/*
	 * public Packet getByName(String name){ try{ return ((PacketController)
	 * controller).getByName(name); } catch(Exception e){
	 * Console.print("Cannot add Packet"); } return null; }
	 */

}
