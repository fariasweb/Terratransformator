/**
 * 
 */
import java.awt.*;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class ViewMain extends AbstractViewer {

	/**
	 * 
	 */

	private JTabbedPane tabbedLeft, tabbedRight, tabbedOpe;

	/**
	 * 
	 * @param c
	 */
	ViewMain(AbstractControllerView c) {
		super(c);
	}

	/**
	 * 
	 */
	protected void create_view() {
		// Creamos el frame
		view = new JFrame("Terratransformator");

		// Evento por defecto
		((JFrame) view).setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		// Size y visibilidad
		view.setSize(500, 500);
		view.setMinimumSize(new Dimension(500,500));
		view.setVisible(true);
		
		//TapPanel principales
		tabbedLeft = (JTabbedPane) new JTabbedPane();
		tabbedRight = (JTabbedPane) new JTabbedPane();
		tabbedOpe = (JTabbedPane) new JTabbedPane();
		
		// Layout
		GroupLayout layout = new GroupLayout(((JFrame) view).getContentPane());
		((JFrame) view).getContentPane().setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);

		//Horizontal
		layout.setHorizontalGroup(layout
				.createParallelGroup()
				.addComponent(tabbedOpe)
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(tabbedLeft)
						)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(tabbedRight)
						)
				)
			);

		//Vertical
		layout.setVerticalGroup(layout
				.createSequentialGroup()
				.addGroup(layout
						.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(tabbedLeft)
						.addComponent(tabbedRight)
				)
				.addGroup(layout
						.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(tabbedOpe)
				)
				
		);
		
		
		((Window) view).pack();

	}

	/**
	 * Anade un panel al TabPanel izquierdo
	 * @param p
	 * @param name
	 */
	public void add_left_tab(Container p, String name) {
		tabbedLeft.add(name, p);
	}	

}
