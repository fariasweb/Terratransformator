import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;

public class GalaxyDetails extends View3Col {

	private JButton bSubmit;
	private GalaxyForm fGalaxy;

	/**
	 * 
	 * @param c
	 */

	GalaxyDetails(AbstractControllerView c, String nameE) {

		super(c);
		
		//Completamos el form
		complete_form(nameE);
	}

	/**
	 * 
	 */
	protected void create_view() {

		// Creacion del formuacio de Galaxy
		fGalaxy = new GalaxyForm(((GalaxyControllerView) controller));
		add_left(fGalaxy);

		// Tabla de planetas
		//pRight.add(new GalaxyPlanetsView(((GalaxyControllerView) controller)));
		GalaxyPlanetsView gpv = new GalaxyPlanetsView(((GalaxyControllerView) controller));
		add_center(gpv);
		
		// Boton de enviar
		bSubmit = create_button_submit();
		add_right(bSubmit);

	}

	/**
	 * 
	 */
	protected void create_events() {
		bSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				try {
					fGalaxy.submit_form();

				} catch (Exception e) {
					controller.show_error(e.getMessage());
				}
			}
		});
	}

	/**
	 * 
	 */

	private void complete_form(String name) {
		// INFORMACION
		try {

			String[] l = decode(((GalaxyControllerView) controller)
					.getByName(name));

			if (l.length == 0)
				throw new Exception("Error in data");
				
			fGalaxy.setNameValue(l[0]);
			fGalaxy.setXValue(l[1]);
			fGalaxy.setYValue(l[2]);
			
			//Marcamos el nombre original
			fGalaxy.setOriginalName(name);

		} catch (Exception e) {
			controller.show_error(e.getMessage());
		}
	}

}
