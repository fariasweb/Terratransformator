
import java.awt.Container;
import javax.swing.JPanel;

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

	/**
	 * 
	 */
	public Container get_view() {
		return view;
	}
	
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
	
}
