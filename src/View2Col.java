import java.awt.Component;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * 
 * @author farias
 * 
 */
public abstract class View2Col extends ViewLayout {

	private JPanel pLeft, pRight;

	/**
	 * 
	 * @param c
	 */
	View2Col(AbstractControllerView c) {
		super(c);
	}

	/**
	 * 
	 */
	protected void create_layout() {
		pLeft = new JPanel();
		pRight = new JPanel();

		// Layout
		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);

		// Horizontal
		layout.setHorizontalGroup(layout.createParallelGroup().addGroup(
				layout.createSequentialGroup()
						.addGroup(
								layout.createParallelGroup(
										GroupLayout.Alignment.LEADING)
										.addComponent(pLeft))
						.addGroup(
								layout.createParallelGroup(
										GroupLayout.Alignment.LEADING)
										.addComponent(pRight))));

		// Vertical
		layout.setVerticalGroup(layout.createSequentialGroup().addGroup(
				layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(pLeft).addComponent(pRight)));

	}

	// ----------------------------------------------------------
	// Funciones graficas
	// ----------------------------------------------------------
	/**
	 * 
	 * @param p
	 * @param c
	 */
	private void _add(JPanel p, Component c) {
		GroupLayout layout = new GroupLayout(p);
		p.setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);

		layout.setHorizontalGroup(layout.createSequentialGroup().addGroup(
				layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
						.addComponent(c)));
		layout.setVerticalGroup(layout.createSequentialGroup().addGroup(
				layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(c)));
	}

	/**
	 * 
	 * @param c
	 */
	public void add_left(Component c) {
		_add(pLeft, c);
	}

	/**
	 * 
	 * @param c
	 */
	public void add_right(Component c) {
		_add(pRight, c);
	}
}
