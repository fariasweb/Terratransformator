/**
 * 
 */
import java.awt.*;
import java.awt.event.WindowEvent;

import javax.swing.event.MenuListener;
import javax.swing.event.MenuEvent;
import javax.swing.*;

public class PresentationView extends JFrame {

	/**
	 * 
	 */
	PresentationController controller;
	private ViewTabbedPane tabbedOpe, tabbedLeft, tabbedRight;
	private ViewNotification errorPanel;

	/**
	 * 
	 * @param c
	 */
	PresentationView(PresentationController c) {
		super("Terratransformator");
		controller = c;

		create_view();
	}

	/**
	 * 
	 */
	protected void create_view() {
		// Creamos el frame

		// Evento por defecto
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		// Size y visibilidad
		//setSize(900, 640);
		int w = Toolkit.getDefaultToolkit().getScreenSize().width;
		int h = Toolkit.getDefaultToolkit().getScreenSize().height;
		
	    setMinimumSize(new Dimension(w,h));
		
		setVisible(true);
		setResizable(false);

		//TapPanel principales
		tabbedLeft = new ViewTabbedPane();
		tabbedRight = new ViewTabbedPane();
		tabbedOpe = new ViewTabbedPane();
		errorPanel = new ViewNotification();

		// Layout
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);

		//Horizontal
		layout.setHorizontalGroup(layout
				.createParallelGroup()
				.addComponent(errorPanel)
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
						.addComponent(errorPanel)
				)
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

		pack();

	}

	/**
	 * Anade un panel al TabPanel izquierdo
	 * 
	 * @param p
	 * @param name
	 */
	public void add_left_tab(JPanel p, String name) {
		tabbedLeft.add_tab(name, p);
	}

	/**
	 * Anade un panel al TabPanel derecho
	 * 
	 * @param p
	 * @param name
	 */
	public void add_right_tab(JPanel p, String name) {
		tabbedRight.add_tab(name, p);
	}

	/**
	 * 
	 * @param p
	 * @param name
	 */
	public ViewTabbedPane get_operation_tab() {
		return tabbedOpe;
	}

	/**
	 * 
	 * @return
	 */
	public ViewNotification get_error_panel() {
		return errorPanel;
	}

	/**
	 * 
	 * @param menu
	 */
	public void setMenu(JMenuBar menu) {
		// MenuBar
		setJMenuBar(menu);
	}

	public void setScrolls() {

	}

}