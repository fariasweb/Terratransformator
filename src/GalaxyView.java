import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 
 * @author farias
 * 
 */
public class GalaxyView extends ViewPanel {

	/**
	 * 
	 * @param c
	 */
	GalaxyView(GalaxyControllerView c) { //He cambiado por esto en vez de AbstractControllerView
		super(c);
	}

	/**
	 * 
	 */
	protected void create_events() {
		// Eventos
		//Boton de crear
		bCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// display/center the jdialog when the button is pressed
				
				//Parametros que pasaremos a esta funcion dependiendo de lo que leamos del Textfield del futuro formulario de Galaxia
				int ReadXForm = 42;
				int ReadYForm = 242;
				
				//He creado funciones getByName y addGalaxy en GalaxyControllerView para que me reconozca aqui las funciones.
				
				//LLamamos a la funcion de GalaxyController a partir de GalaxyControllerView -> Vease UML Presentacion
				((GalaxyControllerView)controller).addGalaxy("ReadGalaxyNameForm", ReadXForm, ReadYForm);
				
				//Si No lanza Excepcion la funcion anterior, pido la galaxia a la capa de dominio y lo a–ado a la tabla suponiendo que no hay control de cache
				Galaxy name = ((GalaxyControllerView)controller).getByName("ReadGalaxyNameForm");

				//Compruebo que no anada otra vez el mismo nombre de la Galaxia iterando en las filas de la tabla 
				boolean found = false;
				for(int i = 0; i < tmodel.getRowCount() && !found; ++i){
					if(tmodel.getValueAt(i,0).equals(name.getName())) found = true;
				}
				
				//Si no encuentra una galaxia con mismo nombre -> La anade en la tabla
				if(!found)tmodel.addRow(new Object[] { name.getName() });
				
				//Compruebo que esta registrada la galaxia en la capa de dominio en la terminal
				Console.print("Coordenada X: " + name.getSize().getX() + "Coordenada Y:" + name.getSize().getY());
				
				//Funciona ejecutando un juego de pruebas sencillito para comprobar el bucle for funciona bien
				
			}
		});
		
		// Boton de guardar
		bImport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				Console.log("you have pressed the SAVE button!");
				controller.save("./save/GalaxyControler.txt", false);
			}
		});
		
		//Boton de cargar
		bExport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				Console.log("you have pressed the LOAD button!");
				controller.load("./save/GalaxyControler.txt");
			}
		});
		
	}

	protected void create_events(){
		

	}
	
	public void show(){

		
	}
}
