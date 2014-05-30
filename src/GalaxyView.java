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
				((GalaxyControllerView)controller).create_form_add(tmodel);
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
		
		//Boton de eliminar - TODO
		bDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				controller.show_error("Oh! Un error");
			}
		});
		
	}

	/*protected void create_events(){
		

	}*/
	public void show(String s){
		String[] ss = s.split(";");
		String[] sss;
		//Chivato
		for (int i = 0; i < ss.length; ++i) {
			sss = ss[i].split(" ");
			Console.print(sss);
			tmodel.addRow(new String[] {sss[0]});
		}
	}

}
