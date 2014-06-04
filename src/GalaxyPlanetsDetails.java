import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;

public class GalaxyPlanetsDetails extends View2Col {

	private JButton bSubmit;
	private GalaxyPlanetsForm fGalaxy;
	private GalaxyPlanetsView vPlanets;
	private String GalaxyName;
	
	/**
	 * 
	 * @param c
	 */

	GalaxyPlanetsDetails(AbstractControllerView c) {

		super(c);
		
		//GalaxyName = name;
		
		//Completamos el form
		complete_form();
	}

	/**
	 * 
	 */
	protected void create_view() {

		// Creacion del formuacio de Galaxy
		fGalaxy = new GalaxyPlanetsForm(((GalaxyControllerView) controller));
		add_left(fGalaxy);
			
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

	private void complete_form() {
		// INFORMACION
		try {

			//Formularuo basico
			//-----------------
			String[][] l = decode_list(((GalaxyControllerView) controller).getPlanetWithoutGalaxy(Galaxyname));
			String[] g = new String[l.length];
			
			for (int i = l.length - 1; i >= 0; i-= 1) {
				g[i] = l[i][0];
			}
			
			fGalaxy.append(g);
			
			/*if (l.length == 0)
				throw new Exception("Error in data");
				
			fGalaxy.setNameValue(l[0]);
			fGalaxy.setXValue(l[1]);
			fGalaxy.setYValue(l[2]);
			
			//Marcamos el nombre original
			//fGalaxy.setOriginalName(name);
			
			//Listao de planetas
			//------------------
			String planets = ((GalaxyControllerView) controller).getPlanets(name);
			String[] list_planets = decode_in_lines(planets);
			
			for (int i = list_planets.length - 1; i >= 0; i-= 1) {
				vPlanets.show(list_planets[i]);
			}*/

		} catch (Exception e) {
			controller.show_error(e.getMessage());
		}
	}
}
