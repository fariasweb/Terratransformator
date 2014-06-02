import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class ResourceCreate extends View2Col {

	private JButton bSubmit;
	private ResourceForm fResource;
	
	/**
	 * 
	 * @param c
	 */
	ResourceCreate(AbstractControllerView c) {
		super(c);
	}
	
	/**
	 * 
	 */
	protected void create_view() {
		
		//Creacion del formuacio de Galaxy
		fResource = new ResourceForm(((ResourceControllerView)controller));
		add_left(fResource);
		
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
					
					fResource.submit_form();
					
				} catch (Exception e) {
					controller.show_error(e.getMessage());
				}
			}
		});
		
	}

}
