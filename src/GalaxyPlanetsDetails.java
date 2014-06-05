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

	GalaxyPlanetsDetails(AbstractControllerView c, String name) {

		super(c);
		
		GalaxyName = name;
		
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
			String[][] l = decode_list(((GalaxyControllerView) controller).getPlanetWithoutGalaxy(GalaxyName));
			String[] g = new String[l.length];
			
			for (int i = l.length - 1; i >= 0; i-= 1) {
				g[i] = l[i][0];
			}
			
			fGalaxy.setOriginalName(GalaxyName);
			fGalaxy.append(g);
			
		} catch (Exception e) {
			controller.show_error(e.getMessage());
		}
	}
}
