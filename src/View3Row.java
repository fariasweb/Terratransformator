import java.awt.Component;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * 
 * @author farias
 * 
 */
public abstract class View3Row extends ViewLayout {

	private JPanel pTop,pMiddle, pBottom;

	/**
	 * 
	 * @param c
	 */
	View3Row(AbstractControllerView c) {
		super(c);
	}

	/**
	 * 
	 */
	protected void create_layout() {
		pTop = new JPanel();
		pBottom = new JPanel();
		pMiddle = new JPanel();
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
										.addComponent(pTop)
										.addComponent(pMiddle)
										.addComponent(pBottom))
						));

		// Vertical
		layout.setVerticalGroup(layout.createSequentialGroup()
				.addGroup(
						layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(pTop))
				.addGroup(
						layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(pMiddle))			
				.addGroup(
						layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(pBottom))
				);

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
	public void add_top(Component c) {
		_add(pTop, c);
	}

	public void add_middle(Component c){
		_add(pMiddle, c);
	}
	/**
	 * 
	 * @param c
	 */
	public void add_bottom(Component c) {
		_add(pBottom, c);
	}
}
