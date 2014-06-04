import java.awt.Container;

import javax.swing.JPanel;

import java.util.Stack;

/**
 * 
 * @author Admira
 * 
 */
public abstract class AbstractControllerView {

	// Controllador
	protected AbstractController controller;

	// Vista
	protected AbstractViewer view;
	// Vista - Elementos compartidos
	protected ViewTabbedPane vShared;
	protected ViewNotification vError;

	// -------------------------------------------------------
	// CACHE - TODO revisar
	// -------------------------------------------------------

	protected static final int CACHE_SIZE = 100;
	// 100 elementos para listar en cada String cache
	protected String firstCache;
	protected String secondCache;

	// -------------------------------------------------------
	// CONSTRCUTOR
	// -------------------------------------------------------

	/**
	 * 
	 * @param vs
	 * @param ve
	 */
	AbstractControllerView(ViewTabbedPane vs, ViewNotification ve) {
		// Elementos compartidos de todos los controladores
		vShared = vs;
		vError = ve;
	}

	// -------------------------------------------------------
	// COMUN
	// -------------------------------------------------------
	public AbstractController get_controller() {
		return controller;
	}

	// -------------------------------------------------------
	// VIEWS
	// -------------------------------------------------------
	/**
	 * 
	 */
	public JPanel get_view() {
		return view;
	}

	// -------------------------------------------------------
	// ERROR
	// -------------------------------------------------------

	/**
	 * 
	 * @param e
	 */
	public void show_error(String e) {
		vError.error(e);
	}

	/**
	 * 
	 */
	public void remove_error() {
		vError.hide();
	}

	// -------------------------------------------------------
	// SAVE AND LOAD
	// -------------------------------------------------------

	/**
	 * 
	 * @param path
	 * @param append
	 */
	public void save(String path, boolean append) {
		try {
			// Constructor que se le pasa controlador y nombre de Thread
			SaveThread st = new SaveThread(controller, path, append);

			// Creamos un Thread que invoque a la funcion de un Savethread
			Thread t1 = new Thread(st, "Saving Function");

			// Arrancamos el thread
			t1.start();
		} catch (Exception e) {
			vError.error("Error saving file! "+e.getMessage());
		}
	}

	/**
	 * 
	 * @param path
	 */
	public void load(String path) {
		try {
			// Constructor que se le pasa controlador y nombre de Thread
			LoadThread lt = new LoadThread(controller, this ,path);

			// Creamos un Thread que invoque a la funcion de un Loadthread
			Thread t1 = new Thread(lt, "Load Function");

			// Arrancamos el thread
			t1.start();
		} catch (Exception e) {
			vError.error("Error loading file! "+e.getMessage());
		}
	}

	public void showOp(String s) {
		ViewTest vt = new ViewTest();
		vt.create_view(s);
		vShared.add_tab("Foo", vt);

	}

	// -------------------------------------------------------
	// COMUN
	// -------------------------------------------------------

	// -------------------------------------------------------
	// CACHE & TABLE
	// -------------------------------------------------------

	public void forwards() {
		firstCache = secondCache;
		secondCache = controller.forwards();
		Console.print("FOR!");

	}

	public void backwards() {
		secondCache = firstCache;
		firstCache = controller.backwards();
		Console.print("BACK!");
	}

	public void refresh() {
		firstCache = controller.refreshFirstCache();
		secondCache = controller.refreshSecondCache();
		Console.print("Refreshing: cache1 = " + firstCache + "   cache2 = "
				+ secondCache);

	}

	public String getStringToShow() {
		Console.print("getStringToShow: " + firstCache + secondCache);
		return firstCache + secondCache;
	}
	
	
	public void reloadTable() {
		
		//Eliminas la tabla actual
		((ViewController) view).clear();
		
		//Cargas cache
		refresh();
		
		//Escribes primerea parte de la cache
		((ViewController) view).show(getStringToShow());
	}

}
