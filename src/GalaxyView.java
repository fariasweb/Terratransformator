import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 
 * @author farias
 * 
 */
public class GalaxyView extends ViewPanel {

	/**
	 * 
	 * @param c
	 */
	GalaxyView(AbstractControllerView c) {
		super(c);
	}

	/**
	 * 
	 */
	protected void create_events() {
		// Eventos
		bCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// display/center the jdialog when the button is pressed
				Console.log("CLICK Galaxia");
				
				((GalaxyControllerView)controller).getGalaxy();
				tmodel.addRow(new Object[] { "GALAXY 1" });
			}
		});
	}
}
