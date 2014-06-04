import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;

public class PacketDetails extends View3Col {

	private JButton bSubmit;
	private PacketForm fPacket;

	/**
	 * 
	 * @param c
	 */

	PacketDetails(AbstractControllerView c, String nameE) {

		super(c);
		
		//Completamos el form
		complete_form(nameE);
	}

	/**
	 * 
	 */
	protected void create_view() {

		// Creacion del formuacio de Packet
		fPacket = new PacketForm(((PacketControllerView) controller));
		add_left(fPacket);

		// Tabla de Rrecursos - TODO
		//pRight.add(new PacketPacketsView(((PacketControllerView) controller)));
		//PacketPacketsView vPackets = new PacketPacketsView(((PacketControllerView) controller));
		//add_center(vPackets);
			
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

	private void complete_form(String name) {
		// INFORMACION
		try {

			//Formularuo basico
			//-----------------
			String[] l = decode(((PacketControllerView) controller)
					.getByName(name));

			if (l.length == 0)
				throw new Exception("Error in data");
				
			fPacket.setNameValue(l[0]);
			
			//Marcamos el nombre original
			fPacket.setOriginalName(name);
			
			//Recursos que tiene
			//-----------------
			
			//TODO

		} catch (Exception e) {
			controller.show_error(e.getMessage());
		}
	}

}
