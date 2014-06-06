import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;

public class PacketResourceDetails extends View2Col {

	private JButton bSubmit;
	private PacketResourceForm fPacket;
	private String Name;
	
	/**
	 * 
	 * @param c
	 */

	PacketResourceDetails(AbstractControllerView c, String name) {

		super(c);
		
		Name = name;
		
		//Completamos el form
		complete_form();
	}

	/**
	 * 
	 */
	protected void create_view() {

		// Creacion del formuacio de Galaxy
		fPacket = new PacketResourceForm(((PacketControllerView) controller));
		add_left(fPacket);
			
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
					fPacket.submit_form();

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
			String[][] l = decode_list(((PacketControllerView) controller).getResourceToPacket(Name));
			String[] g = new String[l.length];
			
			for (int i = l.length - 1; i >= 0; i-= 1) {
				g[i] = l[i][0];
			}
			
			fPacket.setOriginalName(Name);
			fPacket.append(g);
			
		} catch (Exception e) {
			controller.show_error(e.getMessage());
		}
	}
}
