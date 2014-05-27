/**
 * 
 * @author farias
 *
 */
public class PlanetView extends AbstractViewer {

	/**
	 * 
	 * @param c
	 */
	PlanetView(AbstractControllerView c) {
		super(c);
	}

	/**
	 * 
	 */
	protected void create_view() {
		view = new ViewPanel();
	}

}
