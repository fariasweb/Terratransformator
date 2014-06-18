import java.util.Stack;

import javax.swing.JMenuBar;
import javax.swing.table.DefaultTableModel;

/**
 * 
 * @author farias
 * 
 */
public class MenuControllerView extends AbstractControllerView {

	private MenuView menu;
	private String help;
	
	/**
	 * 
	 * @param pc
	 */
	MenuControllerView(ViewTabbedPane vs,ViewNotification ve) {
		super(vs, ve);
		
		menu = new MenuView(this);
		
		help = "Terratransformator - Guia\n"
				+ "============================================\n"
				+ "1. Planetas\n"
				+ "2. Galaxias\n"
				+ "3. Recursos\n"
				+ "4. Paquetes\n"
				+ "5. QAPInput\n"
				+ "6. QAPOutput\n"
				+ "7. Tree\n"
				+ "============================================\n"
				+ "1. Planetas\n"
				+ " Para realizar operaciones con los planetas pulse en la pestana de Planeta en el panel izquierdo y vera que se despliega un panel con 4 botones "
				+ "y con una lista de planetas existentes, la cual estara vacia al inicio\n del programa puesto que no habremos creado ninguno. \n"
				+ "-Para poder crear un planeta pulse el boton Submit y vera que se despliega en la parte inferior del programa una ventana con un formulario a rellenar."
				+ " Dicho formulario contendra un campo que sera el nombre \n del planeta que deseamos que tenga y dos campos que indican la posicion del planeta. \n"
				+ " Una vez introducidos dichos campos pulse el boton de Create y vera que se anade el planeta en la lista de planetas.\n"
				+ "-Para poder eliminar un planeta pulse el boton de Delete y seleccione el planeta a eliminar en la lista de planetas existentes.\n"
				+ "-Para poder consultar las caracteristicas de un planeta existente, pulse en el nombre de un planeta de la lista y vera que aparece en la parte inferior"
				+ " un formulario y en el los datos del planeta seleccionado. \n"
				+ "-Para poder modificar un planeta seleccione el planeta y vera que se despliega una ventana en la parte inferior del programa con un formulario. Edite los campos"
				+ "de dicho formulario y pulse el boton de Submit \n para confirmar los cambios\n"
				+ "-Para poder cargar un fichero de planetas pulse el boton de Load y se abrira una nueva ventana con todos los directorios y ficheros"
				+ " del sistema para que seleccione el archivo a cargar.\n"
				+ "-Para la opcion de guardar pulse el boton de Save y aparecera una ventana para seleccionar el fichero donde desea guardar los planetas.\n"
				+ "============================================\n"
				+ "2. Galaxias\n"
				+ " Para realizar operaciones con las galaxias pulse en la pestana de Galaxia en el panel izquierdoy vera que se despliega un panel con 4 botones "
				+ "y con una lista de galaxias existentes, la cual estara vacia al inicio \n del programa puesto que no habremos creado ninguno. \n"
				+ "-Para poder crear una Galaxia pulse el boton Submit y vera que se despliega en la parte inferior del programa una ventana con un formulario a rellenar.\n"
				+ " Dicho formulario contendra un campo que sera el nombre de la Galaxia que deseamos que tenga y dos campos que indican la anchura y altura de la galaxia. "
				+ " Una vez introducidos dichos campos pulse el boton \n de Create y vera que se anade la galaxia en la lista de galaxias.\n"
				+ "-Para poder consultar las caracteristicas de una galaxia existente, pulse en el nombre de una galaxia de la lista y vera que aparece en la parte inferior"
				+ " un formulario y en el los datos de la galaxia seleccionada.\n Tambien observara que que aparece una tabla que lista los planetas que contiene la galaxia, y varios botones"
				+ "encima de dicha tabla para que pueda anadir o quitar planetas existentes de dicha galaxia.\n"
				+ "-Para poder modificar una galaxia seleccione la galaxia de la lista y vera que se despliega una ventana en la parte inferior del programa con un formulario. Edite los campos"
				+ "de dicho formulario modificando los \n campos de la galaxia o la lista de planetas que contiene y pulse el boton de Submit para confirmar los cambios.\n"
				+ "-Para poder eliminar una galaxia pulse el boton de Delete y seleccione la galaxia a eliminar en la lista de galaxias existentes.\n"
				+ "-Para poder cargar un fichero de galaxias pulse el boton de Load y se abrira una nueva ventana con todos los directorios y ficheros"
				+ " del sistema para que seleccione el archivo a cargar.\n"
				+ "-Para la opcion de guardar pulse el boton de Save y aparecera una ventana para seleccionar el fichero donde desea guardar las galaxias.\n"
				+ "============================================\n"
				+ "3. Recursos\n"
				+ " Para realizar operaciones con los recursos pulse en la pestana de Recursos en el panel derecho y vera que se despliega un panel con 4 botones "
				+ "y con una lista de recursos existentes, la cual estara vacia al inicio \n del programa puesto que no habremos creado ninguno. \n"
				+ "-Para poder crear un recurso pulse el boton Create y vera que se despliega en la parte inferior del programa una ventana con un formulario a rellenar."
				+ " Dicho formulario contendra dos campos que seran el nombre \n del recurso que deseamos que tenga y el tipo de recurso , que puede ser humano o tecnologico\n"
				+ " Una vez introducidos dichos campos pulse el boton de Submit y vera que se anade un recurso en la lista de recursos.\n"
				+ "-Para poder eliminar un recurso pulse el boton de Delete y seleccione el recurso a eliminar en la lista de recursos existentes.\n"
				+ "-Para poder consultar las caracteristicas de un recurso existente, pulse en el nombre de un recurso de la lista y vera que aparece en la parte inferior"
				+ "un formulario y en el los datos del recurso seleccionado. \n"
				+ "-Para poder modificar un recurso seleccione el recurso y vera que se despliega una ventana en la parte inferior del programa con un formulario. Edite los campos"
				+ "de dicho formulario y pulse el boton de Submit \n para confirmar los cambios\n"
				+ "-Para poder cargar un fichero de recursos pulse el boton de Load y se abrira una nueva ventana con todos los directorios y ficheros"
				+ " del sistema para que seleccione el archivo a cargar.\n"
				+ "-Para la opcion de guardar pulse el boton de Save y aparecera una ventana para seleccionar el fichero donde desea guardar los recursos.\n"
				+ "============================================\n"
				+ "4. Paquetes\n"
				+ " Para realizar operaciones con los paquetes pulse en la pestana de Paquete en el panel derecho y vera que se despliega un panel con 4 botones "
				+ "y con una lista de paquetes existentes, la cual estara vacia al inicio \n del programa puesto que no habremos creado ninguno. \n"
				+ "-Para poder crear un Paquete pulse el boton Create y vera que se despliega en la parte inferior del programa una ventana con un formulario a rellenar.\n"
				+ " Dicho formulario contendra un campo que sera el nombre del Paquete que deseamos que tenga"
				+ " Una vez introducidos dicho campo pulse el boton de Submit y vera que se anade el paquete en la lista de paquetes.\n"
				+ "-Para poder consultar las caracteristicas de un paquete existente, pulse en el nombre de un paquete de la lista y vera que aparece en la parte inferior"
				+ " un formulario y en el los datos del paquete seleccionada. Tambien \n observara que aparece una tabla que lista los recursos que contiene la galaxia, y varios botones"
				+ "encima de dicha tabla para que pueda anadir o quitar recursos existentes de dicho paquete. En el caso especifico de \n anadir un recurso, es necesario indicar la "
				+ "cantidad deseada de ese recurso que queremos anadir al paquete.\n"
				+ "-Para poder modificar un paquete seleccione el paquete de la lista y vera que se despliega una ventana en la parte inferior del programa con un formulario. Edite los campos"
				+ "de dicho formulario modificando los \n campos del paquete o la lista de recursos que contiene y pulse el boton de Submit para confirmar los cambios.\n"
				+ "-Para poder eliminar un paquete pulse el boton de Delete y seleccione el paquete a eliminar en la lista de paquetes existentes.\n"
				+ "-Para poder cargar un fichero de paquetes pulse el boton de Load y se abrira una nueva ventana con todos los directorios y ficheros"
				+ " del sistema para que seleccione el archivo a cargar.\n"
				+ "-Para la opcion de guardar pulse el boton de Save y aparecera una ventana para seleccionar el fichero donde desea guardar los paquetes.\n"
				+ "============================================\n"
				+ "5.QAPInput\n"
				+ "Una vez haya creado las galaxias y paquetes que desee, pulse en la pestana de QAPInput en el panel izquierdo y vera que se despliega una ventana un formulario con diversos campos."
				+ "Presione el boton de Refresh \n Galaxy para llenar el listado de galaxias que hayamos actualizado y seleccione en el listado la galaxia que deseemos para obtener la solucion. A continuacion, "
				+ "seleccione si desea ejecutar el algoritmo QAP GilmoreLazy \n o Gilmore Eager y indique el nivel que desea para ejecutar dichos algoritmos. Recuerde que el valor -1 indica Nada para el GilmoreLazy"
				+ "y indica Infinito para el GilmoreEager.\n"
				+ "Posteriormente, pulse el boton de Create Input Form para obtener las matrices de distancia entre planetas de una galaxia y la matriz de flujo entre paquetes.Vera que dichos datos se desplegaran"
				+ "en un panel inferior, \n acompanado de dos botones de Ejecutar Algoritmo y Parar Ejecucion.Recuerde que puede modificar los valores de las matrices antes de ejecutar el algoritmo escogido.\n"
				+ "Pulse el boton de Ejecutar Algoritmo para obtener una solucion. Si desea parar la ejecucion, pulse el boton de Parar Ejecucion. Vera los resultados en el panel de QAPOutput.\n"
				+ "============================================\n"
				+ "5.QAPOutput\n"
				+ "Una vez ejecutado el algoritmo, presione en la pestana de QAPOutput en el panel derecho y pulse en el boton de View Generated Solution para visualizar la solucion. Vera que el primer campo indica"
				+ " el Coste de la \n solucion, el segundo indica el vector de la solucion ofrecida, el tercer campo indica el tiempo invertido para obtener la solucion y el ultimo campo indica que paquete le corresponde "
				+ "a cada planeta.\n"
				+ "============================================\n"
				+ "6.Tree\n"
				+ " Una vez ejecutado el algoritmo, presione en la pestana de Tree en el panel izquiero y pulse en el boton de See tree para visualizar el arbol de la solucion.Vera que aparece una serie de ficheros y directorios"
				+ "y puede \n presionar  el dichos directorios para ver informacion relevante sobre el camino seguido por el algoritmo en el proceso de ejecucion para obtener la solucion al problema. Puede presionar sobre los directorios para ver la \n "
				+ "informacion de los nodos.\n"		
	;}
	/**
	 * 
	 */
	public void show_help() {
		vShared.add_once_tab("Help", new ViewText(help));
	}
	
	/**
	 * 
	 * @return
	 */
	public JMenuBar get_menu() {
		return menu.get_menu();
	}
	
}
