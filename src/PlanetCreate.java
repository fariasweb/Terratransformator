import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class PlanetCreate extends View2Col {

	private JButton bSubmit;
	private PlanetForm fPlanet;
	
	/**
	 * 
	 * @param c
	 */
	PlanetCreate(AbstractControllerView c) {
		super(c);
	}
	
	/**
	 * 
	 */
	protected void create_view() {
		
		//Creacion del formuacio de Galaxy
		fPlanet = new PlanetForm(((PlanetControllerView)controller));
		add_left(fPlanet);
		
		//Boton de enviar
		bSubmit = create_button_submit();
		add_right(bSubmit);
	}

	/**
	 * 
	 */
	protected void create_events() {
		
		bSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event){
				
				try {
					
					fPlanet.submit_form();
					
				} catch (Exception e) {
					controller.show_error(e.getMessage());
				}
			}
		});
		
	}

}
