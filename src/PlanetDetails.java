import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;

public class PlanetDetails extends View3Col {

	private JButton bSubmit;
	private PlanetForm fPlanet;

	/**
	 * 
	 * @param c
	 */

	PlanetDetails(AbstractControllerView c, String nameE) {

		super(c);
		
		//Completamos el form
		complete_form(nameE);
	}

	/**
	 * 
	 */
	protected void create_view() {

		// Creacion del formuacio de Planet
		fPlanet = new PlanetForm(((PlanetControllerView) controller));
		add_left(fPlanet);

		// Tabla de planetas
		//pRight.add(new PlanetPlanetsView(((PlanetControllerView) controller)));
		//PlanetPlanetsView vPlanets = new PlanetPlanetsView(((PlanetControllerView) controller));
		//add_center(vPlanets);
			
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
					fPlanet.submit_form();

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

			//Formularuo basico
			//-----------------
			String[] l = decode(((PlanetControllerView) controller)
					.getByName(name));

			if (l.length == 0)
				throw new Exception("Error in data");
				
			fPlanet.setNameValue(l[0]);
			fPlanet.setXValue(l[1]);
			fPlanet.setYValue(l[2]);
			
			//Marcamos el nombre original
			fPlanet.setOriginalName(name);
			
			//Galaxya a la q pertence
			//-----------------
			
			//TODO

		} catch (Exception e) {
			controller.show_error(e.getMessage());
		}
	}

}
