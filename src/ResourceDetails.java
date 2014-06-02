import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;

public class ResourceDetails extends View2Col {

	private JButton bSubmit;
	private ResourceForm fResource;

	/**
	 * 
	 * @param c
	 */

	ResourceDetails(AbstractControllerView c, String nameE) {

		super(c);
		
		//Completamos el form
		complete_form(nameE);
	}

	/**
	 * 
	 */
	protected void create_view() {

		// Creacion del formuacio de Resource
		fResource = new ResourceForm(((ResourceControllerView) controller));
		add_left(fResource);
			
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
					fResource.submit_form();

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
			String[] l = decode(((ResourceControllerView) controller)
					.getByName(name));

			if (l.length == 0)
				throw new Exception("Error in data");
				
			fResource.setNameValue(l[0]);
			fResource.setTypeValue(l[1]);
			
			//Marcamos el nombre original
			fResource.setOriginalName(name);
			
			//Galaxya a la q pertence
			//-----------------
			
			//TODO

		} catch (Exception e) {
			controller.show_error(e.getMessage());
		}
	}

}
