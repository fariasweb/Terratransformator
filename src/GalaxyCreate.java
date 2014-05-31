import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class GalaxyCreate extends View2Col {

	private JButton bSubmit;
	private GalaxyForm fGalaxy;
	
	/**
	 * 
	 * @param c
	 */
	GalaxyCreate(AbstractControllerView c) {
		super(c);
	}
	
	/**
	 * 
	 */
	protected void create_view() {
		
		//Creacion del formuacio de Galaxy
		fGalaxy = new GalaxyForm(((GalaxyControllerView)controller));
		add_left(fGalaxy);
		
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
					
					fGalaxy.submit_form();
					
				} catch (Exception e) {
					controller.show_error(e.getMessage());
				}
			}
		});
		
	}

}
