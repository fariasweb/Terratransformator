
import java.awt.Container;
import javax.swing.JPanel;
import java.util.Stack;

/**
 * 
 * @author Admira
 *
 */
public abstract class AbstractControllerView {

	//Controllador
	protected AbstractController controller;
	
	//Vista
	protected AbstractViewer view;
	//Vista - Elementos compartidos
	protected ViewOperation vShared;
	protected ViewError vError;
	
	//-------------------------------------------------------
	// CACHE - TODO revisar
	//-------------------------------------------------------
			
	protected static final int CACHE_SIZE = 100;
	//100 elementos para listar en cada String cache
	protected String firstCache;
	protected String secondCache;
	//Object demasiado general? Cada uno pone su clase (Galaxy, etc)
	protected Stack<Entity> references;


	//-------------------------------------------------------
	// CONSTRCUTOR
	//-------------------------------------------------------
		
	/**
	 * 
	 * @param vs
	 * @param ve
	 */
	AbstractControllerView(ViewOperation vs, ViewError ve) {
		//Elementos compartidos de todos los controladores
		vShared = vs;
		vError = ve;
	}
	
	//-------------------------------------------------------
	// VIEWS
	//-------------------------------------------------------
	/**
	 * 
	 */
	public Container get_view() {
		return view;
	}
	
	//-------------------------------------------------------
	// ERROR
	//-------------------------------------------------------
	
	/**
	 * 
	 * @param e
	 */
	public void show_error(String e) {
		vError.show(e);
	}
	
	/**
	 * 
	 */
	public void remove_error() {
		vError.hide();
	}
	
	//-------------------------------------------------------
	// SAVE AND LOAD
	//-------------------------------------------------------
		
	/**
	 * 
	 * @param path
	 * @param append
	 */
	public void save(String path, boolean append){
		try{
			//Constructor que se le pasa controlador y nombre de Thread
			SaveThread st = new SaveThread(controller, path, append);
			
			//Creamos un Thread que invoque a la funcion de un Savethread
			Thread t1 = new Thread(st, "Saving Function");
			
			//Arrancamos el thread
			t1.start();
		}
		catch(Exception e){
			Console.log("Error saving things!");
		}
	}
	
	/**
	 * 
	 * @param path
	 */
	public void load(String path){
		try{
			//Constructor que se le pasa controlador y nombre de Thread
			LoadThread lt = new LoadThread(controller, path);
			
			//Creamos un Thread que invoque a la funcion de un Loadthread
			Thread t1 = new Thread(lt,"Load Function");
		
			//Arrancamos el thread
			t1.start();
		}
		catch(Exception e){
			Console.log("Error laoding things!");
		}
	}

	public void showOp(String s){
		ViewTest vt = new ViewTest();
		vt.create_view(s);
		vShared.add_tab("Foo", vt);

	}

	public abstract String getEntityByName(String name);

	public abstract void updateEntityNameByName(String oldName, String newName);
	
}
