/**
 * 
 * @author farias
 *
 */
public class GalaxyView extends AbstractViewer {

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
	protected void create_view() {
		view = new ViewPanel();
	}

}
