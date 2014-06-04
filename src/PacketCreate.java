import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class PacketCreate extends View2Col {

	private JButton bSubmit;
	private PacketForm fPacket;
	
	/**
	 * 
	 * @param c
	 */
	PacketCreate(AbstractControllerView c) {
		super(c);
	}
	
	/**
	 * 
	 */
	protected void create_view() {
		
		//Creacion del formuacio de Packet
		fPacket = new PacketForm(((PacketControllerView)controller));
		add_left(fPacket);
		
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
					
					fPacket.submit_form();
					
				} catch (Exception e) {
					controller.show_error(e.getMessage());
				}
			}
		});
		
	}

}
