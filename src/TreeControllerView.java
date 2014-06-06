import java.util.Stack;

import javax.swing.table.DefaultTableModel;

/**
 * 
 * @author farias
 * 
 */
public class TreeControllerView extends AbstractControllerView {

	public TreeDetails view_detail;
	
	/**
	 * 
	 * @param pc
	 */
	TreeControllerView(QAPSolution qaps, ViewTabbedPane vs,ViewNotification ve) {
		super(vs, ve);

		// -------------------------------------------------------
		// CONTROLADOR DE DOMINIO
		// -------------------------------------------------------
		
		controller = qaps;

		// -------------------------------------------------------
		// Vistas
		// -------------------------------------------------------
		view = new TreeView(this);
		view_detail = null;


		try {
			// Tomamos los primeros de dominio y los mostramos
			QAPBaBTreeNode node = controller.getTree();
		} catch (Exception e) {
			Console.print(e.getMessage());
		}

	}

	// -------------------------------------------------------
	// CREAR
	// -------------------------------------------------------


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
			((TreeController) controller).addTree(name, readXForm,
					readYForm);
			// Mensaje de notificacion
			vError.success("The Tree " + name + " has been created");

			// Add to table - TODO: CACHE

			Console.print("CREATING Tree!");

		} else { // ACTUALIZACION

			// Comprobamos el nombre
			if (!originalName.equals(name)) {
				((TreeController) controller).updateTreeName(originalName,
						name);
			}

			// Actaulizamos los datos adjuntos
			((TreeController) controller).updateTree(name, readXForm,
					readYForm);

			// Mensaje de notificacion
			vError.success("The Tree " + name + " has been updated");

			// Table - TODO: Cache TODO: Eliminar esto
			Console.print("UPDATING Tree!");
			if(needsRefreshing(name)) refresh();
		}
		reloadTable();
	}
	

	// -------------------------------------------------------
	// LISTAR/EDITAR
	// -------------------------------------------------------

	/**
	 * 
	 * @param name
	 */
	public void create_form_view(String name) {
		view_detail = new TreeDetails(this, name);
		vShared.add_once_tab("Tree details", view_detail);
	}
	

	/**
	 * TODO: Cache
	 */
	public void get() {
		Console.log(((TreeController) controller).getAll());
	}

	/**
	 * 
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public String getByName(String name) throws Exception {
		return ((TreeController) controller).getByNameToString(name);
	}
	
	/**
	 * 
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public String getPlanets(String name) throws Exception {
		return ((TreeController) controller).getPlanetsFromTree(name);

	}
	
	/**
	 * 
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public String getPlanetWithoutTree(String name) throws Exception {
		return ((TreeController) controller).getPlanetsToTree(name);
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
		((TreeController) controller).removeTree(name);
		
		//Eliminar de la tabla - TODO
		reloadTable();
		
		// Mensaje de notificacion
		vError.success("The Tree " + name + " has been deleted");


		vShared.remove_all_tabs();
	}
	
	/**
	 * 
	 * @param Tree
	 * @param planet
	 * @throws Exception 
	 */
	public void delete_planet(String Tree, String planet) throws Exception {
		
		//Eliminar el planeta
		((TreeController) controller).removePlanetFromTree(Tree, planet);
	
		//Refrescamos tabla
		view_detail.update_planet_list(Tree);
				
		//Cerramos pestana
		vShared.remove_tab(1);
	}

	public TreeController getTreeController(){
		return (TreeController) controller;
	}
	// -------------------------------------------------------
	// TEST - TODO: Revisar
	// -------------------------------------------------------

	// ESTO ESTA PROHIBIDO!!! ENTRE CAPAS NO COMPARTES OBJETOS - SOLO DATOS
	// BASICOS
	/*
	 * public Tree getByName(String name){ try{ return ((TreeController)
	 * controller).getByName(name); } catch(Exception e){
	 * Console.print("Cannot add Tree"); } return null; }
	 */

}
