import java.awt.Container;

import javax.swing.JPanel;

/**
 * 
 * @author Admira
 * 
 */
public abstract class AbstractViewer extends JPanel {

	// Controlador & vista
	AbstractControllerView controller;

	/**
	 * 
	 */
	AbstractViewer() {
		controller = null;

	}

	/**
	 * 
	 * @param c
	 */
	AbstractViewer(AbstractControllerView c) {
		// Guargamos el controlador al que pertenecemos
		set_controller(c);

	}

	// --------------------------------------------------------
	// Controllador
	// --------------------------------------------------------

	/**
	 * 
	 * @param c
	 */
	public void set_controller(AbstractControllerView c) {
		controller = c;
	}

	/**
	 * 
	 * @return
	 */
	protected boolean have_controller() {
		return controller != null;
	}

	// --------------------------------------------------------
	// Vistas
	// --------------------------------------------------------

	/**
	 * 
	 */
	protected abstract void create_view();

	/**
	 * 
	 */
	protected abstract void create_events();

	// --------------------------------------------------------
	// Utiles
	// --------------------------------------------------------

	/**
	 * 
	 * @param l
	 * @return
	 */
	protected String[] decode(String l) {
		return l.split(" ");
	}

	/**
	 * 
	 * @param l
	 * @return
	 */
	protected String[][] decode_list(String l) {

		String[] s = decode_in_lines(l);
		if (s.length == 0)
			return null;

		String[][] ll = new String[s.length][];

		int i = 0;
		while (i < s.length) {
			ll[i] = decode(s[i]);
			i += 1;
		}

		return ll;
	}

	/**
	 * 
	 * @param l
	 * @return
	 */
	protected String[] decode_in_lines(String l) {
		return l.split(";");
	}

	public void set_scroll(){}

}
