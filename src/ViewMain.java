/**
 * 
 */
import java.awt.*;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class ViewMain extends JFrame {

	/**
	 * 
	 */
	ViewController controller;
	private JTabbedPane tabbedLeft, tabbedRight;
	private ViewOperation tabbedOpe;
	private ViewError errorPanel;

	/**
	 * 
	 * @param c
	 */
	ViewMain(ViewController c) {
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
		setSize(800, 600);
		setMinimumSize(new Dimension(800,600));
		setVisible(true);
		
		//TapPanel principales
		tabbedLeft = (JTabbedPane) new JTabbedPane();
		tabbedRight = (JTabbedPane) new JTabbedPane();
		tabbedOpe = new ViewOperation();
		errorPanel = new ViewError();
		
		//TEST - TODO: ELIMINAR
		tabbedOpe.add_tab("Test", new ViewTest());
		
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
	 * @param p
	 * @param name
	 */
	public void add_left_tab(Container p, String name) {
		tabbedLeft.add(name, p);
	}
	
	/**
	 * Anade un panel al TabPanel derecho
	 * @param p
	 * @param name
	 */
	public void add_right_tab(Container p, String name) {
		tabbedRight.add(name, p);
	}	

	/**
	 * 
	 * @param p
	 * @param name
	 */
	public ViewOperation get_operation_tab() {
		return tabbedOpe;
	}
	
	/**
	 * 
	 * @return
	 */
	public ViewError get_error_panel() {
		return errorPanel;
	}
	
}
